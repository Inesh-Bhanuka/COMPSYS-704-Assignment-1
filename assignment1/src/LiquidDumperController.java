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
  private int S117108 = 1;
  private int S101775 = 1;
  private int S116819 = 1;
  private int S104283 = 1;
  private int S101800 = 1;
  private int S101784 = 1;
  private int S101779 = 1;
  private int S101821 = 1;
  private int S101826 = 1;
  private int S101876 = 1;
  private int S101881 = 1;
  private int S101886 = 1;
  private int S101988 = 1;
  private int S101993 = 1;
  private int S102112 = 1;
  private int S102107 = 1;
  private int S117106 = 1;
  private int S116914 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread117216(int [] tdone, int [] ends){
        switch(S117106){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S116914){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 132, column: 20
              S116914=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 133, column: 20
                S116914=2;
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
              S116914=2;
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
            S116914=2;
            S116914=0;
            if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 132, column: 20
              S116914=1;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 133, column: 20
                S116914=2;
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

  public void thread117214(int [] tdone, int [] ends){
        S101826=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117213(int [] tdone, int [] ends){
        S101821=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117211(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117210(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117209(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117207(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117206(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117204(int [] tdone, int [] ends){
        switch(S101993){
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

  public void thread117203(int [] tdone, int [] ends){
        switch(S101988){
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

  public void thread117201(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117200(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117198(int [] tdone, int [] ends){
        switch(S101886){
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

  public void thread117197(int [] tdone, int [] ends){
        switch(S101881){
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

  public void thread117196(int [] tdone, int [] ends){
        switch(S101876){
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

  public void thread117194(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117193(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117191(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117190(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117189(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117187(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117186(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117184(int [] tdone, int [] ends){
        switch(S101826){
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

  public void thread117183(int [] tdone, int [] ends){
        switch(S101821){
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

  public void thread117181(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117180(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117179(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117177(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117176(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117174(int [] tdone, int [] ends){
        S101826=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117173(int [] tdone, int [] ends){
        S101821=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117171(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117170(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117169(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117167(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117166(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117164(int [] tdone, int [] ends){
        S101826=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117163(int [] tdone, int [] ends){
        S101821=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117161(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117160(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117159(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117157(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117156(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117154(int [] tdone, int [] ends){
        S101826=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117153(int [] tdone, int [] ends){
        S101821=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117151(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117150(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117149(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117147(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117146(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117144(int [] tdone, int [] ends){
        S101826=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117143(int [] tdone, int [] ends){
        S101821=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117141(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117140(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117139(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117137(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117136(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117134(int [] tdone, int [] ends){
        S101826=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117133(int [] tdone, int [] ends){
        S101821=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117131(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117130(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117129(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117127(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117126(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117125(int [] tdone, int [] ends){
        switch(S116819){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S104283){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
              S104283=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S104283=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S101800=0;
                S101784=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                  S101784=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S101779=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                    S101779=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 77, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                      S101800=1;
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                        S101800=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                          S101800=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                            S101800=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                              S101800=5;
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
                                  S101800=6;
                                  S102112=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S102112=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S102107=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                      S102107=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                        S104283=2;
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
                                  S101800=6;
                                  S102112=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S102112=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S102107=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                      S102107=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                        S104283=2;
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
                              thread117126(tdone,ends);
                              thread117127(tdone,ends);
                              int biggest117128 = 0;
                              if(ends[9]>=biggest117128){
                                biggest117128=ends[9];
                              }
                              if(ends[10]>=biggest117128){
                                biggest117128=ends[10];
                              }
                              if(biggest117128 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread117129(tdone,ends);
                            thread117130(tdone,ends);
                            thread117131(tdone,ends);
                            int biggest117132 = 0;
                            if(ends[6]>=biggest117132){
                              biggest117132=ends[6];
                            }
                            if(ends[7]>=biggest117132){
                              biggest117132=ends[7];
                            }
                            if(ends[8]>=biggest117132){
                              biggest117132=ends[8];
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
                          int biggest117135 = 0;
                          if(ends[4]>=biggest117135){
                            biggest117135=ends[4];
                          }
                          if(ends[5]>=biggest117135){
                            biggest117135=ends[5];
                          }
                          if(biggest117135 == 1){
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
              S104283=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S101800){
                case 0 : 
                  switch(S101784){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                        S101784=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S101779){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                              enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                              S101779=1;
                              if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 77, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                                S101800=1;
                                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                                  S101800=2;
                                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                                    S101800=3;
                                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                                      S101800=4;
                                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                                        S101800=5;
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
                                            S101800=6;
                                            S102112=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S102112=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S102107=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                                S102107=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  S104283=2;
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
                                            S101800=6;
                                            S102112=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S102112=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S102107=0;
                                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                                S102107=1;
                                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                                  S104283=2;
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
                                        thread117136(tdone,ends);
                                        thread117137(tdone,ends);
                                        int biggest117138 = 0;
                                        if(ends[9]>=biggest117138){
                                          biggest117138=ends[9];
                                        }
                                        if(ends[10]>=biggest117138){
                                          biggest117138=ends[10];
                                        }
                                        if(biggest117138 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      thread117139(tdone,ends);
                                      thread117140(tdone,ends);
                                      thread117141(tdone,ends);
                                      int biggest117142 = 0;
                                      if(ends[6]>=biggest117142){
                                        biggest117142=ends[6];
                                      }
                                      if(ends[7]>=biggest117142){
                                        biggest117142=ends[7];
                                      }
                                      if(ends[8]>=biggest117142){
                                        biggest117142=ends[8];
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
                                    int biggest117145 = 0;
                                    if(ends[4]>=biggest117145){
                                      biggest117145=ends[4];
                                    }
                                    if(ends[5]>=biggest117145){
                                      biggest117145=ends[5];
                                    }
                                    if(biggest117145 == 1){
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
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                              S101800=1;
                              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                                S101800=2;
                                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                                  S101800=3;
                                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                                    S101800=4;
                                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                                      S101800=5;
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
                                          S101800=6;
                                          S102112=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                            S102112=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S102107=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S102107=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                                S104283=2;
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
                                          S101800=6;
                                          S102112=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                            S102112=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S102107=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S102107=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                                S104283=2;
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
                                      thread117146(tdone,ends);
                                      thread117147(tdone,ends);
                                      int biggest117148 = 0;
                                      if(ends[9]>=biggest117148){
                                        biggest117148=ends[9];
                                      }
                                      if(ends[10]>=biggest117148){
                                        biggest117148=ends[10];
                                      }
                                      if(biggest117148 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread117149(tdone,ends);
                                    thread117150(tdone,ends);
                                    thread117151(tdone,ends);
                                    int biggest117152 = 0;
                                    if(ends[6]>=biggest117152){
                                      biggest117152=ends[6];
                                    }
                                    if(ends[7]>=biggest117152){
                                      biggest117152=ends[7];
                                    }
                                    if(ends[8]>=biggest117152){
                                      biggest117152=ends[8];
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
                                  int biggest117155 = 0;
                                  if(ends[4]>=biggest117155){
                                    biggest117155=ends[4];
                                  }
                                  if(ends[5]>=biggest117155){
                                    biggest117155=ends[5];
                                  }
                                  if(biggest117155 == 1){
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
                      S101784=1;
                      S101784=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                        S101784=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S101779=0;
                        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                          S101779=1;
                          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 77, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                            System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                            S101800=1;
                            if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                              S101800=2;
                              if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                                S101800=3;
                                if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                                  S101800=4;
                                  if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                                    S101800=5;
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
                                        S101800=6;
                                        S102112=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                          S102112=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S102107=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                            S102107=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S104283=2;
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
                                        S101800=6;
                                        S102112=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                          S102112=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S102107=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                            S102107=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                              S104283=2;
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
                                    thread117156(tdone,ends);
                                    thread117157(tdone,ends);
                                    int biggest117158 = 0;
                                    if(ends[9]>=biggest117158){
                                      biggest117158=ends[9];
                                    }
                                    if(ends[10]>=biggest117158){
                                      biggest117158=ends[10];
                                    }
                                    if(biggest117158 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread117159(tdone,ends);
                                  thread117160(tdone,ends);
                                  thread117161(tdone,ends);
                                  int biggest117162 = 0;
                                  if(ends[6]>=biggest117162){
                                    biggest117162=ends[6];
                                  }
                                  if(ends[7]>=biggest117162){
                                    biggest117162=ends[7];
                                  }
                                  if(ends[8]>=biggest117162){
                                    biggest117162=ends[8];
                                  }
                                  if(biggest117162 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread117163(tdone,ends);
                                thread117164(tdone,ends);
                                int biggest117165 = 0;
                                if(ends[4]>=biggest117165){
                                  biggest117165=ends[4];
                                }
                                if(ends[5]>=biggest117165){
                                  biggest117165=ends[5];
                                }
                                if(biggest117165 == 1){
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
                    S101800=2;
                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                      S101800=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                        S101800=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                          S101800=5;
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
                              S101800=6;
                              S102112=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                S102112=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S102107=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S102107=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S104283=2;
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
                              S101800=6;
                              S102112=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                S102112=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S102107=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S102107=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S104283=2;
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
                          thread117166(tdone,ends);
                          thread117167(tdone,ends);
                          int biggest117168 = 0;
                          if(ends[9]>=biggest117168){
                            biggest117168=ends[9];
                          }
                          if(ends[10]>=biggest117168){
                            biggest117168=ends[10];
                          }
                          if(biggest117168 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread117169(tdone,ends);
                        thread117170(tdone,ends);
                        thread117171(tdone,ends);
                        int biggest117172 = 0;
                        if(ends[6]>=biggest117172){
                          biggest117172=ends[6];
                        }
                        if(ends[7]>=biggest117172){
                          biggest117172=ends[7];
                        }
                        if(ends[8]>=biggest117172){
                          biggest117172=ends[8];
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
                      int biggest117175 = 0;
                      if(ends[4]>=biggest117175){
                        biggest117175=ends[4];
                      }
                      if(ends[5]>=biggest117175){
                        biggest117175=ends[5];
                      }
                      if(biggest117175 == 1){
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
                    S101800=3;
                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                      S101800=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                        S101800=5;
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
                            S101800=6;
                            S102112=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102112=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S102107=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                S102107=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S104283=2;
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
                            S101800=6;
                            S102112=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102112=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S102107=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                S102107=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S104283=2;
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
                        thread117176(tdone,ends);
                        thread117177(tdone,ends);
                        int biggest117178 = 0;
                        if(ends[9]>=biggest117178){
                          biggest117178=ends[9];
                        }
                        if(ends[10]>=biggest117178){
                          biggest117178=ends[10];
                        }
                        if(biggest117178 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread117179(tdone,ends);
                      thread117180(tdone,ends);
                      thread117181(tdone,ends);
                      int biggest117182 = 0;
                      if(ends[6]>=biggest117182){
                        biggest117182=ends[6];
                      }
                      if(ends[7]>=biggest117182){
                        biggest117182=ends[7];
                      }
                      if(ends[8]>=biggest117182){
                        biggest117182=ends[8];
                      }
                      if(biggest117182 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread117183(tdone,ends);
                    thread117184(tdone,ends);
                    int biggest117185 = 0;
                    if(ends[4]>=biggest117185){
                      biggest117185=ends[4];
                    }
                    if(ends[5]>=biggest117185){
                      biggest117185=ends[5];
                    }
                    if(biggest117185 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest117185 == 0){
                      S101800=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                        S101800=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                          S101800=5;
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
                              S101800=6;
                              S102112=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                S102112=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S102107=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S102107=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S104283=2;
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
                              S101800=6;
                              S102112=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                S102112=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S102107=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S102107=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S104283=2;
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
                          thread117186(tdone,ends);
                          thread117187(tdone,ends);
                          int biggest117188 = 0;
                          if(ends[9]>=biggest117188){
                            biggest117188=ends[9];
                          }
                          if(ends[10]>=biggest117188){
                            biggest117188=ends[10];
                          }
                          if(biggest117188 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread117189(tdone,ends);
                        thread117190(tdone,ends);
                        thread117191(tdone,ends);
                        int biggest117192 = 0;
                        if(ends[6]>=biggest117192){
                          biggest117192=ends[6];
                        }
                        if(ends[7]>=biggest117192){
                          biggest117192=ends[7];
                        }
                        if(ends[8]>=biggest117192){
                          biggest117192=ends[8];
                        }
                        if(biggest117192 == 1){
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
                    S101800=4;
                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                      S101800=5;
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
                          S101800=6;
                          S102112=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S102112=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102107=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102107=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S104283=2;
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
                          S101800=6;
                          S102112=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S102112=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102107=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102107=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S104283=2;
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
                      thread117193(tdone,ends);
                      thread117194(tdone,ends);
                      int biggest117195 = 0;
                      if(ends[9]>=biggest117195){
                        biggest117195=ends[9];
                      }
                      if(ends[10]>=biggest117195){
                        biggest117195=ends[10];
                      }
                      if(biggest117195 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread117196(tdone,ends);
                    thread117197(tdone,ends);
                    thread117198(tdone,ends);
                    int biggest117199 = 0;
                    if(ends[6]>=biggest117199){
                      biggest117199=ends[6];
                    }
                    if(ends[7]>=biggest117199){
                      biggest117199=ends[7];
                    }
                    if(ends[8]>=biggest117199){
                      biggest117199=ends[8];
                    }
                    if(biggest117199 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest117199 == 0){
                      S101800=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                        S101800=5;
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
                            S101800=6;
                            S102112=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102112=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S102107=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                S102107=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S104283=2;
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
                            S101800=6;
                            S102112=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102112=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S102107=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                S102107=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                  S104283=2;
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
                        thread117200(tdone,ends);
                        thread117201(tdone,ends);
                        int biggest117202 = 0;
                        if(ends[9]>=biggest117202){
                          biggest117202=ends[9];
                        }
                        if(ends[10]>=biggest117202){
                          biggest117202=ends[10];
                        }
                        if(biggest117202 == 1){
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
                    S101800=5;
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
                        S101800=6;
                        S102112=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                          S102112=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S102107=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                            S102107=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                              S104283=2;
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
                        S101800=6;
                        S102112=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                          S102112=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S102107=0;
                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                            S102107=1;
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 124, column: 5
                              S104283=2;
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
                    thread117203(tdone,ends);
                    thread117204(tdone,ends);
                    int biggest117205 = 0;
                    if(ends[9]>=biggest117205){
                      biggest117205=ends[9];
                    }
                    if(ends[10]>=biggest117205){
                      biggest117205=ends[10];
                    }
                    if(biggest117205 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest117205 == 0){
                      S101800=5;
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
                          S101800=6;
                          S102112=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S102112=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102107=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102107=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S104283=2;
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
                          S101800=6;
                          S102112=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S102112=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102107=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102107=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S104283=2;
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
                      S101800=6;
                      S102112=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                        S102112=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S102107=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                          S102107=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 124, column: 5
                            S104283=2;
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
                      S101800=6;
                      S102112=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                        S102112=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S102107=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                          S102107=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 124, column: 5
                            S104283=2;
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
                  switch(S102112){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                        S102112=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S102107){
                          case 0 : 
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102107=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S104283=2;
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
                              S104283=2;
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
                      S102112=1;
                      S102112=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                        S102112=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S102107=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                          S102107=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 124, column: 5
                            S104283=2;
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
                  S104283=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S104283=2;
            S104283=0;
            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
              S104283=1;
              if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S104283=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S101800=0;
                S101784=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
                  enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                  S101784=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S101779=0;
                  if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                    enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
                    S101779=1;
                    if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
                      enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
                      ends[3]=2;
                      ;//sysj\liquidDumperController.sysj line: 77, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
                      S101800=1;
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                        S101800=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                          S101800=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                            S101800=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                              S101800=5;
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
                                  S101800=6;
                                  S102112=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S102112=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S102107=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                      S102107=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                        S104283=2;
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
                                  S101800=6;
                                  S102112=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                    S102112=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S102107=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                                      S102107=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                        S104283=2;
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
                              thread117206(tdone,ends);
                              thread117207(tdone,ends);
                              int biggest117208 = 0;
                              if(ends[9]>=biggest117208){
                                biggest117208=ends[9];
                              }
                              if(ends[10]>=biggest117208){
                                biggest117208=ends[10];
                              }
                              if(biggest117208 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread117209(tdone,ends);
                            thread117210(tdone,ends);
                            thread117211(tdone,ends);
                            int biggest117212 = 0;
                            if(ends[6]>=biggest117212){
                              biggest117212=ends[6];
                            }
                            if(ends[7]>=biggest117212){
                              biggest117212=ends[7];
                            }
                            if(ends[8]>=biggest117212){
                              biggest117212=ends[8];
                            }
                            if(biggest117212 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread117213(tdone,ends);
                          thread117214(tdone,ends);
                          int biggest117215 = 0;
                          if(ends[4]>=biggest117215){
                            biggest117215=ends[4];
                          }
                          if(ends[5]>=biggest117215){
                            biggest117215=ends[5];
                          }
                          if(biggest117215 == 1){
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

  public void thread117124(int [] tdone, int [] ends){
        switch(S101775){
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

  public void thread117122(int [] tdone, int [] ends){
        S117106=1;
    S116914=0;
    if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 132, column: 20
      S116914=1;
      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 133, column: 20
        S116914=2;
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

  public void thread117120(int [] tdone, int [] ends){
        S101826=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 45
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread117119(int [] tdone, int [] ends){
        S101821=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 88, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread117117(int [] tdone, int [] ends){
        S101886=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 80
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread117116(int [] tdone, int [] ends){
        S101881=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 45
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread117115(int [] tdone, int [] ends){
        S101876=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 94, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread117113(int [] tdone, int [] ends){
        S101993=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 45
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread117112(int [] tdone, int [] ends){
        S101988=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 99, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread117111(int [] tdone, int [] ends){
        S116819=1;
    OK_thread_3 = 0;//sysj\liquidDumperController.sysj line: 62, column: 3
    BLOCKED_thread_3 = 2;//sysj\liquidDumperController.sysj line: 63, column: 3
    WARN_thread_3 = 3;//sysj\liquidDumperController.sysj line: 64, column: 3
    TANK_CAPACITY_thread_3 = 6;//sysj\liquidDumperController.sysj line: 66, column: 3
    TANK_WARN_thread_3 = 4;//sysj\liquidDumperController.sysj line: 67, column: 3
    w_thread_3 = null;//sysj\liquidDumperController.sysj line: 69, column: 3
    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 70, column: 3
    code_thread_3 = 0;//sysj\liquidDumperController.sysj line: 71, column: 3
    S104283=0;
    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 74, column: 20
      S104283=1;
      if(manual_1.getprestatus()){//sysj\liquidDumperController.sysj line: 76, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S104283=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S101800=0;
        S101784=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 77, column: 5
          enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
          S101784=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S101779=0;
          if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
            enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 77, column: 5
            S101779=1;
            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 77, column: 5
              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 77, column: 5
              ends[3]=2;
              ;//sysj\liquidDumperController.sysj line: 77, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 78, column: 5
              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 79, column: 5
              S101800=1;
              if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 21
                S101800=2;
                if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 87, column: 21
                  S101800=3;
                  if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 93, column: 21
                    S101800=4;
                    if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 21
                      S101800=5;
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
                          S101800=6;
                          S102112=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S102112=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102107=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102107=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S104283=2;
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
                          S101800=6;
                          S102112=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 124, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                            S102112=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S102107=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 124, column: 5
                              S102107=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 124, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 124, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 124, column: 5
                                S104283=2;
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
                      thread117112(tdone,ends);
                      thread117113(tdone,ends);
                      int biggest117114 = 0;
                      if(ends[9]>=biggest117114){
                        biggest117114=ends[9];
                      }
                      if(ends[10]>=biggest117114){
                        biggest117114=ends[10];
                      }
                      if(biggest117114 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread117115(tdone,ends);
                    thread117116(tdone,ends);
                    thread117117(tdone,ends);
                    int biggest117118 = 0;
                    if(ends[6]>=biggest117118){
                      biggest117118=ends[6];
                    }
                    if(ends[7]>=biggest117118){
                      biggest117118=ends[7];
                    }
                    if(ends[8]>=biggest117118){
                      biggest117118=ends[8];
                    }
                    if(biggest117118 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread117119(tdone,ends);
                  thread117120(tdone,ends);
                  int biggest117121 = 0;
                  if(ends[4]>=biggest117121){
                    biggest117121=ends[4];
                  }
                  if(ends[5]>=biggest117121){
                    biggest117121=ends[5];
                  }
                  if(biggest117121 == 1){
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

  public void thread117110(int [] tdone, int [] ends){
        S101775=1;
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
      switch(S117108){
        case 0 : 
          S117108=0;
          break RUN;
        
        case 1 : 
          S117108=2;
          S117108=2;
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          thread117110(tdone,ends);
          thread117111(tdone,ends);
          thread117122(tdone,ends);
          int biggest117123 = 0;
          if(ends[2]>=biggest117123){
            biggest117123=ends[2];
          }
          if(ends[3]>=biggest117123){
            biggest117123=ends[3];
          }
          if(ends[11]>=biggest117123){
            biggest117123=ends[11];
          }
          if(biggest117123 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 49, column: 2
          thread117124(tdone,ends);
          thread117125(tdone,ends);
          thread117216(tdone,ends);
          int biggest117217 = 0;
          if(ends[2]>=biggest117217){
            biggest117217=ends[2];
          }
          if(ends[3]>=biggest117217){
            biggest117217=ends[3];
          }
          if(ends[11]>=biggest117217){
            biggest117217=ends[11];
          }
          if(biggest117217 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest117217 == 0){
            S117108=0;
            active[1]=0;
            ends[1]=0;
            S117108=0;
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
