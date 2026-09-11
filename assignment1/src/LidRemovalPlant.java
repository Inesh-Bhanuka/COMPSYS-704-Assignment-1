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
  private int ZTRAVEL_thread_2;//sysj\lidRemovalPlant.sysj line: 93, column: 3
  private int z_thread_2;//sysj\lidRemovalPlant.sysj line: 95, column: 3
  private int TURN_thread_3;//sysj\lidRemovalPlant.sysj line: 131, column: 3
  private int turn_thread_3;//sysj\lidRemovalPlant.sysj line: 133, column: 3
  private int GRIP_thread_4;//sysj\lidRemovalPlant.sysj line: 179, column: 3
  private int grip_thread_4;//sysj\lidRemovalPlant.sysj line: 181, column: 3
  private boolean held_thread_4;//sysj\lidRemovalPlant.sysj line: 183, column: 3
  private boolean ejecting_thread_4;//sysj\lidRemovalPlant.sysj line: 185, column: 3
  private int BIN_CAPACITY_thread_5;//sysj\lidRemovalPlant.sysj line: 265, column: 3
  private RecyclingCapacity bin_thread_5;//sysj\lidRemovalPlant.sysj line: 267, column: 3
  private int S119844 = 1;
  private int S119380 = 1;
  private int S119508 = 1;
  private int S119762 = 1;
  private int S119842 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread119854(int [] tdone, int [] ends){
        switch(S119842){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 273, column: 12
          if(lidDropped_1.getprestatus()){//sysj\lidRemovalPlant.sysj line: 275, column: 13
            bin_thread_5.add();//sysj\lidRemovalPlant.sysj line: 277, column: 6
            System.out.println("[LRPlant] Lid dropped into the waste bin (" + bin_thread_5.level() + " of " + BIN_CAPACITY_thread_5 + ").");//sysj\lidRemovalPlant.sysj line: 279, column: 6
            if(zAxisLifted.getprestatus() && turnAtHomePos.getprestatus() && !lidGripped.getprestatus()){//sysj\lidRemovalPlant.sysj line: 283, column: 13
              bin_thread_5.service(true);//sysj\lidRemovalPlant.sysj line: 283, column: 59
              if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 285, column: 5
                lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 287, column: 6
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
              bin_thread_5.service(false);//sysj\lidRemovalPlant.sysj line: 284, column: 24
              if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 285, column: 5
                lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 287, column: 6
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
            if(zAxisLifted.getprestatus() && turnAtHomePos.getprestatus() && !lidGripped.getprestatus()){//sysj\lidRemovalPlant.sysj line: 283, column: 13
              bin_thread_5.service(true);//sysj\lidRemovalPlant.sysj line: 283, column: 59
              if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 285, column: 5
                lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 287, column: 6
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
              bin_thread_5.service(false);//sysj\lidRemovalPlant.sysj line: 284, column: 24
              if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 285, column: 5
                lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 287, column: 6
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

  public void thread119853(int [] tdone, int [] ends){
        switch(S119762){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 191, column: 12
          if(lidGripperExtend.getprestatus() && zAxisLowered.getprestatus()){//sysj\lidRemovalPlant.sysj line: 195, column: 13
            if(!held_thread_4) {//sysj\lidRemovalPlant.sysj line: 197, column: 15
              grip_thread_4 = grip_thread_4 + 1;//sysj\lidRemovalPlant.sysj line: 199, column: 7
              if(grip_thread_4 >= GRIP_thread_4) {//sysj\lidRemovalPlant.sysj line: 201, column: 23
                held_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 203, column: 8
                System.out.println("[LRPlant] Cap gripped.");//sysj\lidRemovalPlant.sysj line: 205, column: 8
              }
            }
            if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 221, column: 5
              lidGripped.setPresent();//sysj\lidRemovalPlant.sysj line: 221, column: 15
              currsigs.addElement(lidGripped);
              if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 229, column: 13
                if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 231, column: 9
                  ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 233, column: 7
                  if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 235, column: 7
                    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 237, column: 8
                    lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 239, column: 8
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
                ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 249, column: 6
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 229, column: 13
                if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 231, column: 9
                  ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 233, column: 7
                  if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 235, column: 7
                    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 237, column: 8
                    lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 239, column: 8
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
                ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 249, column: 6
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
          else {
            grip_thread_4 = 0;//sysj\lidRemovalPlant.sysj line: 215, column: 6
            if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 221, column: 5
              lidGripped.setPresent();//sysj\lidRemovalPlant.sysj line: 221, column: 15
              currsigs.addElement(lidGripped);
              if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 229, column: 13
                if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 231, column: 9
                  ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 233, column: 7
                  if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 235, column: 7
                    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 237, column: 8
                    lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 239, column: 8
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
                ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 249, column: 6
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 229, column: 13
                if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 231, column: 9
                  ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 233, column: 7
                  if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 235, column: 7
                    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 237, column: 8
                    lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 239, column: 8
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
                ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 249, column: 6
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

  public void thread119852(int [] tdone, int [] ends){
        switch(S119508){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 139, column: 12
          if(unscrewTurnExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 141, column: 13
            if(turn_thread_3 < TURN_thread_3) {//sysj\lidRemovalPlant.sysj line: 143, column: 21
              turn_thread_3 = turn_thread_3 + 1;//sysj\lidRemovalPlant.sysj line: 143, column: 23
            }
            if(unscrewTurnRetract.getprestatus()){//sysj\lidRemovalPlant.sysj line: 147, column: 13
              if(turn_thread_3 > 0) {//sysj\lidRemovalPlant.sysj line: 149, column: 18
                turn_thread_3 = turn_thread_3 - 1;//sysj\lidRemovalPlant.sysj line: 149, column: 20
              }
              if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 153, column: 8
                turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 153, column: 23
                currsigs.addElement(turnAtFinalPos);
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
              if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 153, column: 8
                turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 153, column: 23
                currsigs.addElement(turnAtFinalPos);
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
            if(unscrewTurnRetract.getprestatus()){//sysj\lidRemovalPlant.sysj line: 147, column: 13
              if(turn_thread_3 > 0) {//sysj\lidRemovalPlant.sysj line: 149, column: 18
                turn_thread_3 = turn_thread_3 - 1;//sysj\lidRemovalPlant.sysj line: 149, column: 20
              }
              if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 153, column: 8
                turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 153, column: 23
                currsigs.addElement(turnAtFinalPos);
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
              if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 153, column: 8
                turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 153, column: 23
                currsigs.addElement(turnAtFinalPos);
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
                if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
                  turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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

  public void thread119851(int [] tdone, int [] ends){
        switch(S119380){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 101, column: 12
          if(cylZaxisExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 103, column: 13
            if(z_thread_2 < ZTRAVEL_thread_2) {//sysj\lidRemovalPlant.sysj line: 105, column: 21
              z_thread_2 = z_thread_2 + 1;//sysj\lidRemovalPlant.sysj line: 105, column: 23
            }
            if(z_thread_2 == ZTRAVEL_thread_2){//sysj\lidRemovalPlant.sysj line: 115, column: 8
              zAxisLowered.setPresent();//sysj\lidRemovalPlant.sysj line: 115, column: 23
              currsigs.addElement(zAxisLowered);
              if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 117, column: 8
                zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 117, column: 17
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
              if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 117, column: 8
                zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 117, column: 17
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
            if(z_thread_2 > 0) {//sysj\lidRemovalPlant.sysj line: 111, column: 15
              z_thread_2 = z_thread_2 - 1;//sysj\lidRemovalPlant.sysj line: 111, column: 17
            }
            if(z_thread_2 == ZTRAVEL_thread_2){//sysj\lidRemovalPlant.sysj line: 115, column: 8
              zAxisLowered.setPresent();//sysj\lidRemovalPlant.sysj line: 115, column: 23
              currsigs.addElement(zAxisLowered);
              if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 117, column: 8
                zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 117, column: 17
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
              if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 117, column: 8
                zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 117, column: 17
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

  public void thread119849(int [] tdone, int [] ends){
        S119842=1;
    BIN_CAPACITY_thread_5 = 3;//sysj\lidRemovalPlant.sysj line: 265, column: 3
    bin_thread_5 = new RecyclingCapacity("Lid waste bin", BIN_CAPACITY_thread_5);//sysj\lidRemovalPlant.sysj line: 267, column: 3
    if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 273, column: 12
      if(lidDropped_1.getprestatus()){//sysj\lidRemovalPlant.sysj line: 275, column: 13
        bin_thread_5.add();//sysj\lidRemovalPlant.sysj line: 277, column: 6
        System.out.println("[LRPlant] Lid dropped into the waste bin (" + bin_thread_5.level() + " of " + BIN_CAPACITY_thread_5 + ").");//sysj\lidRemovalPlant.sysj line: 279, column: 6
        if(zAxisLifted.getprestatus() && turnAtHomePos.getprestatus() && !lidGripped.getprestatus()){//sysj\lidRemovalPlant.sysj line: 283, column: 13
          bin_thread_5.service(true);//sysj\lidRemovalPlant.sysj line: 283, column: 59
          if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 285, column: 5
            lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 287, column: 6
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
          bin_thread_5.service(false);//sysj\lidRemovalPlant.sysj line: 284, column: 24
          if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 285, column: 5
            lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 287, column: 6
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
        if(zAxisLifted.getprestatus() && turnAtHomePos.getprestatus() && !lidGripped.getprestatus()){//sysj\lidRemovalPlant.sysj line: 283, column: 13
          bin_thread_5.service(true);//sysj\lidRemovalPlant.sysj line: 283, column: 59
          if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 285, column: 5
            lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 287, column: 6
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
          bin_thread_5.service(false);//sysj\lidRemovalPlant.sysj line: 284, column: 24
          if(bin_thread_5.full()){//sysj\lidRemovalPlant.sysj line: 285, column: 5
            lidBinFull.setPresent();//sysj\lidRemovalPlant.sysj line: 287, column: 6
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

  public void thread119848(int [] tdone, int [] ends){
        S119762=1;
    GRIP_thread_4 = 3;//sysj\lidRemovalPlant.sysj line: 179, column: 3
    grip_thread_4 = 0;//sysj\lidRemovalPlant.sysj line: 181, column: 3
    held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 183, column: 3
    ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 185, column: 3
    if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 191, column: 12
      if(lidGripperExtend.getprestatus() && zAxisLowered.getprestatus()){//sysj\lidRemovalPlant.sysj line: 195, column: 13
        if(!held_thread_4) {//sysj\lidRemovalPlant.sysj line: 197, column: 15
          grip_thread_4 = grip_thread_4 + 1;//sysj\lidRemovalPlant.sysj line: 199, column: 7
          if(grip_thread_4 >= GRIP_thread_4) {//sysj\lidRemovalPlant.sysj line: 201, column: 23
            held_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 203, column: 8
            System.out.println("[LRPlant] Cap gripped.");//sysj\lidRemovalPlant.sysj line: 205, column: 8
          }
        }
        if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 221, column: 5
          lidGripped.setPresent();//sysj\lidRemovalPlant.sysj line: 221, column: 15
          currsigs.addElement(lidGripped);
          if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 229, column: 13
            if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 231, column: 9
              ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 233, column: 7
              if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 235, column: 7
                held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 237, column: 8
                lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 239, column: 8
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
            ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 249, column: 6
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 229, column: 13
            if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 231, column: 9
              ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 233, column: 7
              if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 235, column: 7
                held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 237, column: 8
                lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 239, column: 8
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
            ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 249, column: 6
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
      }
      else {
        grip_thread_4 = 0;//sysj\lidRemovalPlant.sysj line: 215, column: 6
        if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 221, column: 5
          lidGripped.setPresent();//sysj\lidRemovalPlant.sysj line: 221, column: 15
          currsigs.addElement(lidGripped);
          if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 229, column: 13
            if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 231, column: 9
              ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 233, column: 7
              if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 235, column: 7
                held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 237, column: 8
                lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 239, column: 8
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
            ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 249, column: 6
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          if(lidEjectExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 229, column: 13
            if(!ejecting_thread_4){//sysj\lidRemovalPlant.sysj line: 231, column: 9
              ejecting_thread_4 = true;//sysj\lidRemovalPlant.sysj line: 233, column: 7
              if(held_thread_4){//sysj\lidRemovalPlant.sysj line: 235, column: 7
                held_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 237, column: 8
                lidDropped_1.setPresent();//sysj\lidRemovalPlant.sysj line: 239, column: 8
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
            ejecting_thread_4 = false;//sysj\lidRemovalPlant.sysj line: 249, column: 6
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

  public void thread119847(int [] tdone, int [] ends){
        S119508=1;
    TURN_thread_3 = 6;//sysj\lidRemovalPlant.sysj line: 131, column: 3
    turn_thread_3 = 0;//sysj\lidRemovalPlant.sysj line: 133, column: 3
    if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 139, column: 12
      if(unscrewTurnExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 141, column: 13
        if(turn_thread_3 < TURN_thread_3) {//sysj\lidRemovalPlant.sysj line: 143, column: 21
          turn_thread_3 = turn_thread_3 + 1;//sysj\lidRemovalPlant.sysj line: 143, column: 23
        }
        if(unscrewTurnRetract.getprestatus()){//sysj\lidRemovalPlant.sysj line: 147, column: 13
          if(turn_thread_3 > 0) {//sysj\lidRemovalPlant.sysj line: 149, column: 18
            turn_thread_3 = turn_thread_3 - 1;//sysj\lidRemovalPlant.sysj line: 149, column: 20
          }
          if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 153, column: 8
            turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 153, column: 23
            currsigs.addElement(turnAtFinalPos);
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
          if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 153, column: 8
            turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 153, column: 23
            currsigs.addElement(turnAtFinalPos);
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
        if(unscrewTurnRetract.getprestatus()){//sysj\lidRemovalPlant.sysj line: 147, column: 13
          if(turn_thread_3 > 0) {//sysj\lidRemovalPlant.sysj line: 149, column: 18
            turn_thread_3 = turn_thread_3 - 1;//sysj\lidRemovalPlant.sysj line: 149, column: 20
          }
          if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 153, column: 8
            turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 153, column: 23
            currsigs.addElement(turnAtFinalPos);
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
          if(turn_thread_3 == TURN_thread_3){//sysj\lidRemovalPlant.sysj line: 153, column: 8
            turnAtFinalPos.setPresent();//sysj\lidRemovalPlant.sysj line: 153, column: 23
            currsigs.addElement(turnAtFinalPos);
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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
            if(turn_thread_3 == 0){//sysj\lidRemovalPlant.sysj line: 155, column: 8
              turnAtHomePos.setPresent();//sysj\lidRemovalPlant.sysj line: 155, column: 20
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

  public void thread119846(int [] tdone, int [] ends){
        S119380=1;
    ZTRAVEL_thread_2 = 4;//sysj\lidRemovalPlant.sysj line: 93, column: 3
    z_thread_2 = 0;//sysj\lidRemovalPlant.sysj line: 95, column: 3
    if(enable.getprestatus()){//sysj\lidRemovalPlant.sysj line: 101, column: 12
      if(cylZaxisExtend.getprestatus()){//sysj\lidRemovalPlant.sysj line: 103, column: 13
        if(z_thread_2 < ZTRAVEL_thread_2) {//sysj\lidRemovalPlant.sysj line: 105, column: 21
          z_thread_2 = z_thread_2 + 1;//sysj\lidRemovalPlant.sysj line: 105, column: 23
        }
        if(z_thread_2 == ZTRAVEL_thread_2){//sysj\lidRemovalPlant.sysj line: 115, column: 8
          zAxisLowered.setPresent();//sysj\lidRemovalPlant.sysj line: 115, column: 23
          currsigs.addElement(zAxisLowered);
          if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 117, column: 8
            zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 117, column: 17
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
          if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 117, column: 8
            zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 117, column: 17
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
        if(z_thread_2 > 0) {//sysj\lidRemovalPlant.sysj line: 111, column: 15
          z_thread_2 = z_thread_2 - 1;//sysj\lidRemovalPlant.sysj line: 111, column: 17
        }
        if(z_thread_2 == ZTRAVEL_thread_2){//sysj\lidRemovalPlant.sysj line: 115, column: 8
          zAxisLowered.setPresent();//sysj\lidRemovalPlant.sysj line: 115, column: 23
          currsigs.addElement(zAxisLowered);
          if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 117, column: 8
            zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 117, column: 17
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
          if(z_thread_2 == 0){//sysj\lidRemovalPlant.sysj line: 117, column: 8
            zAxisLifted.setPresent();//sysj\lidRemovalPlant.sysj line: 117, column: 17
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
      switch(S119844){
        case 0 : 
          S119844=0;
          break RUN;
        
        case 1 : 
          S119844=2;
          S119844=2;
          lidDropped_1.setClear();//sysj\lidRemovalPlant.sysj line: 79, column: 2
          thread119846(tdone,ends);
          thread119847(tdone,ends);
          thread119848(tdone,ends);
          thread119849(tdone,ends);
          int biggest119850 = 0;
          if(ends[2]>=biggest119850){
            biggest119850=ends[2];
          }
          if(ends[3]>=biggest119850){
            biggest119850=ends[3];
          }
          if(ends[4]>=biggest119850){
            biggest119850=ends[4];
          }
          if(ends[5]>=biggest119850){
            biggest119850=ends[5];
          }
          if(biggest119850 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          lidDropped_1.setClear();//sysj\lidRemovalPlant.sysj line: 79, column: 2
          thread119851(tdone,ends);
          thread119852(tdone,ends);
          thread119853(tdone,ends);
          thread119854(tdone,ends);
          int biggest119855 = 0;
          if(ends[2]>=biggest119855){
            biggest119855=ends[2];
          }
          if(ends[3]>=biggest119855){
            biggest119855=ends[3];
          }
          if(ends[4]>=biggest119855){
            biggest119855=ends[4];
          }
          if(ends[5]>=biggest119855){
            biggest119855=ends[5];
          }
          if(biggest119855 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest119855 == 0){
            S119844=0;
            active[1]=0;
            ends[1]=0;
            S119844=0;
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
