import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidRemovalPlant extends ClockDomain{
  public LidRemovalPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal cylZaxisExtend = new Signal("cylZaxisExtend", Signal.INPUT);
  public Signal unscrewTurnExtend = new Signal("unscrewTurnExtend", Signal.INPUT);
  public Signal unscrewTurnRetract = new Signal("unscrewTurnRetract", Signal.INPUT);
  public Signal lidGripperExtend = new Signal("lidGripperExtend", Signal.INPUT);
  public Signal lidEjectExtend = new Signal("lidEjectExtend", Signal.INPUT);
  public Signal zAxisLowered = new Signal("zAxisLowered", Signal.OUTPUT);
  public Signal zAxisLifted = new Signal("zAxisLifted", Signal.OUTPUT);
  public Signal turnAtHomePos = new Signal("turnAtHomePos", Signal.OUTPUT);
  public Signal turnAtFinalPos = new Signal("turnAtFinalPos", Signal.OUTPUT);
  public Signal lidGripped = new Signal("lidGripped", Signal.OUTPUT);
  public Signal lidBinFull = new Signal("lidBinFull", Signal.OUTPUT);
  private Signal lidDropped_1;
  private int ZTRAVEL_thread_2;//sysj\lidRemovalPlant.sysj line: 36, column: 3
  private int z_thread_2;//sysj\lidRemovalPlant.sysj line: 37, column: 3
  private int TURN_thread_3;//sysj\lidRemovalPlant.sysj line: 55, column: 3
  private int turn_thread_3;//sysj\lidRemovalPlant.sysj line: 56, column: 3
  private int GRIP_thread_4;//sysj\lidRemovalPlant.sysj line: 79, column: 3
  private int grip_thread_4;//sysj\lidRemovalPlant.sysj line: 80, column: 3
  private boolean held_thread_4;//sysj\lidRemovalPlant.sysj line: 81, column: 3
  private boolean ejecting_thread_4;//sysj\lidRemovalPlant.sysj line: 82, column: 3
  private int BIN_CAPACITY_thread_5;//sysj\lidRemovalPlant.sysj line: 122, column: 3
  private RecyclingCapacity bin_thread_5;//sysj\lidRemovalPlant.sysj line: 123, column: 3
  private int S156730 = 1;
  private int S156266 = 1;
  private int S156394 = 1;
  private int S156648 = 1;
  private int S156728 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread156740(int [] tdone, int [] ends){
        switch(S156728){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 126, column: 12
          if(lidDropped_1.getprestatus()){//sysj\lidRemovalPlant.sysj line: 127, column: 13
            bin_thread_5.add();//sysj\lidRemovalPlant.sysj line: 128, column: 6
            System.out.println("[LRPlant] Lid dropped into the waste bin (" + bin_thread_5.level() + " of " + BIN_CAPACITY_thread_5 + ").");//sysj\lidRemovalPlant.sysj line: 129, column: 6
            if(zAxisLifted.getprestatus() && turnAtHomePos.getprestatus() && !lidGripped.getprestatus()){//sysj\lidRemovalPlant.sysj line: 131, column: 13
              bin_thread_5.service(true);//sysj\lidRemovalPlant.sysj line: 131, column: 59
              if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 133, column: 5
                lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 134, column: 6
                currsigs.addElement(lidBinFull);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            else {
              bin_thread_5.service(false);//sysj\lidRemovalPlant.sysj line: 132, column: 24
              if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 133, column: 5
                lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 134, column: 6
                currsigs.addElement(lidBinFull);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
          }
          else {
            if(zAxisLifted.getprestatus() && turnAtHomePos.getprestatus() && !lidGripped.getprestatus()){//sysj\lidRemovalPlant.sysj line: 131, column: 13
              bin_thread_5.service(true);//sysj\lidRemovalPlant.sysj line: 131, column: 59
              if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 133, column: 5
                lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 134, column: 6
                currsigs.addElement(lidBinFull);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            else {
              bin_thread_5.service(false);//sysj\lidRemovalPlant.sysj line: 132, column: 24
              if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 133, column: 5
                lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 134, column: 6
                currsigs.addElement(lidBinFull);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
          }
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread156739(int [] tdone, int [] ends){
        switch(S156648){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 85, column: 12
          if(lidGripperExtend.getprestatus() && zAxisLowered.getprestatus()){//sysj\lidRemovalPlant.sysj line: 87, column: 13
            if(!held_thread_4) {//sysj\lidRemovalPlant.sysj line: 88, column: 15
              grip_thread_4 = grip_thread_4 + 1;//sysj\lidRemovalPlant.sysj line: 89, column: 7
              if(grip_thread_4 >= GRIP_thread_4) {//sysj\lidRemovalPlant.sysj line: 90, column: 23
                held_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 91, column: 8
                System.out.println("[LRPlant] Cap gripped.");//sysj\lidRemovalPlant.sysj line: 92, column: 8
              }
            }
            if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 100, column: 5
              lidGripped.setPresent();//sysj\lidRemovalPlant.sysj line: 100, column: 15
              currsigs.addElement(lidGripped);
              if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 104, column: 13
                if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 105, column: 9
                  ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 106, column: 7
                  if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 107, column: 7
                    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 108, column: 8
                    lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 109, column: 8
                    currsigs.addElement(lidDropped_1);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 114, column: 6
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 104, column: 13
                if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 105, column: 9
                  ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 106, column: 7
                  if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 107, column: 7
                    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 108, column: 8
                    lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 109, column: 8
                    currsigs.addElement(lidDropped_1);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 114, column: 6
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
          else {
            grip_thread_4 = 0;//sysj\lidRemovalPlant.sysj line: 97, column: 6
            if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 100, column: 5
              lidGripped.setPresent();//sysj\lidRemovalPlant.sysj line: 100, column: 15
              currsigs.addElement(lidGripped);
              if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 104, column: 13
                if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 105, column: 9
                  ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 106, column: 7
                  if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 107, column: 7
                    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 108, column: 8
                    lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 109, column: 8
                    currsigs.addElement(lidDropped_1);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 114, column: 6
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 104, column: 13
                if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 105, column: 9
                  ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 106, column: 7
                  if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 107, column: 7
                    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 108, column: 8
                    lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 109, column: 8
                    currsigs.addElement(lidDropped_1);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 114, column: 6
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread156738(int [] tdone, int [] ends){
        switch(S156394){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 59, column: 12
          if(unscrewTurnExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 60, column: 13
            if(turn_thread_3 < TURN_thread_3) {//sysj\lidRemovalPlant.sysj line: 61, column: 21
              turn_thread_3 = turn_thread_3 + 1;//sysj\lidRemovalPlant.sysj line: 61, column: 23
            }
            if(unscrewTurnRetract.getprestatus()){//sysj\lidRemovalPlant.sysj line: 63, column: 13
              if(turn_thread_3 > 0) {//sysj\lidRemovalPlant.sysj line: 64, column: 18
                turn_thread_3 = turn_thread_3 - 1;//sysj\lidRemovalPlant.sysj line: 64, column: 20
              }
              if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 66, column: 8
                turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 66, column: 23
                currsigs.addElement(turnAtFinalPos);
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
                  currsigs.addElement(turnAtHomePos);
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
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
                  currsigs.addElement(turnAtHomePos);
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
              if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 66, column: 8
                turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 66, column: 23
                currsigs.addElement(turnAtFinalPos);
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
                  currsigs.addElement(turnAtHomePos);
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
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
                  currsigs.addElement(turnAtHomePos);
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
            if(unscrewTurnRetract.getprestatus()){//sysj\lidRemovalPlant.sysj line: 63, column: 13
              if(turn_thread_3 > 0) {//sysj\lidRemovalPlant.sysj line: 64, column: 18
                turn_thread_3 = turn_thread_3 - 1;//sysj\lidRemovalPlant.sysj line: 64, column: 20
              }
              if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 66, column: 8
                turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 66, column: 23
                currsigs.addElement(turnAtFinalPos);
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
                  currsigs.addElement(turnAtHomePos);
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
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
                  currsigs.addElement(turnAtHomePos);
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
              if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 66, column: 8
                turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 66, column: 23
                currsigs.addElement(turnAtFinalPos);
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
                  currsigs.addElement(turnAtHomePos);
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
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
                  currsigs.addElement(turnAtHomePos);
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

  public void thread156737(int [] tdone, int [] ends){
        switch(S156266){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 40, column: 12
          if(cylZaxisExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 41, column: 13
            if(z_thread_2 < ZTRAVEL_thread_2) {//sysj\lidRemovalPlant.sysj line: 42, column: 21
              z_thread_2 = z_thread_2 + 1;//sysj\lidRemovalPlant.sysj line: 42, column: 23
            }
            if(z_thread_2 == ZTRAVEL_thread_2){//sysj\lidRemovalPlant.sysj line: 47, column: 8
              zAxisLowered.setPresent();//sysj\lidRemovalPlant.sysj line: 47, column: 23
              currsigs.addElement(zAxisLowered);
              if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 48, column: 8
                zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 48, column: 17
                currsigs.addElement(zAxisLifted);
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
              if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 48, column: 8
                zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 48, column: 17
                currsigs.addElement(zAxisLifted);
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
            if(z_thread_2 > 0) {//sysj\lidRemovalPlant.sysj line: 45, column: 15
              z_thread_2 = z_thread_2 - 1;//sysj\lidRemovalPlant.sysj line: 45, column: 17
            }
            if(z_thread_2 == ZTRAVEL_thread_2){//sysj\lidRemovalPlant.sysj line: 47, column: 8
              zAxisLowered.setPresent();//sysj\lidRemovalPlant.sysj line: 47, column: 23
              currsigs.addElement(zAxisLowered);
              if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 48, column: 8
                zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 48, column: 17
                currsigs.addElement(zAxisLifted);
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
              if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 48, column: 8
                zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 48, column: 17
                currsigs.addElement(zAxisLifted);
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
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread156735(int [] tdone, int [] ends){
        S156728=1;
    BIN_CAPACITY_thread_5 = RecyclingCapacity.LID_BIN;//sysj\lidRemovalPlant.sysj line: 122, column: 3
    bin_thread_5 = new RecyclingCapacity("Lid waste bin", BIN_CAPACITY_thread_5);//sysj\lidRemovalPlant.sysj line: 123, column: 3
    if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 126, column: 12
      if(lidDropped_1.getprestatus()){//sysj\lidRemovalPlant.sysj line: 127, column: 13
        bin_thread_5.add();//sysj\lidRemovalPlant.sysj line: 128, column: 6
        System.out.println("[LRPlant] Lid dropped into the waste bin (" + bin_thread_5.level() + " of " + BIN_CAPACITY_thread_5 + ").");//sysj\lidRemovalPlant.sysj line: 129, column: 6
        if(zAxisLifted.getprestatus() && turnAtHomePos.getprestatus() && !lidGripped.getprestatus()){//sysj\lidRemovalPlant.sysj line: 131, column: 13
          bin_thread_5.service(true);//sysj\lidRemovalPlant.sysj line: 131, column: 59
          if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 133, column: 5
            lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 134, column: 6
            currsigs.addElement(lidBinFull);
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
          else {
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
        }
        else {
          bin_thread_5.service(false);//sysj\lidRemovalPlant.sysj line: 132, column: 24
          if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 133, column: 5
            lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 134, column: 6
            currsigs.addElement(lidBinFull);
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
          else {
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
        }
      }
      else {
        if(zAxisLifted.getprestatus() && turnAtHomePos.getprestatus() && !lidGripped.getprestatus()){//sysj\lidRemovalPlant.sysj line: 131, column: 13
          bin_thread_5.service(true);//sysj\lidRemovalPlant.sysj line: 131, column: 59
          if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 133, column: 5
            lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 134, column: 6
            currsigs.addElement(lidBinFull);
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
          else {
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
        }
        else {
          bin_thread_5.service(false);//sysj\lidRemovalPlant.sysj line: 132, column: 24
          if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 133, column: 5
            lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 134, column: 6
            currsigs.addElement(lidBinFull);
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
          else {
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
        }
      }
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread156734(int [] tdone, int [] ends){
        S156648=1;
    GRIP_thread_4 = PlantTiming.ticks(3);//sysj\lidRemovalPlant.sysj line: 79, column: 3
    grip_thread_4 = 0;//sysj\lidRemovalPlant.sysj line: 80, column: 3
    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 81, column: 3
    ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 82, column: 3
    if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 85, column: 12
      if(lidGripperExtend.getprestatus() && zAxisLowered.getprestatus()){//sysj\lidRemovalPlant.sysj line: 87, column: 13
        if(!held_thread_4) {//sysj\lidRemovalPlant.sysj line: 88, column: 15
          grip_thread_4 = grip_thread_4 + 1;//sysj\lidRemovalPlant.sysj line: 89, column: 7
          if(grip_thread_4 >= GRIP_thread_4) {//sysj\lidRemovalPlant.sysj line: 90, column: 23
            held_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 91, column: 8
            System.out.println("[LRPlant] Cap gripped.");//sysj\lidRemovalPlant.sysj line: 92, column: 8
          }
        }
        if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 100, column: 5
          lidGripped.setPresent();//sysj\lidRemovalPlant.sysj line: 100, column: 15
          currsigs.addElement(lidGripped);
          if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 104, column: 13
            if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 105, column: 9
              ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 106, column: 7
              if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 107, column: 7
                held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 108, column: 8
                lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 109, column: 8
                currsigs.addElement(lidDropped_1);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 114, column: 6
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 104, column: 13
            if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 105, column: 9
              ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 106, column: 7
              if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 107, column: 7
                held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 108, column: 8
                lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 109, column: 8
                currsigs.addElement(lidDropped_1);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 114, column: 6
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
      }
      else {
        grip_thread_4 = 0;//sysj\lidRemovalPlant.sysj line: 97, column: 6
        if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 100, column: 5
          lidGripped.setPresent();//sysj\lidRemovalPlant.sysj line: 100, column: 15
          currsigs.addElement(lidGripped);
          if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 104, column: 13
            if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 105, column: 9
              ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 106, column: 7
              if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 107, column: 7
                held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 108, column: 8
                lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 109, column: 8
                currsigs.addElement(lidDropped_1);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 114, column: 6
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 104, column: 13
            if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 105, column: 9
              ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 106, column: 7
              if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 107, column: 7
                held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 108, column: 8
                lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 109, column: 8
                currsigs.addElement(lidDropped_1);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 114, column: 6
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread156733(int [] tdone, int [] ends){
        S156394=1;
    TURN_thread_3 = PlantTiming.ticks(6);//sysj\lidRemovalPlant.sysj line: 55, column: 3
    turn_thread_3 = 0;//sysj\lidRemovalPlant.sysj line: 56, column: 3
    if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 59, column: 12
      if(unscrewTurnExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 60, column: 13
        if(turn_thread_3 < TURN_thread_3) {//sysj\lidRemovalPlant.sysj line: 61, column: 21
          turn_thread_3 = turn_thread_3 + 1;//sysj\lidRemovalPlant.sysj line: 61, column: 23
        }
        if(unscrewTurnRetract.getprestatus()){//sysj\lidRemovalPlant.sysj line: 63, column: 13
          if(turn_thread_3 > 0) {//sysj\lidRemovalPlant.sysj line: 64, column: 18
            turn_thread_3 = turn_thread_3 - 1;//sysj\lidRemovalPlant.sysj line: 64, column: 20
          }
          if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 66, column: 8
            turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 66, column: 23
            currsigs.addElement(turnAtFinalPos);
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
              currsigs.addElement(turnAtHomePos);
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
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
              currsigs.addElement(turnAtHomePos);
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
          if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 66, column: 8
            turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 66, column: 23
            currsigs.addElement(turnAtFinalPos);
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
              currsigs.addElement(turnAtHomePos);
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
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
              currsigs.addElement(turnAtHomePos);
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
        if(unscrewTurnRetract.getprestatus()){//sysj\lidRemovalPlant.sysj line: 63, column: 13
          if(turn_thread_3 > 0) {//sysj\lidRemovalPlant.sysj line: 64, column: 18
            turn_thread_3 = turn_thread_3 - 1;//sysj\lidRemovalPlant.sysj line: 64, column: 20
          }
          if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 66, column: 8
            turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 66, column: 23
            currsigs.addElement(turnAtFinalPos);
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
              currsigs.addElement(turnAtHomePos);
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
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
              currsigs.addElement(turnAtHomePos);
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
          if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 66, column: 8
            turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 66, column: 23
            currsigs.addElement(turnAtFinalPos);
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
              currsigs.addElement(turnAtHomePos);
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
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 67, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 67, column: 20
              currsigs.addElement(turnAtHomePos);
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

  public void thread156732(int [] tdone, int [] ends){
        S156266=1;
    ZTRAVEL_thread_2 = PlantTiming.ticks(4);//sysj\lidRemovalPlant.sysj line: 36, column: 3
    z_thread_2 = 0;//sysj\lidRemovalPlant.sysj line: 37, column: 3
    if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 40, column: 12
      if(cylZaxisExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 41, column: 13
        if(z_thread_2 < ZTRAVEL_thread_2) {//sysj\lidRemovalPlant.sysj line: 42, column: 21
          z_thread_2 = z_thread_2 + 1;//sysj\lidRemovalPlant.sysj line: 42, column: 23
        }
        if(z_thread_2 == ZTRAVEL_thread_2){//sysj\lidRemovalPlant.sysj line: 47, column: 8
          zAxisLowered.setPresent();//sysj\lidRemovalPlant.sysj line: 47, column: 23
          currsigs.addElement(zAxisLowered);
          if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 48, column: 8
            zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 48, column: 17
            currsigs.addElement(zAxisLifted);
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
          if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 48, column: 8
            zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 48, column: 17
            currsigs.addElement(zAxisLifted);
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
        if(z_thread_2 > 0) {//sysj\lidRemovalPlant.sysj line: 45, column: 15
          z_thread_2 = z_thread_2 - 1;//sysj\lidRemovalPlant.sysj line: 45, column: 17
        }
        if(z_thread_2 == ZTRAVEL_thread_2){//sysj\lidRemovalPlant.sysj line: 47, column: 8
          zAxisLowered.setPresent();//sysj\lidRemovalPlant.sysj line: 47, column: 23
          currsigs.addElement(zAxisLowered);
          if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 48, column: 8
            zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 48, column: 17
            currsigs.addElement(zAxisLifted);
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
          if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 48, column: 8
            zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 48, column: 17
            currsigs.addElement(zAxisLifted);
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
      switch(S156730){
        case 0 : 
          S156730=0;
          break RUN;
        
        case 1 : 
          S156730=2;
          S156730=2;
          lidDropped_1.setClear();//sysj\lidRemovalPlant.sysj line: 29, column: 2
          thread156732(tdone,ends);
          thread156733(tdone,ends);
          thread156734(tdone,ends);
          thread156735(tdone,ends);
          int biggest156736 = 0;
          if(ends[2]>=biggest156736){
            biggest156736=ends[2];
          }
          if(ends[3]>=biggest156736){
            biggest156736=ends[3];
          }
          if(ends[4]>=biggest156736){
            biggest156736=ends[4];
          }
          if(ends[5]>=biggest156736){
            biggest156736=ends[5];
          }
          if(biggest156736 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          lidDropped_1.setClear();//sysj\lidRemovalPlant.sysj line: 29, column: 2
          thread156737(tdone,ends);
          thread156738(tdone,ends);
          thread156739(tdone,ends);
          thread156740(tdone,ends);
          int biggest156741 = 0;
          if(ends[2]>=biggest156741){
            biggest156741=ends[2];
          }
          if(ends[3]>=biggest156741){
            biggest156741=ends[3];
          }
          if(ends[4]>=biggest156741){
            biggest156741=ends[4];
          }
          if(ends[5]>=biggest156741){
            biggest156741=ends[5];
          }
          if(biggest156741 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest156741 == 0){
            S156730=0;
            active[1]=0;
            ends[1]=0;
            S156730=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    lidDropped_1 = new Signal();
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
          cylZaxisExtend.gethook();
          unscrewTurnExtend.gethook();
          unscrewTurnRetract.gethook();
          lidGripperExtend.gethook();
          lidEjectExtend.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      cylZaxisExtend.setpreclear();
      unscrewTurnExtend.setpreclear();
      unscrewTurnRetract.setpreclear();
      lidGripperExtend.setpreclear();
      lidEjectExtend.setpreclear();
      zAxisLowered.setpreclear();
      zAxisLifted.setpreclear();
      turnAtHomePos.setpreclear();
      turnAtFinalPos.setpreclear();
      lidGripped.setpreclear();
      lidBinFull.setpreclear();
      lidDropped_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = cylZaxisExtend.getStatus() ? cylZaxisExtend.setprepresent() : cylZaxisExtend.setpreclear();
      cylZaxisExtend.setpreval(cylZaxisExtend.getValue());
      cylZaxisExtend.setClear();
      dummyint = unscrewTurnExtend.getStatus() ? unscrewTurnExtend.setprepresent() : unscrewTurnExtend.setpreclear();
      unscrewTurnExtend.setpreval(unscrewTurnExtend.getValue());
      unscrewTurnExtend.setClear();
      dummyint = unscrewTurnRetract.getStatus() ? unscrewTurnRetract.setprepresent() : unscrewTurnRetract.setpreclear();
      unscrewTurnRetract.setpreval(unscrewTurnRetract.getValue());
      unscrewTurnRetract.setClear();
      dummyint = lidGripperExtend.getStatus() ? lidGripperExtend.setprepresent() : lidGripperExtend.setpreclear();
      lidGripperExtend.setpreval(lidGripperExtend.getValue());
      lidGripperExtend.setClear();
      dummyint = lidEjectExtend.getStatus() ? lidEjectExtend.setprepresent() : lidEjectExtend.setpreclear();
      lidEjectExtend.setpreval(lidEjectExtend.getValue());
      lidEjectExtend.setClear();
      zAxisLowered.sethook();
      zAxisLowered.setClear();
      zAxisLifted.sethook();
      zAxisLifted.setClear();
      turnAtHomePos.sethook();
      turnAtHomePos.setClear();
      turnAtFinalPos.sethook();
      turnAtFinalPos.setClear();
      lidGripped.sethook();
      lidGripped.setClear();
      lidBinFull.sethook();
      lidBinFull.setClear();
      lidDropped_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        cylZaxisExtend.gethook();
        unscrewTurnExtend.gethook();
        unscrewTurnRetract.gethook();
        lidGripperExtend.gethook();
        lidEjectExtend.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
