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
  private int OK_thread_3;//sysj/liquidDumperController.sysj line: 62, column: 3
  private int BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 63, column: 3
  private int WARN_thread_3;//sysj/liquidDumperController.sysj line: 64, column: 3
  private int TANK_CAPACITY_thread_3;//sysj/liquidDumperController.sysj line: 66, column: 3
  private int TANK_WARN_thread_3;//sysj/liquidDumperController.sysj line: 67, column: 3
  private Workpiece w_thread_3;//sysj/liquidDumperController.sysj line: 69, column: 3
  private int level_thread_3;//sysj/liquidDumperController.sysj line: 70, column: 3
  private int code_thread_3;//sysj/liquidDumperController.sysj line: 71, column: 3
  private int S117072 = 1;
  private int S101739 = 1;
  private int S116783 = 1;
  private int S104247 = 1;
  private int S101764 = 1;
  private int S101748 = 1;
  private int S101743 = 1;
  private int S101785 = 1;
  private int S101790 = 1;
  private int S101840 = 1;
  private int S101845 = 1;
  private int S101850 = 1;
  private int S101952 = 1;
  private int S101957 = 1;
  private int S102076 = 1;
  private int S102071 = 1;
  private int S117070 = 1;
  private int S116878 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread117180(int [] tdone, int [] ends){
        switch(S117070){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S116878){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/liquidDumperController.sysj line: 132, column: 20
              S116878=1;
              if(auto_1.getprestatus()){//sysj/liquidDumperController.sysj line: 133, column: 20
                S116878=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 135, column: 14
                  cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 135, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 136, column: 14
                    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 136, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                  if(invertRotateExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 136, column: 14
                    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 136, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
            if(auto_1.getprestatus()){//sysj/liquidDumperController.sysj line: 133, column: 20
              S116878=2;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              if(cylClampBottleExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 135, column: 14
                cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 135, column: 38
                currsigs.addElement(cylClampBottleExtend);
                if(invertRotateExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 136, column: 14
                  invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 136, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                  if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                if(invertRotateExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 136, column: 14
                  invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 136, column: 36
                  currsigs.addElement(invertRotateExtend);
                  if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                  if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
            S116878=2;
            S116878=0;
            if(manual_1.getprestatus()){//sysj/liquidDumperController.sysj line: 132, column: 20
              S116878=1;
              if(auto_1.getprestatus()){//sysj/liquidDumperController.sysj line: 133, column: 20
                S116878=2;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 135, column: 14
                  cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 135, column: 38
                  currsigs.addElement(cylClampBottleExtend);
                  if(invertRotateExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 136, column: 14
                    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 136, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                  if(invertRotateExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 136, column: 14
                    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 136, column: 36
                    currsigs.addElement(invertRotateExtend);
                    if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
                    if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
                      drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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

  public void thread117178(int [] tdone, int [] ends){
        S101790=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117177(int [] tdone, int [] ends){
        S101785=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117175(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117174(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117173(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117171(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117170(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117168(int [] tdone, int [] ends){
        switch(S101957){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
        currsigs.addElement(invertRotateRetract);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread117167(int [] tdone, int [] ends){
        switch(S101952){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread117165(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117164(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117162(int [] tdone, int [] ends){
        switch(S101850){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
        currsigs.addElement(drainValveOnOff);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread117161(int [] tdone, int [] ends){
        switch(S101845){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
        currsigs.addElement(invertRotateExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread117160(int [] tdone, int [] ends){
        switch(S101840){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread117158(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117157(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117155(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117154(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117153(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117151(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117150(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117148(int [] tdone, int [] ends){
        switch(S101790){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 45
        currsigs.addElement(invertRotateExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread117147(int [] tdone, int [] ends){
        switch(S101785){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 8
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread117145(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117144(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117143(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117141(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117140(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117138(int [] tdone, int [] ends){
        S101790=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117137(int [] tdone, int [] ends){
        S101785=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117135(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117134(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117133(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117131(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117130(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117128(int [] tdone, int [] ends){
        S101790=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117127(int [] tdone, int [] ends){
        S101785=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117125(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117124(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117123(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117121(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117120(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117118(int [] tdone, int [] ends){
        S101790=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117117(int [] tdone, int [] ends){
        S101785=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117115(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117114(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117113(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117111(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117110(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117108(int [] tdone, int [] ends){
        S101790=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117107(int [] tdone, int [] ends){
        S101785=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117105(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117104(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117103(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117101(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117100(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117098(int [] tdone, int [] ends){
        S101790=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117097(int [] tdone, int [] ends){
        S101785=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117095(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117094(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117093(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117091(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117090(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117089(int [] tdone, int [] ends){
        switch(S116783){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S104247){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/liquidDumperController.sysj line: 74, column: 20
              S104247=1;
              if(manual_1.getprestatus()){//sysj/liquidDumperController.sysj line: 76, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S104247=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S101764=0;
                S101748=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 77, column: 5
                  enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                  S101748=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S101743=0;
                  if(!enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                    enable_in.setACK(true);//sysj/liquidDumperController.sysj line: 77, column: 5
                    S101743=1;
                    if(enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                      enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                      ends[3]=2;
                      ;//sysj/liquidDumperController.sysj line: 77, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/liquidDumperController.sysj line: 78, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj/liquidDumperController.sysj line: 79, column: 5
                      S101764=1;
                      if(clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 82, column: 21
                        S101764=2;
                        if(bottleInverted.getprestatus()){//sysj/liquidDumperController.sysj line: 87, column: 21
                          S101764=3;
                          if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                            S101764=4;
                            if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                              S101764=5;
                              if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                                w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                                level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                                if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                                  code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                  }
                                  S101764=6;
                                  S102076=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                    S102076=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S102071=0;
                                    if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                      S102071=1;
                                      if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                        S104247=2;
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
                                  code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                  }
                                  S101764=6;
                                  S102076=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                    S102076=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S102071=0;
                                    if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                      S102071=1;
                                      if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                        S104247=2;
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
                              thread117090(tdone,ends);
                              thread117091(tdone,ends);
                              int biggest117092 = 0;
                              if(ends[9]>=biggest117092){
                                biggest117092=ends[9];
                              }
                              if(ends[10]>=biggest117092){
                                biggest117092=ends[10];
                              }
                              if(biggest117092 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread117093(tdone,ends);
                            thread117094(tdone,ends);
                            thread117095(tdone,ends);
                            int biggest117096 = 0;
                            if(ends[6]>=biggest117096){
                              biggest117096=ends[6];
                            }
                            if(ends[7]>=biggest117096){
                              biggest117096=ends[7];
                            }
                            if(ends[8]>=biggest117096){
                              biggest117096=ends[8];
                            }
                            if(biggest117096 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread117097(tdone,ends);
                          thread117098(tdone,ends);
                          int biggest117099 = 0;
                          if(ends[4]>=biggest117099){
                            biggest117099=ends[4];
                          }
                          if(ends[5]>=biggest117099){
                            biggest117099=ends[5];
                          }
                          if(biggest117099 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 83, column: 6
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
            if(manual_1.getprestatus()){//sysj/liquidDumperController.sysj line: 76, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S104247=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S101764){
                case 0 : 
                  switch(S101748){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 77, column: 5
                        enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                        S101748=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S101743){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                              enable_in.setACK(true);//sysj/liquidDumperController.sysj line: 77, column: 5
                              S101743=1;
                              if(enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                                enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                                ends[3]=2;
                                ;//sysj/liquidDumperController.sysj line: 77, column: 5
                                w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/liquidDumperController.sysj line: 78, column: 5
                                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj/liquidDumperController.sysj line: 79, column: 5
                                S101764=1;
                                if(clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 82, column: 21
                                  S101764=2;
                                  if(bottleInverted.getprestatus()){//sysj/liquidDumperController.sysj line: 87, column: 21
                                    S101764=3;
                                    if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                                      S101764=4;
                                      if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                                        S101764=5;
                                        if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                                          w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                                          level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                                          if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                                            code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                              code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                            }
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                            }
                                            S101764=6;
                                            S102076=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                              S102076=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S102071=0;
                                              if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                                S102071=1;
                                                if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                                  status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                                  S104247=2;
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
                                            code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                              code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                            }
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                            }
                                            S101764=6;
                                            S102076=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                              S102076=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S102071=0;
                                              if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                                S102071=1;
                                                if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                                  status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                                  S104247=2;
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
                                        thread117100(tdone,ends);
                                        thread117101(tdone,ends);
                                        int biggest117102 = 0;
                                        if(ends[9]>=biggest117102){
                                          biggest117102=ends[9];
                                        }
                                        if(ends[10]>=biggest117102){
                                          biggest117102=ends[10];
                                        }
                                        if(biggest117102 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      thread117103(tdone,ends);
                                      thread117104(tdone,ends);
                                      thread117105(tdone,ends);
                                      int biggest117106 = 0;
                                      if(ends[6]>=biggest117106){
                                        biggest117106=ends[6];
                                      }
                                      if(ends[7]>=biggest117106){
                                        biggest117106=ends[7];
                                      }
                                      if(ends[8]>=biggest117106){
                                        biggest117106=ends[8];
                                      }
                                      if(biggest117106 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread117107(tdone,ends);
                                    thread117108(tdone,ends);
                                    int biggest117109 = 0;
                                    if(ends[4]>=biggest117109){
                                      biggest117109=ends[4];
                                    }
                                    if(ends[5]>=biggest117109){
                                      biggest117109=ends[5];
                                    }
                                    if(biggest117109 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 83, column: 6
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
                            if(enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                              enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                              ends[3]=2;
                              ;//sysj/liquidDumperController.sysj line: 77, column: 5
                              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/liquidDumperController.sysj line: 78, column: 5
                              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj/liquidDumperController.sysj line: 79, column: 5
                              S101764=1;
                              if(clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 82, column: 21
                                S101764=2;
                                if(bottleInverted.getprestatus()){//sysj/liquidDumperController.sysj line: 87, column: 21
                                  S101764=3;
                                  if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                                    S101764=4;
                                    if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                                      S101764=5;
                                      if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                                        w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                                        level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                                        if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                                          code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                            code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                          }
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                          }
                                          S101764=6;
                                          S102076=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                            S102076=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S102071=0;
                                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                              S102071=1;
                                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                                ends[3]=2;
                                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                                S104247=2;
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
                                          code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                            code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                          }
                                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                          }
                                          S101764=6;
                                          S102076=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                            S102076=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S102071=0;
                                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                              S102071=1;
                                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                                ends[3]=2;
                                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                                S104247=2;
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
                                      thread117110(tdone,ends);
                                      thread117111(tdone,ends);
                                      int biggest117112 = 0;
                                      if(ends[9]>=biggest117112){
                                        biggest117112=ends[9];
                                      }
                                      if(ends[10]>=biggest117112){
                                        biggest117112=ends[10];
                                      }
                                      if(biggest117112 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread117113(tdone,ends);
                                    thread117114(tdone,ends);
                                    thread117115(tdone,ends);
                                    int biggest117116 = 0;
                                    if(ends[6]>=biggest117116){
                                      biggest117116=ends[6];
                                    }
                                    if(ends[7]>=biggest117116){
                                      biggest117116=ends[7];
                                    }
                                    if(ends[8]>=biggest117116){
                                      biggest117116=ends[8];
                                    }
                                    if(biggest117116 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread117117(tdone,ends);
                                  thread117118(tdone,ends);
                                  int biggest117119 = 0;
                                  if(ends[4]>=biggest117119){
                                    biggest117119=ends[4];
                                  }
                                  if(ends[5]>=biggest117119){
                                    biggest117119=ends[5];
                                  }
                                  if(biggest117119 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 83, column: 6
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
                      S101748=1;
                      S101748=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 77, column: 5
                        enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                        S101748=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S101743=0;
                        if(!enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                          enable_in.setACK(true);//sysj/liquidDumperController.sysj line: 77, column: 5
                          S101743=1;
                          if(enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                            enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                            ends[3]=2;
                            ;//sysj/liquidDumperController.sysj line: 77, column: 5
                            w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/liquidDumperController.sysj line: 78, column: 5
                            System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj/liquidDumperController.sysj line: 79, column: 5
                            S101764=1;
                            if(clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 82, column: 21
                              S101764=2;
                              if(bottleInverted.getprestatus()){//sysj/liquidDumperController.sysj line: 87, column: 21
                                S101764=3;
                                if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                                  S101764=4;
                                  if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                                    S101764=5;
                                    if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                                      w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                                      System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                                      level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                                      if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                                        code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                          code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                        }
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                        }
                                        S101764=6;
                                        S102076=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                          status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                          S102076=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S102071=0;
                                          if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                            S102071=1;
                                            if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                              ends[3]=2;
                                              ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                              S104247=2;
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
                                        code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                          code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                        }
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                        }
                                        S101764=6;
                                        S102076=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                          status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                          S102076=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S102071=0;
                                          if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                            S102071=1;
                                            if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                              ends[3]=2;
                                              ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                              S104247=2;
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
                                    thread117120(tdone,ends);
                                    thread117121(tdone,ends);
                                    int biggest117122 = 0;
                                    if(ends[9]>=biggest117122){
                                      biggest117122=ends[9];
                                    }
                                    if(ends[10]>=biggest117122){
                                      biggest117122=ends[10];
                                    }
                                    if(biggest117122 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread117123(tdone,ends);
                                  thread117124(tdone,ends);
                                  thread117125(tdone,ends);
                                  int biggest117126 = 0;
                                  if(ends[6]>=biggest117126){
                                    biggest117126=ends[6];
                                  }
                                  if(ends[7]>=biggest117126){
                                    biggest117126=ends[7];
                                  }
                                  if(ends[8]>=biggest117126){
                                    biggest117126=ends[8];
                                  }
                                  if(biggest117126 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread117127(tdone,ends);
                                thread117128(tdone,ends);
                                int biggest117129 = 0;
                                if(ends[4]>=biggest117129){
                                  biggest117129=ends[4];
                                }
                                if(ends[5]>=biggest117129){
                                  biggest117129=ends[5];
                                }
                                if(biggest117129 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 83, column: 6
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
                  if(clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 82, column: 21
                    S101764=2;
                    if(bottleInverted.getprestatus()){//sysj/liquidDumperController.sysj line: 87, column: 21
                      S101764=3;
                      if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                        S101764=4;
                        if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                          S101764=5;
                          if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                            w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                            level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                            if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                              code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                              }
                              S101764=6;
                              S102076=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                S102076=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S102071=0;
                                if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                  S102071=1;
                                  if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                    S104247=2;
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
                              code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                              }
                              S101764=6;
                              S102076=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                S102076=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S102071=0;
                                if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                  S102071=1;
                                  if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                    S104247=2;
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
                          thread117130(tdone,ends);
                          thread117131(tdone,ends);
                          int biggest117132 = 0;
                          if(ends[9]>=biggest117132){
                            biggest117132=ends[9];
                          }
                          if(ends[10]>=biggest117132){
                            biggest117132=ends[10];
                          }
                          if(biggest117132 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread117133(tdone,ends);
                        thread117134(tdone,ends);
                        thread117135(tdone,ends);
                        int biggest117136 = 0;
                        if(ends[6]>=biggest117136){
                          biggest117136=ends[6];
                        }
                        if(ends[7]>=biggest117136){
                          biggest117136=ends[7];
                        }
                        if(ends[8]>=biggest117136){
                          biggest117136=ends[8];
                        }
                        if(biggest117136 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread117137(tdone,ends);
                      thread117138(tdone,ends);
                      int biggest117139 = 0;
                      if(ends[4]>=biggest117139){
                        biggest117139=ends[4];
                      }
                      if(ends[5]>=biggest117139){
                        biggest117139=ends[5];
                      }
                      if(biggest117139 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 83, column: 6
                    currsigs.addElement(cylClampBottleExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(bottleInverted.getprestatus()){//sysj/liquidDumperController.sysj line: 87, column: 21
                    S101764=3;
                    if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                      S101764=4;
                      if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                        S101764=5;
                        if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                          w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                          level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                          if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                            code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                              code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                            }
                            S101764=6;
                            S102076=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102076=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S102071=0;
                              if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                S102071=1;
                                if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                  S104247=2;
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
                            code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                              code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                            }
                            S101764=6;
                            S102076=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102076=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S102071=0;
                              if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                S102071=1;
                                if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                  S104247=2;
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
                        thread117140(tdone,ends);
                        thread117141(tdone,ends);
                        int biggest117142 = 0;
                        if(ends[9]>=biggest117142){
                          biggest117142=ends[9];
                        }
                        if(ends[10]>=biggest117142){
                          biggest117142=ends[10];
                        }
                        if(biggest117142 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread117143(tdone,ends);
                      thread117144(tdone,ends);
                      thread117145(tdone,ends);
                      int biggest117146 = 0;
                      if(ends[6]>=biggest117146){
                        biggest117146=ends[6];
                      }
                      if(ends[7]>=biggest117146){
                        biggest117146=ends[7];
                      }
                      if(ends[8]>=biggest117146){
                        biggest117146=ends[8];
                      }
                      if(biggest117146 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread117147(tdone,ends);
                    thread117148(tdone,ends);
                    int biggest117149 = 0;
                    if(ends[4]>=biggest117149){
                      biggest117149=ends[4];
                    }
                    if(ends[5]>=biggest117149){
                      biggest117149=ends[5];
                    }
                    if(biggest117149 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest117149 == 0){
                      S101764=3;
                      if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                        S101764=4;
                        if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                          S101764=5;
                          if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                            w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                            level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                            if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                              code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                              }
                              S101764=6;
                              S102076=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                S102076=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S102071=0;
                                if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                  S102071=1;
                                  if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                    S104247=2;
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
                              code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                              }
                              if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                              }
                              S101764=6;
                              S102076=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                S102076=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S102071=0;
                                if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                  S102071=1;
                                  if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                    S104247=2;
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
                          thread117150(tdone,ends);
                          thread117151(tdone,ends);
                          int biggest117152 = 0;
                          if(ends[9]>=biggest117152){
                            biggest117152=ends[9];
                          }
                          if(ends[10]>=biggest117152){
                            biggest117152=ends[10];
                          }
                          if(biggest117152 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread117153(tdone,ends);
                        thread117154(tdone,ends);
                        thread117155(tdone,ends);
                        int biggest117156 = 0;
                        if(ends[6]>=biggest117156){
                          biggest117156=ends[6];
                        }
                        if(ends[7]>=biggest117156){
                          biggest117156=ends[7];
                        }
                        if(ends[8]>=biggest117156){
                          biggest117156=ends[8];
                        }
                        if(biggest117156 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 3 : 
                  if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                    S101764=4;
                    if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                      S101764=5;
                      if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                        w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                        level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                          code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                          }
                          S101764=6;
                          S102076=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            S102076=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102071=0;
                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102071=1;
                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                S104247=2;
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
                          code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                          }
                          S101764=6;
                          S102076=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            S102076=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102071=0;
                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102071=1;
                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                S104247=2;
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
                      thread117157(tdone,ends);
                      thread117158(tdone,ends);
                      int biggest117159 = 0;
                      if(ends[9]>=biggest117159){
                        biggest117159=ends[9];
                      }
                      if(ends[10]>=biggest117159){
                        biggest117159=ends[10];
                      }
                      if(biggest117159 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread117160(tdone,ends);
                    thread117161(tdone,ends);
                    thread117162(tdone,ends);
                    int biggest117163 = 0;
                    if(ends[6]>=biggest117163){
                      biggest117163=ends[6];
                    }
                    if(ends[7]>=biggest117163){
                      biggest117163=ends[7];
                    }
                    if(ends[8]>=biggest117163){
                      biggest117163=ends[8];
                    }
                    if(biggest117163 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest117163 == 0){
                      S101764=4;
                      if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                        S101764=5;
                        if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                          w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                          level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                          if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                            code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                              code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                            }
                            S101764=6;
                            S102076=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102076=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S102071=0;
                              if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                S102071=1;
                                if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                  S104247=2;
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
                            code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                              code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                            }
                            if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                            }
                            S101764=6;
                            S102076=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102076=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S102071=0;
                              if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                S102071=1;
                                if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                  S104247=2;
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
                        thread117164(tdone,ends);
                        thread117165(tdone,ends);
                        int biggest117166 = 0;
                        if(ends[9]>=biggest117166){
                          biggest117166=ends[9];
                        }
                        if(ends[10]>=biggest117166){
                          biggest117166=ends[10];
                        }
                        if(biggest117166 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 4 : 
                  if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                    S101764=5;
                    if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                      w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                      System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                      level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                      if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                        code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                          code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                        }
                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                        }
                        S101764=6;
                        S102076=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                          status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                          S102076=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S102071=0;
                          if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                            S102071=1;
                            if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                              ends[3]=2;
                              ;//sysj/liquidDumperController.sysj line: 124, column: 5
                              S104247=2;
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
                        code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                        if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                          System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                          code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                        }
                        if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                          System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                        }
                        S101764=6;
                        S102076=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                          status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                          S102076=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S102071=0;
                          if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                            S102071=1;
                            if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                              ends[3]=2;
                              ;//sysj/liquidDumperController.sysj line: 124, column: 5
                              S104247=2;
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
                    thread117167(tdone,ends);
                    thread117168(tdone,ends);
                    int biggest117169 = 0;
                    if(ends[9]>=biggest117169){
                      biggest117169=ends[9];
                    }
                    if(ends[10]>=biggest117169){
                      biggest117169=ends[10];
                    }
                    if(biggest117169 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest117169 == 0){
                      S101764=5;
                      if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                        w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                        level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                          code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                          }
                          S101764=6;
                          S102076=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            S102076=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102071=0;
                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102071=1;
                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                S104247=2;
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
                          code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                          }
                          S101764=6;
                          S102076=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            S102076=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102071=0;
                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102071=1;
                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                S104247=2;
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
                  if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                    w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                    level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                    if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                      code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                        code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                      }
                      if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                      }
                      S101764=6;
                      S102076=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                        S102076=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S102071=0;
                        if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                          S102071=1;
                          if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj/liquidDumperController.sysj line: 124, column: 5
                            S104247=2;
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
                      code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                        code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                      }
                      if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                      }
                      S101764=6;
                      S102076=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                        S102076=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S102071=0;
                        if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                          S102071=1;
                          if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj/liquidDumperController.sysj line: 124, column: 5
                            S104247=2;
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
                  switch(S102076){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                        S102076=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S102071){
                          case 0 : 
                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102071=1;
                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                S104247=2;
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
                            if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                              ends[3]=2;
                              ;//sysj/liquidDumperController.sysj line: 124, column: 5
                              S104247=2;
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
                      S102076=1;
                      S102076=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                        S102076=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S102071=0;
                        if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                          S102071=1;
                          if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj/liquidDumperController.sysj line: 124, column: 5
                            S104247=2;
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
                  S104247=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S104247=2;
            S104247=0;
            if(auto_1.getprestatus()){//sysj/liquidDumperController.sysj line: 74, column: 20
              S104247=1;
              if(manual_1.getprestatus()){//sysj/liquidDumperController.sysj line: 76, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S104247=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S101764=0;
                S101748=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 77, column: 5
                  enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                  S101748=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S101743=0;
                  if(!enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                    enable_in.setACK(true);//sysj/liquidDumperController.sysj line: 77, column: 5
                    S101743=1;
                    if(enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
                      enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
                      ends[3]=2;
                      ;//sysj/liquidDumperController.sysj line: 77, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/liquidDumperController.sysj line: 78, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj/liquidDumperController.sysj line: 79, column: 5
                      S101764=1;
                      if(clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 82, column: 21
                        S101764=2;
                        if(bottleInverted.getprestatus()){//sysj/liquidDumperController.sysj line: 87, column: 21
                          S101764=3;
                          if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                            S101764=4;
                            if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                              S101764=5;
                              if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                                w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                                level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                                if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                                  code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                  }
                                  S101764=6;
                                  S102076=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                    S102076=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S102071=0;
                                    if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                      S102071=1;
                                      if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                        S104247=2;
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
                                  code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                                    code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                                  }
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                                  }
                                  S101764=6;
                                  S102076=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                    S102076=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S102071=0;
                                    if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                                      S102071=1;
                                      if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                        S104247=2;
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
                              thread117170(tdone,ends);
                              thread117171(tdone,ends);
                              int biggest117172 = 0;
                              if(ends[9]>=biggest117172){
                                biggest117172=ends[9];
                              }
                              if(ends[10]>=biggest117172){
                                biggest117172=ends[10];
                              }
                              if(biggest117172 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread117173(tdone,ends);
                            thread117174(tdone,ends);
                            thread117175(tdone,ends);
                            int biggest117176 = 0;
                            if(ends[6]>=biggest117176){
                              biggest117176=ends[6];
                            }
                            if(ends[7]>=biggest117176){
                              biggest117176=ends[7];
                            }
                            if(ends[8]>=biggest117176){
                              biggest117176=ends[8];
                            }
                            if(biggest117176 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread117177(tdone,ends);
                          thread117178(tdone,ends);
                          int biggest117179 = 0;
                          if(ends[4]>=biggest117179){
                            biggest117179=ends[4];
                          }
                          if(ends[5]>=biggest117179){
                            biggest117179=ends[5];
                          }
                          if(biggest117179 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 83, column: 6
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

  public void thread117088(int [] tdone, int [] ends){
        switch(S101739){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj/liquidDumperController.sysj line: 53, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/liquidDumperController.sysj line: 54, column: 8
            auto_1.setPresent();//sysj/liquidDumperController.sysj line: 54, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj/liquidDumperController.sysj line: 55, column: 12
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

  public void thread117086(int [] tdone, int [] ends){
        S117070=1;
    S116878=0;
    if(manual_1.getprestatus()){//sysj/liquidDumperController.sysj line: 132, column: 20
      S116878=1;
      if(auto_1.getprestatus()){//sysj/liquidDumperController.sysj line: 133, column: 20
        S116878=2;
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
      }
      else {
        if(cylClampBottleExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 135, column: 14
          cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 135, column: 38
          currsigs.addElement(cylClampBottleExtend);
          if(invertRotateExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 136, column: 14
            invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 136, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
              drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
            if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
              drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
          if(invertRotateExtendM.getprestatus()){//sysj/liquidDumperController.sysj line: 136, column: 14
            invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 136, column: 36
            currsigs.addElement(invertRotateExtend);
            if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
              drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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
            if(drainValveOnOffM.getprestatus()){//sysj/liquidDumperController.sysj line: 137, column: 14
              drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 137, column: 33
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

  public void thread117084(int [] tdone, int [] ends){
        S101790=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117083(int [] tdone, int [] ends){
        S101785=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117081(int [] tdone, int [] ends){
        S101850=1;
    drainValveOnOff.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117080(int [] tdone, int [] ends){
        S101845=1;
    invertRotateExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117079(int [] tdone, int [] ends){
        S101840=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117077(int [] tdone, int [] ends){
        S101957=1;
    invertRotateRetract.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117076(int [] tdone, int [] ends){
        S101952=1;
    cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117075(int [] tdone, int [] ends){
        S116783=1;
    OK_thread_3 = 0;//sysj/liquidDumperController.sysj line: 62, column: 3
    BLOCKED_thread_3 = 2;//sysj/liquidDumperController.sysj line: 63, column: 3
    WARN_thread_3 = 3;//sysj/liquidDumperController.sysj line: 64, column: 3
    TANK_CAPACITY_thread_3 = 6;//sysj/liquidDumperController.sysj line: 66, column: 3
    TANK_WARN_thread_3 = 4;//sysj/liquidDumperController.sysj line: 67, column: 3
    w_thread_3 = null;//sysj/liquidDumperController.sysj line: 69, column: 3
    level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 70, column: 3
    code_thread_3 = 0;//sysj/liquidDumperController.sysj line: 71, column: 3
    S104247=0;
    if(auto_1.getprestatus()){//sysj/liquidDumperController.sysj line: 74, column: 20
      S104247=1;
      if(manual_1.getprestatus()){//sysj/liquidDumperController.sysj line: 76, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S104247=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S101764=0;
        S101748=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 77, column: 5
          enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
          S101748=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S101743=0;
          if(!enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
            enable_in.setACK(true);//sysj/liquidDumperController.sysj line: 77, column: 5
            S101743=1;
            if(enable_in.isREQ()){//sysj/liquidDumperController.sysj line: 77, column: 5
              enable_in.setACK(false);//sysj/liquidDumperController.sysj line: 77, column: 5
              ends[3]=2;
              ;//sysj/liquidDumperController.sysj line: 77, column: 5
              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/liquidDumperController.sysj line: 78, column: 5
              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj/liquidDumperController.sysj line: 79, column: 5
              S101764=1;
              if(clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 82, column: 21
                S101764=2;
                if(bottleInverted.getprestatus()){//sysj/liquidDumperController.sysj line: 87, column: 21
                  S101764=3;
                  if(bottleDrained.getprestatus()){//sysj/liquidDumperController.sysj line: 93, column: 21
                    S101764=4;
                    if(bottleUpright.getprestatus()){//sysj/liquidDumperController.sysj line: 98, column: 21
                      S101764=5;
                      if(!clampClosed.getprestatus()){//sysj/liquidDumperController.sysj line: 103, column: 21
                        w_thread_3.drain();//sysj/liquidDumperController.sysj line: 105, column: 5
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj/liquidDumperController.sysj line: 106, column: 5
                        level_thread_3 = 0;//sysj/liquidDumperController.sysj line: 109, column: 5
                        if(wasteTankLevel.getprestatus()){//sysj/liquidDumperController.sysj line: 110, column: 13
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj/liquidDumperController.sysj line: 111, column: 6
                          code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                          }
                          S101764=6;
                          S102076=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            S102076=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102071=0;
                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102071=1;
                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                S104247=2;
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
                          code_thread_3 = OK_thread_3;//sysj/liquidDumperController.sysj line: 114, column: 5
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj/liquidDumperController.sysj line: 115, column: 27
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj/liquidDumperController.sysj line: 116, column: 6
                            code_thread_3 = WARN_thread_3;//sysj/liquidDumperController.sysj line: 117, column: 6
                          }
                          if(level_thread_3 >= TANK_CAPACITY_thread_3) {//sysj/liquidDumperController.sysj line: 119, column: 31
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj/liquidDumperController.sysj line: 120, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj/liquidDumperController.sysj line: 121, column: 6
                          }
                          S101764=6;
                          S102076=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                            S102076=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102071=0;
                            if(status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/liquidDumperController.sysj line: 124, column: 5
                              S102071=1;
                              if(!status_o.isACK()){//sysj/liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj/liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj/liquidDumperController.sysj line: 124, column: 5
                                S104247=2;
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
                      thread117076(tdone,ends);
                      thread117077(tdone,ends);
                      int biggest117078 = 0;
                      if(ends[9]>=biggest117078){
                        biggest117078=ends[9];
                      }
                      if(ends[10]>=biggest117078){
                        biggest117078=ends[10];
                      }
                      if(biggest117078 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread117079(tdone,ends);
                    thread117080(tdone,ends);
                    thread117081(tdone,ends);
                    int biggest117082 = 0;
                    if(ends[6]>=biggest117082){
                      biggest117082=ends[6];
                    }
                    if(ends[7]>=biggest117082){
                      biggest117082=ends[7];
                    }
                    if(ends[8]>=biggest117082){
                      biggest117082=ends[8];
                    }
                    if(biggest117082 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread117083(tdone,ends);
                  thread117084(tdone,ends);
                  int biggest117085 = 0;
                  if(ends[4]>=biggest117085){
                    biggest117085=ends[4];
                  }
                  if(ends[5]>=biggest117085){
                    biggest117085=ends[5];
                  }
                  if(biggest117085 == 1){
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                cylClampBottleExtend.setPresent();//sysj/liquidDumperController.sysj line: 83, column: 6
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

  public void thread117074(int [] tdone, int [] ends){
        S101739=1;
    if(mode.getprestatus()){//sysj/liquidDumperController.sysj line: 53, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/liquidDumperController.sysj line: 54, column: 8
        auto_1.setPresent();//sysj/liquidDumperController.sysj line: 54, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj/liquidDumperController.sysj line: 55, column: 12
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
      switch(S117072){
        case 0 : 
          S117072=0;
          break RUN;
        
        case 1 : 
          S117072=2;
          S117072=2;
          auto_1.setClear();//sysj/liquidDumperController.sysj line: 49, column: 2
          manual_1.setClear();//sysj/liquidDumperController.sysj line: 49, column: 2
          thread117074(tdone,ends);
          thread117075(tdone,ends);
          thread117086(tdone,ends);
          int biggest117087 = 0;
          if(ends[2]>=biggest117087){
            biggest117087=ends[2];
          }
          if(ends[3]>=biggest117087){
            biggest117087=ends[3];
          }
          if(ends[11]>=biggest117087){
            biggest117087=ends[11];
          }
          if(biggest117087 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/liquidDumperController.sysj line: 49, column: 2
          manual_1.setClear();//sysj/liquidDumperController.sysj line: 49, column: 2
          thread117088(tdone,ends);
          thread117089(tdone,ends);
          thread117180(tdone,ends);
          int biggest117181 = 0;
          if(ends[2]>=biggest117181){
            biggest117181=ends[2];
          }
          if(ends[3]>=biggest117181){
            biggest117181=ends[3];
          }
          if(ends[11]>=biggest117181){
            biggest117181=ends[11];
          }
          if(biggest117181 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest117181 == 0){
            S117072=0;
            active[1]=0;
            ends[1]=0;
            S117072=0;
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
