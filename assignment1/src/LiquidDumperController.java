import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LiquidDumperController extends ClockDomain{
  public LiquidDumperController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal clampClosed = new Signal("clampClosed", Signal.INPUT);
  public Signal bottleInverted = new Signal("bottleInverted", Signal.INPUT);
  public Signal bottleUpright = new Signal("bottleUpright", Signal.INPUT);
  public Signal bottleDrained = new Signal("bottleDrained", Signal.INPUT);
  public Signal wasteTankLevel = new Signal("wasteTankLevel", Signal.INPUT);
  public Signal cylClampBottleExtendM = new Signal("cylClampBottleExtendM", Signal.INPUT);
  public Signal invertRotateExtendM = new Signal("invertRotateExtendM", Signal.INPUT);
  public Signal drainValveOnOffM = new Signal("drainValveOnOffM", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  public Signal invertRotateExtend = new Signal("invertRotateExtend", Signal.OUTPUT);
  public Signal invertRotateRetract = new Signal("invertRotateRetract", Signal.OUTPUT);
  public Signal drainValveOnOff = new Signal("drainValveOnOff", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int OK_thread_3;//sysj\liquidDumperController.sysj line: 123, column: 3
  private int BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 125, column: 3
  private int WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 3
  private int TANK_CAPACITY_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 3
  private int TANK_WARN_thread_3;//sysj\liquidDumperController.sysj line: 133, column: 3
  private WorkpieceTwin w_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 3
  private int level_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 3
  private int code_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 3
  private int S137403 = 1;
  private int S122070 = 1;
  private int S137114 = 1;
  private int S124578 = 1;
  private int S122095 = 1;
  private int S122079 = 1;
  private int S122074 = 1;
  private int S122116 = 1;
  private int S122121 = 1;
  private int S122171 = 1;
  private int S122176 = 1;
  private int S122181 = 1;
  private int S122283 = 1;
  private int S122288 = 1;
  private int S122407 = 1;
  private int S122402 = 1;
  private int S137401 = 1;
  private int S137209 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread137511(int [] tdone, int [] ends){
        switch(S137401){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S137209){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 263, column: 20
              S137209=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 265, column: 20
                S137209=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 269, column: 14
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 269, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 271, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                      currsigs.addElement(drainValveOnOff);
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                    else {
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                  }
                  else {
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                      currsigs.addElement(drainValveOnOff);
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                    else {
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                  }
                }
                else {
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 271, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                      currsigs.addElement(drainValveOnOff);
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                    else {
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                  }
                  else {
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                      currsigs.addElement(drainValveOnOff);
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                    else {
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                  }
                }
              }
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 265, column: 20
              S137209=2;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 269, column: 14
                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 269, column: 38
                currsigs.addElement(cylClampBottleExtend);
                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 14
                  invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 271, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                    currsigs.addElement(drainValveOnOff);
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                  else {
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                }
                else {
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                    currsigs.addElement(drainValveOnOff);
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                  else {
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                }
              }
              else {
                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 14
                  invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 271, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                    currsigs.addElement(drainValveOnOff);
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                  else {
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                }
                else {
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                    currsigs.addElement(drainValveOnOff);
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                  else {
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                }
              }
            }
            break;
          
          case 2 : 
            S137209=2;
            S137209=0;
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 263, column: 20
              S137209=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 265, column: 20
                S137209=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 269, column: 14
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 269, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 271, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                      currsigs.addElement(drainValveOnOff);
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                    else {
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                  }
                  else {
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                      currsigs.addElement(drainValveOnOff);
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                    else {
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                  }
                }
                else {
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 271, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                      currsigs.addElement(drainValveOnOff);
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                    else {
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                  }
                  else {
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
                      currsigs.addElement(drainValveOnOff);
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                    else {
                      active[11]=1;
                      ends[11]=1;
                      tdone[11]=1;
                    }
                  }
                }
              }
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread137509(int [] tdone, int [] ends){
        S122121=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137508(int [] tdone, int [] ends){
        S122116=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137506(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137505(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137504(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137502(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137501(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137499(int [] tdone, int [] ends){
        switch(S122288){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
        currsigs.addElement(invertRotateRetract);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread137498(int [] tdone, int [] ends){
        switch(S122283){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread137496(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137495(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137493(int [] tdone, int [] ends){
        switch(S122181){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
        currsigs.addElement(drainValveOnOff);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread137492(int [] tdone, int [] ends){
        switch(S122176){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
        currsigs.addElement(invertRotateExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread137491(int [] tdone, int [] ends){
        switch(S122171){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread137489(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137488(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137486(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137485(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137484(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137482(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137481(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137479(int [] tdone, int [] ends){
        switch(S122121){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
        currsigs.addElement(invertRotateExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread137478(int [] tdone, int [] ends){
        switch(S122116){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread137476(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137475(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137474(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137472(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137471(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137469(int [] tdone, int [] ends){
        S122121=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137468(int [] tdone, int [] ends){
        S122116=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137466(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137465(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137464(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137462(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137461(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137459(int [] tdone, int [] ends){
        S122121=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137458(int [] tdone, int [] ends){
        S122116=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137456(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137455(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137454(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137452(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137451(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137449(int [] tdone, int [] ends){
        S122121=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137448(int [] tdone, int [] ends){
        S122116=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137446(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137445(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137444(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137442(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137441(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137439(int [] tdone, int [] ends){
        S122121=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137438(int [] tdone, int [] ends){
        S122116=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137436(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137435(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137434(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137432(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137431(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137429(int [] tdone, int [] ends){
        S122121=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137428(int [] tdone, int [] ends){
        S122116=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137426(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137425(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137424(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137422(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137421(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137420(int [] tdone, int [] ends){
        switch(S137114){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S124578){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 147, column: 20
              S124578=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S124578=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S122095=0;
                S122079=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                  S122079=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S122074=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
                    S122074=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 153, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                      S122095=1;
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                        S122095=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                          S122095=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                            S122095=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                              S122095=5;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                  }
                                  S122095=6;
                                  S122407=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                    S122407=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S122402=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                      S122402=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                        S124578=2;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                  }
                                  S122095=6;
                                  S122407=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                    S122407=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S122402=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                      S122402=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                        S124578=2;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                            else {
                              thread137421(tdone,ends);
                              thread137422(tdone,ends);
                              int biggest137423 = 0;
                              if(ends[9]>=biggest137423){
                                biggest137423=ends[9];
                              }
                              if(ends[10]>=biggest137423){
                                biggest137423=ends[10];
                              }
                              if(biggest137423 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread137424(tdone,ends);
                            thread137425(tdone,ends);
                            thread137426(tdone,ends);
                            int biggest137427 = 0;
                            if(ends[6]>=biggest137427){
                              biggest137427=ends[6];
                            }
                            if(ends[7]>=biggest137427){
                              biggest137427=ends[7];
                            }
                            if(ends[8]>=biggest137427){
                              biggest137427=ends[8];
                            }
                            if(biggest137427 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread137428(tdone,ends);
                          thread137429(tdone,ends);
                          int biggest137430 = 0;
                          if(ends[4]>=biggest137430){
                            biggest137430=ends[4];
                          }
                          if(ends[5]>=biggest137430){
                            biggest137430=ends[5];
                          }
                          if(biggest137430 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 165, column: 6
                        currsigs.addElement(cylClampBottleExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
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
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S124578=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S122095){
                case 0 : 
                  switch(S122079){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                        S122079=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S122074){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                              enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
                              S122074=1;
                              if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 153, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                                S122095=1;
                                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                                  S122095=2;
                                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                                    S122095=3;
                                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                                      S122095=4;
                                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                                        S122095=5;
                                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                            }
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                            }
                                            S122095=6;
                                            S122407=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                              S122407=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S122402=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                                S122402=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                                  S124578=2;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                            }
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                            }
                                            S122095=6;
                                            S122407=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                              S122407=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S122402=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                                S122402=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                                  S124578=2;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                      else {
                                        thread137431(tdone,ends);
                                        thread137432(tdone,ends);
                                        int biggest137433 = 0;
                                        if(ends[9]>=biggest137433){
                                          biggest137433=ends[9];
                                        }
                                        if(ends[10]>=biggest137433){
                                          biggest137433=ends[10];
                                        }
                                        if(biggest137433 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      thread137434(tdone,ends);
                                      thread137435(tdone,ends);
                                      thread137436(tdone,ends);
                                      int biggest137437 = 0;
                                      if(ends[6]>=biggest137437){
                                        biggest137437=ends[6];
                                      }
                                      if(ends[7]>=biggest137437){
                                        biggest137437=ends[7];
                                      }
                                      if(ends[8]>=biggest137437){
                                        biggest137437=ends[8];
                                      }
                                      if(biggest137437 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread137438(tdone,ends);
                                    thread137439(tdone,ends);
                                    int biggest137440 = 0;
                                    if(ends[4]>=biggest137440){
                                      biggest137440=ends[4];
                                    }
                                    if(ends[5]>=biggest137440){
                                      biggest137440=ends[5];
                                    }
                                    if(biggest137440 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 165, column: 6
                                  currsigs.addElement(cylClampBottleExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 153, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                              S122095=1;
                              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                                S122095=2;
                                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                                  S122095=3;
                                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                                    S122095=4;
                                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                                      S122095=5;
                                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                          }
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                          }
                                          S122095=6;
                                          S122407=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                            S122407=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S122402=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                              S122402=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                                S124578=2;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                          }
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                          }
                                          S122095=6;
                                          S122407=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                            S122407=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S122402=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                              S122402=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                                S124578=2;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                    else {
                                      thread137441(tdone,ends);
                                      thread137442(tdone,ends);
                                      int biggest137443 = 0;
                                      if(ends[9]>=biggest137443){
                                        biggest137443=ends[9];
                                      }
                                      if(ends[10]>=biggest137443){
                                        biggest137443=ends[10];
                                      }
                                      if(biggest137443 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread137444(tdone,ends);
                                    thread137445(tdone,ends);
                                    thread137446(tdone,ends);
                                    int biggest137447 = 0;
                                    if(ends[6]>=biggest137447){
                                      biggest137447=ends[6];
                                    }
                                    if(ends[7]>=biggest137447){
                                      biggest137447=ends[7];
                                    }
                                    if(ends[8]>=biggest137447){
                                      biggest137447=ends[8];
                                    }
                                    if(biggest137447 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread137448(tdone,ends);
                                  thread137449(tdone,ends);
                                  int biggest137450 = 0;
                                  if(ends[4]>=biggest137450){
                                    biggest137450=ends[4];
                                  }
                                  if(ends[5]>=biggest137450){
                                    biggest137450=ends[5];
                                  }
                                  if(biggest137450 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 165, column: 6
                                currsigs.addElement(cylClampBottleExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                      break;
                    
                    case 1 : 
                      S122079=1;
                      S122079=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                        S122079=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S122074=0;
                        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
                          S122074=1;
                          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 153, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                            System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                            S122095=1;
                            if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                              S122095=2;
                              if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                                S122095=3;
                                if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                                  S122095=4;
                                  if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                                    S122095=5;
                                    if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                                      w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                                      System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                                      level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                                      if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                        }
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                        }
                                        S122095=6;
                                        S122407=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                          S122407=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S122402=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                            S122402=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                              S124578=2;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                        }
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                        }
                                        S122095=6;
                                        S122407=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                          S122407=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S122402=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                            S122402=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                              S124578=2;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                  else {
                                    thread137451(tdone,ends);
                                    thread137452(tdone,ends);
                                    int biggest137453 = 0;
                                    if(ends[9]>=biggest137453){
                                      biggest137453=ends[9];
                                    }
                                    if(ends[10]>=biggest137453){
                                      biggest137453=ends[10];
                                    }
                                    if(biggest137453 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread137454(tdone,ends);
                                  thread137455(tdone,ends);
                                  thread137456(tdone,ends);
                                  int biggest137457 = 0;
                                  if(ends[6]>=biggest137457){
                                    biggest137457=ends[6];
                                  }
                                  if(ends[7]>=biggest137457){
                                    biggest137457=ends[7];
                                  }
                                  if(ends[8]>=biggest137457){
                                    biggest137457=ends[8];
                                  }
                                  if(biggest137457 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread137458(tdone,ends);
                                thread137459(tdone,ends);
                                int biggest137460 = 0;
                                if(ends[4]>=biggest137460){
                                  biggest137460=ends[4];
                                }
                                if(ends[5]>=biggest137460){
                                  biggest137460=ends[5];
                                }
                                if(biggest137460 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 165, column: 6
                              currsigs.addElement(cylClampBottleExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 1 : 
                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                    S122095=2;
                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                      S122095=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                        S122095=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                          S122095=5;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                              }
                              S122095=6;
                              S122407=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                S122407=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S122402=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                  S122402=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                    S124578=2;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                              }
                              S122095=6;
                              S122407=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                S122407=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S122402=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                  S122402=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                    S124578=2;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                        else {
                          thread137461(tdone,ends);
                          thread137462(tdone,ends);
                          int biggest137463 = 0;
                          if(ends[9]>=biggest137463){
                            biggest137463=ends[9];
                          }
                          if(ends[10]>=biggest137463){
                            biggest137463=ends[10];
                          }
                          if(biggest137463 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread137464(tdone,ends);
                        thread137465(tdone,ends);
                        thread137466(tdone,ends);
                        int biggest137467 = 0;
                        if(ends[6]>=biggest137467){
                          biggest137467=ends[6];
                        }
                        if(ends[7]>=biggest137467){
                          biggest137467=ends[7];
                        }
                        if(ends[8]>=biggest137467){
                          biggest137467=ends[8];
                        }
                        if(biggest137467 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread137468(tdone,ends);
                      thread137469(tdone,ends);
                      int biggest137470 = 0;
                      if(ends[4]>=biggest137470){
                        biggest137470=ends[4];
                      }
                      if(ends[5]>=biggest137470){
                        biggest137470=ends[5];
                      }
                      if(biggest137470 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 165, column: 6
                    currsigs.addElement(cylClampBottleExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                    S122095=3;
                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                      S122095=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                        S122095=5;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            }
                            S122095=6;
                            S122407=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122407=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S122402=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                S122402=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                  S124578=2;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            }
                            S122095=6;
                            S122407=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122407=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S122402=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                S122402=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                  S124578=2;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                      else {
                        thread137471(tdone,ends);
                        thread137472(tdone,ends);
                        int biggest137473 = 0;
                        if(ends[9]>=biggest137473){
                          biggest137473=ends[9];
                        }
                        if(ends[10]>=biggest137473){
                          biggest137473=ends[10];
                        }
                        if(biggest137473 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread137474(tdone,ends);
                      thread137475(tdone,ends);
                      thread137476(tdone,ends);
                      int biggest137477 = 0;
                      if(ends[6]>=biggest137477){
                        biggest137477=ends[6];
                      }
                      if(ends[7]>=biggest137477){
                        biggest137477=ends[7];
                      }
                      if(ends[8]>=biggest137477){
                        biggest137477=ends[8];
                      }
                      if(biggest137477 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread137478(tdone,ends);
                    thread137479(tdone,ends);
                    int biggest137480 = 0;
                    if(ends[4]>=biggest137480){
                      biggest137480=ends[4];
                    }
                    if(ends[5]>=biggest137480){
                      biggest137480=ends[5];
                    }
                    if(biggest137480 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest137480 == 0){
                      S122095=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                        S122095=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                          S122095=5;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                              }
                              S122095=6;
                              S122407=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                S122407=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S122402=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                  S122402=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                    S124578=2;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                              }
                              S122095=6;
                              S122407=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                S122407=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S122402=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                  S122402=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                    S124578=2;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                        else {
                          thread137481(tdone,ends);
                          thread137482(tdone,ends);
                          int biggest137483 = 0;
                          if(ends[9]>=biggest137483){
                            biggest137483=ends[9];
                          }
                          if(ends[10]>=biggest137483){
                            biggest137483=ends[10];
                          }
                          if(biggest137483 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread137484(tdone,ends);
                        thread137485(tdone,ends);
                        thread137486(tdone,ends);
                        int biggest137487 = 0;
                        if(ends[6]>=biggest137487){
                          biggest137487=ends[6];
                        }
                        if(ends[7]>=biggest137487){
                          biggest137487=ends[7];
                        }
                        if(ends[8]>=biggest137487){
                          biggest137487=ends[8];
                        }
                        if(biggest137487 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 3 : 
                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                    S122095=4;
                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                      S122095=5;
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                          }
                          S122095=6;
                          S122407=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            S122407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S122402=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122402=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                S124578=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                          }
                          S122095=6;
                          S122407=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            S122407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S122402=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122402=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                S124578=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                    else {
                      thread137488(tdone,ends);
                      thread137489(tdone,ends);
                      int biggest137490 = 0;
                      if(ends[9]>=biggest137490){
                        biggest137490=ends[9];
                      }
                      if(ends[10]>=biggest137490){
                        biggest137490=ends[10];
                      }
                      if(biggest137490 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread137491(tdone,ends);
                    thread137492(tdone,ends);
                    thread137493(tdone,ends);
                    int biggest137494 = 0;
                    if(ends[6]>=biggest137494){
                      biggest137494=ends[6];
                    }
                    if(ends[7]>=biggest137494){
                      biggest137494=ends[7];
                    }
                    if(ends[8]>=biggest137494){
                      biggest137494=ends[8];
                    }
                    if(biggest137494 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest137494 == 0){
                      S122095=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                        S122095=5;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            }
                            S122095=6;
                            S122407=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122407=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S122402=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                S122402=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                  S124578=2;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            }
                            S122095=6;
                            S122407=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122407=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S122402=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                S122402=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                  S124578=2;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                      else {
                        thread137495(tdone,ends);
                        thread137496(tdone,ends);
                        int biggest137497 = 0;
                        if(ends[9]>=biggest137497){
                          biggest137497=ends[9];
                        }
                        if(ends[10]>=biggest137497){
                          biggest137497=ends[10];
                        }
                        if(biggest137497 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 4 : 
                  if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                    S122095=5;
                    if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                      w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                      System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                      level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                      if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                        }
                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                        }
                        S122095=6;
                        S122407=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                          S122407=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S122402=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                            S122402=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 247, column: 5
                              S124578=2;
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
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                        }
                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                        }
                        S122095=6;
                        S122407=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                          S122407=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S122402=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                            S122402=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 247, column: 5
                              S124578=2;
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
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
                  else {
                    thread137498(tdone,ends);
                    thread137499(tdone,ends);
                    int biggest137500 = 0;
                    if(ends[9]>=biggest137500){
                      biggest137500=ends[9];
                    }
                    if(ends[10]>=biggest137500){
                      biggest137500=ends[10];
                    }
                    if(biggest137500 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest137500 == 0){
                      S122095=5;
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                          }
                          S122095=6;
                          S122407=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            S122407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S122402=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122402=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                S124578=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                          }
                          S122095=6;
                          S122407=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            S122407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S122402=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122402=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                S124578=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                  }
                  break;
                
                case 5 : 
                  if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                    w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                    if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                      }
                      if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                      }
                      S122095=6;
                      S122407=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                        S122407=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S122402=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                          S122402=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 247, column: 5
                            S124578=2;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                      }
                      if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                      }
                      S122095=6;
                      S122407=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                        S122407=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S122402=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                          S122402=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 247, column: 5
                            S124578=2;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
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
                
                case 6 : 
                  switch(S122407){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                        S122407=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S122402){
                          case 0 : 
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122402=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                S124578=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 247, column: 5
                              S124578=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                        }
                      }
                      break;
                    
                    case 1 : 
                      S122407=1;
                      S122407=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                        S122407=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S122402=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                          S122402=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 247, column: 5
                            S124578=2;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 7 : 
                  S124578=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S124578=2;
            S124578=0;
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 147, column: 20
              S124578=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S124578=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S122095=0;
                S122079=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                  S122079=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S122074=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
                    S122074=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 153, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                      S122095=1;
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                        S122095=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                          S122095=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                            S122095=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                              S122095=5;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                  }
                                  S122095=6;
                                  S122407=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                    S122407=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S122402=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                      S122402=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                        S124578=2;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                  }
                                  S122095=6;
                                  S122407=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                    S122407=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S122402=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                                      S122402=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                        S124578=2;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                            else {
                              thread137501(tdone,ends);
                              thread137502(tdone,ends);
                              int biggest137503 = 0;
                              if(ends[9]>=biggest137503){
                                biggest137503=ends[9];
                              }
                              if(ends[10]>=biggest137503){
                                biggest137503=ends[10];
                              }
                              if(biggest137503 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread137504(tdone,ends);
                            thread137505(tdone,ends);
                            thread137506(tdone,ends);
                            int biggest137507 = 0;
                            if(ends[6]>=biggest137507){
                              biggest137507=ends[6];
                            }
                            if(ends[7]>=biggest137507){
                              biggest137507=ends[7];
                            }
                            if(ends[8]>=biggest137507){
                              biggest137507=ends[8];
                            }
                            if(biggest137507 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread137508(tdone,ends);
                          thread137509(tdone,ends);
                          int biggest137510 = 0;
                          if(ends[4]>=biggest137510){
                            biggest137510=ends[4];
                          }
                          if(ends[5]>=biggest137510){
                            biggest137510=ends[5];
                          }
                          if(biggest137510 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 165, column: 6
                        currsigs.addElement(cylClampBottleExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
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
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread137419(int [] tdone, int [] ends){
        switch(S122070){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\liquidDumperController.sysj line: 107, column: 8
            auto_1.setPresent();//sysj\liquidDumperController.sysj line: 107, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 12
            currsigs.addElement(manual_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
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

  public void thread137417(int [] tdone, int [] ends){
        S137401=1;
    S137209=0;
    if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 263, column: 20
      S137209=1;
      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 265, column: 20
        S137209=2;
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
      }
      else {
        if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 269, column: 14
          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 269, column: 38
          currsigs.addElement(cylClampBottleExtend);
          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 14
            invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 271, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
              currsigs.addElement(drainValveOnOff);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
          }
          else {
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
              currsigs.addElement(drainValveOnOff);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
          }
        }
        else {
          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 14
            invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 271, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
              currsigs.addElement(drainValveOnOff);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
          }
          else {
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 273, column: 33
              currsigs.addElement(drainValveOnOff);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
          }
        }
      }
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread137415(int [] tdone, int [] ends){
        S122121=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137414(int [] tdone, int [] ends){
        S122116=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137412(int [] tdone, int [] ends){
        S122181=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread137411(int [] tdone, int [] ends){
        S122176=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137410(int [] tdone, int [] ends){
        S122171=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137408(int [] tdone, int [] ends){
        S122288=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread137407(int [] tdone, int [] ends){
        S122283=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread137406(int [] tdone, int [] ends){
        S137114=1;
    OK_thread_3 = 0;//sysj\liquidDumperController.sysj line: 123, column: 3
    BLOCKED_thread_3 = 2;//sysj\liquidDumperController.sysj line: 125, column: 3
    WARN_thread_3 = 3;//sysj\liquidDumperController.sysj line: 127, column: 3
    TANK_CAPACITY_thread_3 = 6;//sysj\liquidDumperController.sysj line: 131, column: 3
    TANK_WARN_thread_3 = 4;//sysj\liquidDumperController.sysj line: 133, column: 3
    w_thread_3 = null;//sysj\liquidDumperController.sysj line: 137, column: 3
    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 139, column: 3
    code_thread_3 = 0;//sysj\liquidDumperController.sysj line: 141, column: 3
    S124578=0;
    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 147, column: 20
      S124578=1;
      if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S124578=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S122095=0;
        S122079=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
          enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
          S122079=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S122074=0;
          if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
            enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
            S122074=1;
            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
              ends[3]=2;
              ;//sysj\liquidDumperController.sysj line: 153, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
              S122095=1;
              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                S122095=2;
                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                  S122095=3;
                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                    S122095=4;
                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                      S122095=5;
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 205, column: 21
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 209, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 211, column: 5
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 217, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 219, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 221, column: 6
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                          }
                          S122095=6;
                          S122407=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            S122407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S122402=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122402=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                S124578=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 237, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                          }
                          S122095=6;
                          S122407=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                            S122407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S122402=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 247, column: 5
                              S122402=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 247, column: 5
                                S124578=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                    else {
                      thread137407(tdone,ends);
                      thread137408(tdone,ends);
                      int biggest137409 = 0;
                      if(ends[9]>=biggest137409){
                        biggest137409=ends[9];
                      }
                      if(ends[10]>=biggest137409){
                        biggest137409=ends[10];
                      }
                      if(biggest137409 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread137410(tdone,ends);
                    thread137411(tdone,ends);
                    thread137412(tdone,ends);
                    int biggest137413 = 0;
                    if(ends[6]>=biggest137413){
                      biggest137413=ends[6];
                    }
                    if(ends[7]>=biggest137413){
                      biggest137413=ends[7];
                    }
                    if(ends[8]>=biggest137413){
                      biggest137413=ends[8];
                    }
                    if(biggest137413 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread137414(tdone,ends);
                  thread137415(tdone,ends);
                  int biggest137416 = 0;
                  if(ends[4]>=biggest137416){
                    biggest137416=ends[4];
                  }
                  if(ends[5]>=biggest137416){
                    biggest137416=ends[5];
                  }
                  if(biggest137416 == 1){
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 165, column: 6
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
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
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread137405(int [] tdone, int [] ends){
        S122070=1;
    if(mode.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\liquidDumperController.sysj line: 107, column: 8
        auto_1.setPresent();//sysj\liquidDumperController.sysj line: 107, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 12
        currsigs.addElement(manual_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
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
      switch(S137403){
        case 0 : 
          S137403=0;
          break RUN;
        
        case 1 : 
          S137403=2;
          S137403=2;
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 97, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 97, column: 2
          thread137405(tdone,ends);
          thread137406(tdone,ends);
          thread137417(tdone,ends);
          int biggest137418 = 0;
          if(ends[2]>=biggest137418){
            biggest137418=ends[2];
          }
          if(ends[3]>=biggest137418){
            biggest137418=ends[3];
          }
          if(ends[11]>=biggest137418){
            biggest137418=ends[11];
          }
          if(biggest137418 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 97, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 97, column: 2
          thread137419(tdone,ends);
          thread137420(tdone,ends);
          thread137511(tdone,ends);
          int biggest137512 = 0;
          if(ends[2]>=biggest137512){
            biggest137512=ends[2];
          }
          if(ends[3]>=biggest137512){
            biggest137512=ends[3];
          }
          if(ends[11]>=biggest137512){
            biggest137512=ends[11];
          }
          if(biggest137512 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest137512 == 0){
            S137403=0;
            active[1]=0;
            ends[1]=0;
            S137403=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    auto_1 = new Signal();
    manual_1 = new Signal();
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
          enable_in.gethook();
          status_o.gethook();
          mode.gethook();
          clampClosed.gethook();
          bottleInverted.gethook();
          bottleUpright.gethook();
          bottleDrained.gethook();
          wasteTankLevel.gethook();
          cylClampBottleExtendM.gethook();
          invertRotateExtendM.gethook();
          drainValveOnOffM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      clampClosed.setpreclear();
      bottleInverted.setpreclear();
      bottleUpright.setpreclear();
      bottleDrained.setpreclear();
      wasteTankLevel.setpreclear();
      cylClampBottleExtendM.setpreclear();
      invertRotateExtendM.setpreclear();
      drainValveOnOffM.setpreclear();
      cylClampBottleExtend.setpreclear();
      invertRotateExtend.setpreclear();
      invertRotateRetract.setpreclear();
      drainValveOnOff.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = clampClosed.getStatus() ? clampClosed.setprepresent() : clampClosed.setpreclear();
      clampClosed.setpreval(clampClosed.getValue());
      clampClosed.setClear();
      dummyint = bottleInverted.getStatus() ? bottleInverted.setprepresent() : bottleInverted.setpreclear();
      bottleInverted.setpreval(bottleInverted.getValue());
      bottleInverted.setClear();
      dummyint = bottleUpright.getStatus() ? bottleUpright.setprepresent() : bottleUpright.setpreclear();
      bottleUpright.setpreval(bottleUpright.getValue());
      bottleUpright.setClear();
      dummyint = bottleDrained.getStatus() ? bottleDrained.setprepresent() : bottleDrained.setpreclear();
      bottleDrained.setpreval(bottleDrained.getValue());
      bottleDrained.setClear();
      dummyint = wasteTankLevel.getStatus() ? wasteTankLevel.setprepresent() : wasteTankLevel.setpreclear();
      wasteTankLevel.setpreval(wasteTankLevel.getValue());
      wasteTankLevel.setClear();
      dummyint = cylClampBottleExtendM.getStatus() ? cylClampBottleExtendM.setprepresent() : cylClampBottleExtendM.setpreclear();
      cylClampBottleExtendM.setpreval(cylClampBottleExtendM.getValue());
      cylClampBottleExtendM.setClear();
      dummyint = invertRotateExtendM.getStatus() ? invertRotateExtendM.setprepresent() : invertRotateExtendM.setpreclear();
      invertRotateExtendM.setpreval(invertRotateExtendM.getValue());
      invertRotateExtendM.setClear();
      dummyint = drainValveOnOffM.getStatus() ? drainValveOnOffM.setprepresent() : drainValveOnOffM.setpreclear();
      drainValveOnOffM.setpreval(drainValveOnOffM.getValue());
      drainValveOnOffM.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      invertRotateExtend.sethook();
      invertRotateExtend.setClear();
      invertRotateRetract.sethook();
      invertRotateRetract.setClear();
      drainValveOnOff.sethook();
      drainValveOnOff.setClear();
      auto_1.setClear();
      manual_1.setClear();
      enable_in.sethook();
      status_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable_in.gethook();
        status_o.gethook();
        mode.gethook();
        clampClosed.gethook();
        bottleInverted.gethook();
        bottleUpright.gethook();
        bottleDrained.gethook();
        wasteTankLevel.gethook();
        cylClampBottleExtendM.gethook();
        invertRotateExtendM.gethook();
        drainValveOnOffM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
