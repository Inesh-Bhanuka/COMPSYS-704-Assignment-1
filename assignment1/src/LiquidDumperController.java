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
  private Workpiece w_thread_3;//sysj\liquidDumperController.sysj line: 69, column: 3
  private int level_thread_3;//sysj\liquidDumperController.sysj line: 70, column: 3
  private int code_thread_3;//sysj\liquidDumperController.sysj line: 71, column: 3
  private int S79229 = 1;
  private int S63896 = 1;
  private int S78940 = 1;
  private int S66404 = 1;
  private int S63921 = 1;
  private int S63905 = 1;
  private int S63900 = 1;
  private int S63942 = 1;
  private int S63947 = 1;
  private int S63997 = 1;
  private int S64002 = 1;
  private int S64007 = 1;
  private int S64109 = 1;
  private int S64114 = 1;
  private int S64233 = 1;
  private int S64228 = 1;
  private int S79227 = 1;
  private int S79035 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread79337(int [] tdone, int [] ends){
        switch(S79227){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S79035){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 132, column: 20
              S79035=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 133, column: 20
                S79035=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 135, column: 14
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 135, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 136, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 136, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 133, column: 20
              S79035=2;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 135, column: 14
                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 135, column: 38
                currsigs.addElement(cylClampBottleExtend);
                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 14
                  invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 136, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 14
                  invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 136, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
            S79035=2;
            S79035=0;
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 132, column: 20
              S79035=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 133, column: 20
                S79035=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 135, column: 14
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 135, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 136, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                  if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 14
                    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 136, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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

  public void thread79335(int [] tdone, int [] ends){
        S63947=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread79334(int [] tdone, int [] ends){
        S63942=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread79332(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79331(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79330(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79328(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79327(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79325(int [] tdone, int [] ends){
        switch(S64114){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
        currsigs.addElement(invertRotateRetract);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread79324(int [] tdone, int [] ends){
        switch(S64109){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread79322(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79321(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79319(int [] tdone, int [] ends){
        switch(S64007){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
        currsigs.addElement(drainValveOnOff);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread79318(int [] tdone, int [] ends){
        switch(S64002){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
        currsigs.addElement(invertRotateExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread79317(int [] tdone, int [] ends){
        switch(S63997){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread79315(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79314(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79312(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79311(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79310(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79308(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79307(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79305(int [] tdone, int [] ends){
        switch(S63947){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
        currsigs.addElement(invertRotateExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread79304(int [] tdone, int [] ends){
        switch(S63942){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread79302(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79301(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79300(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79298(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79297(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79295(int [] tdone, int [] ends){
        S63947=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread79294(int [] tdone, int [] ends){
        S63942=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread79292(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79291(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79290(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79288(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79287(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79285(int [] tdone, int [] ends){
        S63947=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread79284(int [] tdone, int [] ends){
        S63942=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread79282(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79281(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79280(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79278(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79277(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79275(int [] tdone, int [] ends){
        S63947=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread79274(int [] tdone, int [] ends){
        S63942=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread79272(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79271(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79270(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79268(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79267(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79265(int [] tdone, int [] ends){
        S63947=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread79264(int [] tdone, int [] ends){
        S63942=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread79262(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79261(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79260(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79258(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79257(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79255(int [] tdone, int [] ends){
        S63947=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread79254(int [] tdone, int [] ends){
        S63942=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread79252(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79251(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79250(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79248(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79247(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79246(int [] tdone, int [] ends){
        switch(S78940){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S66404){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
              S66404=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S66404=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S63921=0;
                S63905=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                  S63905=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S63900=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                    S63900=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 77, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                      S63921=1;
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                        S63921=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                          S63921=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                            S63921=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                              S63921=5;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                  }
                                  S63921=6;
                                  S64233=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S64233=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S64228=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                      S64228=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                        S66404=2;
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
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                  }
                                  S63921=6;
                                  S64233=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S64233=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S64228=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                      S64228=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                        S66404=2;
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
                              thread79247(tdone,ends);
                              thread79248(tdone,ends);
                              int biggest79249 = 0;
                              if(ends[9]>=biggest79249){
                                biggest79249=ends[9];
                              }
                              if(ends[10]>=biggest79249){
                                biggest79249=ends[10];
                              }
                              if(biggest79249 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread79250(tdone,ends);
                            thread79251(tdone,ends);
                            thread79252(tdone,ends);
                            int biggest79253 = 0;
                            if(ends[6]>=biggest79253){
                              biggest79253=ends[6];
                            }
                            if(ends[7]>=biggest79253){
                              biggest79253=ends[7];
                            }
                            if(ends[8]>=biggest79253){
                              biggest79253=ends[8];
                            }
                            if(biggest79253 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread79254(tdone,ends);
                          thread79255(tdone,ends);
                          int biggest79256 = 0;
                          if(ends[4]>=biggest79256){
                            biggest79256=ends[4];
                          }
                          if(ends[5]>=biggest79256){
                            biggest79256=ends[5];
                          }
                          if(biggest79256 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 83, column: 6
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
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S66404=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S63921){
                case 0 : 
                  switch(S63905){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                        S63905=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S63900){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                              enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                              S63900=1;
                              if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 77, column: 5
                                w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                                S63921=1;
                                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                                  S63921=2;
                                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                                    S63921=3;
                                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                                      S63921=4;
                                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                                        S63921=5;
                                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                            }
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                            }
                                            S63921=6;
                                            S64233=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S64233=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S64228=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                                S64228=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  S66404=2;
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
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                            }
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                            }
                                            S63921=6;
                                            S64233=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S64233=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S64228=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                                S64228=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  S66404=2;
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
                                        thread79257(tdone,ends);
                                        thread79258(tdone,ends);
                                        int biggest79259 = 0;
                                        if(ends[9]>=biggest79259){
                                          biggest79259=ends[9];
                                        }
                                        if(ends[10]>=biggest79259){
                                          biggest79259=ends[10];
                                        }
                                        if(biggest79259 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      thread79260(tdone,ends);
                                      thread79261(tdone,ends);
                                      thread79262(tdone,ends);
                                      int biggest79263 = 0;
                                      if(ends[6]>=biggest79263){
                                        biggest79263=ends[6];
                                      }
                                      if(ends[7]>=biggest79263){
                                        biggest79263=ends[7];
                                      }
                                      if(ends[8]>=biggest79263){
                                        biggest79263=ends[8];
                                      }
                                      if(biggest79263 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread79264(tdone,ends);
                                    thread79265(tdone,ends);
                                    int biggest79266 = 0;
                                    if(ends[4]>=biggest79266){
                                      biggest79266=ends[4];
                                    }
                                    if(ends[5]>=biggest79266){
                                      biggest79266=ends[5];
                                    }
                                    if(biggest79266 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 83, column: 6
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
                            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 77, column: 5
                              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                              S63921=1;
                              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                                S63921=2;
                                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                                  S63921=3;
                                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                                    S63921=4;
                                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                                      S63921=5;
                                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                          }
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                          }
                                          S63921=6;
                                          S64233=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                            S64233=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S64228=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S64228=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                                S66404=2;
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
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                          }
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                          }
                                          S63921=6;
                                          S64233=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                            S64233=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S64228=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S64228=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                                S66404=2;
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
                                      thread79267(tdone,ends);
                                      thread79268(tdone,ends);
                                      int biggest79269 = 0;
                                      if(ends[9]>=biggest79269){
                                        biggest79269=ends[9];
                                      }
                                      if(ends[10]>=biggest79269){
                                        biggest79269=ends[10];
                                      }
                                      if(biggest79269 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread79270(tdone,ends);
                                    thread79271(tdone,ends);
                                    thread79272(tdone,ends);
                                    int biggest79273 = 0;
                                    if(ends[6]>=biggest79273){
                                      biggest79273=ends[6];
                                    }
                                    if(ends[7]>=biggest79273){
                                      biggest79273=ends[7];
                                    }
                                    if(ends[8]>=biggest79273){
                                      biggest79273=ends[8];
                                    }
                                    if(biggest79273 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread79274(tdone,ends);
                                  thread79275(tdone,ends);
                                  int biggest79276 = 0;
                                  if(ends[4]>=biggest79276){
                                    biggest79276=ends[4];
                                  }
                                  if(ends[5]>=biggest79276){
                                    biggest79276=ends[5];
                                  }
                                  if(biggest79276 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 83, column: 6
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
                      S63905=1;
                      S63905=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                        S63905=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S63900=0;
                        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                          S63900=1;
                          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 77, column: 5
                            w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                            System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                            S63921=1;
                            if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                              S63921=2;
                              if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                                S63921=3;
                                if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                                  S63921=4;
                                  if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                                    S63921=5;
                                    if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                                      w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                                      System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                                      level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                                      if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                        }
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                        }
                                        S63921=6;
                                        S64233=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                          S64233=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S64228=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                            S64228=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S66404=2;
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
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                        }
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                        }
                                        S63921=6;
                                        S64233=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                          S64233=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S64228=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                            S64228=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S66404=2;
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
                                    thread79277(tdone,ends);
                                    thread79278(tdone,ends);
                                    int biggest79279 = 0;
                                    if(ends[9]>=biggest79279){
                                      biggest79279=ends[9];
                                    }
                                    if(ends[10]>=biggest79279){
                                      biggest79279=ends[10];
                                    }
                                    if(biggest79279 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread79280(tdone,ends);
                                  thread79281(tdone,ends);
                                  thread79282(tdone,ends);
                                  int biggest79283 = 0;
                                  if(ends[6]>=biggest79283){
                                    biggest79283=ends[6];
                                  }
                                  if(ends[7]>=biggest79283){
                                    biggest79283=ends[7];
                                  }
                                  if(ends[8]>=biggest79283){
                                    biggest79283=ends[8];
                                  }
                                  if(biggest79283 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread79284(tdone,ends);
                                thread79285(tdone,ends);
                                int biggest79286 = 0;
                                if(ends[4]>=biggest79286){
                                  biggest79286=ends[4];
                                }
                                if(ends[5]>=biggest79286){
                                  biggest79286=ends[5];
                                }
                                if(biggest79286 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 83, column: 6
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
                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                    S63921=2;
                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                      S63921=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                        S63921=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                          S63921=5;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                              }
                              S63921=6;
                              S64233=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                S64233=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S64228=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S64228=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S66404=2;
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
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                              }
                              S63921=6;
                              S64233=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                S64233=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S64228=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S64228=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S66404=2;
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
                          thread79287(tdone,ends);
                          thread79288(tdone,ends);
                          int biggest79289 = 0;
                          if(ends[9]>=biggest79289){
                            biggest79289=ends[9];
                          }
                          if(ends[10]>=biggest79289){
                            biggest79289=ends[10];
                          }
                          if(biggest79289 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread79290(tdone,ends);
                        thread79291(tdone,ends);
                        thread79292(tdone,ends);
                        int biggest79293 = 0;
                        if(ends[6]>=biggest79293){
                          biggest79293=ends[6];
                        }
                        if(ends[7]>=biggest79293){
                          biggest79293=ends[7];
                        }
                        if(ends[8]>=biggest79293){
                          biggest79293=ends[8];
                        }
                        if(biggest79293 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread79294(tdone,ends);
                      thread79295(tdone,ends);
                      int biggest79296 = 0;
                      if(ends[4]>=biggest79296){
                        biggest79296=ends[4];
                      }
                      if(ends[5]>=biggest79296){
                        biggest79296=ends[5];
                      }
                      if(biggest79296 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 83, column: 6
                    currsigs.addElement(cylClampBottleExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                    S63921=3;
                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                      S63921=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                        S63921=5;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                            }
                            S63921=6;
                            S64233=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64233=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S64228=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                S64228=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S66404=2;
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
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                            }
                            S63921=6;
                            S64233=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64233=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S64228=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                S64228=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S66404=2;
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
                        thread79297(tdone,ends);
                        thread79298(tdone,ends);
                        int biggest79299 = 0;
                        if(ends[9]>=biggest79299){
                          biggest79299=ends[9];
                        }
                        if(ends[10]>=biggest79299){
                          biggest79299=ends[10];
                        }
                        if(biggest79299 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread79300(tdone,ends);
                      thread79301(tdone,ends);
                      thread79302(tdone,ends);
                      int biggest79303 = 0;
                      if(ends[6]>=biggest79303){
                        biggest79303=ends[6];
                      }
                      if(ends[7]>=biggest79303){
                        biggest79303=ends[7];
                      }
                      if(ends[8]>=biggest79303){
                        biggest79303=ends[8];
                      }
                      if(biggest79303 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread79304(tdone,ends);
                    thread79305(tdone,ends);
                    int biggest79306 = 0;
                    if(ends[4]>=biggest79306){
                      biggest79306=ends[4];
                    }
                    if(ends[5]>=biggest79306){
                      biggest79306=ends[5];
                    }
                    if(biggest79306 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest79306 == 0){
                      S63921=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                        S63921=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                          S63921=5;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                              }
                              S63921=6;
                              S64233=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                S64233=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S64228=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S64228=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S66404=2;
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
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                              }
                              S63921=6;
                              S64233=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                S64233=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S64228=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S64228=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S66404=2;
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
                          thread79307(tdone,ends);
                          thread79308(tdone,ends);
                          int biggest79309 = 0;
                          if(ends[9]>=biggest79309){
                            biggest79309=ends[9];
                          }
                          if(ends[10]>=biggest79309){
                            biggest79309=ends[10];
                          }
                          if(biggest79309 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread79310(tdone,ends);
                        thread79311(tdone,ends);
                        thread79312(tdone,ends);
                        int biggest79313 = 0;
                        if(ends[6]>=biggest79313){
                          biggest79313=ends[6];
                        }
                        if(ends[7]>=biggest79313){
                          biggest79313=ends[7];
                        }
                        if(ends[8]>=biggest79313){
                          biggest79313=ends[8];
                        }
                        if(biggest79313 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 3 : 
                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                    S63921=4;
                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                      S63921=5;
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                          }
                          S63921=6;
                          S64233=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S64233=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S64228=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64228=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S66404=2;
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
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                          }
                          S63921=6;
                          S64233=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S64233=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S64228=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64228=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S66404=2;
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
                      thread79314(tdone,ends);
                      thread79315(tdone,ends);
                      int biggest79316 = 0;
                      if(ends[9]>=biggest79316){
                        biggest79316=ends[9];
                      }
                      if(ends[10]>=biggest79316){
                        biggest79316=ends[10];
                      }
                      if(biggest79316 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread79317(tdone,ends);
                    thread79318(tdone,ends);
                    thread79319(tdone,ends);
                    int biggest79320 = 0;
                    if(ends[6]>=biggest79320){
                      biggest79320=ends[6];
                    }
                    if(ends[7]>=biggest79320){
                      biggest79320=ends[7];
                    }
                    if(ends[8]>=biggest79320){
                      biggest79320=ends[8];
                    }
                    if(biggest79320 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest79320 == 0){
                      S63921=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                        S63921=5;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                            }
                            S63921=6;
                            S64233=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64233=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S64228=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                S64228=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S66404=2;
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
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                            }
                            S63921=6;
                            S64233=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64233=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S64228=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                S64228=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S66404=2;
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
                        thread79321(tdone,ends);
                        thread79322(tdone,ends);
                        int biggest79323 = 0;
                        if(ends[9]>=biggest79323){
                          biggest79323=ends[9];
                        }
                        if(ends[10]>=biggest79323){
                          biggest79323=ends[10];
                        }
                        if(biggest79323 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 4 : 
                  if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                    S63921=5;
                    if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                      w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                      System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                      level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                      if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                        }
                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                        }
                        S63921=6;
                        S64233=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                          S64233=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S64228=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                            S64228=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                              S66404=2;
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
                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                          code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                        }
                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                        }
                        S63921=6;
                        S64233=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                          S64233=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S64228=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                            S64228=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                              S66404=2;
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
                    thread79324(tdone,ends);
                    thread79325(tdone,ends);
                    int biggest79326 = 0;
                    if(ends[9]>=biggest79326){
                      biggest79326=ends[9];
                    }
                    if(ends[10]>=biggest79326){
                      biggest79326=ends[10];
                    }
                    if(biggest79326 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest79326 == 0){
                      S63921=5;
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                          }
                          S63921=6;
                          S64233=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S64233=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S64228=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64228=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S66404=2;
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
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                          }
                          S63921=6;
                          S64233=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S64233=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S64228=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64228=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S66404=2;
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
                  if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                    w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                    if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                      }
                      if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                      }
                      S63921=6;
                      S64233=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                        S64233=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S64228=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                          S64228=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 124, column: 5
                            S66404=2;
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
                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                      }
                      if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                      }
                      S63921=6;
                      S64233=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                        S64233=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S64228=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                          S64228=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 124, column: 5
                            S66404=2;
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
                  switch(S64233){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                        S64233=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S64228){
                          case 0 : 
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64228=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S66404=2;
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
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                              S66404=2;
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
                      S64233=1;
                      S64233=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                        S64233=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S64228=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                          S64228=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 124, column: 5
                            S66404=2;
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
                  S66404=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S66404=2;
            S66404=0;
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
              S66404=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S66404=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S63921=0;
                S63905=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                  S63905=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S63900=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                    S63900=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 77, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                      S63921=1;
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                        S63921=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                          S63921=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                            S63921=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                              S63921=5;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                  }
                                  S63921=6;
                                  S64233=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S64233=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S64228=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                      S64228=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                        S66404=2;
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
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                                  }
                                  S63921=6;
                                  S64233=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S64233=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S64228=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                      S64228=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                        S66404=2;
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
                              thread79327(tdone,ends);
                              thread79328(tdone,ends);
                              int biggest79329 = 0;
                              if(ends[9]>=biggest79329){
                                biggest79329=ends[9];
                              }
                              if(ends[10]>=biggest79329){
                                biggest79329=ends[10];
                              }
                              if(biggest79329 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread79330(tdone,ends);
                            thread79331(tdone,ends);
                            thread79332(tdone,ends);
                            int biggest79333 = 0;
                            if(ends[6]>=biggest79333){
                              biggest79333=ends[6];
                            }
                            if(ends[7]>=biggest79333){
                              biggest79333=ends[7];
                            }
                            if(ends[8]>=biggest79333){
                              biggest79333=ends[8];
                            }
                            if(biggest79333 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread79334(tdone,ends);
                          thread79335(tdone,ends);
                          int biggest79336 = 0;
                          if(ends[4]>=biggest79336){
                            biggest79336=ends[4];
                          }
                          if(ends[5]>=biggest79336){
                            biggest79336=ends[5];
                          }
                          if(biggest79336 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 83, column: 6
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

  public void thread79245(int [] tdone, int [] ends){
        switch(S63896){
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

  public void thread79243(int [] tdone, int [] ends){
        S79227=1;
    S79035=0;
    if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 132, column: 20
      S79035=1;
      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 133, column: 20
        S79035=2;
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
      }
      else {
        if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 135, column: 14
          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 135, column: 38
          currsigs.addElement(cylClampBottleExtend);
          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 14
            invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 136, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 136, column: 14
            invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 136, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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
            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 137, column: 14
              drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 137, column: 33
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

  public void thread79241(int [] tdone, int [] ends){
        S63947=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread79240(int [] tdone, int [] ends){
        S63942=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread79238(int [] tdone, int [] ends){
        S64007=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread79237(int [] tdone, int [] ends){
        S64002=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread79236(int [] tdone, int [] ends){
        S63997=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread79234(int [] tdone, int [] ends){
        S64114=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread79233(int [] tdone, int [] ends){
        S64109=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread79232(int [] tdone, int [] ends){
        S78940=1;
    OK_thread_3 = 0;//sysj\liquidDumperController.sysj line: 62, column: 3
    BLOCKED_thread_3 = 2;//sysj\liquidDumperController.sysj line: 63, column: 3
    WARN_thread_3 = 3;//sysj\liquidDumperController.sysj line: 64, column: 3
    TANK_CAPACITY_thread_3 = 6;//sysj\liquidDumperController.sysj line: 66, column: 3
    TANK_WARN_thread_3 = 4;//sysj\liquidDumperController.sysj line: 67, column: 3
    w_thread_3 = null;//sysj\liquidDumperController.sysj line: 69, column: 3
    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 70, column: 3
    code_thread_3 = 0;//sysj\liquidDumperController.sysj line: 71, column: 3
    S66404=0;
    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
      S66404=1;
      if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S66404=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S63921=0;
        S63905=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
          enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
          S63905=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S63900=0;
          if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
            enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
            S63900=1;
            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
              ends[3]=2;
              ;//sysj\liquidDumperController.sysj line: 77, column: 5
              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
              S63921=1;
              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                S63921=2;
                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                  S63921=3;
                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                    S63921=4;
                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                      S63921=5;
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 21
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 105, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 106, column: 5
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 109, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 111, column: 6
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                          }
                          S63921=6;
                          S64233=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S64233=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S64228=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64228=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S66404=2;
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
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj\liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 121, column: 6
                          }
                          S63921=6;
                          S64233=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S64233=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S64228=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S64228=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S66404=2;
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
                      thread79233(tdone,ends);
                      thread79234(tdone,ends);
                      int biggest79235 = 0;
                      if(ends[9]>=biggest79235){
                        biggest79235=ends[9];
                      }
                      if(ends[10]>=biggest79235){
                        biggest79235=ends[10];
                      }
                      if(biggest79235 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread79236(tdone,ends);
                    thread79237(tdone,ends);
                    thread79238(tdone,ends);
                    int biggest79239 = 0;
                    if(ends[6]>=biggest79239){
                      biggest79239=ends[6];
                    }
                    if(ends[7]>=biggest79239){
                      biggest79239=ends[7];
                    }
                    if(ends[8]>=biggest79239){
                      biggest79239=ends[8];
                    }
                    if(biggest79239 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread79240(tdone,ends);
                  thread79241(tdone,ends);
                  int biggest79242 = 0;
                  if(ends[4]>=biggest79242){
                    biggest79242=ends[4];
                  }
                  if(ends[5]>=biggest79242){
                    biggest79242=ends[5];
                  }
                  if(biggest79242 == 1){
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 83, column: 6
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

  public void thread79231(int [] tdone, int [] ends){
        S63896=1;
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
      switch(S79229){
        case 0 : 
          S79229=0;
          break RUN;
        
        case 1 : 
          S79229=2;
          S79229=2;
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          thread79231(tdone,ends);
          thread79232(tdone,ends);
          thread79243(tdone,ends);
          int biggest79244 = 0;
          if(ends[2]>=biggest79244){
            biggest79244=ends[2];
          }
          if(ends[3]>=biggest79244){
            biggest79244=ends[3];
          }
          if(ends[11]>=biggest79244){
            biggest79244=ends[11];
          }
          if(biggest79244 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          thread79245(tdone,ends);
          thread79246(tdone,ends);
          thread79337(tdone,ends);
          int biggest79338 = 0;
          if(ends[2]>=biggest79338){
            biggest79338=ends[2];
          }
          if(ends[3]>=biggest79338){
            biggest79338=ends[3];
          }
          if(ends[11]>=biggest79338){
            biggest79338=ends[11];
          }
          if(biggest79338 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest79338 == 0){
            S79229=0;
            active[1]=0;
            ends[1]=0;
            S79229=0;
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
