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
  private int S159609 = 1;
  private int S119868 = 1;
  private int S159320 = 1;
  private int S126444 = 1;
  private int S119893 = 1;
  private int S119877 = 1;
  private int S119872 = 1;
  private int S119914 = 1;
  private int S119919 = 1;
  private int S119969 = 1;
  private int S119974 = 1;
  private int S119979 = 1;
  private int S120081 = 1;
  private int S120086 = 1;
  private int S121033 = 1;
  private int S121028 = 1;
  private int S159607 = 1;
  private int S159415 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread159717(int [] tdone, int [] ends){
        switch(S159607){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S159415){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 20
              S159415=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 20
                S159415=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 277, column: 14
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 277, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 279, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 279, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 279, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 279, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 20
              S159415=2;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 277, column: 14
                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 277, column: 38
                currsigs.addElement(cylClampBottleExtend);
                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 279, column: 14
                  invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 279, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 279, column: 14
                  invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 279, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
            S159415=2;
            S159415=0;
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 20
              S159415=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 20
                S159415=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 277, column: 14
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 277, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 279, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 279, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 279, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 279, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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

  public void thread159715(int [] tdone, int [] ends){
        S119919=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread159714(int [] tdone, int [] ends){
        S119914=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread159712(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159711(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159710(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159708(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159707(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159705(int [] tdone, int [] ends){
        switch(S120086){
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

  public void thread159704(int [] tdone, int [] ends){
        switch(S120081){
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

  public void thread159702(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159701(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159699(int [] tdone, int [] ends){
        switch(S119979){
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

  public void thread159698(int [] tdone, int [] ends){
        switch(S119974){
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

  public void thread159697(int [] tdone, int [] ends){
        switch(S119969){
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

  public void thread159695(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159694(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159692(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159691(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159690(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159688(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159687(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159685(int [] tdone, int [] ends){
        switch(S119919){
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

  public void thread159684(int [] tdone, int [] ends){
        switch(S119914){
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

  public void thread159682(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159681(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159680(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159678(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159677(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159675(int [] tdone, int [] ends){
        S119919=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread159674(int [] tdone, int [] ends){
        S119914=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread159672(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159671(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159670(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159668(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159667(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159665(int [] tdone, int [] ends){
        S119919=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread159664(int [] tdone, int [] ends){
        S119914=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread159662(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159661(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159660(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159658(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159657(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159655(int [] tdone, int [] ends){
        S119919=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread159654(int [] tdone, int [] ends){
        S119914=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread159652(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159651(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159650(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159648(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159647(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159645(int [] tdone, int [] ends){
        S119919=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread159644(int [] tdone, int [] ends){
        S119914=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread159642(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159641(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159640(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159638(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159637(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159635(int [] tdone, int [] ends){
        S119919=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread159634(int [] tdone, int [] ends){
        S119914=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread159632(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159631(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159630(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159628(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159627(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159626(int [] tdone, int [] ends){
        switch(S159320){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S126444){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 147, column: 20
              S126444=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S126444=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S119893=0;
                S119877=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                  S119877=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S119872=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
                    S119872=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 153, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                      S119893=1;
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                        S119893=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                          S119893=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                            S119893=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                              S119893=5;
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
                                  S119893=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                      S119893=7;
                                      S121033=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S121033=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S121028=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                          S121028=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                            S126444=2;
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
                                    S119893=7;
                                    S121033=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S121033=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S121028=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S121028=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                          S126444=2;
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
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                  }
                                  S119893=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                      S119893=7;
                                      S121033=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S121033=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S121028=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                          S121028=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                            S126444=2;
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
                                    S119893=7;
                                    S121033=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S121033=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S121028=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S121028=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                          S126444=2;
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
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              thread159627(tdone,ends);
                              thread159628(tdone,ends);
                              int biggest159629 = 0;
                              if(ends[9]>=biggest159629){
                                biggest159629=ends[9];
                              }
                              if(ends[10]>=biggest159629){
                                biggest159629=ends[10];
                              }
                              if(biggest159629 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread159630(tdone,ends);
                            thread159631(tdone,ends);
                            thread159632(tdone,ends);
                            int biggest159633 = 0;
                            if(ends[6]>=biggest159633){
                              biggest159633=ends[6];
                            }
                            if(ends[7]>=biggest159633){
                              biggest159633=ends[7];
                            }
                            if(ends[8]>=biggest159633){
                              biggest159633=ends[8];
                            }
                            if(biggest159633 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread159634(tdone,ends);
                          thread159635(tdone,ends);
                          int biggest159636 = 0;
                          if(ends[4]>=biggest159636){
                            biggest159636=ends[4];
                          }
                          if(ends[5]>=biggest159636){
                            biggest159636=ends[5];
                          }
                          if(biggest159636 == 1){
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
              S126444=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S119893){
                case 0 : 
                  switch(S119877){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                        S119877=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S119872){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                              enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
                              S119872=1;
                              if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 153, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                                S119893=1;
                                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                                  S119893=2;
                                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                                    S119893=3;
                                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                                      S119893=4;
                                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                                        S119893=5;
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
                                            S119893=6;
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                                S119893=7;
                                                S121033=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S121033=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S121028=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    S121028=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                      S126444=2;
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
                                              S119893=7;
                                              S121033=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S121033=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S121028=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S121028=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    S126444=2;
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
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                            }
                                            S119893=6;
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                                S119893=7;
                                                S121033=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S121033=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S121028=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    S121028=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                      S126444=2;
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
                                              S119893=7;
                                              S121033=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S121033=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S121028=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S121028=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    S126444=2;
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
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        thread159637(tdone,ends);
                                        thread159638(tdone,ends);
                                        int biggest159639 = 0;
                                        if(ends[9]>=biggest159639){
                                          biggest159639=ends[9];
                                        }
                                        if(ends[10]>=biggest159639){
                                          biggest159639=ends[10];
                                        }
                                        if(biggest159639 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      thread159640(tdone,ends);
                                      thread159641(tdone,ends);
                                      thread159642(tdone,ends);
                                      int biggest159643 = 0;
                                      if(ends[6]>=biggest159643){
                                        biggest159643=ends[6];
                                      }
                                      if(ends[7]>=biggest159643){
                                        biggest159643=ends[7];
                                      }
                                      if(ends[8]>=biggest159643){
                                        biggest159643=ends[8];
                                      }
                                      if(biggest159643 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread159644(tdone,ends);
                                    thread159645(tdone,ends);
                                    int biggest159646 = 0;
                                    if(ends[4]>=biggest159646){
                                      biggest159646=ends[4];
                                    }
                                    if(ends[5]>=biggest159646){
                                      biggest159646=ends[5];
                                    }
                                    if(biggest159646 == 1){
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
                              S119893=1;
                              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                                S119893=2;
                                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                                  S119893=3;
                                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                                    S119893=4;
                                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                                      S119893=5;
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
                                          S119893=6;
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                              S119893=7;
                                              S121033=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S121033=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S121028=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S121028=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    S126444=2;
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
                                            S119893=7;
                                            S121033=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                              S121033=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S121028=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S121028=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S126444=2;
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
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                          }
                                          S119893=6;
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                              S119893=7;
                                              S121033=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S121033=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S121028=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S121028=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                    S126444=2;
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
                                            S119893=7;
                                            S121033=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                              S121033=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S121028=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S121028=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S126444=2;
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
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      thread159647(tdone,ends);
                                      thread159648(tdone,ends);
                                      int biggest159649 = 0;
                                      if(ends[9]>=biggest159649){
                                        biggest159649=ends[9];
                                      }
                                      if(ends[10]>=biggest159649){
                                        biggest159649=ends[10];
                                      }
                                      if(biggest159649 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread159650(tdone,ends);
                                    thread159651(tdone,ends);
                                    thread159652(tdone,ends);
                                    int biggest159653 = 0;
                                    if(ends[6]>=biggest159653){
                                      biggest159653=ends[6];
                                    }
                                    if(ends[7]>=biggest159653){
                                      biggest159653=ends[7];
                                    }
                                    if(ends[8]>=biggest159653){
                                      biggest159653=ends[8];
                                    }
                                    if(biggest159653 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread159654(tdone,ends);
                                  thread159655(tdone,ends);
                                  int biggest159656 = 0;
                                  if(ends[4]>=biggest159656){
                                    biggest159656=ends[4];
                                  }
                                  if(ends[5]>=biggest159656){
                                    biggest159656=ends[5];
                                  }
                                  if(biggest159656 == 1){
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
                      S119877=1;
                      S119877=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                        S119877=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S119872=0;
                        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
                          S119872=1;
                          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 153, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                            System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                            S119893=1;
                            if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                              S119893=2;
                              if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                                S119893=3;
                                if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                                  S119893=4;
                                  if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                                    S119893=5;
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
                                        S119893=6;
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                            S119893=7;
                                            S121033=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                              S121033=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S121028=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S121028=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S126444=2;
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
                                          S119893=7;
                                          S121033=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                            S121033=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S121028=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                              S121028=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S126444=2;
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
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                        }
                                        S119893=6;
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                            S119893=7;
                                            S121033=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                              S121033=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S121028=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S121028=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                  S126444=2;
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
                                          S119893=7;
                                          S121033=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                            S121033=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S121028=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                              S121028=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                                S126444=2;
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
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread159657(tdone,ends);
                                    thread159658(tdone,ends);
                                    int biggest159659 = 0;
                                    if(ends[9]>=biggest159659){
                                      biggest159659=ends[9];
                                    }
                                    if(ends[10]>=biggest159659){
                                      biggest159659=ends[10];
                                    }
                                    if(biggest159659 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread159660(tdone,ends);
                                  thread159661(tdone,ends);
                                  thread159662(tdone,ends);
                                  int biggest159663 = 0;
                                  if(ends[6]>=biggest159663){
                                    biggest159663=ends[6];
                                  }
                                  if(ends[7]>=biggest159663){
                                    biggest159663=ends[7];
                                  }
                                  if(ends[8]>=biggest159663){
                                    biggest159663=ends[8];
                                  }
                                  if(biggest159663 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread159664(tdone,ends);
                                thread159665(tdone,ends);
                                int biggest159666 = 0;
                                if(ends[4]>=biggest159666){
                                  biggest159666=ends[4];
                                }
                                if(ends[5]>=biggest159666){
                                  biggest159666=ends[5];
                                }
                                if(biggest159666 == 1){
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
                    S119893=2;
                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                      S119893=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                        S119893=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                          S119893=5;
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
                              S119893=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                  S119893=7;
                                  S121033=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121033=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S121028=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S121028=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S126444=2;
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
                                S119893=7;
                                S121033=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121033=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S121028=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121028=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S126444=2;
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
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                              }
                              S119893=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                  S119893=7;
                                  S121033=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121033=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S121028=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S121028=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S126444=2;
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
                                S119893=7;
                                S121033=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121033=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S121028=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121028=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S126444=2;
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
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          thread159667(tdone,ends);
                          thread159668(tdone,ends);
                          int biggest159669 = 0;
                          if(ends[9]>=biggest159669){
                            biggest159669=ends[9];
                          }
                          if(ends[10]>=biggest159669){
                            biggest159669=ends[10];
                          }
                          if(biggest159669 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread159670(tdone,ends);
                        thread159671(tdone,ends);
                        thread159672(tdone,ends);
                        int biggest159673 = 0;
                        if(ends[6]>=biggest159673){
                          biggest159673=ends[6];
                        }
                        if(ends[7]>=biggest159673){
                          biggest159673=ends[7];
                        }
                        if(ends[8]>=biggest159673){
                          biggest159673=ends[8];
                        }
                        if(biggest159673 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread159674(tdone,ends);
                      thread159675(tdone,ends);
                      int biggest159676 = 0;
                      if(ends[4]>=biggest159676){
                        biggest159676=ends[4];
                      }
                      if(ends[5]>=biggest159676){
                        biggest159676=ends[5];
                      }
                      if(biggest159676 == 1){
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
                    S119893=3;
                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                      S119893=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                        S119893=5;
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
                            S119893=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                S119893=7;
                                S121033=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121033=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S121028=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121028=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S126444=2;
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
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                            }
                            S119893=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                S119893=7;
                                S121033=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121033=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S121028=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121028=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S126444=2;
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
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        thread159677(tdone,ends);
                        thread159678(tdone,ends);
                        int biggest159679 = 0;
                        if(ends[9]>=biggest159679){
                          biggest159679=ends[9];
                        }
                        if(ends[10]>=biggest159679){
                          biggest159679=ends[10];
                        }
                        if(biggest159679 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread159680(tdone,ends);
                      thread159681(tdone,ends);
                      thread159682(tdone,ends);
                      int biggest159683 = 0;
                      if(ends[6]>=biggest159683){
                        biggest159683=ends[6];
                      }
                      if(ends[7]>=biggest159683){
                        biggest159683=ends[7];
                      }
                      if(ends[8]>=biggest159683){
                        biggest159683=ends[8];
                      }
                      if(biggest159683 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread159684(tdone,ends);
                    thread159685(tdone,ends);
                    int biggest159686 = 0;
                    if(ends[4]>=biggest159686){
                      biggest159686=ends[4];
                    }
                    if(ends[5]>=biggest159686){
                      biggest159686=ends[5];
                    }
                    if(biggest159686 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest159686 == 0){
                      S119893=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                        S119893=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                          S119893=5;
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
                              S119893=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                  S119893=7;
                                  S121033=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121033=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S121028=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S121028=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S126444=2;
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
                                S119893=7;
                                S121033=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121033=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S121028=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121028=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S126444=2;
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
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                              }
                              S119893=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                  S119893=7;
                                  S121033=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121033=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S121028=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S121028=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S126444=2;
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
                                S119893=7;
                                S121033=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121033=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S121028=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121028=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S126444=2;
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
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          thread159687(tdone,ends);
                          thread159688(tdone,ends);
                          int biggest159689 = 0;
                          if(ends[9]>=biggest159689){
                            biggest159689=ends[9];
                          }
                          if(ends[10]>=biggest159689){
                            biggest159689=ends[10];
                          }
                          if(biggest159689 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread159690(tdone,ends);
                        thread159691(tdone,ends);
                        thread159692(tdone,ends);
                        int biggest159693 = 0;
                        if(ends[6]>=biggest159693){
                          biggest159693=ends[6];
                        }
                        if(ends[7]>=biggest159693){
                          biggest159693=ends[7];
                        }
                        if(ends[8]>=biggest159693){
                          biggest159693=ends[8];
                        }
                        if(biggest159693 == 1){
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
                    S119893=4;
                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                      S119893=5;
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
                          S119893=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 245, column: 21
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                            S119893=7;
                            S121033=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121033=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S121028=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121028=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S126444=2;
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
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          S119893=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 245, column: 21
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                            S119893=7;
                            S121033=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121033=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S121028=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121028=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S126444=2;
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
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      thread159694(tdone,ends);
                      thread159695(tdone,ends);
                      int biggest159696 = 0;
                      if(ends[9]>=biggest159696){
                        biggest159696=ends[9];
                      }
                      if(ends[10]>=biggest159696){
                        biggest159696=ends[10];
                      }
                      if(biggest159696 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread159697(tdone,ends);
                    thread159698(tdone,ends);
                    thread159699(tdone,ends);
                    int biggest159700 = 0;
                    if(ends[6]>=biggest159700){
                      biggest159700=ends[6];
                    }
                    if(ends[7]>=biggest159700){
                      biggest159700=ends[7];
                    }
                    if(ends[8]>=biggest159700){
                      biggest159700=ends[8];
                    }
                    if(biggest159700 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest159700 == 0){
                      S119893=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                        S119893=5;
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
                            S119893=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                S119893=7;
                                S121033=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121033=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S121028=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121028=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S126444=2;
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
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                            }
                            S119893=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                S119893=7;
                                S121033=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121033=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S121028=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S121028=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S126444=2;
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
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        thread159701(tdone,ends);
                        thread159702(tdone,ends);
                        int biggest159703 = 0;
                        if(ends[9]>=biggest159703){
                          biggest159703=ends[9];
                        }
                        if(ends[10]>=biggest159703){
                          biggest159703=ends[10];
                        }
                        if(biggest159703 == 1){
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
                    S119893=5;
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
                        S119893=6;
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 245, column: 21
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                            S119893=7;
                            S121033=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121033=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S121028=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121028=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S126444=2;
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
                          S119893=7;
                          S121033=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                            S121033=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121028=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121028=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                S126444=2;
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
                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                        }
                        S119893=6;
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 245, column: 21
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                            S119893=7;
                            S121033=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121033=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S121028=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121028=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S126444=2;
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
                          S119893=7;
                          S121033=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                            S121033=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121028=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121028=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                S126444=2;
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
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    thread159704(tdone,ends);
                    thread159705(tdone,ends);
                    int biggest159706 = 0;
                    if(ends[9]>=biggest159706){
                      biggest159706=ends[9];
                    }
                    if(ends[10]>=biggest159706){
                      biggest159706=ends[10];
                    }
                    if(biggest159706 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest159706 == 0){
                      S119893=5;
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
                          S119893=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 245, column: 21
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                            S119893=7;
                            S121033=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121033=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S121028=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121028=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S126444=2;
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
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          S119893=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 245, column: 21
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                            S119893=7;
                            S121033=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121033=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S121028=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121028=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S126444=2;
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
                      S119893=6;
                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\liquidDumperController.sysj line: 245, column: 21
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                          S119893=7;
                          S121033=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                            S121033=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121028=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121028=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                S126444=2;
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
                        S119893=7;
                        S121033=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                          S121033=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S121028=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                            S121028=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 255, column: 5
                              S126444=2;
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
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                      }
                      S119893=6;
                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\liquidDumperController.sysj line: 245, column: 21
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                          S119893=7;
                          S121033=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                            S121033=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121028=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121028=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                S126444=2;
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
                        S119893=7;
                        S121033=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                          S121033=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S121028=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                            S121028=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 255, column: 5
                              S126444=2;
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
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 6 : 
                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 247, column: 33
                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 247, column: 50
                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 245, column: 21
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                      S119893=7;
                      S121033=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                        S121033=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121028=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                          S121028=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 255, column: 5
                            S126444=2;
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
                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 245, column: 21
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                      S119893=7;
                      S121033=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                        S121033=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121028=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                          S121028=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 255, column: 5
                            S126444=2;
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
                  break;
                
                case 7 : 
                  switch(S121033){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                        S121033=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S121028){
                          case 0 : 
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121028=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                S126444=2;
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
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 255, column: 5
                              S126444=2;
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
                      S121033=1;
                      S121033=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                        S121033=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121028=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                          S121028=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 255, column: 5
                            S126444=2;
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
                
                case 8 : 
                  S126444=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S126444=2;
            S126444=0;
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 147, column: 20
              S126444=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S126444=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S119893=0;
                S119877=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                  S119877=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S119872=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
                    S119872=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 153, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
                      S119893=1;
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                        S119893=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                          S119893=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                            S119893=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                              S119893=5;
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
                                  S119893=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                      S119893=7;
                                      S121033=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S121033=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S121028=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                          S121028=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                            S126444=2;
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
                                    S119893=7;
                                    S121033=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S121033=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S121028=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S121028=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                          S126444=2;
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
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                                  }
                                  S119893=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 245, column: 21
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                                      S119893=7;
                                      S121033=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S121033=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S121028=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                          S121028=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                            S126444=2;
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
                                    S119893=7;
                                    S121033=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                      S121033=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S121028=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                        S121028=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                          S126444=2;
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
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              thread159707(tdone,ends);
                              thread159708(tdone,ends);
                              int biggest159709 = 0;
                              if(ends[9]>=biggest159709){
                                biggest159709=ends[9];
                              }
                              if(ends[10]>=biggest159709){
                                biggest159709=ends[10];
                              }
                              if(biggest159709 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread159710(tdone,ends);
                            thread159711(tdone,ends);
                            thread159712(tdone,ends);
                            int biggest159713 = 0;
                            if(ends[6]>=biggest159713){
                              biggest159713=ends[6];
                            }
                            if(ends[7]>=biggest159713){
                              biggest159713=ends[7];
                            }
                            if(ends[8]>=biggest159713){
                              biggest159713=ends[8];
                            }
                            if(biggest159713 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread159714(tdone,ends);
                          thread159715(tdone,ends);
                          int biggest159716 = 0;
                          if(ends[4]>=biggest159716){
                            biggest159716=ends[4];
                          }
                          if(ends[5]>=biggest159716){
                            biggest159716=ends[5];
                          }
                          if(biggest159716 == 1){
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

  public void thread159625(int [] tdone, int [] ends){
        switch(S119868){
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

  public void thread159623(int [] tdone, int [] ends){
        S159607=1;
    S159415=0;
    if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 271, column: 20
      S159415=1;
      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 273, column: 20
        S159415=2;
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
      }
      else {
        if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 277, column: 14
          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 277, column: 38
          currsigs.addElement(cylClampBottleExtend);
          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 279, column: 14
            invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 279, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 279, column: 14
            invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 279, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 281, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 281, column: 33
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

  public void thread159621(int [] tdone, int [] ends){
        S119919=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread159620(int [] tdone, int [] ends){
        S119914=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 175, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread159618(int [] tdone, int [] ends){
        S119979=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread159617(int [] tdone, int [] ends){
        S119974=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread159616(int [] tdone, int [] ends){
        S119969=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 187, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread159614(int [] tdone, int [] ends){
        S120086=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread159613(int [] tdone, int [] ends){
        S120081=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 197, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread159612(int [] tdone, int [] ends){
        S159320=1;
    OK_thread_3 = 0;//sysj\liquidDumperController.sysj line: 123, column: 3
    BLOCKED_thread_3 = 2;//sysj\liquidDumperController.sysj line: 125, column: 3
    WARN_thread_3 = 3;//sysj\liquidDumperController.sysj line: 127, column: 3
    TANK_CAPACITY_thread_3 = 6;//sysj\liquidDumperController.sysj line: 131, column: 3
    TANK_WARN_thread_3 = 4;//sysj\liquidDumperController.sysj line: 133, column: 3
    w_thread_3 = null;//sysj\liquidDumperController.sysj line: 137, column: 3
    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 139, column: 3
    code_thread_3 = 0;//sysj\liquidDumperController.sysj line: 141, column: 3
    S126444=0;
    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 147, column: 20
      S126444=1;
      if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S126444=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S119893=0;
        S119877=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 153, column: 5
          enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
          S119877=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S119872=0;
          if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
            enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 153, column: 5
            S119872=1;
            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 153, column: 5
              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 153, column: 5
              ends[3]=2;
              ;//sysj\liquidDumperController.sysj line: 153, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 155, column: 5
              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 157, column: 5
              S119893=1;
              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 163, column: 21
                S119893=2;
                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 173, column: 21
                  S119893=3;
                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 185, column: 21
                    S119893=4;
                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 195, column: 21
                      S119893=5;
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
                          S119893=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 245, column: 21
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                            S119893=7;
                            S121033=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121033=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S121028=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121028=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S126444=2;
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
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 227, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 229, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 231, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 233, column: 6
                          }
                          S119893=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 237, column: 8
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 239, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 241, column: 6
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 245, column: 27
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 245, column: 21
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 249, column: 21
                              S119893=7;
                              S121033=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121033=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S121028=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S121028=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                    S126444=2;
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
                            S119893=7;
                            S121033=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 255, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                              S121033=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S121028=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 255, column: 5
                                S121028=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 255, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 255, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 255, column: 5
                                  S126444=2;
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
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      thread159613(tdone,ends);
                      thread159614(tdone,ends);
                      int biggest159615 = 0;
                      if(ends[9]>=biggest159615){
                        biggest159615=ends[9];
                      }
                      if(ends[10]>=biggest159615){
                        biggest159615=ends[10];
                      }
                      if(biggest159615 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread159616(tdone,ends);
                    thread159617(tdone,ends);
                    thread159618(tdone,ends);
                    int biggest159619 = 0;
                    if(ends[6]>=biggest159619){
                      biggest159619=ends[6];
                    }
                    if(ends[7]>=biggest159619){
                      biggest159619=ends[7];
                    }
                    if(ends[8]>=biggest159619){
                      biggest159619=ends[8];
                    }
                    if(biggest159619 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread159620(tdone,ends);
                  thread159621(tdone,ends);
                  int biggest159622 = 0;
                  if(ends[4]>=biggest159622){
                    biggest159622=ends[4];
                  }
                  if(ends[5]>=biggest159622){
                    biggest159622=ends[5];
                  }
                  if(biggest159622 == 1){
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

  public void thread159611(int [] tdone, int [] ends){
        S119868=1;
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
      switch(S159609){
        case 0 : 
          S159609=0;
          break RUN;
        
        case 1 : 
          S159609=2;
          S159609=2;
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 97, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 97, column: 2
          thread159611(tdone,ends);
          thread159612(tdone,ends);
          thread159623(tdone,ends);
          int biggest159624 = 0;
          if(ends[2]>=biggest159624){
            biggest159624=ends[2];
          }
          if(ends[3]>=biggest159624){
            biggest159624=ends[3];
          }
          if(ends[11]>=biggest159624){
            biggest159624=ends[11];
          }
          if(biggest159624 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 97, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 97, column: 2
          thread159625(tdone,ends);
          thread159626(tdone,ends);
          thread159717(tdone,ends);
          int biggest159718 = 0;
          if(ends[2]>=biggest159718){
            biggest159718=ends[2];
          }
          if(ends[3]>=biggest159718){
            biggest159718=ends[3];
          }
          if(ends[11]>=biggest159718){
            biggest159718=ends[11];
          }
          if(biggest159718 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest159718 == 0){
            S159609=0;
            active[1]=0;
            ends[1]=0;
            S159609=0;
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
