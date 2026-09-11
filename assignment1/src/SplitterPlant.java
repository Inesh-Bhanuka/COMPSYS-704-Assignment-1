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
  public Signal bottleAtSplitter = new Signal("bottleAtSplitter", Signal.OUTPUT);
  public Signal divertAtNormal = new Signal("divertAtNormal", Signal.OUTPUT);
  public Signal divertAtReject = new Signal("divertAtReject", Signal.OUTPUT);
  public Signal bottleLeftSplitter = new Signal("bottleLeftSplitter", Signal.OUTPUT);
  private int TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 25, column: 2
  private int STROKE_thread_1;//sysj\splitterPlant.sysj line: 26, column: 2
  private int RELEASE_thread_1;//sysj\splitterPlant.sysj line: 27, column: 2
  private int travel_thread_1;//sysj\splitterPlant.sysj line: 29, column: 2
  private boolean atPoint_thread_1;//sysj\splitterPlant.sysj line: 30, column: 2
  private boolean departed_thread_1;//sysj\splitterPlant.sysj line: 31, column: 2
  private int release_thread_1;//sysj\splitterPlant.sysj line: 32, column: 2
  private int stroke_thread_1;//sysj\splitterPlant.sysj line: 33, column: 2
  private boolean admitting_thread_1;//sysj\splitterPlant.sysj line: 34, column: 2
  private int S207792 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S207792){
        case 0 : 
          S207792=0;
          break RUN;
        
        case 1 : 
          S207792=2;
          S207792=2;
          TRAVEL_thread_1 = 4;//sysj\splitterPlant.sysj line: 25, column: 2
          STROKE_thread_1 = 3;//sysj\splitterPlant.sysj line: 26, column: 2
          RELEASE_thread_1 = 2;//sysj\splitterPlant.sysj line: 27, column: 2
          travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 29, column: 2
          atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 30, column: 2
          departed_thread_1 = false;//sysj\splitterPlant.sysj line: 31, column: 2
          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 32, column: 2
          stroke_thread_1 = 0;//sysj\splitterPlant.sysj line: 33, column: 2
          admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 34, column: 2
          if(enable.getprestatus()){//sysj\splitterPlant.sysj line: 37, column: 11
            if(admitBottle.getprestatus()){//sysj\splitterPlant.sysj line: 44, column: 12
              if(!admitting_thread_1) {//sysj\splitterPlant.sysj line: 45, column: 19
                admitting_thread_1 = true;//sysj\splitterPlant.sysj line: 46, column: 6
                if(!atPoint_thread_1 && travel_thread_1 < 0) {//sysj\splitterPlant.sysj line: 47, column: 32
                  travel_thread_1 = TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 48, column: 7
                  departed_thread_1 = false;//sysj\splitterPlant.sysj line: 49, column: 7
                  System.out.println("[SPPlant] Bottle claimed from the outfeed.");//sysj\splitterPlant.sysj line: 50, column: 7
                }
              }
              if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 58, column: 18
                travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 59, column: 5
              }
              if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 61, column: 19
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 62, column: 5
                atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 63, column: 5
                System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 64, column: 5
              }
              if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 68, column: 12
                if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 69, column: 24
                  stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 69, column: 26
                }
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 71, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 72, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 72, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 71, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 72, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 72, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
              admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 55, column: 5
              if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 58, column: 18
                travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 59, column: 5
              }
              if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 61, column: 19
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 62, column: 5
                atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 63, column: 5
                System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 64, column: 5
              }
              if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 68, column: 12
                if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 69, column: 24
                  stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 69, column: 26
                }
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 71, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 72, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 72, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 71, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 72, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 72, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
        
        case 2 : 
          if(enable.getprestatus()){//sysj\splitterPlant.sysj line: 37, column: 11
            if(admitBottle.getprestatus()){//sysj\splitterPlant.sysj line: 44, column: 12
              if(!admitting_thread_1) {//sysj\splitterPlant.sysj line: 45, column: 19
                admitting_thread_1 = true;//sysj\splitterPlant.sysj line: 46, column: 6
                if(!atPoint_thread_1 && travel_thread_1 < 0) {//sysj\splitterPlant.sysj line: 47, column: 32
                  travel_thread_1 = TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 48, column: 7
                  departed_thread_1 = false;//sysj\splitterPlant.sysj line: 49, column: 7
                  System.out.println("[SPPlant] Bottle claimed from the outfeed.");//sysj\splitterPlant.sysj line: 50, column: 7
                }
              }
              if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 58, column: 18
                travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 59, column: 5
              }
              if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 61, column: 19
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 62, column: 5
                atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 63, column: 5
                System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 64, column: 5
              }
              if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 68, column: 12
                if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 69, column: 24
                  stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 69, column: 26
                }
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 71, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 72, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 72, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 71, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 72, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 72, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
              admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 55, column: 5
              if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 58, column: 18
                travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 59, column: 5
              }
              if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 61, column: 19
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 62, column: 5
                atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 63, column: 5
                System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 64, column: 5
              }
              if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 68, column: 12
                if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 69, column: 24
                  stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 69, column: 26
                }
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 71, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 72, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 72, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 71, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 72, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 72, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 77, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 78, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 80, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 81, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 85, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 86, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 87, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 88, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 90, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 92, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 93, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 96, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 97, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 103, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 104, column: 5
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
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      admitBottle.setpreclear();
      diverterExtend.setpreclear();
      diverterRetract.setpreclear();
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
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
