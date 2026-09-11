import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class BottleReturnPlant extends ClockDomain{
  public BottleReturnPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal motorOnOff = new Signal("motorOnOff", Signal.INPUT);
  public Signal transferArmExtend = new Signal("transferArmExtend", Signal.INPUT);
  public Signal transferArmRetract = new Signal("transferArmRetract", Signal.INPUT);
  public Signal bottleAtCollector = new Signal("bottleAtCollector", Signal.OUTPUT);
  public Signal armAtHome = new Signal("armAtHome", Signal.OUTPUT);
  public Signal armAtLoader = new Signal("armAtLoader", Signal.OUTPUT);
  public Signal collectorBinFull = new Signal("collectorBinFull", Signal.OUTPUT);
  private int BELT_thread_1;//sysj\bottleReturnPlant.sysj line: 45, column: 2
  private int ARM_thread_1;//sysj\bottleReturnPlant.sysj line: 47, column: 2
  private int BIN_CAPACITY_thread_1;//sysj\bottleReturnPlant.sysj line: 49, column: 2
  private int pos_thread_1;//sysj\bottleReturnPlant.sysj line: 53, column: 2
  private int arm_thread_1;//sysj\bottleReturnPlant.sysj line: 55, column: 2
  private boolean running_thread_1;//sysj\bottleReturnPlant.sysj line: 57, column: 2
  private boolean carrying_thread_1;//sysj\bottleReturnPlant.sysj line: 59, column: 2
  private RecyclingCapacity bin_thread_1;//sysj\bottleReturnPlant.sysj line: 61, column: 2
  private int S15941 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S15941){
        case 0 : 
          S15941=0;
          break RUN;
        
        case 1 : 
          S15941=2;
          S15941=2;
          BELT_thread_1 = 6;//sysj\bottleReturnPlant.sysj line: 45, column: 2
          ARM_thread_1 = 4;//sysj\bottleReturnPlant.sysj line: 47, column: 2
          BIN_CAPACITY_thread_1 = 3;//sysj\bottleReturnPlant.sysj line: 49, column: 2
          pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 53, column: 2
          arm_thread_1 = 0;//sysj\bottleReturnPlant.sysj line: 55, column: 2
          running_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 57, column: 2
          carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 59, column: 2
          bin_thread_1 = new RecyclingCapacity("Bottle collector", BIN_CAPACITY_thread_1);//sysj\bottleReturnPlant.sysj line: 61, column: 2
          if(enable.getprestatus()){//sysj\bottleReturnPlant.sysj line: 67, column: 11
            if(motorOnOff.getprestatus()){//sysj\bottleReturnPlant.sysj line: 71, column: 12
              if(!running_thread_1) {//sysj\bottleReturnPlant.sysj line: 73, column: 17
                running_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 75, column: 6
                if(pos_thread_1 < 0) {//sysj\bottleReturnPlant.sysj line: 77, column: 17
                  pos_thread_1 = 0;//sysj\bottleReturnPlant.sysj line: 79, column: 7
                  System.out.println("[BRPlant] Bottle transferred onto the return conveyor.");//sysj\bottleReturnPlant.sysj line: 81, column: 7
                }
              }
              if(pos_thread_1 >= 0 && pos_thread_1 < BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 87, column: 31
                pos_thread_1 = pos_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 89, column: 6
                if(pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 91, column: 21
                  System.out.println("[BRPlant] Bottle at the transfer point.");//sysj\bottleReturnPlant.sysj line: 93, column: 7
                }
              }
              if(pos_thread_1 == BELT_thread_1){//sysj\bottleReturnPlant.sysj line: 109, column: 7
                bottleAtCollector.setPresent();//sysj\bottleReturnPlant.sysj line: 109, column: 21
                currsigs.addElement(bottleAtCollector);
                if(transferArmExtend.getprestatus()){//sysj\bottleReturnPlant.sysj line: 115, column: 12
                  if(arm_thread_1 < ARM_thread_1) {//sysj\bottleReturnPlant.sysj line: 117, column: 18
                    if(arm_thread_1 == 0 && pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 119, column: 33
                      carrying_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 121, column: 7
                      pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 123, column: 7
                    }
                    arm_thread_1 = arm_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 127, column: 6
                  }
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                if(transferArmExtend.getprestatus()){//sysj\bottleReturnPlant.sysj line: 115, column: 12
                  if(arm_thread_1 < ARM_thread_1) {//sysj\bottleReturnPlant.sysj line: 117, column: 18
                    if(arm_thread_1 == 0 && pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 119, column: 33
                      carrying_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 121, column: 7
                      pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 123, column: 7
                    }
                    arm_thread_1 = arm_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 127, column: 6
                  }
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
              running_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 103, column: 5
              if(pos_thread_1 == BELT_thread_1){//sysj\bottleReturnPlant.sysj line: 109, column: 7
                bottleAtCollector.setPresent();//sysj\bottleReturnPlant.sysj line: 109, column: 21
                currsigs.addElement(bottleAtCollector);
                if(transferArmExtend.getprestatus()){//sysj\bottleReturnPlant.sysj line: 115, column: 12
                  if(arm_thread_1 < ARM_thread_1) {//sysj\bottleReturnPlant.sysj line: 117, column: 18
                    if(arm_thread_1 == 0 && pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 119, column: 33
                      carrying_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 121, column: 7
                      pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 123, column: 7
                    }
                    arm_thread_1 = arm_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 127, column: 6
                  }
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                if(transferArmExtend.getprestatus()){//sysj\bottleReturnPlant.sysj line: 115, column: 12
                  if(arm_thread_1 < ARM_thread_1) {//sysj\bottleReturnPlant.sysj line: 117, column: 18
                    if(arm_thread_1 == 0 && pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 119, column: 33
                      carrying_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 121, column: 7
                      pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 123, column: 7
                    }
                    arm_thread_1 = arm_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 127, column: 6
                  }
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
          if(enable.getprestatus()){//sysj\bottleReturnPlant.sysj line: 67, column: 11
            if(motorOnOff.getprestatus()){//sysj\bottleReturnPlant.sysj line: 71, column: 12
              if(!running_thread_1) {//sysj\bottleReturnPlant.sysj line: 73, column: 17
                running_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 75, column: 6
                if(pos_thread_1 < 0) {//sysj\bottleReturnPlant.sysj line: 77, column: 17
                  pos_thread_1 = 0;//sysj\bottleReturnPlant.sysj line: 79, column: 7
                  System.out.println("[BRPlant] Bottle transferred onto the return conveyor.");//sysj\bottleReturnPlant.sysj line: 81, column: 7
                }
              }
              if(pos_thread_1 >= 0 && pos_thread_1 < BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 87, column: 31
                pos_thread_1 = pos_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 89, column: 6
                if(pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 91, column: 21
                  System.out.println("[BRPlant] Bottle at the transfer point.");//sysj\bottleReturnPlant.sysj line: 93, column: 7
                }
              }
              if(pos_thread_1 == BELT_thread_1){//sysj\bottleReturnPlant.sysj line: 109, column: 7
                bottleAtCollector.setPresent();//sysj\bottleReturnPlant.sysj line: 109, column: 21
                currsigs.addElement(bottleAtCollector);
                if(transferArmExtend.getprestatus()){//sysj\bottleReturnPlant.sysj line: 115, column: 12
                  if(arm_thread_1 < ARM_thread_1) {//sysj\bottleReturnPlant.sysj line: 117, column: 18
                    if(arm_thread_1 == 0 && pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 119, column: 33
                      carrying_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 121, column: 7
                      pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 123, column: 7
                    }
                    arm_thread_1 = arm_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 127, column: 6
                  }
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                if(transferArmExtend.getprestatus()){//sysj\bottleReturnPlant.sysj line: 115, column: 12
                  if(arm_thread_1 < ARM_thread_1) {//sysj\bottleReturnPlant.sysj line: 117, column: 18
                    if(arm_thread_1 == 0 && pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 119, column: 33
                      carrying_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 121, column: 7
                      pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 123, column: 7
                    }
                    arm_thread_1 = arm_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 127, column: 6
                  }
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
              running_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 103, column: 5
              if(pos_thread_1 == BELT_thread_1){//sysj\bottleReturnPlant.sysj line: 109, column: 7
                bottleAtCollector.setPresent();//sysj\bottleReturnPlant.sysj line: 109, column: 21
                currsigs.addElement(bottleAtCollector);
                if(transferArmExtend.getprestatus()){//sysj\bottleReturnPlant.sysj line: 115, column: 12
                  if(arm_thread_1 < ARM_thread_1) {//sysj\bottleReturnPlant.sysj line: 117, column: 18
                    if(arm_thread_1 == 0 && pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 119, column: 33
                      carrying_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 121, column: 7
                      pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 123, column: 7
                    }
                    arm_thread_1 = arm_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 127, column: 6
                  }
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                if(transferArmExtend.getprestatus()){//sysj\bottleReturnPlant.sysj line: 115, column: 12
                  if(arm_thread_1 < ARM_thread_1) {//sysj\bottleReturnPlant.sysj line: 117, column: 18
                    if(arm_thread_1 == 0 && pos_thread_1 == BELT_thread_1) {//sysj\bottleReturnPlant.sysj line: 119, column: 33
                      carrying_thread_1 = true;//sysj\bottleReturnPlant.sysj line: 121, column: 7
                      pos_thread_1 = -1;//sysj\bottleReturnPlant.sysj line: 123, column: 7
                    }
                    arm_thread_1 = arm_thread_1 + 1;//sysj\bottleReturnPlant.sysj line: 127, column: 6
                  }
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                  if(transferArmRetract.getprestatus()){//sysj\bottleReturnPlant.sysj line: 133, column: 12
                    if(arm_thread_1 > 0) {//sysj\bottleReturnPlant.sysj line: 135, column: 16
                      arm_thread_1 = arm_thread_1 - 1;//sysj\bottleReturnPlant.sysj line: 135, column: 18
                    }
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
                    if(arm_thread_1 == ARM_thread_1){//sysj\bottleReturnPlant.sysj line: 141, column: 7
                      armAtLoader.setPresent();//sysj\bottleReturnPlant.sysj line: 143, column: 5
                      currsigs.addElement(armAtLoader);
                      if(carrying_thread_1) {//sysj\bottleReturnPlant.sysj line: 145, column: 17
                        carrying_thread_1 = false;//sysj\bottleReturnPlant.sysj line: 147, column: 6
                        bin_thread_1.add();//sysj\bottleReturnPlant.sysj line: 149, column: 6
                        System.out.println("[BRPlant] Bottle placed in the collector bin (" + bin_thread_1.level() + " of " + BIN_CAPACITY_thread_1 + ").");//sysj\bottleReturnPlant.sysj line: 151, column: 6
                      }
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(arm_thread_1 == 0){//sysj\bottleReturnPlant.sysj line: 157, column: 7
                        armAtHome.setPresent();//sysj\bottleReturnPlant.sysj line: 157, column: 18
                        currsigs.addElement(armAtHome);
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        bin_thread_1.serviceReturn(arm_thread_1, carrying_thread_1, pos_thread_1);//sysj\bottleReturnPlant.sysj line: 161, column: 4
                        if(bin_thread_1.full()){//sysj\bottleReturnPlant.sysj line: 162, column: 4
                          collectorBinFull.setPresent();//sysj\bottleReturnPlant.sysj line: 164, column: 5
                          currsigs.addElement(collectorBinFull);
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
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
          motorOnOff.gethook();
          transferArmExtend.gethook();
          transferArmRetract.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      motorOnOff.setpreclear();
      transferArmExtend.setpreclear();
      transferArmRetract.setpreclear();
      bottleAtCollector.setpreclear();
      armAtHome.setpreclear();
      armAtLoader.setpreclear();
      collectorBinFull.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = motorOnOff.getStatus() ? motorOnOff.setprepresent() : motorOnOff.setpreclear();
      motorOnOff.setpreval(motorOnOff.getValue());
      motorOnOff.setClear();
      dummyint = transferArmExtend.getStatus() ? transferArmExtend.setprepresent() : transferArmExtend.setpreclear();
      transferArmExtend.setpreval(transferArmExtend.getValue());
      transferArmExtend.setClear();
      dummyint = transferArmRetract.getStatus() ? transferArmRetract.setprepresent() : transferArmRetract.setpreclear();
      transferArmRetract.setpreval(transferArmRetract.getValue());
      transferArmRetract.setClear();
      bottleAtCollector.sethook();
      bottleAtCollector.setClear();
      armAtHome.sethook();
      armAtHome.setClear();
      armAtLoader.sethook();
      armAtLoader.setClear();
      collectorBinFull.sethook();
      collectorBinFull.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        motorOnOff.gethook();
        transferArmExtend.gethook();
        transferArmRetract.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
