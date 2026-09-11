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
  private int TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 49, column: 2
  private int STROKE_thread_1;//sysj\splitterPlant.sysj line: 51, column: 2
  private int RELEASE_thread_1;//sysj\splitterPlant.sysj line: 53, column: 2
  private int travel_thread_1;//sysj\splitterPlant.sysj line: 57, column: 2
  private boolean atPoint_thread_1;//sysj\splitterPlant.sysj line: 59, column: 2
  private boolean departed_thread_1;//sysj\splitterPlant.sysj line: 61, column: 2
  private int release_thread_1;//sysj\splitterPlant.sysj line: 63, column: 2
  private int stroke_thread_1;//sysj\splitterPlant.sysj line: 65, column: 2
  private boolean admitting_thread_1;//sysj\splitterPlant.sysj line: 67, column: 2
  private int S248721 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S248721){
        case 0 : 
          S248721=0;
          break RUN;
        
        case 1 : 
          S248721=2;
          S248721=2;
          TRAVEL_thread_1 = 4;//sysj\splitterPlant.sysj line: 49, column: 2
          STROKE_thread_1 = 3;//sysj\splitterPlant.sysj line: 51, column: 2
          RELEASE_thread_1 = 2;//sysj\splitterPlant.sysj line: 53, column: 2
          travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 57, column: 2
          atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 59, column: 2
          departed_thread_1 = false;//sysj\splitterPlant.sysj line: 61, column: 2
          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 63, column: 2
          stroke_thread_1 = 0;//sysj\splitterPlant.sysj line: 65, column: 2
          admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 67, column: 2
          if(enable.getprestatus()){//sysj\splitterPlant.sysj line: 73, column: 11
            if(admitBottle.getprestatus()){//sysj\splitterPlant.sysj line: 87, column: 12
              if(!admitting_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 19
                admitting_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 6
                if(!atPoint_thread_1 && travel_thread_1 < 0) {//sysj\splitterPlant.sysj line: 93, column: 32
                  travel_thread_1 = TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 95, column: 7
                  departed_thread_1 = false;//sysj\splitterPlant.sysj line: 97, column: 7
                  System.out.println("[SPPlant] Bottle claimed from the outfeed.");//sysj\splitterPlant.sysj line: 99, column: 7
                }
              }
              if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 115, column: 18
                travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 117, column: 5
              }
              if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 121, column: 19
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 123, column: 5
                atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 125, column: 5
                System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 127, column: 5
              }
              if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 135, column: 12
                if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 137, column: 24
                  stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 137, column: 26
                }
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 141, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 143, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 143, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 141, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 143, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 143, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
              admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 109, column: 5
              if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 115, column: 18
                travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 117, column: 5
              }
              if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 121, column: 19
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 123, column: 5
                atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 125, column: 5
                System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 127, column: 5
              }
              if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 135, column: 12
                if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 137, column: 24
                  stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 137, column: 26
                }
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 141, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 143, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 143, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 141, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 143, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 143, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
          if(enable.getprestatus()){//sysj\splitterPlant.sysj line: 73, column: 11
            if(admitBottle.getprestatus()){//sysj\splitterPlant.sysj line: 87, column: 12
              if(!admitting_thread_1) {//sysj\splitterPlant.sysj line: 89, column: 19
                admitting_thread_1 = true;//sysj\splitterPlant.sysj line: 91, column: 6
                if(!atPoint_thread_1 && travel_thread_1 < 0) {//sysj\splitterPlant.sysj line: 93, column: 32
                  travel_thread_1 = TRAVEL_thread_1;//sysj\splitterPlant.sysj line: 95, column: 7
                  departed_thread_1 = false;//sysj\splitterPlant.sysj line: 97, column: 7
                  System.out.println("[SPPlant] Bottle claimed from the outfeed.");//sysj\splitterPlant.sysj line: 99, column: 7
                }
              }
              if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 115, column: 18
                travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 117, column: 5
              }
              if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 121, column: 19
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 123, column: 5
                atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 125, column: 5
                System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 127, column: 5
              }
              if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 135, column: 12
                if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 137, column: 24
                  stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 137, column: 26
                }
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 141, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 143, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 143, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 141, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 143, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 143, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
              admitting_thread_1 = false;//sysj\splitterPlant.sysj line: 109, column: 5
              if(travel_thread_1 > 0) {//sysj\splitterPlant.sysj line: 115, column: 18
                travel_thread_1 = travel_thread_1 - 1;//sysj\splitterPlant.sysj line: 117, column: 5
              }
              if(travel_thread_1 == 0) {//sysj\splitterPlant.sysj line: 121, column: 19
                travel_thread_1 = -1;//sysj\splitterPlant.sysj line: 123, column: 5
                atPoint_thread_1 = true;//sysj\splitterPlant.sysj line: 125, column: 5
                System.out.println("[SPPlant] Bottle at the quality splitter.");//sysj\splitterPlant.sysj line: 127, column: 5
              }
              if(diverterExtend.getprestatus()){//sysj\splitterPlant.sysj line: 135, column: 12
                if(stroke_thread_1 < STROKE_thread_1) {//sysj\splitterPlant.sysj line: 137, column: 24
                  stroke_thread_1 = stroke_thread_1 + 1;//sysj\splitterPlant.sysj line: 137, column: 26
                }
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 141, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 143, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 143, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                if(diverterRetract.getprestatus()){//sysj\splitterPlant.sysj line: 141, column: 12
                  if(stroke_thread_1 > 0) {//sysj\splitterPlant.sysj line: 143, column: 19
                    stroke_thread_1 = stroke_thread_1 - 1;//sysj\splitterPlant.sysj line: 143, column: 21
                  }
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(stroke_thread_1 == 0){//sysj\splitterPlant.sysj line: 153, column: 7
                    divertAtNormal.setPresent();//sysj\splitterPlant.sysj line: 155, column: 5
                    currsigs.addElement(divertAtNormal);
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(stroke_thread_1 == STROKE_thread_1){//sysj\splitterPlant.sysj line: 159, column: 7
                      divertAtReject.setPresent();//sysj\splitterPlant.sysj line: 161, column: 5
                      currsigs.addElement(divertAtReject);
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(atPoint_thread_1){//sysj\splitterPlant.sysj line: 169, column: 4
                        bottleAtSplitter.setPresent();//sysj\splitterPlant.sysj line: 171, column: 5
                        currsigs.addElement(bottleAtSplitter);
                        if(stroke_thread_1 == STROKE_thread_1) {//sysj\splitterPlant.sysj line: 173, column: 25
                          release_thread_1 = release_thread_1 + 1;//sysj\splitterPlant.sysj line: 175, column: 6
                          if(release_thread_1 >= RELEASE_thread_1) {//sysj\splitterPlant.sysj line: 177, column: 28
                            atPoint_thread_1 = false;//sysj\splitterPlant.sysj line: 179, column: 7
                            departed_thread_1 = true;//sysj\splitterPlant.sysj line: 181, column: 7
                            release_thread_1 = 0;//sysj\splitterPlant.sysj line: 183, column: 7
                            System.out.println("[SPPlant] Bottle diverted onto the recycling conveyor.");//sysj\splitterPlant.sysj line: 185, column: 7
                          }
                        }
                        else {//sysj\splitterPlant.sysj line: 191, column: 10
                          release_thread_1 = 0;//sysj\splitterPlant.sysj line: 193, column: 6
                        }
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(departed_thread_1){//sysj\splitterPlant.sysj line: 205, column: 4
                          bottleLeftSplitter.setPresent();//sysj\splitterPlant.sysj line: 207, column: 5
                          currsigs.addElement(bottleLeftSplitter);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
