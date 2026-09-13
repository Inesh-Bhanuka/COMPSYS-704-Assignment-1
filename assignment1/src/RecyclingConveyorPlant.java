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
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal bottleAtSplitterExit = new Signal("bottleAtSplitterExit", Signal.OUTPUT);
  public Signal bottleAtLidRemoval = new Signal("bottleAtLidRemoval", Signal.OUTPUT);
  public Signal bottleAtDumper = new Signal("bottleAtDumper", Signal.OUTPUT);
  public Signal bottleAtReturn = new Signal("bottleAtReturn", Signal.OUTPUT);
  public Signal bottleLeftReturn = new Signal("bottleLeftReturn", Signal.OUTPUT);
  private int STEP_thread_1;//sysj\recyclingConveyorPlant.sysj line: 55, column: 3
  private int LAST_thread_1;//sysj\recyclingConveyorPlant.sysj line: 56, column: 3
  private int pos_thread_1;//sysj\recyclingConveyorPlant.sysj line: 58, column: 3
  private int travel_thread_1;//sysj\recyclingConveyorPlant.sysj line: 59, column: 3
  private boolean injecting_thread_1;//sysj\recyclingConveyorPlant.sysj line: 60, column: 3
  private boolean collecting_thread_1;//sysj\recyclingConveyorPlant.sysj line: 61, column: 3
  private boolean cleared_thread_1;//sysj\recyclingConveyorPlant.sysj line: 62, column: 3
  private boolean running_thread_1;//sysj\recyclingConveyorPlant.sysj line: 63, column: 3
  private boolean indexing_thread_1;//sysj\recyclingConveyorPlant.sysj line: 64, column: 3
  private int S242108 = 1;
  private int S238308 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S242108){
        case 0 : 
          S242108=0;
          break RUN;
        
        case 1 : 
          S242108=2;
          S242108=2;
          S238308=0;
          if(reset.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 54, column: 19
            S238308=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            STEP_thread_1 = PlantTiming.ticks(5);//sysj\recyclingConveyorPlant.sysj line: 55, column: 3
            LAST_thread_1 = 3;//sysj\recyclingConveyorPlant.sysj line: 56, column: 3
            pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 58, column: 3
            travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 59, column: 3
            injecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 60, column: 3
            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 61, column: 3
            cleared_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 62, column: 3
            running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 63, column: 3
            indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 64, column: 3
            if(enable.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 67, column: 12
              if(injectAtEntry.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 69, column: 13
                if(!injecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 70, column: 20
                  injecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 71, column: 7
                  if(pos_thread_1 < 0) {//sysj\recyclingConveyorPlant.sysj line: 72, column: 18
                    pos_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 73, column: 8
                    travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 74, column: 8
                    indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 75, column: 8
                    cleared_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 76, column: 8
                    System.out.println("[RCPlant] Bottle entered the recycling conveyor.");//sysj\recyclingConveyorPlant.sysj line: 77, column: 8
                  }
                }
                if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 85, column: 13
                  if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 91, column: 18
                    running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 92, column: 7
                    if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 93, column: 33
                      indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 94, column: 8
                    }
                  }
                  if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 98, column: 18
                    travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 99, column: 7
                    if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 100, column: 25
                      travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 101, column: 8
                      indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 102, column: 8
                      pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 103, column: 8
                      if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 104, column: 20
                        System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 104, column: 22
                      }
                      if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 105, column: 20
                        System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 105, column: 22
                      }
                      if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 106, column: 20
                        System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 106, column: 22
                      }
                    }
                  }
                  if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                    if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                      bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                      currsigs.addElement(bottleAtSplitterExit);
                      if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                        bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                        currsigs.addElement(bottleAtLidRemoval);
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                      if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                        bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                        currsigs.addElement(bottleAtLidRemoval);
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                    if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                      if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                        collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                        if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                          pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                          cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                          System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                        }
                      }
                      if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                        bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                        currsigs.addElement(bottleLeftReturn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                      if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                        bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                        currsigs.addElement(bottleLeftReturn);
                        active[1]=1;
                        ends[1]=1;
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
                  running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 111, column: 6
                  if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                    if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                      bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                      currsigs.addElement(bottleAtSplitterExit);
                      if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                        bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                        currsigs.addElement(bottleAtLidRemoval);
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                      if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                        bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                        currsigs.addElement(bottleAtLidRemoval);
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                    if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                      if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                        collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                        if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                          pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                          cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                          System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                        }
                      }
                      if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                        bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                        currsigs.addElement(bottleLeftReturn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                      if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                        bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                        currsigs.addElement(bottleLeftReturn);
                        active[1]=1;
                        ends[1]=1;
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
                injecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 82, column: 6
                if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 85, column: 13
                  if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 91, column: 18
                    running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 92, column: 7
                    if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 93, column: 33
                      indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 94, column: 8
                    }
                  }
                  if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 98, column: 18
                    travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 99, column: 7
                    if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 100, column: 25
                      travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 101, column: 8
                      indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 102, column: 8
                      pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 103, column: 8
                      if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 104, column: 20
                        System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 104, column: 22
                      }
                      if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 105, column: 20
                        System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 105, column: 22
                      }
                      if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 106, column: 20
                        System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 106, column: 22
                      }
                    }
                  }
                  if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                    if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                      bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                      currsigs.addElement(bottleAtSplitterExit);
                      if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                        bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                        currsigs.addElement(bottleAtLidRemoval);
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                      if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                        bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                        currsigs.addElement(bottleAtLidRemoval);
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                    if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                      if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                        collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                        if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                          pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                          cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                          System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                        }
                      }
                      if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                        bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                        currsigs.addElement(bottleLeftReturn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                      if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                        bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                        currsigs.addElement(bottleLeftReturn);
                        active[1]=1;
                        ends[1]=1;
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
                  running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 111, column: 6
                  if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                    if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                      bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                      currsigs.addElement(bottleAtSplitterExit);
                      if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                        bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                        currsigs.addElement(bottleAtLidRemoval);
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                      if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                        bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                        currsigs.addElement(bottleAtLidRemoval);
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                        if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                          bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                          currsigs.addElement(bottleAtDumper);
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                          if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                            bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                            currsigs.addElement(bottleAtReturn);
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                            if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                              if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                  pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                  cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                  System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                }
                              }
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                              if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                currsigs.addElement(bottleLeftReturn);
                                active[1]=1;
                                ends[1]=1;
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
                    if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                      if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                        collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                        if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                          pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                          cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                          System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                        }
                      }
                      if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                        bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                        currsigs.addElement(bottleLeftReturn);
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                      if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                        bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                        currsigs.addElement(bottleLeftReturn);
                        active[1]=1;
                        ends[1]=1;
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
        
        case 2 : 
          switch(S238308){
            case 0 : 
              if(reset.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 54, column: 19
                S238308=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                if(enable.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 67, column: 12
                  if(injectAtEntry.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 69, column: 13
                    if(!injecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 70, column: 20
                      injecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 71, column: 7
                      if(pos_thread_1 < 0) {//sysj\recyclingConveyorPlant.sysj line: 72, column: 18
                        pos_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 73, column: 8
                        travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 74, column: 8
                        indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 75, column: 8
                        cleared_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 76, column: 8
                        System.out.println("[RCPlant] Bottle entered the recycling conveyor.");//sysj\recyclingConveyorPlant.sysj line: 77, column: 8
                      }
                    }
                    if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 85, column: 13
                      if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 91, column: 18
                        running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 92, column: 7
                        if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 93, column: 33
                          indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 94, column: 8
                        }
                      }
                      if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 98, column: 18
                        travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 99, column: 7
                        if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 100, column: 25
                          travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 101, column: 8
                          indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 102, column: 8
                          pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 103, column: 8
                          if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 104, column: 20
                            System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 104, column: 22
                          }
                          if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 105, column: 20
                            System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 105, column: 22
                          }
                          if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 106, column: 20
                            System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 106, column: 22
                          }
                        }
                      }
                      if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                        if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                          bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                          currsigs.addElement(bottleAtSplitterExit);
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                        if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                          if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                            collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                            if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                              pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                              cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                              System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                            }
                          }
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
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
                      running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 111, column: 6
                      if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                        if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                          bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                          currsigs.addElement(bottleAtSplitterExit);
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                        if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                          if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                            collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                            if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                              pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                              cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                              System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                            }
                          }
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
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
                    injecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 82, column: 6
                    if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 85, column: 13
                      if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 91, column: 18
                        running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 92, column: 7
                        if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 93, column: 33
                          indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 94, column: 8
                        }
                      }
                      if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 98, column: 18
                        travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 99, column: 7
                        if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 100, column: 25
                          travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 101, column: 8
                          indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 102, column: 8
                          pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 103, column: 8
                          if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 104, column: 20
                            System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 104, column: 22
                          }
                          if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 105, column: 20
                            System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 105, column: 22
                          }
                          if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 106, column: 20
                            System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 106, column: 22
                          }
                        }
                      }
                      if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                        if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                          bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                          currsigs.addElement(bottleAtSplitterExit);
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                        if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                          if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                            collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                            if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                              pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                              cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                              System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                            }
                          }
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
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
                      running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 111, column: 6
                      if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                        if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                          bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                          currsigs.addElement(bottleAtSplitterExit);
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                        if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                          if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                            collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                            if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                              pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                              cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                              System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                            }
                          }
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
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
            
            case 1 : 
              S238308=1;
              S238308=0;
              if(reset.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 54, column: 19
                S238308=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                STEP_thread_1 = PlantTiming.ticks(5);//sysj\recyclingConveyorPlant.sysj line: 55, column: 3
                LAST_thread_1 = 3;//sysj\recyclingConveyorPlant.sysj line: 56, column: 3
                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 58, column: 3
                travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 59, column: 3
                injecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 60, column: 3
                collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 61, column: 3
                cleared_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 62, column: 3
                running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 63, column: 3
                indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 64, column: 3
                if(enable.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 67, column: 12
                  if(injectAtEntry.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 69, column: 13
                    if(!injecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 70, column: 20
                      injecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 71, column: 7
                      if(pos_thread_1 < 0) {//sysj\recyclingConveyorPlant.sysj line: 72, column: 18
                        pos_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 73, column: 8
                        travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 74, column: 8
                        indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 75, column: 8
                        cleared_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 76, column: 8
                        System.out.println("[RCPlant] Bottle entered the recycling conveyor.");//sysj\recyclingConveyorPlant.sysj line: 77, column: 8
                      }
                    }
                    if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 85, column: 13
                      if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 91, column: 18
                        running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 92, column: 7
                        if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 93, column: 33
                          indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 94, column: 8
                        }
                      }
                      if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 98, column: 18
                        travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 99, column: 7
                        if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 100, column: 25
                          travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 101, column: 8
                          indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 102, column: 8
                          pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 103, column: 8
                          if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 104, column: 20
                            System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 104, column: 22
                          }
                          if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 105, column: 20
                            System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 105, column: 22
                          }
                          if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 106, column: 20
                            System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 106, column: 22
                          }
                        }
                      }
                      if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                        if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                          bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                          currsigs.addElement(bottleAtSplitterExit);
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                        if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                          if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                            collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                            if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                              pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                              cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                              System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                            }
                          }
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
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
                      running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 111, column: 6
                      if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                        if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                          bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                          currsigs.addElement(bottleAtSplitterExit);
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                        if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                          if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                            collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                            if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                              pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                              cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                              System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                            }
                          }
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
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
                    injecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 82, column: 6
                    if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 85, column: 13
                      if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 91, column: 18
                        running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 92, column: 7
                        if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 93, column: 33
                          indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 94, column: 8
                        }
                      }
                      if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 98, column: 18
                        travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 99, column: 7
                        if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 100, column: 25
                          travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 101, column: 8
                          indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 102, column: 8
                          pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 103, column: 8
                          if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 104, column: 20
                            System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 104, column: 22
                          }
                          if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 105, column: 20
                            System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 105, column: 22
                          }
                          if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 106, column: 20
                            System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 106, column: 22
                          }
                        }
                      }
                      if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                        if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                          bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                          currsigs.addElement(bottleAtSplitterExit);
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                        if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                          if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                            collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                            if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                              pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                              cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                              System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                            }
                          }
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
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
                      running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 111, column: 6
                      if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 117, column: 8
                        if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 118, column: 9
                          bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 118, column: 20
                          currsigs.addElement(bottleAtSplitterExit);
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                          if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 119, column: 9
                            bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 119, column: 20
                            currsigs.addElement(bottleAtLidRemoval);
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                            if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 120, column: 9
                              bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 120, column: 20
                              currsigs.addElement(bottleAtDumper);
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                              if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 121, column: 9
                                bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 121, column: 20
                                currsigs.addElement(bottleAtReturn);
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                                if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                                  if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                                    collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                                    if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                                      pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                                      cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                                      System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                                    }
                                  }
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                  else {
                                    active[1]=1;
                                    ends[1]=1;
                                    break RUN;
                                  }
                                }
                                else {
                                  collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                                  if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                                    bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                                    currsigs.addElement(bottleLeftReturn);
                                    active[1]=1;
                                    ends[1]=1;
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
                        if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 124, column: 13
                          if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 21
                            collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 126, column: 7
                            if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 127, column: 22
                              pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 128, column: 8
                              cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 129, column: 8
                              System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 130, column: 8
                            }
                          }
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 6
                          if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 138, column: 5
                            bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 139, column: 6
                            currsigs.addElement(bottleLeftReturn);
                            active[1]=1;
                            ends[1]=1;
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
          reset.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      recyclingConveyorMotor.setpreclear();
      injectAtEntry.setpreclear();
      collectAtReturn.setpreclear();
      reset.setpreclear();
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
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
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
