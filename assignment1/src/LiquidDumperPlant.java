import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LiquidDumperPlant extends ClockDomain{
  public LiquidDumperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal invertRotateExtend = new Signal("invertRotateExtend", Signal.INPUT);
  public Signal invertRotateRetract = new Signal("invertRotateRetract", Signal.INPUT);
  public Signal drainValveOnOff = new Signal("drainValveOnOff", Signal.INPUT);
  public Signal clampClosed = new Signal("clampClosed", Signal.OUTPUT);
  public Signal bottleInverted = new Signal("bottleInverted", Signal.OUTPUT);
  public Signal bottleUpright = new Signal("bottleUpright", Signal.OUTPUT);
  public Signal bottleDrained = new Signal("bottleDrained", Signal.OUTPUT);
  public Signal wasteTankLevel = new Signal("wasteTankLevel", Signal.OUTPUT);
  private int CLAMP_thread_1;//sysj\liquidDumperPlant.sysj line: 28, column: 2
  private int ROTATE_thread_1;//sysj\liquidDumperPlant.sysj line: 29, column: 2
  private int DRAIN_thread_1;//sysj\liquidDumperPlant.sysj line: 30, column: 2
  private int clamp_thread_1;//sysj\liquidDumperPlant.sysj line: 32, column: 2
  private int angle_thread_1;//sysj\liquidDumperPlant.sysj line: 33, column: 2
  private int drain_thread_1;//sysj\liquidDumperPlant.sysj line: 34, column: 2
  private boolean drained_thread_1;//sysj\liquidDumperPlant.sysj line: 35, column: 2
  private int tank_thread_1;//sysj\liquidDumperPlant.sysj line: 36, column: 2
  private int S118773 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S118773){
        case 0 : 
          S118773=0;
          break RUN;
        
        case 1 : 
          S118773=2;
          S118773=2;
          CLAMP_thread_1 = 3;//sysj\liquidDumperPlant.sysj line: 28, column: 2
          ROTATE_thread_1 = 5;//sysj\liquidDumperPlant.sysj line: 29, column: 2
          DRAIN_thread_1 = 8;//sysj\liquidDumperPlant.sysj line: 30, column: 2
          clamp_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 32, column: 2
          angle_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 33, column: 2
          drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 34, column: 2
          drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 35, column: 2
          tank_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 36, column: 2
          if(enable.getprestatus()){//sysj\liquidDumperPlant.sysj line: 39, column: 11
            if(cylClampBottleExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 42, column: 12
              if(clamp_thread_1 < CLAMP_thread_1) {//sysj\liquidDumperPlant.sysj line: 43, column: 22
                clamp_thread_1 = clamp_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 43, column: 24
              }
              if(clamp_thread_1 == CLAMP_thread_1){//sysj\liquidDumperPlant.sysj line: 48, column: 7
                clampClosed.setPresent();//sysj\liquidDumperPlant.sysj line: 48, column: 24
                currsigs.addElement(clampClosed);
                if(invertRotateExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 51, column: 12
                  if(angle_thread_1 < ROTATE_thread_1) {//sysj\liquidDumperPlant.sysj line: 52, column: 23
                    angle_thread_1 = angle_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 52, column: 25
                  }
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                if(invertRotateExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 51, column: 12
                  if(angle_thread_1 < ROTATE_thread_1) {//sysj\liquidDumperPlant.sysj line: 52, column: 23
                    angle_thread_1 = angle_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 52, column: 25
                  }
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
              if(clamp_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 46, column: 18
                clamp_thread_1 = clamp_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 46, column: 20
              }
              if(clamp_thread_1 == CLAMP_thread_1){//sysj\liquidDumperPlant.sysj line: 48, column: 7
                clampClosed.setPresent();//sysj\liquidDumperPlant.sysj line: 48, column: 24
                currsigs.addElement(clampClosed);
                if(invertRotateExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 51, column: 12
                  if(angle_thread_1 < ROTATE_thread_1) {//sysj\liquidDumperPlant.sysj line: 52, column: 23
                    angle_thread_1 = angle_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 52, column: 25
                  }
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                if(invertRotateExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 51, column: 12
                  if(angle_thread_1 < ROTATE_thread_1) {//sysj\liquidDumperPlant.sysj line: 52, column: 23
                    angle_thread_1 = angle_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 52, column: 25
                  }
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
          if(enable.getprestatus()){//sysj\liquidDumperPlant.sysj line: 39, column: 11
            if(cylClampBottleExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 42, column: 12
              if(clamp_thread_1 < CLAMP_thread_1) {//sysj\liquidDumperPlant.sysj line: 43, column: 22
                clamp_thread_1 = clamp_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 43, column: 24
              }
              if(clamp_thread_1 == CLAMP_thread_1){//sysj\liquidDumperPlant.sysj line: 48, column: 7
                clampClosed.setPresent();//sysj\liquidDumperPlant.sysj line: 48, column: 24
                currsigs.addElement(clampClosed);
                if(invertRotateExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 51, column: 12
                  if(angle_thread_1 < ROTATE_thread_1) {//sysj\liquidDumperPlant.sysj line: 52, column: 23
                    angle_thread_1 = angle_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 52, column: 25
                  }
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                if(invertRotateExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 51, column: 12
                  if(angle_thread_1 < ROTATE_thread_1) {//sysj\liquidDumperPlant.sysj line: 52, column: 23
                    angle_thread_1 = angle_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 52, column: 25
                  }
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
              if(clamp_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 46, column: 18
                clamp_thread_1 = clamp_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 46, column: 20
              }
              if(clamp_thread_1 == CLAMP_thread_1){//sysj\liquidDumperPlant.sysj line: 48, column: 7
                clampClosed.setPresent();//sysj\liquidDumperPlant.sysj line: 48, column: 24
                currsigs.addElement(clampClosed);
                if(invertRotateExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 51, column: 12
                  if(angle_thread_1 < ROTATE_thread_1) {//sysj\liquidDumperPlant.sysj line: 52, column: 23
                    angle_thread_1 = angle_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 52, column: 25
                  }
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                if(invertRotateExtend.getprestatus()){//sysj\liquidDumperPlant.sysj line: 51, column: 12
                  if(angle_thread_1 < ROTATE_thread_1) {//sysj\liquidDumperPlant.sysj line: 52, column: 23
                    angle_thread_1 = angle_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 52, column: 25
                  }
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
                  if(invertRotateRetract.getprestatus()){//sysj\liquidDumperPlant.sysj line: 54, column: 12
                    if(angle_thread_1 > 0) {//sysj\liquidDumperPlant.sysj line: 55, column: 18
                      angle_thread_1 = angle_thread_1 - 1;//sysj\liquidDumperPlant.sysj line: 55, column: 20
                    }
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    if(angle_thread_1 == ROTATE_thread_1){//sysj\liquidDumperPlant.sysj line: 57, column: 7
                      bottleInverted.setPresent();//sysj\liquidDumperPlant.sysj line: 57, column: 25
                      currsigs.addElement(bottleInverted);
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(angle_thread_1 == 0){//sysj\liquidDumperPlant.sysj line: 58, column: 7
                        bottleUpright.setPresent();//sysj\liquidDumperPlant.sysj line: 58, column: 20
                        currsigs.addElement(bottleUpright);
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(drainValveOnOff.getprestatus()){//sysj\liquidDumperPlant.sysj line: 61, column: 12
                          if(angle_thread_1 == ROTATE_thread_1 && !drained_thread_1) {//sysj\liquidDumperPlant.sysj line: 62, column: 36
                            drain_thread_1 = drain_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 63, column: 6
                            if(drain_thread_1 >= DRAIN_thread_1) {//sysj\liquidDumperPlant.sysj line: 64, column: 24
                              drained_thread_1 = true;//sysj\liquidDumperPlant.sysj line: 65, column: 7
                              drain_thread_1 = 0;//sysj\liquidDumperPlant.sysj line: 66, column: 7
                              tank_thread_1 = tank_thread_1 + 1;//sysj\liquidDumperPlant.sysj line: 67, column: 7
                              System.out.println("[LDPlant] Contents drained to the waste tank (level " + tank_thread_1 + ").");//sysj\liquidDumperPlant.sysj line: 68, column: 7
                            }
                          }
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(drained_thread_1){//sysj\liquidDumperPlant.sysj line: 72, column: 4
                            bottleDrained.setPresent();//sysj\liquidDumperPlant.sysj line: 72, column: 17
                            currsigs.addElement(bottleDrained);
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            if(clamp_thread_1 == 0) {//sysj\liquidDumperPlant.sysj line: 76, column: 18
                              drained_thread_1 = false;//sysj\liquidDumperPlant.sysj line: 77, column: 5
                            }
                            wasteTankLevel.setPresent();//sysj\liquidDumperPlant.sysj line: 80, column: 4
                            currsigs.addElement(wasteTankLevel);
                            wasteTankLevel.setValue(tank_thread_1);//sysj\liquidDumperPlant.sysj line: 80, column: 4
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
          cylClampBottleExtend.gethook();
          invertRotateExtend.gethook();
          invertRotateRetract.gethook();
          drainValveOnOff.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      cylClampBottleExtend.setpreclear();
      invertRotateExtend.setpreclear();
      invertRotateRetract.setpreclear();
      drainValveOnOff.setpreclear();
      clampClosed.setpreclear();
      bottleInverted.setpreclear();
      bottleUpright.setpreclear();
      bottleDrained.setpreclear();
      wasteTankLevel.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = cylClampBottleExtend.getStatus() ? cylClampBottleExtend.setprepresent() : cylClampBottleExtend.setpreclear();
      cylClampBottleExtend.setpreval(cylClampBottleExtend.getValue());
      cylClampBottleExtend.setClear();
      dummyint = invertRotateExtend.getStatus() ? invertRotateExtend.setprepresent() : invertRotateExtend.setpreclear();
      invertRotateExtend.setpreval(invertRotateExtend.getValue());
      invertRotateExtend.setClear();
      dummyint = invertRotateRetract.getStatus() ? invertRotateRetract.setprepresent() : invertRotateRetract.setpreclear();
      invertRotateRetract.setpreval(invertRotateRetract.getValue());
      invertRotateRetract.setClear();
      dummyint = drainValveOnOff.getStatus() ? drainValveOnOff.setprepresent() : drainValveOnOff.setpreclear();
      drainValveOnOff.setpreval(drainValveOnOff.getValue());
      drainValveOnOff.setClear();
      clampClosed.sethook();
      clampClosed.setClear();
      bottleInverted.sethook();
      bottleInverted.setClear();
      bottleUpright.sethook();
      bottleUpright.setClear();
      bottleDrained.sethook();
      bottleDrained.setClear();
      wasteTankLevel.sethook();
      wasteTankLevel.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        cylClampBottleExtend.gethook();
        invertRotateExtend.gethook();
        invertRotateRetract.gethook();
        drainValveOnOff.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
