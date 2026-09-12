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
  private int OK_thread_3;//sysj\liquidDumperController.sysj line: 62, column: 3
  private int BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 63, column: 3
  private int WARN_thread_3;//sysj\liquidDumperController.sysj line: 64, column: 3
  private int TANK_CAPACITY_thread_3;//sysj\liquidDumperController.sysj line: 66, column: 3
  private int TANK_WARN_thread_3;//sysj\liquidDumperController.sysj line: 67, column: 3
  private WorkpieceTwin w_thread_3;//sysj\liquidDumperController.sysj line: 69, column: 3
  private int level_thread_3;//sysj\liquidDumperController.sysj line: 70, column: 3
  private int code_thread_3;//sysj\liquidDumperController.sysj line: 71, column: 3
  private int S223746 = 1;
  private int S138195 = 1;
  private int S223457 = 1;
  private int S152406 = 1;
  private int S138220 = 1;
  private int S138204 = 1;
  private int S138199 = 1;
  private int S138229 = 1;
  private int S138234 = 1;
  private int S138239 = 1;
  private int S138267 = 1;
  private int S138272 = 1;
  private int S138277 = 1;
  private int S138347 = 1;
  private int S138352 = 1;
  private int S141839 = 1;
  private int S141834 = 1;
  private int S223744 = 1;
  private int S223552 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread223854(int [] tdone, int [] ends){
        switch(S223744){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S223552){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 150, column: 20
              S223552=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
                S223552=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 153, column: 14
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 153, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 154, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 154, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 154, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 154, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
              S223552=2;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 153, column: 14
                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 153, column: 38
                currsigs.addElement(cylClampBottleExtend);
                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 154, column: 14
                  invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 154, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 154, column: 14
                  invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 154, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
            S223552=2;
            S223552=0;
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 150, column: 20
              S223552=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
                S223552=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 153, column: 14
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 153, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 154, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 154, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 154, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 154, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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

  public void thread223852(int [] tdone, int [] ends){
        S138239=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223851(int [] tdone, int [] ends){
        S138234=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223849(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223848(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223847(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223845(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223844(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223842(int [] tdone, int [] ends){
        switch(S138352){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
        currsigs.addElement(invertRotateRetract);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread223841(int [] tdone, int [] ends){
        switch(S138347){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread223839(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223838(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223836(int [] tdone, int [] ends){
        switch(S138277){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
        currsigs.addElement(drainValveOnOff);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread223835(int [] tdone, int [] ends){
        switch(S138272){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
        currsigs.addElement(invertRotateExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread223834(int [] tdone, int [] ends){
        switch(S138267){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread223832(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223831(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223829(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223828(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223827(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223825(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223824(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223822(int [] tdone, int [] ends){
        switch(S138239){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 46
        currsigs.addElement(invertRotateExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread223821(int [] tdone, int [] ends){
        switch(S138234){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread223819(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223818(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223817(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223815(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223814(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223812(int [] tdone, int [] ends){
        S138239=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223811(int [] tdone, int [] ends){
        S138234=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223809(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223808(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223807(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223805(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223804(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223802(int [] tdone, int [] ends){
        S138239=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223801(int [] tdone, int [] ends){
        S138234=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223799(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223798(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223797(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223795(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223794(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223792(int [] tdone, int [] ends){
        S138239=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223791(int [] tdone, int [] ends){
        S138234=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223789(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223788(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223787(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223785(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223784(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223782(int [] tdone, int [] ends){
        S138239=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223781(int [] tdone, int [] ends){
        S138234=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223779(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223778(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223777(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223775(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223774(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223772(int [] tdone, int [] ends){
        S138239=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223771(int [] tdone, int [] ends){
        S138234=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223769(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223768(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223767(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223765(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223764(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223763(int [] tdone, int [] ends){
        switch(S223457){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S152406){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
              S152406=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S152406=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S138220=0;
                S138204=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                  S138204=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S138199=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                    S138199=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 77, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 86, column: 5
                      S138220=1;
                      if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 88, column: 8
                        System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 89, column: 6
                        S138229=0;
                        if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 92, column: 22
                          S138229=1;
                          if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                            S138229=2;
                            if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                              S138229=3;
                              if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                                S138229=4;
                                if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                                  w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                                  System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                                  level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                    }
                                    S138229=5;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                        S138220=2;
                                        S141839=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141839=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S141834=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S141834=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                              S152406=2;
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
                                      S138220=2;
                                      S141839=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141839=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S141834=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141834=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S152406=2;
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
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                    }
                                    S138229=5;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                        S138220=2;
                                        S141839=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141839=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S141834=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S141834=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                              S152406=2;
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
                                      S138220=2;
                                      S141839=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141839=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S141834=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141834=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S152406=2;
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
                                thread223764(tdone,ends);
                                thread223765(tdone,ends);
                                int biggest223766 = 0;
                                if(ends[9]>=biggest223766){
                                  biggest223766=ends[9];
                                }
                                if(ends[10]>=biggest223766){
                                  biggest223766=ends[10];
                                }
                                if(biggest223766 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              thread223767(tdone,ends);
                              thread223768(tdone,ends);
                              thread223769(tdone,ends);
                              int biggest223770 = 0;
                              if(ends[6]>=biggest223770){
                                biggest223770=ends[6];
                              }
                              if(ends[7]>=biggest223770){
                                biggest223770=ends[7];
                              }
                              if(ends[8]>=biggest223770){
                                biggest223770=ends[8];
                              }
                              if(biggest223770 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread223771(tdone,ends);
                            thread223772(tdone,ends);
                            int biggest223773 = 0;
                            if(ends[4]>=biggest223773){
                              biggest223773=ends[4];
                            }
                            if(ends[5]>=biggest223773){
                              biggest223773=ends[5];
                            }
                            if(biggest223773 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 93, column: 7
                          currsigs.addElement(cylClampBottleExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S138220=2;
                        S141839=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                          S141839=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S141834=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                            S141834=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 142, column: 5
                              S152406=2;
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
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S152406=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S138220){
                case 0 : 
                  switch(S138204){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                        S138204=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S138199){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                              enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                              S138199=1;
                              if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 77, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 86, column: 5
                                S138220=1;
                                if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 88, column: 8
                                  System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 89, column: 6
                                  S138229=0;
                                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 92, column: 22
                                    S138229=1;
                                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                      S138229=2;
                                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                                        S138229=3;
                                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                                          S138229=4;
                                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                              }
                                              S138229=5;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                                  S138220=2;
                                                  S141839=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S141839=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S141834=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      S141834=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                        S152406=2;
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
                                                S138220=2;
                                                S141839=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S141839=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S141834=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S141834=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      S152406=2;
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
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                              }
                                              S138229=5;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                                  S138220=2;
                                                  S141839=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S141839=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S141834=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      S141834=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                        S152406=2;
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
                                                S138220=2;
                                                S141839=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S141839=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S141834=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S141834=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      S152406=2;
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
                                          thread223774(tdone,ends);
                                          thread223775(tdone,ends);
                                          int biggest223776 = 0;
                                          if(ends[9]>=biggest223776){
                                            biggest223776=ends[9];
                                          }
                                          if(ends[10]>=biggest223776){
                                            biggest223776=ends[10];
                                          }
                                          if(biggest223776 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        thread223777(tdone,ends);
                                        thread223778(tdone,ends);
                                        thread223779(tdone,ends);
                                        int biggest223780 = 0;
                                        if(ends[6]>=biggest223780){
                                          biggest223780=ends[6];
                                        }
                                        if(ends[7]>=biggest223780){
                                          biggest223780=ends[7];
                                        }
                                        if(ends[8]>=biggest223780){
                                          biggest223780=ends[8];
                                        }
                                        if(biggest223780 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      thread223781(tdone,ends);
                                      thread223782(tdone,ends);
                                      int biggest223783 = 0;
                                      if(ends[4]>=biggest223783){
                                        biggest223783=ends[4];
                                      }
                                      if(ends[5]>=biggest223783){
                                        biggest223783=ends[5];
                                      }
                                      if(biggest223783 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 93, column: 7
                                    currsigs.addElement(cylClampBottleExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 77, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 86, column: 5
                              S138220=1;
                              if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 88, column: 8
                                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 89, column: 6
                                S138229=0;
                                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 92, column: 22
                                  S138229=1;
                                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                    S138229=2;
                                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                                      S138229=3;
                                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                                        S138229=4;
                                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                            }
                                            S138229=5;
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                                S138220=2;
                                                S141839=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S141839=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S141834=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S141834=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      S152406=2;
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
                                              S138220=2;
                                              S141839=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                S141839=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S141834=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S141834=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S152406=2;
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
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                            }
                                            S138229=5;
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                                S138220=2;
                                                S141839=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S141839=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S141834=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S141834=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                      S152406=2;
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
                                              S138220=2;
                                              S141839=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                S141839=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S141834=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S141834=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S152406=2;
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
                                        thread223784(tdone,ends);
                                        thread223785(tdone,ends);
                                        int biggest223786 = 0;
                                        if(ends[9]>=biggest223786){
                                          biggest223786=ends[9];
                                        }
                                        if(ends[10]>=biggest223786){
                                          biggest223786=ends[10];
                                        }
                                        if(biggest223786 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      thread223787(tdone,ends);
                                      thread223788(tdone,ends);
                                      thread223789(tdone,ends);
                                      int biggest223790 = 0;
                                      if(ends[6]>=biggest223790){
                                        biggest223790=ends[6];
                                      }
                                      if(ends[7]>=biggest223790){
                                        biggest223790=ends[7];
                                      }
                                      if(ends[8]>=biggest223790){
                                        biggest223790=ends[8];
                                      }
                                      if(biggest223790 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread223791(tdone,ends);
                                    thread223792(tdone,ends);
                                    int biggest223793 = 0;
                                    if(ends[4]>=biggest223793){
                                      biggest223793=ends[4];
                                    }
                                    if(ends[5]>=biggest223793){
                                      biggest223793=ends[5];
                                    }
                                    if(biggest223793 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 93, column: 7
                                  currsigs.addElement(cylClampBottleExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                          
                        }
                      }
                      break;
                    
                    case 1 : 
                      S138204=1;
                      S138204=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                        S138204=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S138199=0;
                        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                          S138199=1;
                          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 77, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 86, column: 5
                            S138220=1;
                            if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 88, column: 8
                              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 89, column: 6
                              S138229=0;
                              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 92, column: 22
                                S138229=1;
                                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                  S138229=2;
                                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                                    S138229=3;
                                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                                      S138229=4;
                                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                          }
                                          S138229=5;
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                              S138220=2;
                                              S141839=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                S141839=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S141834=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S141834=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S152406=2;
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
                                            S138220=2;
                                            S141839=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                              S141839=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S141834=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                S141834=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S152406=2;
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
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                          }
                                          S138229=5;
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                              S138220=2;
                                              S141839=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                S141839=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S141834=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S141834=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                    S152406=2;
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
                                            S138220=2;
                                            S141839=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                              S141839=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S141834=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                                S141834=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                                  S152406=2;
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
                                      thread223794(tdone,ends);
                                      thread223795(tdone,ends);
                                      int biggest223796 = 0;
                                      if(ends[9]>=biggest223796){
                                        biggest223796=ends[9];
                                      }
                                      if(ends[10]>=biggest223796){
                                        biggest223796=ends[10];
                                      }
                                      if(biggest223796 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread223797(tdone,ends);
                                    thread223798(tdone,ends);
                                    thread223799(tdone,ends);
                                    int biggest223800 = 0;
                                    if(ends[6]>=biggest223800){
                                      biggest223800=ends[6];
                                    }
                                    if(ends[7]>=biggest223800){
                                      biggest223800=ends[7];
                                    }
                                    if(ends[8]>=biggest223800){
                                      biggest223800=ends[8];
                                    }
                                    if(biggest223800 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread223801(tdone,ends);
                                  thread223802(tdone,ends);
                                  int biggest223803 = 0;
                                  if(ends[4]>=biggest223803){
                                    biggest223803=ends[4];
                                  }
                                  if(ends[5]>=biggest223803){
                                    biggest223803=ends[5];
                                  }
                                  if(biggest223803 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 93, column: 7
                                currsigs.addElement(cylClampBottleExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S138220=2;
                              S141839=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141839=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S141834=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141834=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S152406=2;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 1 : 
                  switch(S138229){
                    case 0 : 
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 92, column: 22
                        S138229=1;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                          S138229=2;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                            S138229=3;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                              S138229=4;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                  }
                                  S138229=5;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                      S138220=2;
                                      S141839=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141839=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S141834=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141834=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S152406=2;
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
                                    S138220=2;
                                    S141839=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141839=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S141834=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141834=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S152406=2;
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
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                  }
                                  S138229=5;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                      S138220=2;
                                      S141839=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141839=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S141834=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141834=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S152406=2;
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
                                    S138220=2;
                                    S141839=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141839=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S141834=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141834=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S152406=2;
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
                              thread223804(tdone,ends);
                              thread223805(tdone,ends);
                              int biggest223806 = 0;
                              if(ends[9]>=biggest223806){
                                biggest223806=ends[9];
                              }
                              if(ends[10]>=biggest223806){
                                biggest223806=ends[10];
                              }
                              if(biggest223806 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread223807(tdone,ends);
                            thread223808(tdone,ends);
                            thread223809(tdone,ends);
                            int biggest223810 = 0;
                            if(ends[6]>=biggest223810){
                              biggest223810=ends[6];
                            }
                            if(ends[7]>=biggest223810){
                              biggest223810=ends[7];
                            }
                            if(ends[8]>=biggest223810){
                              biggest223810=ends[8];
                            }
                            if(biggest223810 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread223811(tdone,ends);
                          thread223812(tdone,ends);
                          int biggest223813 = 0;
                          if(ends[4]>=biggest223813){
                            biggest223813=ends[4];
                          }
                          if(ends[5]>=biggest223813){
                            biggest223813=ends[5];
                          }
                          if(biggest223813 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 93, column: 7
                        currsigs.addElement(cylClampBottleExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                        S138229=2;
                        if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                          S138229=3;
                          if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                            S138229=4;
                            if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                              w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                              System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                              level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                              if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                }
                                S138229=5;
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                    S138220=2;
                                    S141839=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141839=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S141834=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141834=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S152406=2;
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
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                }
                                S138229=5;
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                    S138220=2;
                                    S141839=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141839=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S141834=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141834=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S152406=2;
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
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                            thread223814(tdone,ends);
                            thread223815(tdone,ends);
                            int biggest223816 = 0;
                            if(ends[9]>=biggest223816){
                              biggest223816=ends[9];
                            }
                            if(ends[10]>=biggest223816){
                              biggest223816=ends[10];
                            }
                            if(biggest223816 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread223817(tdone,ends);
                          thread223818(tdone,ends);
                          thread223819(tdone,ends);
                          int biggest223820 = 0;
                          if(ends[6]>=biggest223820){
                            biggest223820=ends[6];
                          }
                          if(ends[7]>=biggest223820){
                            biggest223820=ends[7];
                          }
                          if(ends[8]>=biggest223820){
                            biggest223820=ends[8];
                          }
                          if(biggest223820 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread223821(tdone,ends);
                        thread223822(tdone,ends);
                        int biggest223823 = 0;
                        if(ends[4]>=biggest223823){
                          biggest223823=ends[4];
                        }
                        if(ends[5]>=biggest223823){
                          biggest223823=ends[5];
                        }
                        if(biggest223823 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest223823 == 0){
                          S138229=2;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                            S138229=3;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                              S138229=4;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                  }
                                  S138229=5;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                      S138220=2;
                                      S141839=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141839=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S141834=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141834=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S152406=2;
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
                                    S138220=2;
                                    S141839=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141839=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S141834=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141834=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S152406=2;
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
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                  }
                                  S138229=5;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                      S138220=2;
                                      S141839=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141839=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S141834=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141834=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S152406=2;
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
                                    S138220=2;
                                    S141839=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141839=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S141834=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141834=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S152406=2;
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
                              thread223824(tdone,ends);
                              thread223825(tdone,ends);
                              int biggest223826 = 0;
                              if(ends[9]>=biggest223826){
                                biggest223826=ends[9];
                              }
                              if(ends[10]>=biggest223826){
                                biggest223826=ends[10];
                              }
                              if(biggest223826 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread223827(tdone,ends);
                            thread223828(tdone,ends);
                            thread223829(tdone,ends);
                            int biggest223830 = 0;
                            if(ends[6]>=biggest223830){
                              biggest223830=ends[6];
                            }
                            if(ends[7]>=biggest223830){
                              biggest223830=ends[7];
                            }
                            if(ends[8]>=biggest223830){
                              biggest223830=ends[8];
                            }
                            if(biggest223830 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      break;
                    
                    case 2 : 
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                        S138229=3;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                          S138229=4;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                              }
                              S138229=5;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                              }
                              S138229=5;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                          thread223831(tdone,ends);
                          thread223832(tdone,ends);
                          int biggest223833 = 0;
                          if(ends[9]>=biggest223833){
                            biggest223833=ends[9];
                          }
                          if(ends[10]>=biggest223833){
                            biggest223833=ends[10];
                          }
                          if(biggest223833 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread223834(tdone,ends);
                        thread223835(tdone,ends);
                        thread223836(tdone,ends);
                        int biggest223837 = 0;
                        if(ends[6]>=biggest223837){
                          biggest223837=ends[6];
                        }
                        if(ends[7]>=biggest223837){
                          biggest223837=ends[7];
                        }
                        if(ends[8]>=biggest223837){
                          biggest223837=ends[8];
                        }
                        if(biggest223837 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest223837 == 0){
                          S138229=3;
                          if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                            S138229=4;
                            if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                              w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                              System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                              level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                              if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                }
                                S138229=5;
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                    S138220=2;
                                    S141839=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141839=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S141834=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141834=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S152406=2;
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
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                }
                                S138229=5;
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                    S138220=2;
                                    S141839=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141839=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S141834=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141834=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S152406=2;
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
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                            thread223838(tdone,ends);
                            thread223839(tdone,ends);
                            int biggest223840 = 0;
                            if(ends[9]>=biggest223840){
                              biggest223840=ends[9];
                            }
                            if(ends[10]>=biggest223840){
                              biggest223840=ends[10];
                            }
                            if(biggest223840 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      break;
                    
                    case 3 : 
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                        S138229=4;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                            }
                            S138229=5;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                              S138220=2;
                              S141839=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141839=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S141834=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141834=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S152406=2;
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
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                            }
                            S138229=5;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                              S138220=2;
                              S141839=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141839=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S141834=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141834=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S152406=2;
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
                        thread223841(tdone,ends);
                        thread223842(tdone,ends);
                        int biggest223843 = 0;
                        if(ends[9]>=biggest223843){
                          biggest223843=ends[9];
                        }
                        if(ends[10]>=biggest223843){
                          biggest223843=ends[10];
                        }
                        if(biggest223843 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest223843 == 0){
                          S138229=4;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                              }
                              S138229=5;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                              }
                              S138229=5;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                  S138220=2;
                                  S141839=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141839=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S141834=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S141834=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S152406=2;
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
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                    
                    case 4 : 
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                          }
                          S138229=5;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 134, column: 22
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                              S138220=2;
                              S141839=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141839=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S141834=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141834=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S152406=2;
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
                            S138220=2;
                            S141839=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                              S141839=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S141834=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141834=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S152406=2;
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
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                          }
                          S138229=5;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 134, column: 22
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                              S138220=2;
                              S141839=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141839=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S141834=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141834=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S152406=2;
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
                            S138220=2;
                            S141839=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                              S141839=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S141834=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141834=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S152406=2;
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
                    
                    case 5 : 
                      if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 34
                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 136, column: 51
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\liquidDumperController.sysj line: 134, column: 22
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                          S138220=2;
                          S141839=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                            S141839=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S141834=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                              S141834=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                S152406=2;
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
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\liquidDumperController.sysj line: 134, column: 22
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                          S138220=2;
                          S141839=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                            S141839=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S141834=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                              S141834=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                S152406=2;
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
                    
                  }
                  break;
                
                case 2 : 
                  switch(S141839){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                        S141839=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S141834){
                          case 0 : 
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                              S141834=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                S152406=2;
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
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 142, column: 5
                              S152406=2;
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
                      S141839=1;
                      S141839=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                        S141839=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S141834=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                          S141834=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                            S152406=2;
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
                
                case 3 : 
                  S152406=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S152406=2;
            S152406=0;
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
              S152406=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S152406=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S138220=0;
                S138204=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                  S138204=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S138199=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                    S138199=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 77, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 86, column: 5
                      S138220=1;
                      if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 88, column: 8
                        System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 89, column: 6
                        S138229=0;
                        if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 92, column: 22
                          S138229=1;
                          if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                            S138229=2;
                            if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                              S138229=3;
                              if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                                S138229=4;
                                if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                                  w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                                  System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                                  level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                    }
                                    S138229=5;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                        S138220=2;
                                        S141839=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141839=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S141834=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S141834=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                              S152406=2;
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
                                      S138220=2;
                                      S141839=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141839=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S141834=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141834=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S152406=2;
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
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                                    }
                                    S138229=5;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                        S138220=2;
                                        S141839=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141839=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S141834=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S141834=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                              S152406=2;
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
                                      S138220=2;
                                      S141839=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                        S141839=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S141834=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                          S141834=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                            S152406=2;
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
                                thread223844(tdone,ends);
                                thread223845(tdone,ends);
                                int biggest223846 = 0;
                                if(ends[9]>=biggest223846){
                                  biggest223846=ends[9];
                                }
                                if(ends[10]>=biggest223846){
                                  biggest223846=ends[10];
                                }
                                if(biggest223846 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              thread223847(tdone,ends);
                              thread223848(tdone,ends);
                              thread223849(tdone,ends);
                              int biggest223850 = 0;
                              if(ends[6]>=biggest223850){
                                biggest223850=ends[6];
                              }
                              if(ends[7]>=biggest223850){
                                biggest223850=ends[7];
                              }
                              if(ends[8]>=biggest223850){
                                biggest223850=ends[8];
                              }
                              if(biggest223850 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread223851(tdone,ends);
                            thread223852(tdone,ends);
                            int biggest223853 = 0;
                            if(ends[4]>=biggest223853){
                              biggest223853=ends[4];
                            }
                            if(ends[5]>=biggest223853){
                              biggest223853=ends[5];
                            }
                            if(biggest223853 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 93, column: 7
                          currsigs.addElement(cylClampBottleExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S138220=2;
                        S141839=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                          S141839=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S141834=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                            S141834=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 142, column: 5
                              S152406=2;
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

  public void thread223762(int [] tdone, int [] ends){
        switch(S138195){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\liquidDumperController.sysj line: 53, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\liquidDumperController.sysj line: 54, column: 8
            auto_1.setPresent();//sysj\liquidDumperController.sysj line: 54, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\liquidDumperController.sysj line: 55, column: 12
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

  public void thread223760(int [] tdone, int [] ends){
        S223744=1;
    S223552=0;
    if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 150, column: 20
      S223552=1;
      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 151, column: 20
        S223552=2;
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
      }
      else {
        if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 153, column: 14
          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 153, column: 38
          currsigs.addElement(cylClampBottleExtend);
          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 154, column: 14
            invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 154, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 154, column: 14
            invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 154, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 155, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 155, column: 33
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

  public void thread223758(int [] tdone, int [] ends){
        S138239=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223757(int [] tdone, int [] ends){
        S138234=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223755(int [] tdone, int [] ends){
        S138277=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223754(int [] tdone, int [] ends){
        S138272=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223753(int [] tdone, int [] ends){
        S138267=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223751(int [] tdone, int [] ends){
        S138352=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223750(int [] tdone, int [] ends){
        S138347=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 109, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223749(int [] tdone, int [] ends){
        S223457=1;
    OK_thread_3 = 0;//sysj\liquidDumperController.sysj line: 62, column: 3
    BLOCKED_thread_3 = 2;//sysj\liquidDumperController.sysj line: 63, column: 3
    WARN_thread_3 = 3;//sysj\liquidDumperController.sysj line: 64, column: 3
    TANK_CAPACITY_thread_3 = RecyclingCapacity.WASTE_TANK;//sysj\liquidDumperController.sysj line: 66, column: 3
    TANK_WARN_thread_3 = RecyclingCapacity.WASTE_TANK_WARN;//sysj\liquidDumperController.sysj line: 67, column: 3
    w_thread_3 = null;//sysj\liquidDumperController.sysj line: 69, column: 3
    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 70, column: 3
    code_thread_3 = 0;//sysj\liquidDumperController.sysj line: 71, column: 3
    S152406=0;
    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
      S152406=1;
      if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S152406=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S138220=0;
        S138204=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
          enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
          S138204=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S138199=0;
          if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
            enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
            S138199=1;
            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
              ends[3]=2;
              ;//sysj\liquidDumperController.sysj line: 77, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 86, column: 5
              S138220=1;
              if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 88, column: 8
                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 89, column: 6
                S138229=0;
                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 92, column: 22
                  S138229=1;
                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                    S138229=2;
                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 22
                      S138229=3;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 108, column: 22
                        S138229=4;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 113, column: 22
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 115, column: 6
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 116, column: 6
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 119, column: 6
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 120, column: 14
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 121, column: 7
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                            }
                            S138229=5;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                              S138220=2;
                              S141839=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141839=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S141834=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141834=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S152406=2;
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
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 124, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 125, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 126, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 127, column: 7
                            }
                            S138229=5;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 129, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 130, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 131, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 134, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 134, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 138, column: 22
                                S138220=2;
                                S141839=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141839=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S141834=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S141834=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                      S152406=2;
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
                              S138220=2;
                              S141839=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                S141839=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S141834=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                                  S141834=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 5
                                    S152406=2;
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
                        thread223750(tdone,ends);
                        thread223751(tdone,ends);
                        int biggest223752 = 0;
                        if(ends[9]>=biggest223752){
                          biggest223752=ends[9];
                        }
                        if(ends[10]>=biggest223752){
                          biggest223752=ends[10];
                        }
                        if(biggest223752 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread223753(tdone,ends);
                      thread223754(tdone,ends);
                      thread223755(tdone,ends);
                      int biggest223756 = 0;
                      if(ends[6]>=biggest223756){
                        biggest223756=ends[6];
                      }
                      if(ends[7]>=biggest223756){
                        biggest223756=ends[7];
                      }
                      if(ends[8]>=biggest223756){
                        biggest223756=ends[8];
                      }
                      if(biggest223756 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread223757(tdone,ends);
                    thread223758(tdone,ends);
                    int biggest223759 = 0;
                    if(ends[4]>=biggest223759){
                      biggest223759=ends[4];
                    }
                    if(ends[5]>=biggest223759){
                      biggest223759=ends[5];
                    }
                    if(biggest223759 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 93, column: 7
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                S138220=2;
                S141839=0;
                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 142, column: 5
                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                  S141839=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S141834=0;
                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 142, column: 5
                    S141834=1;
                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 142, column: 5
                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 142, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 142, column: 5
                      S152406=2;
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

  public void thread223748(int [] tdone, int [] ends){
        S138195=1;
    if(mode.getprestatus()){//sysj\liquidDumperController.sysj line: 53, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\liquidDumperController.sysj line: 54, column: 8
        auto_1.setPresent();//sysj\liquidDumperController.sysj line: 54, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\liquidDumperController.sysj line: 55, column: 12
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
      switch(S223746){
        case 0 : 
          S223746=0;
          break RUN;
        
        case 1 : 
          S223746=2;
          S223746=2;
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          thread223748(tdone,ends);
          thread223749(tdone,ends);
          thread223760(tdone,ends);
          int biggest223761 = 0;
          if(ends[2]>=biggest223761){
            biggest223761=ends[2];
          }
          if(ends[3]>=biggest223761){
            biggest223761=ends[3];
          }
          if(ends[11]>=biggest223761){
            biggest223761=ends[11];
          }
          if(biggest223761 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          thread223762(tdone,ends);
          thread223763(tdone,ends);
          thread223854(tdone,ends);
          int biggest223855 = 0;
          if(ends[2]>=biggest223855){
            biggest223855=ends[2];
          }
          if(ends[3]>=biggest223855){
            biggest223855=ends[3];
          }
          if(ends[11]>=biggest223855){
            biggest223855=ends[11];
          }
          if(biggest223855 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest223855 == 0){
            S223746=0;
            active[1]=0;
            ends[1]=0;
            S223746=0;
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
