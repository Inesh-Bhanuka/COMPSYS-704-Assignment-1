import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class SplitterPlant extends ClockDomain{
  public SplitterPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal admitBottle = new Signal("admitBottle", Signal.INPUT);
  public Signal diverterExtend = new Signal("diverterExtend", Signal.INPUT);
  public Signal diverterRetract = new Signal("diverterRetract", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal bottleAtSplitter = new Signal("bottleAtSplitter", Signal.OUTPUT);
  public Signal divertAtNormal = new Signal("divertAtNormal", Signal.OUTPUT);
  public Signal divertAtReject = new Signal("divertAtReject", Signal.OUTPUT);
  public Signal bottleLeftSplitter = new Signal("bottleLeftSplitter", Signal.OUTPUT);
  private int TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 32, column: 3
  private int STROKE_thread_1;//sysj\splitterPlant.sysj line: 33, column: 3
  private int RELEASE_thread_1;//sysj\splitterPlant.sysj line: 34, column: 3
  private int travel_thread_1;//sysj\splitterPlant.sysj line: 36, column: 3
  private boolean atPoint_thread_1;//sysj\splitterPlant.sysj line: 37, column: 3
  private boolean departed_thread_1;//sysj\splitterPlant.sysj line: 38, column: 3
  private int release_thread_1;//sysj\splitterPlant.sysj line: 39, column: 3
  private int stroke_thread_1;//sysj\splitterPlant.sysj line: 40, column: 3
  private boolean admitting_thread_1;//sysj\splitterPlant.sysj line: 41, column: 3
  private int S591818 = 1;
  private int S589782 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S591818){
        case 0 : 
          S591818=0;
          break RUN;
        
        case 1 : 
          S591818=2;
          S591818=2;
          S589782=0;
          if(reset.getprestatus()){//sysj\splitterPlant.sysj line: 31, column: 19
            S589782=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            TRAVEL_thread_1 = PlantTiming.ticks(4);//sysj\splitterPlant.sysj line: 32, column: 3
            STROKE_thread_1 = PlantTiming.ticks(3);//sysj\splitterPlant.sysj line: 33, column: 3
            RELEASE_thread_1 = PlantTiming.ticks(2);//sysj\splitterPlant.sysj line: 34, column: 3
            travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 36, column: 3
            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 37, column: 3
            departed_thread_1 = false;//sysj\splitterPlant.sysj line: 38, column: 3
            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 39, column: 3
            stroke_thread_1 = 0;//sysj\splitterPlant.sysj line: 40, column: 3
            admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 41, column: 3
            if(enable.getprestatus()){//sysj\splitterPlant.sysj line: 44, column: 12
              if(admitBottle.getprestatus()){//sysj\splitterPlant.sysj line: 51, column: 13
                if(!admitting_thread_1) {//sysj\splitterPlant.sysj line: 52, column: 20
                  admitting_thread_1 = true;//sysj\splitterPlant.sysj line: 53, column: 7
                  if(!atPoint_thread_1 && travel_thread_1 < 0) {//sysj\splitterPlant.sysj line: 54, column: 33
                    travel_thread_1 = TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 55, column: 8
                    departed_thread_1 = false;//sysj\splitterPlant.sysj line: 56, column: 8
                    System.out.println("[SPPlant] Bottle claimed from the outfeed.");//sysj\splitterPlant.sysj line: 57, column: 8
                  }
                }
                if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 65, column: 19
                  travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 66, column: 6
                }
                if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 68, column: 20
                  travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 69, column: 6
                  atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 70, column: 6
                  System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 71, column: 6
                }
                if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 75, column: 13
                  if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 76, column: 25
                    stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 76, column: 27
                  }
                  if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                    if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                      stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                    }
                    if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                      divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                      currsigs.addElement(divertAtNormal);
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                    if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                      divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                      currsigs.addElement(divertAtNormal);
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                  if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                    if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                      stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                    }
                    if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                      divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                      currsigs.addElement(divertAtNormal);
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                    if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                      divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                      currsigs.addElement(divertAtNormal);
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 62, column: 6
                if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 65, column: 19
                  travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 66, column: 6
                }
                if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 68, column: 20
                  travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 69, column: 6
                  atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 70, column: 6
                  System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 71, column: 6
                }
                if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 75, column: 13
                  if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 76, column: 25
                    stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 76, column: 27
                  }
                  if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                    if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                      stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                    }
                    if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                      divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                      currsigs.addElement(divertAtNormal);
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                    if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                      divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                      currsigs.addElement(divertAtNormal);
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                  if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                    if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                      stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                    }
                    if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                      divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                      currsigs.addElement(divertAtNormal);
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                    if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                      divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                      currsigs.addElement(divertAtNormal);
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
                      if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                        divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                        currsigs.addElement(divertAtReject);
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                          bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                          currsigs.addElement(bottleAtSplitter);
                          if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                            release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                            if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                              atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                              departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                              release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                              if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                              }
                              else {//sysj\splitterPlant.sysj line: 107, column: 13
                                System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                              }
                            }
                          }
                          else {//sysj\splitterPlant.sysj line: 112, column: 11
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                          }
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                            bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                            currsigs.addElement(bottleLeftSplitter);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
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
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S589782){
            case 0 : 
              if(reset.getprestatus()){//sysj\splitterPlant.sysj line: 31, column: 19
                S589782=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                if(enable.getprestatus()){//sysj\splitterPlant.sysj line: 44, column: 12
                  if(admitBottle.getprestatus()){//sysj\splitterPlant.sysj line: 51, column: 13
                    if(!admitting_thread_1) {//sysj\splitterPlant.sysj line: 52, column: 20
                      admitting_thread_1 = true;//sysj\splitterPlant.sysj line: 53, column: 7
                      if(!atPoint_thread_1 && travel_thread_1 < 0) {//sysj\splitterPlant.sysj line: 54, column: 33
                        travel_thread_1 = TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 55, column: 8
                        departed_thread_1 = false;//sysj\splitterPlant.sysj line: 56, column: 8
                        System.out.println("[SPPlant] Bottle claimed from the outfeed.");//sysj\splitterPlant.sysj line: 57, column: 8
                      }
                    }
                    if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 65, column: 19
                      travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 66, column: 6
                    }
                    if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 68, column: 20
                      travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 69, column: 6
                      atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 70, column: 6
                      System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 71, column: 6
                    }
                    if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 75, column: 13
                      if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 76, column: 25
                        stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 76, column: 27
                      }
                      if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                        if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                          stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                        }
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                      if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                        if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                          stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                        }
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                    admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 62, column: 6
                    if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 65, column: 19
                      travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 66, column: 6
                    }
                    if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 68, column: 20
                      travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 69, column: 6
                      atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 70, column: 6
                      System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 71, column: 6
                    }
                    if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 75, column: 13
                      if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 76, column: 25
                        stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 76, column: 27
                      }
                      if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                        if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                          stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                        }
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                      if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                        if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                          stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                        }
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              S589782=1;
              S589782=0;
              if(reset.getprestatus()){//sysj\splitterPlant.sysj line: 31, column: 19
                S589782=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                TRAVEL_thread_1 = PlantTiming.ticks(4);//sysj\splitterPlant.sysj line: 32, column: 3
                STROKE_thread_1 = PlantTiming.ticks(3);//sysj\splitterPlant.sysj line: 33, column: 3
                RELEASE_thread_1 = PlantTiming.ticks(2);//sysj\splitterPlant.sysj line: 34, column: 3
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 36, column: 3
                atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 37, column: 3
                departed_thread_1 = false;//sysj\splitterPlant.sysj line: 38, column: 3
                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 39, column: 3
                stroke_thread_1 = 0;//sysj\splitterPlant.sysj line: 40, column: 3
                admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 41, column: 3
                if(enable.getprestatus()){//sysj\splitterPlant.sysj line: 44, column: 12
                  if(admitBottle.getprestatus()){//sysj\splitterPlant.sysj line: 51, column: 13
                    if(!admitting_thread_1) {//sysj\splitterPlant.sysj line: 52, column: 20
                      admitting_thread_1 = true;//sysj\splitterPlant.sysj line: 53, column: 7
                      if(!atPoint_thread_1 && travel_thread_1 < 0) {//sysj\splitterPlant.sysj line: 54, column: 33
                        travel_thread_1 = TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 55, column: 8
                        departed_thread_1 = false;//sysj\splitterPlant.sysj line: 56, column: 8
                        System.out.println("[SPPlant] Bottle claimed from the outfeed.");//sysj\splitterPlant.sysj line: 57, column: 8
                      }
                    }
                    if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 65, column: 19
                      travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 66, column: 6
                    }
                    if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 68, column: 20
                      travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 69, column: 6
                      atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 70, column: 6
                      System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 71, column: 6
                    }
                    if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 75, column: 13
                      if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 76, column: 25
                        stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 76, column: 27
                      }
                      if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                        if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                          stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                        }
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                      if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                        if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                          stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                        }
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                    admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 62, column: 6
                    if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 65, column: 19
                      travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 66, column: 6
                    }
                    if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 68, column: 20
                      travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 69, column: 6
                      atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 70, column: 6
                      System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 71, column: 6
                    }
                    if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 75, column: 13
                      if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 76, column: 25
                        stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 76, column: 27
                      }
                      if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                        if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                          stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                        }
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                      if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 78, column: 13
                        if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 79, column: 20
                          stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 79, column: 22
                        }
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                        if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 84, column: 8
                          divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 85, column: 6
                          currsigs.addElement(divertAtNormal);
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
                          if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 87, column: 8
                            divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 88, column: 6
                            currsigs.addElement(divertAtReject);
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                          }
                          else {
                            if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 96, column: 5
                              bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 97, column: 6
                              currsigs.addElement(bottleAtSplitter);
                              if(stroke_thread_1 == 0 || stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 98, column: 41
                                release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 99, column: 7
                                if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 100, column: 29
                                  atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 101, column: 8
                                  departed_thread_1 = true;//sysj\splitterPlant.sysj line: 102, column: 8
                                  release_thread_1 = 0;//sysj\splitterPlant.sysj line: 103, column: 8
                                  if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 104, column: 28
                                    System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 105, column: 9
                                  }
                                  else {//sysj\splitterPlant.sysj line: 107, column: 13
                                    System.out.println("[SPPlant] Bottle carried on to the labeller.");//sysj\splitterPlant.sysj line: 108, column: 9
                                  }
                                }
                              }
                              else {//sysj\splitterPlant.sysj line: 112, column: 11
                                release_thread_1 = 0;//sysj\splitterPlant.sysj line: 113, column: 7
                              }
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                              else {
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
                              }
                            }
                            else {
                              if(departed_thread_1){//sysj\splitterPlant.sysj line: 119, column: 5
                                bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 120, column: 6
                                currsigs.addElement(bottleLeftSplitter);
                                active[1]=1;
                                ends[1]=1;
                                break RUN;
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
          admitBottle.gethook();
          diverterExtend.gethook();
          diverterRetract.gethook();
          reset.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      admitBottle.setpreclear();
      diverterExtend.setpreclear();
      diverterRetract.setpreclear();
      reset.setpreclear();
      bottleAtSplitter.setpreclear();
      divertAtNormal.setpreclear();
      divertAtReject.setpreclear();
      bottleLeftSplitter.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = admitBottle.getStatus() ? admitBottle.setprepresent() : admitBottle.setpreclear();
      admitBottle.setpreval(admitBottle.getValue());
      admitBottle.setClear();
      dummyint = diverterExtend.getStatus() ? diverterExtend.setprepresent() : diverterExtend.setpreclear();
      diverterExtend.setpreval(diverterExtend.getValue());
      diverterExtend.setClear();
      dummyint = diverterRetract.getStatus() ? diverterRetract.setprepresent() : diverterRetract.setpreclear();
      diverterRetract.setpreval(diverterRetract.getValue());
      diverterRetract.setClear();
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
      bottleAtSplitter.sethook();
      bottleAtSplitter.setClear();
      divertAtNormal.sethook();
      divertAtNormal.setClear();
      divertAtReject.sethook();
      divertAtReject.setClear();
      bottleLeftSplitter.sethook();
      bottleLeftSplitter.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        admitBottle.gethook();
        diverterExtend.gethook();
        diverterRetract.gethook();
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
