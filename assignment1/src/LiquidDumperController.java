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
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal clampClosed = new Signal("clampClosed", Signal.INPUT);
  public Signal bottleInverted = new Signal("bottleInverted", Signal.INPUT);
  public Signal bottleUpright = new Signal("bottleUpright", Signal.INPUT);
  public Signal bottleDrained = new Signal("bottleDrained", Signal.INPUT);
  public Signal wasteTankLevel = new Signal("wasteTankLevel", Signal.INPUT);
  public Signal cylClampBottleExtendM = new Signal("cylClampBottleExtendM", Signal.INPUT);
  public Signal invertRotateExtendM = new Signal("invertRotateExtendM", Signal.INPUT);
  public Signal invertRotateRetractM = new Signal("invertRotateRetractM", Signal.INPUT);
  public Signal drainValveOnOffM = new Signal("drainValveOnOffM", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  public Signal invertRotateExtend = new Signal("invertRotateExtend", Signal.OUTPUT);
  public Signal invertRotateRetract = new Signal("invertRotateRetract", Signal.OUTPUT);
  public Signal drainValveOnOff = new Signal("drainValveOnOff", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int OK_thread_3;//sysj\liquidDumperController.sysj line: 68, column: 3
  private int BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 69, column: 3
  private int WARN_thread_3;//sysj\liquidDumperController.sysj line: 70, column: 3
  private int TANK_CAPACITY_thread_3;//sysj\liquidDumperController.sysj line: 72, column: 3
  private int TANK_WARN_thread_3;//sysj\liquidDumperController.sysj line: 73, column: 3
  private WorkpieceTwin w_thread_3;//sysj\liquidDumperController.sysj line: 75, column: 3
  private int level_thread_3;//sysj\liquidDumperController.sysj line: 76, column: 3
  private int code_thread_3;//sysj\liquidDumperController.sysj line: 77, column: 3
  private int S223592 = 1;
  private int S155470 = 1;
  private int S223590 = 1;
  private int S166824 = 1;
  private int S155494 = 1;
  private int S155478 = 1;
  private int S155473 = 1;
  private int S155499 = 1;
  private int S155572 = 1;
  private int S155526 = 1;
  private int S155531 = 1;
  private int S155921 = 1;
  private int S155850 = 1;
  private int S155855 = 1;
  private int S155860 = 1;
  private int S156528 = 1;
  private int S156482 = 1;
  private int S156487 = 1;
  private int S165289 = 1;
  private int S165284 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread223927(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223926(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223924(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223923(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223921(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223920(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223919(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223917(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223916(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223915(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223913(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223912(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223910(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223909(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223907(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223906(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223904(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223903(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223901(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223900(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223899(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223897(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223896(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223895(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223893(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223892(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223890(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223889(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223887(int [] tdone, int [] ends){
        switch(S156487){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
        currsigs.addElement(invertRotateRetract);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread223886(int [] tdone, int [] ends){
        switch(S156482){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread223884(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223883(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223881(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223880(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223878(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223877(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223875(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223874(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223872(int [] tdone, int [] ends){
        switch(S155860){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
        currsigs.addElement(drainValveOnOff);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread223871(int [] tdone, int [] ends){
        switch(S155855){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
        currsigs.addElement(invertRotateExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread223870(int [] tdone, int [] ends){
        switch(S155850){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread223868(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223867(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223866(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223864(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223863(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223862(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223860(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223859(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223857(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223856(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223854(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223853(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223852(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223850(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223849(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223848(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223846(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223845(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223843(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223842(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223840(int [] tdone, int [] ends){
        switch(S155531){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
        currsigs.addElement(invertRotateExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread223839(int [] tdone, int [] ends){
        switch(S155526){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread223837(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223836(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223834(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223833(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223831(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223830(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223829(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223827(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223826(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223825(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223823(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223822(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223820(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223819(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223817(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223816(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223814(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223813(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223811(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223810(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223809(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223807(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223806(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223805(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223803(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223802(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223800(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223799(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223797(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223796(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223794(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223793(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223791(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223790(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223789(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223787(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223786(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223785(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223783(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223782(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223780(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223779(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223777(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223776(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223774(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223773(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223771(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223770(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223769(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223767(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223766(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223765(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223763(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223762(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223760(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223759(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223757(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223756(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223754(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223753(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223751(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223750(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223749(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223747(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223746(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223745(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223743(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223742(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223740(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223739(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223737(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223736(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223734(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223733(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223731(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223730(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223729(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223727(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223726(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223725(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223723(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223722(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223720(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223719(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223717(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223716(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223714(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223713(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223711(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223710(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223709(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223707(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223706(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223705(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223703(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223702(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223700(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223699(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223697(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223696(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223694(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223693(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223691(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223690(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223689(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223687(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223686(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223685(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223683(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223682(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223680(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223679(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223677(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223676(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223674(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223673(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223671(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223670(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223669(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223667(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223666(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223665(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223663(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223662(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223660(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223659(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223657(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223656(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223654(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223653(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223651(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223650(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223649(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223647(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223646(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223645(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223643(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223642(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223640(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223639(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223638(int [] tdone, int [] ends){
        switch(S223590){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S166824){
          case 0 : 
            if(reset.getprestatus()){//sysj\liquidDumperController.sysj line: 80, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S166824=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S155494){
                case 0 : 
                  switch(S155478){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 81, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
                        S155478=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S155473){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
                              enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 81, column: 5
                              S155473=1;
                              if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
                                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 81, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 82, column: 5
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 90, column: 5
                                S155494=1;
                                if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 92, column: 8
                                  System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 93, column: 6
                                  S155499=0;
                                  if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 22
                                    S155499=1;
                                    if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                      S155499=2;
                                      if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                                        S155499=3;
                                        if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                          S155499=4;
                                          if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                            S155499=5;
                                            if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                              w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                              System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                              level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                              if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                                level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                                }
                                                S155499=6;
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                    S155494=2;
                                                    S165289=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165289=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S165284=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S165284=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          S166824=1;
                                                          active[3]=1;
                                                          ends[3]=1;
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
                                                  S155494=2;
                                                  S165289=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165289=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S165284=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165284=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S166824=1;
                                                        active[3]=1;
                                                        ends[3]=1;
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
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                                }
                                                S155499=6;
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                    S155494=2;
                                                    S165289=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165289=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S165284=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S165284=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          S166824=1;
                                                          active[3]=1;
                                                          ends[3]=1;
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
                                                  S155494=2;
                                                  S165289=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165289=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S165284=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165284=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S166824=1;
                                                        active[3]=1;
                                                        ends[3]=1;
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
                                            S156528=0;
                                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                              S156528=1;
                                              thread223639(tdone,ends);
                                              thread223640(tdone,ends);
                                              int biggest223641 = 0;
                                              if(ends[9]>=biggest223641){
                                                biggest223641=ends[9];
                                              }
                                              if(ends[10]>=biggest223641){
                                                biggest223641=ends[10];
                                              }
                                              if(biggest223641 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                                S156528=1;
                                                thread223642(tdone,ends);
                                                thread223643(tdone,ends);
                                                int biggest223644 = 0;
                                                if(ends[9]>=biggest223644){
                                                  biggest223644=ends[9];
                                                }
                                                if(ends[10]>=biggest223644){
                                                  biggest223644=ends[10];
                                                }
                                                if(biggest223644 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
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
                                          S155921=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                            S155921=1;
                                            thread223645(tdone,ends);
                                            thread223646(tdone,ends);
                                            thread223647(tdone,ends);
                                            int biggest223648 = 0;
                                            if(ends[6]>=biggest223648){
                                              biggest223648=ends[6];
                                            }
                                            if(ends[7]>=biggest223648){
                                              biggest223648=ends[7];
                                            }
                                            if(ends[8]>=biggest223648){
                                              biggest223648=ends[8];
                                            }
                                            if(biggest223648 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                              S155921=1;
                                              thread223649(tdone,ends);
                                              thread223650(tdone,ends);
                                              thread223651(tdone,ends);
                                              int biggest223652 = 0;
                                              if(ends[6]>=biggest223652){
                                                biggest223652=ends[6];
                                              }
                                              if(ends[7]>=biggest223652){
                                                biggest223652=ends[7];
                                              }
                                              if(ends[8]>=biggest223652){
                                                biggest223652=ends[8];
                                              }
                                              if(biggest223652 == 1){
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155572=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                                          S155572=1;
                                          thread223653(tdone,ends);
                                          thread223654(tdone,ends);
                                          int biggest223655 = 0;
                                          if(ends[4]>=biggest223655){
                                            biggest223655=ends[4];
                                          }
                                          if(ends[5]>=biggest223655){
                                            biggest223655=ends[5];
                                          }
                                          if(biggest223655 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                            S155572=1;
                                            thread223656(tdone,ends);
                                            thread223657(tdone,ends);
                                            int biggest223658 = 0;
                                            if(ends[4]>=biggest223658){
                                              biggest223658=ends[4];
                                            }
                                            if(ends[5]>=biggest223658){
                                              biggest223658=ends[5];
                                            }
                                            if(biggest223658 == 1){
                                              active[3]=1;
                                              ends[3]=1;
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
                                      cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
                                      currsigs.addElement(cylClampBottleExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 45
                                      S155499=1;
                                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                        S155499=2;
                                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                                          S155499=3;
                                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                            S155499=4;
                                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                              S155499=5;
                                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                                  }
                                                  S155499=6;
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                      S155494=2;
                                                      S165289=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S165289=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S165284=0;
                                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          S165284=1;
                                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                            S166824=1;
                                                            active[3]=1;
                                                            ends[3]=1;
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
                                                    S155494=2;
                                                    S165289=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165289=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S165284=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S165284=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          S166824=1;
                                                          active[3]=1;
                                                          ends[3]=1;
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
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                                  }
                                                  S155499=6;
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                      S155494=2;
                                                      S165289=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S165289=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S165284=0;
                                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          S165284=1;
                                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                            S166824=1;
                                                            active[3]=1;
                                                            ends[3]=1;
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
                                                    S155494=2;
                                                    S165289=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165289=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S165284=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S165284=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          S166824=1;
                                                          active[3]=1;
                                                          ends[3]=1;
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
                                              S156528=0;
                                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                                S156528=1;
                                                thread223659(tdone,ends);
                                                thread223660(tdone,ends);
                                                int biggest223661 = 0;
                                                if(ends[9]>=biggest223661){
                                                  biggest223661=ends[9];
                                                }
                                                if(ends[10]>=biggest223661){
                                                  biggest223661=ends[10];
                                                }
                                                if(biggest223661 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                                  S156528=1;
                                                  thread223662(tdone,ends);
                                                  thread223663(tdone,ends);
                                                  int biggest223664 = 0;
                                                  if(ends[9]>=biggest223664){
                                                    biggest223664=ends[9];
                                                  }
                                                  if(ends[10]>=biggest223664){
                                                    biggest223664=ends[10];
                                                  }
                                                  if(biggest223664 == 1){
                                                    active[3]=1;
                                                    ends[3]=1;
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
                                            S155921=0;
                                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                              S155921=1;
                                              thread223665(tdone,ends);
                                              thread223666(tdone,ends);
                                              thread223667(tdone,ends);
                                              int biggest223668 = 0;
                                              if(ends[6]>=biggest223668){
                                                biggest223668=ends[6];
                                              }
                                              if(ends[7]>=biggest223668){
                                                biggest223668=ends[7];
                                              }
                                              if(ends[8]>=biggest223668){
                                                biggest223668=ends[8];
                                              }
                                              if(biggest223668 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                                S155921=1;
                                                thread223669(tdone,ends);
                                                thread223670(tdone,ends);
                                                thread223671(tdone,ends);
                                                int biggest223672 = 0;
                                                if(ends[6]>=biggest223672){
                                                  biggest223672=ends[6];
                                                }
                                                if(ends[7]>=biggest223672){
                                                  biggest223672=ends[7];
                                                }
                                                if(ends[8]>=biggest223672){
                                                  biggest223672=ends[8];
                                                }
                                                if(biggest223672 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
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
                                          S155572=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                                            S155572=1;
                                            thread223673(tdone,ends);
                                            thread223674(tdone,ends);
                                            int biggest223675 = 0;
                                            if(ends[4]>=biggest223675){
                                              biggest223675=ends[4];
                                            }
                                            if(ends[5]>=biggest223675){
                                              biggest223675=ends[5];
                                            }
                                            if(biggest223675 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                              S155572=1;
                                              thread223676(tdone,ends);
                                              thread223677(tdone,ends);
                                              int biggest223678 = 0;
                                              if(ends[4]>=biggest223678){
                                                biggest223678=ends[4];
                                              }
                                              if(ends[5]>=biggest223678){
                                                biggest223678=ends[5];
                                              }
                                              if(biggest223678 == 1){
                                                active[3]=1;
                                                ends[3]=1;
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
                                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
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
                                }
                                else {
                                  S155494=2;
                                  S165289=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165289=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S165284=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165284=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S166824=1;
                                        active[3]=1;
                                        ends[3]=1;
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
                            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
                              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 81, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 82, column: 5
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 90, column: 5
                              S155494=1;
                              if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 92, column: 8
                                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 93, column: 6
                                S155499=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 22
                                  S155499=1;
                                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                    S155499=2;
                                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                                      S155499=3;
                                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                        S155499=4;
                                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                          S155499=5;
                                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                              }
                                              S155499=6;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                  S155494=2;
                                                  S165289=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165289=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S165284=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165284=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S166824=1;
                                                        active[3]=1;
                                                        ends[3]=1;
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
                                                S155494=2;
                                                S165289=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  S165289=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S165284=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165284=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S166824=1;
                                                      active[3]=1;
                                                      ends[3]=1;
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
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                              }
                                              S155499=6;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                  S155494=2;
                                                  S165289=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165289=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S165284=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165284=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S166824=1;
                                                        active[3]=1;
                                                        ends[3]=1;
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
                                                S155494=2;
                                                S165289=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  S165289=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S165284=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165284=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S166824=1;
                                                      active[3]=1;
                                                      ends[3]=1;
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
                                          S156528=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                            S156528=1;
                                            thread223679(tdone,ends);
                                            thread223680(tdone,ends);
                                            int biggest223681 = 0;
                                            if(ends[9]>=biggest223681){
                                              biggest223681=ends[9];
                                            }
                                            if(ends[10]>=biggest223681){
                                              biggest223681=ends[10];
                                            }
                                            if(biggest223681 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                              S156528=1;
                                              thread223682(tdone,ends);
                                              thread223683(tdone,ends);
                                              int biggest223684 = 0;
                                              if(ends[9]>=biggest223684){
                                                biggest223684=ends[9];
                                              }
                                              if(ends[10]>=biggest223684){
                                                biggest223684=ends[10];
                                              }
                                              if(biggest223684 == 1){
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155921=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                          S155921=1;
                                          thread223685(tdone,ends);
                                          thread223686(tdone,ends);
                                          thread223687(tdone,ends);
                                          int biggest223688 = 0;
                                          if(ends[6]>=biggest223688){
                                            biggest223688=ends[6];
                                          }
                                          if(ends[7]>=biggest223688){
                                            biggest223688=ends[7];
                                          }
                                          if(ends[8]>=biggest223688){
                                            biggest223688=ends[8];
                                          }
                                          if(biggest223688 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                            S155921=1;
                                            thread223689(tdone,ends);
                                            thread223690(tdone,ends);
                                            thread223691(tdone,ends);
                                            int biggest223692 = 0;
                                            if(ends[6]>=biggest223692){
                                              biggest223692=ends[6];
                                            }
                                            if(ends[7]>=biggest223692){
                                              biggest223692=ends[7];
                                            }
                                            if(ends[8]>=biggest223692){
                                              biggest223692=ends[8];
                                            }
                                            if(biggest223692 == 1){
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155572=0;
                                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                                        S155572=1;
                                        thread223693(tdone,ends);
                                        thread223694(tdone,ends);
                                        int biggest223695 = 0;
                                        if(ends[4]>=biggest223695){
                                          biggest223695=ends[4];
                                        }
                                        if(ends[5]>=biggest223695){
                                          biggest223695=ends[5];
                                        }
                                        if(biggest223695 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                          S155572=1;
                                          thread223696(tdone,ends);
                                          thread223697(tdone,ends);
                                          int biggest223698 = 0;
                                          if(ends[4]>=biggest223698){
                                            biggest223698=ends[4];
                                          }
                                          if(ends[5]>=biggest223698){
                                            biggest223698=ends[5];
                                          }
                                          if(biggest223698 == 1){
                                            active[3]=1;
                                            ends[3]=1;
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
                                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
                                    currsigs.addElement(cylClampBottleExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 45
                                    S155499=1;
                                    if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                      S155499=2;
                                      if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                                        S155499=3;
                                        if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                          S155499=4;
                                          if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                            S155499=5;
                                            if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                              w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                              System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                              level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                              if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                                level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                                }
                                                S155499=6;
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                    S155494=2;
                                                    S165289=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165289=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S165284=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S165284=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          S166824=1;
                                                          active[3]=1;
                                                          ends[3]=1;
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
                                                  S155494=2;
                                                  S165289=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165289=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S165284=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165284=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S166824=1;
                                                        active[3]=1;
                                                        ends[3]=1;
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
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                                }
                                                S155499=6;
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                    S155494=2;
                                                    S165289=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165289=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S165284=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S165284=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                          S166824=1;
                                                          active[3]=1;
                                                          ends[3]=1;
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
                                                  S155494=2;
                                                  S165289=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165289=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S165284=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165284=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S166824=1;
                                                        active[3]=1;
                                                        ends[3]=1;
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
                                            S156528=0;
                                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                              S156528=1;
                                              thread223699(tdone,ends);
                                              thread223700(tdone,ends);
                                              int biggest223701 = 0;
                                              if(ends[9]>=biggest223701){
                                                biggest223701=ends[9];
                                              }
                                              if(ends[10]>=biggest223701){
                                                biggest223701=ends[10];
                                              }
                                              if(biggest223701 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                                S156528=1;
                                                thread223702(tdone,ends);
                                                thread223703(tdone,ends);
                                                int biggest223704 = 0;
                                                if(ends[9]>=biggest223704){
                                                  biggest223704=ends[9];
                                                }
                                                if(ends[10]>=biggest223704){
                                                  biggest223704=ends[10];
                                                }
                                                if(biggest223704 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
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
                                          S155921=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                            S155921=1;
                                            thread223705(tdone,ends);
                                            thread223706(tdone,ends);
                                            thread223707(tdone,ends);
                                            int biggest223708 = 0;
                                            if(ends[6]>=biggest223708){
                                              biggest223708=ends[6];
                                            }
                                            if(ends[7]>=biggest223708){
                                              biggest223708=ends[7];
                                            }
                                            if(ends[8]>=biggest223708){
                                              biggest223708=ends[8];
                                            }
                                            if(biggest223708 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                              S155921=1;
                                              thread223709(tdone,ends);
                                              thread223710(tdone,ends);
                                              thread223711(tdone,ends);
                                              int biggest223712 = 0;
                                              if(ends[6]>=biggest223712){
                                                biggest223712=ends[6];
                                              }
                                              if(ends[7]>=biggest223712){
                                                biggest223712=ends[7];
                                              }
                                              if(ends[8]>=biggest223712){
                                                biggest223712=ends[8];
                                              }
                                              if(biggest223712 == 1){
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155572=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                                          S155572=1;
                                          thread223713(tdone,ends);
                                          thread223714(tdone,ends);
                                          int biggest223715 = 0;
                                          if(ends[4]>=biggest223715){
                                            biggest223715=ends[4];
                                          }
                                          if(ends[5]>=biggest223715){
                                            biggest223715=ends[5];
                                          }
                                          if(biggest223715 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                            S155572=1;
                                            thread223716(tdone,ends);
                                            thread223717(tdone,ends);
                                            int biggest223718 = 0;
                                            if(ends[4]>=biggest223718){
                                              biggest223718=ends[4];
                                            }
                                            if(ends[5]>=biggest223718){
                                              biggest223718=ends[5];
                                            }
                                            if(biggest223718 == 1){
                                              active[3]=1;
                                              ends[3]=1;
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
                                      cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
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
                              }
                              else {
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                      S155478=1;
                      S155478=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 81, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
                        S155478=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S155473=0;
                        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
                          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 81, column: 5
                          S155473=1;
                          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
                            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 81, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 82, column: 5
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 90, column: 5
                            S155494=1;
                            if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 92, column: 8
                              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 93, column: 6
                              S155499=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 22
                                S155499=1;
                                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                  S155499=2;
                                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                                    S155499=3;
                                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                      S155499=4;
                                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                        S155499=5;
                                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                            }
                                            S155499=6;
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                S155494=2;
                                                S165289=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  S165289=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S165284=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165284=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S166824=1;
                                                      active[3]=1;
                                                      ends[3]=1;
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
                                              S155494=2;
                                              S165289=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                S165289=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S165284=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  S165284=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S166824=1;
                                                    active[3]=1;
                                                    ends[3]=1;
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
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                            }
                                            S155499=6;
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                S155494=2;
                                                S165289=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  S165289=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S165284=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165284=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S166824=1;
                                                      active[3]=1;
                                                      ends[3]=1;
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
                                              S155494=2;
                                              S165289=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                S165289=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S165284=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  S165284=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S166824=1;
                                                    active[3]=1;
                                                    ends[3]=1;
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
                                        S156528=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                          S156528=1;
                                          thread223719(tdone,ends);
                                          thread223720(tdone,ends);
                                          int biggest223721 = 0;
                                          if(ends[9]>=biggest223721){
                                            biggest223721=ends[9];
                                          }
                                          if(ends[10]>=biggest223721){
                                            biggest223721=ends[10];
                                          }
                                          if(biggest223721 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                            S156528=1;
                                            thread223722(tdone,ends);
                                            thread223723(tdone,ends);
                                            int biggest223724 = 0;
                                            if(ends[9]>=biggest223724){
                                              biggest223724=ends[9];
                                            }
                                            if(ends[10]>=biggest223724){
                                              biggest223724=ends[10];
                                            }
                                            if(biggest223724 == 1){
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155921=0;
                                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                        S155921=1;
                                        thread223725(tdone,ends);
                                        thread223726(tdone,ends);
                                        thread223727(tdone,ends);
                                        int biggest223728 = 0;
                                        if(ends[6]>=biggest223728){
                                          biggest223728=ends[6];
                                        }
                                        if(ends[7]>=biggest223728){
                                          biggest223728=ends[7];
                                        }
                                        if(ends[8]>=biggest223728){
                                          biggest223728=ends[8];
                                        }
                                        if(biggest223728 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                          S155921=1;
                                          thread223729(tdone,ends);
                                          thread223730(tdone,ends);
                                          thread223731(tdone,ends);
                                          int biggest223732 = 0;
                                          if(ends[6]>=biggest223732){
                                            biggest223732=ends[6];
                                          }
                                          if(ends[7]>=biggest223732){
                                            biggest223732=ends[7];
                                          }
                                          if(ends[8]>=biggest223732){
                                            biggest223732=ends[8];
                                          }
                                          if(biggest223732 == 1){
                                            active[3]=1;
                                            ends[3]=1;
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
                                    S155572=0;
                                    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                                      S155572=1;
                                      thread223733(tdone,ends);
                                      thread223734(tdone,ends);
                                      int biggest223735 = 0;
                                      if(ends[4]>=biggest223735){
                                        biggest223735=ends[4];
                                      }
                                      if(ends[5]>=biggest223735){
                                        biggest223735=ends[5];
                                      }
                                      if(biggest223735 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                        S155572=1;
                                        thread223736(tdone,ends);
                                        thread223737(tdone,ends);
                                        int biggest223738 = 0;
                                        if(ends[4]>=biggest223738){
                                          biggest223738=ends[4];
                                        }
                                        if(ends[5]>=biggest223738){
                                          biggest223738=ends[5];
                                        }
                                        if(biggest223738 == 1){
                                          active[3]=1;
                                          ends[3]=1;
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
                                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
                                  currsigs.addElement(cylClampBottleExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 45
                                  S155499=1;
                                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                                    S155499=2;
                                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                                      S155499=3;
                                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                        S155499=4;
                                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                          S155499=5;
                                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                              }
                                              S155499=6;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                  S155494=2;
                                                  S165289=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165289=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S165284=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165284=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S166824=1;
                                                        active[3]=1;
                                                        ends[3]=1;
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
                                                S155494=2;
                                                S165289=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  S165289=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S165284=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165284=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S166824=1;
                                                      active[3]=1;
                                                      ends[3]=1;
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
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                              }
                                              S155499=6;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                                  S155494=2;
                                                  S165289=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165289=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S165284=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S165284=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                        S166824=1;
                                                        active[3]=1;
                                                        ends[3]=1;
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
                                                S155494=2;
                                                S165289=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                  S165289=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S165284=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                                    S165284=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                      S166824=1;
                                                      active[3]=1;
                                                      ends[3]=1;
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
                                          S156528=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                            S156528=1;
                                            thread223739(tdone,ends);
                                            thread223740(tdone,ends);
                                            int biggest223741 = 0;
                                            if(ends[9]>=biggest223741){
                                              biggest223741=ends[9];
                                            }
                                            if(ends[10]>=biggest223741){
                                              biggest223741=ends[10];
                                            }
                                            if(biggest223741 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                              S156528=1;
                                              thread223742(tdone,ends);
                                              thread223743(tdone,ends);
                                              int biggest223744 = 0;
                                              if(ends[9]>=biggest223744){
                                                biggest223744=ends[9];
                                              }
                                              if(ends[10]>=biggest223744){
                                                biggest223744=ends[10];
                                              }
                                              if(biggest223744 == 1){
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155921=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                          S155921=1;
                                          thread223745(tdone,ends);
                                          thread223746(tdone,ends);
                                          thread223747(tdone,ends);
                                          int biggest223748 = 0;
                                          if(ends[6]>=biggest223748){
                                            biggest223748=ends[6];
                                          }
                                          if(ends[7]>=biggest223748){
                                            biggest223748=ends[7];
                                          }
                                          if(ends[8]>=biggest223748){
                                            biggest223748=ends[8];
                                          }
                                          if(biggest223748 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                            S155921=1;
                                            thread223749(tdone,ends);
                                            thread223750(tdone,ends);
                                            thread223751(tdone,ends);
                                            int biggest223752 = 0;
                                            if(ends[6]>=biggest223752){
                                              biggest223752=ends[6];
                                            }
                                            if(ends[7]>=biggest223752){
                                              biggest223752=ends[7];
                                            }
                                            if(ends[8]>=biggest223752){
                                              biggest223752=ends[8];
                                            }
                                            if(biggest223752 == 1){
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155572=0;
                                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                                        S155572=1;
                                        thread223753(tdone,ends);
                                        thread223754(tdone,ends);
                                        int biggest223755 = 0;
                                        if(ends[4]>=biggest223755){
                                          biggest223755=ends[4];
                                        }
                                        if(ends[5]>=biggest223755){
                                          biggest223755=ends[5];
                                        }
                                        if(biggest223755 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                          S155572=1;
                                          thread223756(tdone,ends);
                                          thread223757(tdone,ends);
                                          int biggest223758 = 0;
                                          if(ends[4]>=biggest223758){
                                            biggest223758=ends[4];
                                          }
                                          if(ends[5]>=biggest223758){
                                            biggest223758=ends[5];
                                          }
                                          if(biggest223758 == 1){
                                            active[3]=1;
                                            ends[3]=1;
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
                                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
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
                            }
                            else {
                              S155494=2;
                              S165289=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165289=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S165284=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165284=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S166824=1;
                                    active[3]=1;
                                    ends[3]=1;
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
                  switch(S155499){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 22
                        S155499=1;
                        if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                          S155499=2;
                          if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                            S155499=3;
                            if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                              S155499=4;
                              if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                S155499=5;
                                if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                  w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                  System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                  level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                    }
                                    S155499=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                    }
                                    S155499=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                S156528=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                  S156528=1;
                                  thread223759(tdone,ends);
                                  thread223760(tdone,ends);
                                  int biggest223761 = 0;
                                  if(ends[9]>=biggest223761){
                                    biggest223761=ends[9];
                                  }
                                  if(ends[10]>=biggest223761){
                                    biggest223761=ends[10];
                                  }
                                  if(biggest223761 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                    S156528=1;
                                    thread223762(tdone,ends);
                                    thread223763(tdone,ends);
                                    int biggest223764 = 0;
                                    if(ends[9]>=biggest223764){
                                      biggest223764=ends[9];
                                    }
                                    if(ends[10]>=biggest223764){
                                      biggest223764=ends[10];
                                    }
                                    if(biggest223764 == 1){
                                      active[3]=1;
                                      ends[3]=1;
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
                              S155921=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                S155921=1;
                                thread223765(tdone,ends);
                                thread223766(tdone,ends);
                                thread223767(tdone,ends);
                                int biggest223768 = 0;
                                if(ends[6]>=biggest223768){
                                  biggest223768=ends[6];
                                }
                                if(ends[7]>=biggest223768){
                                  biggest223768=ends[7];
                                }
                                if(ends[8]>=biggest223768){
                                  biggest223768=ends[8];
                                }
                                if(biggest223768 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                  S155921=1;
                                  thread223769(tdone,ends);
                                  thread223770(tdone,ends);
                                  thread223771(tdone,ends);
                                  int biggest223772 = 0;
                                  if(ends[6]>=biggest223772){
                                    biggest223772=ends[6];
                                  }
                                  if(ends[7]>=biggest223772){
                                    biggest223772=ends[7];
                                  }
                                  if(ends[8]>=biggest223772){
                                    biggest223772=ends[8];
                                  }
                                  if(biggest223772 == 1){
                                    active[3]=1;
                                    ends[3]=1;
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
                            S155572=0;
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                              S155572=1;
                              thread223773(tdone,ends);
                              thread223774(tdone,ends);
                              int biggest223775 = 0;
                              if(ends[4]>=biggest223775){
                                biggest223775=ends[4];
                              }
                              if(ends[5]>=biggest223775){
                                biggest223775=ends[5];
                              }
                              if(biggest223775 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                S155572=1;
                                thread223776(tdone,ends);
                                thread223777(tdone,ends);
                                int biggest223778 = 0;
                                if(ends[4]>=biggest223778){
                                  biggest223778=ends[4];
                                }
                                if(ends[5]>=biggest223778){
                                  biggest223778=ends[5];
                                }
                                if(biggest223778 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
                          currsigs.addElement(cylClampBottleExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 45
                          S155499=1;
                          if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                            S155499=2;
                            if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                              S155499=3;
                              if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                S155499=4;
                                if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                  S155499=5;
                                  if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                    w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                    if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                      }
                                      S155499=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                          S155494=2;
                                          S165289=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165289=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S165284=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S165284=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                S166824=1;
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                      }
                                      S155499=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                          S155494=2;
                                          S165289=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165289=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S165284=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S165284=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                S166824=1;
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                  S156528=0;
                                  if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                    S156528=1;
                                    thread223779(tdone,ends);
                                    thread223780(tdone,ends);
                                    int biggest223781 = 0;
                                    if(ends[9]>=biggest223781){
                                      biggest223781=ends[9];
                                    }
                                    if(ends[10]>=biggest223781){
                                      biggest223781=ends[10];
                                    }
                                    if(biggest223781 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                      S156528=1;
                                      thread223782(tdone,ends);
                                      thread223783(tdone,ends);
                                      int biggest223784 = 0;
                                      if(ends[9]>=biggest223784){
                                        biggest223784=ends[9];
                                      }
                                      if(ends[10]>=biggest223784){
                                        biggest223784=ends[10];
                                      }
                                      if(biggest223784 == 1){
                                        active[3]=1;
                                        ends[3]=1;
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
                                S155921=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                  S155921=1;
                                  thread223785(tdone,ends);
                                  thread223786(tdone,ends);
                                  thread223787(tdone,ends);
                                  int biggest223788 = 0;
                                  if(ends[6]>=biggest223788){
                                    biggest223788=ends[6];
                                  }
                                  if(ends[7]>=biggest223788){
                                    biggest223788=ends[7];
                                  }
                                  if(ends[8]>=biggest223788){
                                    biggest223788=ends[8];
                                  }
                                  if(biggest223788 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                    S155921=1;
                                    thread223789(tdone,ends);
                                    thread223790(tdone,ends);
                                    thread223791(tdone,ends);
                                    int biggest223792 = 0;
                                    if(ends[6]>=biggest223792){
                                      biggest223792=ends[6];
                                    }
                                    if(ends[7]>=biggest223792){
                                      biggest223792=ends[7];
                                    }
                                    if(ends[8]>=biggest223792){
                                      biggest223792=ends[8];
                                    }
                                    if(biggest223792 == 1){
                                      active[3]=1;
                                      ends[3]=1;
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
                              S155572=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                                S155572=1;
                                thread223793(tdone,ends);
                                thread223794(tdone,ends);
                                int biggest223795 = 0;
                                if(ends[4]>=biggest223795){
                                  biggest223795=ends[4];
                                }
                                if(ends[5]>=biggest223795){
                                  biggest223795=ends[5];
                                }
                                if(biggest223795 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                  S155572=1;
                                  thread223796(tdone,ends);
                                  thread223797(tdone,ends);
                                  int biggest223798 = 0;
                                  if(ends[4]>=biggest223798){
                                    biggest223798=ends[4];
                                  }
                                  if(ends[5]>=biggest223798){
                                    biggest223798=ends[5];
                                  }
                                  if(biggest223798 == 1){
                                    active[3]=1;
                                    ends[3]=1;
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
                            cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
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
                      break;
                    
                    case 1 : 
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                        S155499=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                          S155499=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                            S155499=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                              S155499=5;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                  }
                                  S155499=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                    S155494=2;
                                    S165289=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165289=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S165284=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165284=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S166824=1;
                                          active[3]=1;
                                          ends[3]=1;
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
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                  }
                                  S155499=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                    S155494=2;
                                    S165289=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165289=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S165284=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165284=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S166824=1;
                                          active[3]=1;
                                          ends[3]=1;
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
                              S156528=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                S156528=1;
                                thread223799(tdone,ends);
                                thread223800(tdone,ends);
                                int biggest223801 = 0;
                                if(ends[9]>=biggest223801){
                                  biggest223801=ends[9];
                                }
                                if(ends[10]>=biggest223801){
                                  biggest223801=ends[10];
                                }
                                if(biggest223801 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                  S156528=1;
                                  thread223802(tdone,ends);
                                  thread223803(tdone,ends);
                                  int biggest223804 = 0;
                                  if(ends[9]>=biggest223804){
                                    biggest223804=ends[9];
                                  }
                                  if(ends[10]>=biggest223804){
                                    biggest223804=ends[10];
                                  }
                                  if(biggest223804 == 1){
                                    active[3]=1;
                                    ends[3]=1;
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
                            S155921=0;
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                              S155921=1;
                              thread223805(tdone,ends);
                              thread223806(tdone,ends);
                              thread223807(tdone,ends);
                              int biggest223808 = 0;
                              if(ends[6]>=biggest223808){
                                biggest223808=ends[6];
                              }
                              if(ends[7]>=biggest223808){
                                biggest223808=ends[7];
                              }
                              if(ends[8]>=biggest223808){
                                biggest223808=ends[8];
                              }
                              if(biggest223808 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                S155921=1;
                                thread223809(tdone,ends);
                                thread223810(tdone,ends);
                                thread223811(tdone,ends);
                                int biggest223812 = 0;
                                if(ends[6]>=biggest223812){
                                  biggest223812=ends[6];
                                }
                                if(ends[7]>=biggest223812){
                                  biggest223812=ends[7];
                                }
                                if(ends[8]>=biggest223812){
                                  biggest223812=ends[8];
                                }
                                if(biggest223812 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                          S155572=0;
                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                            S155572=1;
                            thread223813(tdone,ends);
                            thread223814(tdone,ends);
                            int biggest223815 = 0;
                            if(ends[4]>=biggest223815){
                              biggest223815=ends[4];
                            }
                            if(ends[5]>=biggest223815){
                              biggest223815=ends[5];
                            }
                            if(biggest223815 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                              S155572=1;
                              thread223816(tdone,ends);
                              thread223817(tdone,ends);
                              int biggest223818 = 0;
                              if(ends[4]>=biggest223818){
                                biggest223818=ends[4];
                              }
                              if(ends[5]>=biggest223818){
                                biggest223818=ends[5];
                              }
                              if(biggest223818 == 1){
                                active[3]=1;
                                ends[3]=1;
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
                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
                        currsigs.addElement(cylClampBottleExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                        S155499=3;
                        if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                          S155499=4;
                          if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                            S155499=5;
                            if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                              w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                              System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                              level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                              if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                }
                                S155499=6;
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                    S155494=2;
                                    S165289=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165289=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S165284=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165284=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S166824=1;
                                          active[3]=1;
                                          ends[3]=1;
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
                                  S155494=2;
                                  S165289=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165289=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S165284=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165284=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S166824=1;
                                        active[3]=1;
                                        ends[3]=1;
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
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                }
                                S155499=6;
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                    S155494=2;
                                    S165289=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165289=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S165284=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165284=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S166824=1;
                                          active[3]=1;
                                          ends[3]=1;
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
                                  S155494=2;
                                  S165289=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165289=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S165284=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165284=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S166824=1;
                                        active[3]=1;
                                        ends[3]=1;
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
                            S156528=0;
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                              S156528=1;
                              thread223819(tdone,ends);
                              thread223820(tdone,ends);
                              int biggest223821 = 0;
                              if(ends[9]>=biggest223821){
                                biggest223821=ends[9];
                              }
                              if(ends[10]>=biggest223821){
                                biggest223821=ends[10];
                              }
                              if(biggest223821 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                S156528=1;
                                thread223822(tdone,ends);
                                thread223823(tdone,ends);
                                int biggest223824 = 0;
                                if(ends[9]>=biggest223824){
                                  biggest223824=ends[9];
                                }
                                if(ends[10]>=biggest223824){
                                  biggest223824=ends[10];
                                }
                                if(biggest223824 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                          S155921=0;
                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                            S155921=1;
                            thread223825(tdone,ends);
                            thread223826(tdone,ends);
                            thread223827(tdone,ends);
                            int biggest223828 = 0;
                            if(ends[6]>=biggest223828){
                              biggest223828=ends[6];
                            }
                            if(ends[7]>=biggest223828){
                              biggest223828=ends[7];
                            }
                            if(ends[8]>=biggest223828){
                              biggest223828=ends[8];
                            }
                            if(biggest223828 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                              S155921=1;
                              thread223829(tdone,ends);
                              thread223830(tdone,ends);
                              thread223831(tdone,ends);
                              int biggest223832 = 0;
                              if(ends[6]>=biggest223832){
                                biggest223832=ends[6];
                              }
                              if(ends[7]>=biggest223832){
                                biggest223832=ends[7];
                              }
                              if(ends[8]>=biggest223832){
                                biggest223832=ends[8];
                              }
                              if(biggest223832 == 1){
                                active[3]=1;
                                ends[3]=1;
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
                        switch(S155572){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                              S155572=1;
                              thread223833(tdone,ends);
                              thread223834(tdone,ends);
                              int biggest223835 = 0;
                              if(ends[4]>=biggest223835){
                                biggest223835=ends[4];
                              }
                              if(ends[5]>=biggest223835){
                                biggest223835=ends[5];
                              }
                              if(biggest223835 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                S155572=1;
                                thread223836(tdone,ends);
                                thread223837(tdone,ends);
                                int biggest223838 = 0;
                                if(ends[4]>=biggest223838){
                                  biggest223838=ends[4];
                                }
                                if(ends[5]>=biggest223838){
                                  biggest223838=ends[5];
                                }
                                if(biggest223838 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                          
                          case 1 : 
                            thread223839(tdone,ends);
                            thread223840(tdone,ends);
                            int biggest223841 = 0;
                            if(ends[4]>=biggest223841){
                              biggest223841=ends[4];
                            }
                            if(ends[5]>=biggest223841){
                              biggest223841=ends[5];
                            }
                            if(biggest223841 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest223841 == 0){
                              S155499=3;
                              if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                S155499=4;
                                if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                  S155499=5;
                                  if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                    w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                    if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                      }
                                      S155499=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                          S155494=2;
                                          S165289=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165289=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S165284=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S165284=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                S166824=1;
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                      }
                                      S155499=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                          S155494=2;
                                          S165289=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165289=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S165284=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S165284=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                S166824=1;
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                  S156528=0;
                                  if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                    S156528=1;
                                    thread223842(tdone,ends);
                                    thread223843(tdone,ends);
                                    int biggest223844 = 0;
                                    if(ends[9]>=biggest223844){
                                      biggest223844=ends[9];
                                    }
                                    if(ends[10]>=biggest223844){
                                      biggest223844=ends[10];
                                    }
                                    if(biggest223844 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                      S156528=1;
                                      thread223845(tdone,ends);
                                      thread223846(tdone,ends);
                                      int biggest223847 = 0;
                                      if(ends[9]>=biggest223847){
                                        biggest223847=ends[9];
                                      }
                                      if(ends[10]>=biggest223847){
                                        biggest223847=ends[10];
                                      }
                                      if(biggest223847 == 1){
                                        active[3]=1;
                                        ends[3]=1;
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
                                S155921=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                  S155921=1;
                                  thread223848(tdone,ends);
                                  thread223849(tdone,ends);
                                  thread223850(tdone,ends);
                                  int biggest223851 = 0;
                                  if(ends[6]>=biggest223851){
                                    biggest223851=ends[6];
                                  }
                                  if(ends[7]>=biggest223851){
                                    biggest223851=ends[7];
                                  }
                                  if(ends[8]>=biggest223851){
                                    biggest223851=ends[8];
                                  }
                                  if(biggest223851 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                    S155921=1;
                                    thread223852(tdone,ends);
                                    thread223853(tdone,ends);
                                    thread223854(tdone,ends);
                                    int biggest223855 = 0;
                                    if(ends[6]>=biggest223855){
                                      biggest223855=ends[6];
                                    }
                                    if(ends[7]>=biggest223855){
                                      biggest223855=ends[7];
                                    }
                                    if(ends[8]>=biggest223855){
                                      biggest223855=ends[8];
                                    }
                                    if(biggest223855 == 1){
                                      active[3]=1;
                                      ends[3]=1;
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
                      }
                      break;
                    
                    case 3 : 
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                        S155499=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                          S155499=5;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                              }
                              S155499=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                  S155494=2;
                                  S165289=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165289=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S165284=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165284=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S166824=1;
                                        active[3]=1;
                                        ends[3]=1;
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
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                              }
                              S155499=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                  S155494=2;
                                  S165289=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165289=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S165284=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165284=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S166824=1;
                                        active[3]=1;
                                        ends[3]=1;
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
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                          S156528=0;
                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                            S156528=1;
                            thread223856(tdone,ends);
                            thread223857(tdone,ends);
                            int biggest223858 = 0;
                            if(ends[9]>=biggest223858){
                              biggest223858=ends[9];
                            }
                            if(ends[10]>=biggest223858){
                              biggest223858=ends[10];
                            }
                            if(biggest223858 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                              S156528=1;
                              thread223859(tdone,ends);
                              thread223860(tdone,ends);
                              int biggest223861 = 0;
                              if(ends[9]>=biggest223861){
                                biggest223861=ends[9];
                              }
                              if(ends[10]>=biggest223861){
                                biggest223861=ends[10];
                              }
                              if(biggest223861 == 1){
                                active[3]=1;
                                ends[3]=1;
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
                        switch(S155921){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                              S155921=1;
                              thread223862(tdone,ends);
                              thread223863(tdone,ends);
                              thread223864(tdone,ends);
                              int biggest223865 = 0;
                              if(ends[6]>=biggest223865){
                                biggest223865=ends[6];
                              }
                              if(ends[7]>=biggest223865){
                                biggest223865=ends[7];
                              }
                              if(ends[8]>=biggest223865){
                                biggest223865=ends[8];
                              }
                              if(biggest223865 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                S155921=1;
                                thread223866(tdone,ends);
                                thread223867(tdone,ends);
                                thread223868(tdone,ends);
                                int biggest223869 = 0;
                                if(ends[6]>=biggest223869){
                                  biggest223869=ends[6];
                                }
                                if(ends[7]>=biggest223869){
                                  biggest223869=ends[7];
                                }
                                if(ends[8]>=biggest223869){
                                  biggest223869=ends[8];
                                }
                                if(biggest223869 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                          
                          case 1 : 
                            thread223870(tdone,ends);
                            thread223871(tdone,ends);
                            thread223872(tdone,ends);
                            int biggest223873 = 0;
                            if(ends[6]>=biggest223873){
                              biggest223873=ends[6];
                            }
                            if(ends[7]>=biggest223873){
                              biggest223873=ends[7];
                            }
                            if(ends[8]>=biggest223873){
                              biggest223873=ends[8];
                            }
                            if(biggest223873 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest223873 == 0){
                              S155499=4;
                              if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                S155499=5;
                                if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                  w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                  System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                  level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                    }
                                    S155499=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                    }
                                    S155499=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                S156528=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                  S156528=1;
                                  thread223874(tdone,ends);
                                  thread223875(tdone,ends);
                                  int biggest223876 = 0;
                                  if(ends[9]>=biggest223876){
                                    biggest223876=ends[9];
                                  }
                                  if(ends[10]>=biggest223876){
                                    biggest223876=ends[10];
                                  }
                                  if(biggest223876 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                    S156528=1;
                                    thread223877(tdone,ends);
                                    thread223878(tdone,ends);
                                    int biggest223879 = 0;
                                    if(ends[9]>=biggest223879){
                                      biggest223879=ends[9];
                                    }
                                    if(ends[10]>=biggest223879){
                                      biggest223879=ends[10];
                                    }
                                    if(biggest223879 == 1){
                                      active[3]=1;
                                      ends[3]=1;
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
                      }
                      break;
                    
                    case 4 : 
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                        S155499=5;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                            }
                            S155499=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                              S155494=2;
                              S165289=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165289=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S165284=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165284=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S166824=1;
                                    active[3]=1;
                                    ends[3]=1;
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
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                            }
                            S155499=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                              S155494=2;
                              S165289=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165289=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S165284=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165284=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S166824=1;
                                    active[3]=1;
                                    ends[3]=1;
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
                        switch(S156528){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                              S156528=1;
                              thread223880(tdone,ends);
                              thread223881(tdone,ends);
                              int biggest223882 = 0;
                              if(ends[9]>=biggest223882){
                                biggest223882=ends[9];
                              }
                              if(ends[10]>=biggest223882){
                                biggest223882=ends[10];
                              }
                              if(biggest223882 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                S156528=1;
                                thread223883(tdone,ends);
                                thread223884(tdone,ends);
                                int biggest223885 = 0;
                                if(ends[9]>=biggest223885){
                                  biggest223885=ends[9];
                                }
                                if(ends[10]>=biggest223885){
                                  biggest223885=ends[10];
                                }
                                if(biggest223885 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                          
                          case 1 : 
                            thread223886(tdone,ends);
                            thread223887(tdone,ends);
                            int biggest223888 = 0;
                            if(ends[9]>=biggest223888){
                              biggest223888=ends[9];
                            }
                            if(ends[10]>=biggest223888){
                              biggest223888=ends[10];
                            }
                            if(biggest223888 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest223888 == 0){
                              S155499=5;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                  }
                                  S155499=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                    S155494=2;
                                    S165289=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165289=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S165284=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165284=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S166824=1;
                                          active[3]=1;
                                          ends[3]=1;
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
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                  }
                                  S155499=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                    S155494=2;
                                    S165289=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165289=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S165284=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165284=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S166824=1;
                                          active[3]=1;
                                          ends[3]=1;
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
                            break;
                          
                        }
                      }
                      break;
                    
                    case 5 : 
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                          }
                          S155499=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 142, column: 22
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                              S155494=2;
                              S165289=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165289=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S165284=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165284=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S166824=1;
                                    active[3]=1;
                                    ends[3]=1;
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
                            S155494=2;
                            S165289=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                              S165289=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S165284=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165284=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S166824=1;
                                  active[3]=1;
                                  ends[3]=1;
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
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                          }
                          S155499=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 142, column: 22
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                              S155494=2;
                              S165289=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165289=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S165284=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165284=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S166824=1;
                                    active[3]=1;
                                    ends[3]=1;
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
                            S155494=2;
                            S165289=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                              S165289=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S165284=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165284=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S166824=1;
                                  active[3]=1;
                                  ends[3]=1;
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
                      if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 144, column: 34
                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 144, column: 51
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\liquidDumperController.sysj line: 142, column: 22
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                          S155494=2;
                          S165289=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                            S165289=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S165284=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                              S165284=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                S166824=1;
                                active[3]=1;
                                ends[3]=1;
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
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\liquidDumperController.sysj line: 142, column: 22
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                          S155494=2;
                          S165289=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                            S165289=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S165284=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                              S165284=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                S166824=1;
                                active[3]=1;
                                ends[3]=1;
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
                  switch(S165289){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                        S165289=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S165284){
                          case 0 : 
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                              S165284=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                S166824=1;
                                active[3]=1;
                                ends[3]=1;
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
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                              S166824=1;
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
                      S165289=1;
                      S165289=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                        S165289=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S165284=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                          S165284=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                            S166824=1;
                            active[3]=1;
                            ends[3]=1;
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
                  S166824=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 1 : 
            S166824=1;
            S166824=0;
            if(reset.getprestatus()){//sysj\liquidDumperController.sysj line: 80, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S166824=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S155494=0;
              S155478=0;
              if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 81, column: 5
                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
                S155478=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S155473=0;
                if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
                  enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 81, column: 5
                  S155473=1;
                  if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
                    enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
                    ends[3]=2;
                    ;//sysj\liquidDumperController.sysj line: 81, column: 5
                    w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 82, column: 5
                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 90, column: 5
                    S155494=1;
                    if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 92, column: 8
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 93, column: 6
                      S155499=0;
                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 22
                        S155499=1;
                        if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                          S155499=2;
                          if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                            S155499=3;
                            if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                              S155499=4;
                              if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                S155499=5;
                                if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                  w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                  System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                  level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                    }
                                    S155499=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                    }
                                    S155499=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      S155494=2;
                                      S165289=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S165289=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S165284=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165284=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S166824=1;
                                            active[3]=1;
                                            ends[3]=1;
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
                                S156528=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                  S156528=1;
                                  thread223889(tdone,ends);
                                  thread223890(tdone,ends);
                                  int biggest223891 = 0;
                                  if(ends[9]>=biggest223891){
                                    biggest223891=ends[9];
                                  }
                                  if(ends[10]>=biggest223891){
                                    biggest223891=ends[10];
                                  }
                                  if(biggest223891 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                    S156528=1;
                                    thread223892(tdone,ends);
                                    thread223893(tdone,ends);
                                    int biggest223894 = 0;
                                    if(ends[9]>=biggest223894){
                                      biggest223894=ends[9];
                                    }
                                    if(ends[10]>=biggest223894){
                                      biggest223894=ends[10];
                                    }
                                    if(biggest223894 == 1){
                                      active[3]=1;
                                      ends[3]=1;
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
                              S155921=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                S155921=1;
                                thread223895(tdone,ends);
                                thread223896(tdone,ends);
                                thread223897(tdone,ends);
                                int biggest223898 = 0;
                                if(ends[6]>=biggest223898){
                                  biggest223898=ends[6];
                                }
                                if(ends[7]>=biggest223898){
                                  biggest223898=ends[7];
                                }
                                if(ends[8]>=biggest223898){
                                  biggest223898=ends[8];
                                }
                                if(biggest223898 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                  S155921=1;
                                  thread223899(tdone,ends);
                                  thread223900(tdone,ends);
                                  thread223901(tdone,ends);
                                  int biggest223902 = 0;
                                  if(ends[6]>=biggest223902){
                                    biggest223902=ends[6];
                                  }
                                  if(ends[7]>=biggest223902){
                                    biggest223902=ends[7];
                                  }
                                  if(ends[8]>=biggest223902){
                                    biggest223902=ends[8];
                                  }
                                  if(biggest223902 == 1){
                                    active[3]=1;
                                    ends[3]=1;
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
                            S155572=0;
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                              S155572=1;
                              thread223903(tdone,ends);
                              thread223904(tdone,ends);
                              int biggest223905 = 0;
                              if(ends[4]>=biggest223905){
                                biggest223905=ends[4];
                              }
                              if(ends[5]>=biggest223905){
                                biggest223905=ends[5];
                              }
                              if(biggest223905 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                S155572=1;
                                thread223906(tdone,ends);
                                thread223907(tdone,ends);
                                int biggest223908 = 0;
                                if(ends[4]>=biggest223908){
                                  biggest223908=ends[4];
                                }
                                if(ends[5]>=biggest223908){
                                  biggest223908=ends[5];
                                }
                                if(biggest223908 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
                          currsigs.addElement(cylClampBottleExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 45
                          S155499=1;
                          if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                            S155499=2;
                            if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                              S155499=3;
                              if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                                S155499=4;
                                if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                                  S155499=5;
                                  if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                                    w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                                    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                                    if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                      }
                                      S155499=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                          S155494=2;
                                          S165289=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165289=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S165284=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S165284=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                S166824=1;
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                                      }
                                      S155499=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                          S155494=2;
                                          S165289=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165289=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S165284=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S165284=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                                S166824=1;
                                                active[3]=1;
                                                ends[3]=1;
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
                                        S155494=2;
                                        S165289=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                          S165289=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S165284=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                            S165284=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                              S166824=1;
                                              active[3]=1;
                                              ends[3]=1;
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
                                  S156528=0;
                                  if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                                    S156528=1;
                                    thread223909(tdone,ends);
                                    thread223910(tdone,ends);
                                    int biggest223911 = 0;
                                    if(ends[9]>=biggest223911){
                                      biggest223911=ends[9];
                                    }
                                    if(ends[10]>=biggest223911){
                                      biggest223911=ends[10];
                                    }
                                    if(biggest223911 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                                      S156528=1;
                                      thread223912(tdone,ends);
                                      thread223913(tdone,ends);
                                      int biggest223914 = 0;
                                      if(ends[9]>=biggest223914){
                                        biggest223914=ends[9];
                                      }
                                      if(ends[10]>=biggest223914){
                                        biggest223914=ends[10];
                                      }
                                      if(biggest223914 == 1){
                                        active[3]=1;
                                        ends[3]=1;
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
                                S155921=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                                  S155921=1;
                                  thread223915(tdone,ends);
                                  thread223916(tdone,ends);
                                  thread223917(tdone,ends);
                                  int biggest223918 = 0;
                                  if(ends[6]>=biggest223918){
                                    biggest223918=ends[6];
                                  }
                                  if(ends[7]>=biggest223918){
                                    biggest223918=ends[7];
                                  }
                                  if(ends[8]>=biggest223918){
                                    biggest223918=ends[8];
                                  }
                                  if(biggest223918 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                                    S155921=1;
                                    thread223919(tdone,ends);
                                    thread223920(tdone,ends);
                                    thread223921(tdone,ends);
                                    int biggest223922 = 0;
                                    if(ends[6]>=biggest223922){
                                      biggest223922=ends[6];
                                    }
                                    if(ends[7]>=biggest223922){
                                      biggest223922=ends[7];
                                    }
                                    if(ends[8]>=biggest223922){
                                      biggest223922=ends[8];
                                    }
                                    if(biggest223922 == 1){
                                      active[3]=1;
                                      ends[3]=1;
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
                              S155572=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                                S155572=1;
                                thread223923(tdone,ends);
                                thread223924(tdone,ends);
                                int biggest223925 = 0;
                                if(ends[4]>=biggest223925){
                                  biggest223925=ends[4];
                                }
                                if(ends[5]>=biggest223925){
                                  biggest223925=ends[5];
                                }
                                if(biggest223925 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                                  S155572=1;
                                  thread223926(tdone,ends);
                                  thread223927(tdone,ends);
                                  int biggest223928 = 0;
                                  if(ends[4]>=biggest223928){
                                    biggest223928=ends[4];
                                  }
                                  if(ends[5]>=biggest223928){
                                    biggest223928=ends[5];
                                  }
                                  if(biggest223928 == 1){
                                    active[3]=1;
                                    ends[3]=1;
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
                            cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
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
                    }
                    else {
                      S155494=2;
                      S165289=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                        S165289=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S165284=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                          S165284=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 150, column: 5
                            S166824=1;
                            active[3]=1;
                            ends[3]=1;
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
            break;
          
        }
        break;
      
    }
  }

  public void thread223637(int [] tdone, int [] ends){
        switch(S155470){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\liquidDumperController.sysj line: 59, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\liquidDumperController.sysj line: 60, column: 8
            auto_1.setPresent();//sysj\liquidDumperController.sysj line: 60, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\liquidDumperController.sysj line: 61, column: 12
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

  public void thread223634(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223633(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223631(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223630(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223628(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223627(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223626(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223624(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223623(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223622(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223620(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223619(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223617(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223616(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223614(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223613(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223611(int [] tdone, int [] ends){
        S155531=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread223610(int [] tdone, int [] ends){
        S155526=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 104, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread223608(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223607(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223606(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223604(int [] tdone, int [] ends){
        S155860=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread223603(int [] tdone, int [] ends){
        S155855=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread223602(int [] tdone, int [] ends){
        S155850=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 111, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread223600(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223599(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223597(int [] tdone, int [] ends){
        S156487=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread223596(int [] tdone, int [] ends){
        S156482=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 117, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread223595(int [] tdone, int [] ends){
        S223590=1;
    OK_thread_3 = 0;//sysj\liquidDumperController.sysj line: 68, column: 3
    BLOCKED_thread_3 = 2;//sysj\liquidDumperController.sysj line: 69, column: 3
    WARN_thread_3 = 3;//sysj\liquidDumperController.sysj line: 70, column: 3
    TANK_CAPACITY_thread_3 = RecyclingCapacity.WASTE_TANK;//sysj\liquidDumperController.sysj line: 72, column: 3
    TANK_WARN_thread_3 = RecyclingCapacity.WASTE_TANK_WARN;//sysj\liquidDumperController.sysj line: 73, column: 3
    w_thread_3 = null;//sysj\liquidDumperController.sysj line: 75, column: 3
    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 76, column: 3
    code_thread_3 = 0;//sysj\liquidDumperController.sysj line: 77, column: 3
    S166824=0;
    if(reset.getprestatus()){//sysj\liquidDumperController.sysj line: 80, column: 20
      enable_in.setPreempted();
      status_o.setPreempted();
      S166824=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S155494=0;
      S155478=0;
      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 81, column: 5
        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
        S155478=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S155473=0;
        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 81, column: 5
          S155473=1;
          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 81, column: 5
            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 81, column: 5
            ends[3]=2;
            ;//sysj\liquidDumperController.sysj line: 81, column: 5
            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 82, column: 5
            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 90, column: 5
            S155494=1;
            if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 92, column: 8
              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 93, column: 6
              S155499=0;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 22
                S155499=1;
                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                  S155499=2;
                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                    S155499=3;
                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                      S155499=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                        S155499=5;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                            }
                            S155499=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                              S155494=2;
                              S165289=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165289=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S165284=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165284=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S166824=1;
                                    active[3]=1;
                                    ends[3]=1;
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
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                            }
                            S155499=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                              S155494=2;
                              S165289=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                S165289=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S165284=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165284=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S166824=1;
                                    active[3]=1;
                                    ends[3]=1;
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
                        S156528=0;
                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                          S156528=1;
                          thread223596(tdone,ends);
                          thread223597(tdone,ends);
                          int biggest223598 = 0;
                          if(ends[9]>=biggest223598){
                            biggest223598=ends[9];
                          }
                          if(ends[10]>=biggest223598){
                            biggest223598=ends[10];
                          }
                          if(biggest223598 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                            S156528=1;
                            thread223599(tdone,ends);
                            thread223600(tdone,ends);
                            int biggest223601 = 0;
                            if(ends[9]>=biggest223601){
                              biggest223601=ends[9];
                            }
                            if(ends[10]>=biggest223601){
                              biggest223601=ends[10];
                            }
                            if(biggest223601 == 1){
                              active[3]=1;
                              ends[3]=1;
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
                      S155921=0;
                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                        S155921=1;
                        thread223602(tdone,ends);
                        thread223603(tdone,ends);
                        thread223604(tdone,ends);
                        int biggest223605 = 0;
                        if(ends[6]>=biggest223605){
                          biggest223605=ends[6];
                        }
                        if(ends[7]>=biggest223605){
                          biggest223605=ends[7];
                        }
                        if(ends[8]>=biggest223605){
                          biggest223605=ends[8];
                        }
                        if(biggest223605 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                          S155921=1;
                          thread223606(tdone,ends);
                          thread223607(tdone,ends);
                          thread223608(tdone,ends);
                          int biggest223609 = 0;
                          if(ends[6]>=biggest223609){
                            biggest223609=ends[6];
                          }
                          if(ends[7]>=biggest223609){
                            biggest223609=ends[7];
                          }
                          if(ends[8]>=biggest223609){
                            biggest223609=ends[8];
                          }
                          if(biggest223609 == 1){
                            active[3]=1;
                            ends[3]=1;
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
                    S155572=0;
                    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                      S155572=1;
                      thread223610(tdone,ends);
                      thread223611(tdone,ends);
                      int biggest223612 = 0;
                      if(ends[4]>=biggest223612){
                        biggest223612=ends[4];
                      }
                      if(ends[5]>=biggest223612){
                        biggest223612=ends[5];
                      }
                      if(biggest223612 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                        S155572=1;
                        thread223613(tdone,ends);
                        thread223614(tdone,ends);
                        int biggest223615 = 0;
                        if(ends[4]>=biggest223615){
                          biggest223615=ends[4];
                        }
                        if(ends[5]>=biggest223615){
                          biggest223615=ends[5];
                        }
                        if(biggest223615 == 1){
                          active[3]=1;
                          ends[3]=1;
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
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 96, column: 45
                  S155499=1;
                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 97, column: 22
                    S155499=2;
                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 102, column: 22
                      S155499=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 109, column: 22
                        S155499=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 115, column: 22
                          S155499=5;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 121, column: 22
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 123, column: 6
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 124, column: 6
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 127, column: 6
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 128, column: 14
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 129, column: 7
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                              }
                              S155499=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                  S155494=2;
                                  S165289=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165289=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S165284=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165284=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S166824=1;
                                        active[3]=1;
                                        ends[3]=1;
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
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 132, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 133, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 134, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 135, column: 7
                              }
                              S155499=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 137, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 138, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 139, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 142, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 142, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 146, column: 22
                                  S155494=2;
                                  S165289=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165289=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S165284=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S165284=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                        S166824=1;
                                        active[3]=1;
                                        ends[3]=1;
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
                                S155494=2;
                                S165289=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                  S165289=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S165284=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                                    S165284=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 150, column: 5
                                      S166824=1;
                                      active[3]=1;
                                      ends[3]=1;
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
                          S156528=0;
                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 23
                            S156528=1;
                            thread223616(tdone,ends);
                            thread223617(tdone,ends);
                            int biggest223618 = 0;
                            if(ends[9]>=biggest223618){
                              biggest223618=ends[9];
                            }
                            if(ends[10]>=biggest223618){
                              biggest223618=ends[10];
                            }
                            if(biggest223618 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 116, column: 46
                              S156528=1;
                              thread223619(tdone,ends);
                              thread223620(tdone,ends);
                              int biggest223621 = 0;
                              if(ends[9]>=biggest223621){
                                biggest223621=ends[9];
                              }
                              if(ends[10]>=biggest223621){
                                biggest223621=ends[10];
                              }
                              if(biggest223621 == 1){
                                active[3]=1;
                                ends[3]=1;
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
                        S155921=0;
                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 23
                          S155921=1;
                          thread223622(tdone,ends);
                          thread223623(tdone,ends);
                          thread223624(tdone,ends);
                          int biggest223625 = 0;
                          if(ends[6]>=biggest223625){
                            biggest223625=ends[6];
                          }
                          if(ends[7]>=biggest223625){
                            biggest223625=ends[7];
                          }
                          if(ends[8]>=biggest223625){
                            biggest223625=ends[8];
                          }
                          if(biggest223625 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 110, column: 46
                            S155921=1;
                            thread223626(tdone,ends);
                            thread223627(tdone,ends);
                            thread223628(tdone,ends);
                            int biggest223629 = 0;
                            if(ends[6]>=biggest223629){
                              biggest223629=ends[6];
                            }
                            if(ends[7]>=biggest223629){
                              biggest223629=ends[7];
                            }
                            if(ends[8]>=biggest223629){
                              biggest223629=ends[8];
                            }
                            if(biggest223629 == 1){
                              active[3]=1;
                              ends[3]=1;
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
                      S155572=0;
                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 23
                        S155572=1;
                        thread223630(tdone,ends);
                        thread223631(tdone,ends);
                        int biggest223632 = 0;
                        if(ends[4]>=biggest223632){
                          biggest223632=ends[4];
                        }
                        if(ends[5]>=biggest223632){
                          biggest223632=ends[5];
                        }
                        if(biggest223632 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 103, column: 46
                          S155572=1;
                          thread223633(tdone,ends);
                          thread223634(tdone,ends);
                          int biggest223635 = 0;
                          if(ends[4]>=biggest223635){
                            biggest223635=ends[4];
                          }
                          if(ends[5]>=biggest223635){
                            biggest223635=ends[5];
                          }
                          if(biggest223635 == 1){
                            active[3]=1;
                            ends[3]=1;
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
                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 98, column: 7
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
            }
            else {
              S155494=2;
              S165289=0;
              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 150, column: 5
                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                S165289=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S165284=0;
                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 150, column: 5
                  S165284=1;
                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 150, column: 5
                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 150, column: 5
                    ends[3]=2;
                    ;//sysj\liquidDumperController.sysj line: 150, column: 5
                    S166824=1;
                    active[3]=1;
                    ends[3]=1;
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

  public void thread223594(int [] tdone, int [] ends){
        S155470=1;
    if(mode.getprestatus()){//sysj\liquidDumperController.sysj line: 59, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\liquidDumperController.sysj line: 60, column: 8
        auto_1.setPresent();//sysj\liquidDumperController.sysj line: 60, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\liquidDumperController.sysj line: 61, column: 12
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
      switch(S223592){
        case 0 : 
          S223592=0;
          break RUN;
        
        case 1 : 
          S223592=2;
          S223592=2;
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 55, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 55, column: 2
          thread223594(tdone,ends);
          thread223595(tdone,ends);
          int biggest223636 = 0;
          if(ends[2]>=biggest223636){
            biggest223636=ends[2];
          }
          if(ends[3]>=biggest223636){
            biggest223636=ends[3];
          }
          if(biggest223636 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 55, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 55, column: 2
          thread223637(tdone,ends);
          thread223638(tdone,ends);
          int biggest223929 = 0;
          if(ends[2]>=biggest223929){
            biggest223929=ends[2];
          }
          if(ends[3]>=biggest223929){
            biggest223929=ends[3];
          }
          if(biggest223929 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest223929 == 0){
            S223592=0;
            active[1]=0;
            ends[1]=0;
            S223592=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          reset.gethook();
          clampClosed.gethook();
          bottleInverted.gethook();
          bottleUpright.gethook();
          bottleDrained.gethook();
          wasteTankLevel.gethook();
          cylClampBottleExtendM.gethook();
          invertRotateExtendM.gethook();
          invertRotateRetractM.gethook();
          drainValveOnOffM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
      clampClosed.setpreclear();
      bottleInverted.setpreclear();
      bottleUpright.setpreclear();
      bottleDrained.setpreclear();
      wasteTankLevel.setpreclear();
      cylClampBottleExtendM.setpreclear();
      invertRotateExtendM.setpreclear();
      invertRotateRetractM.setpreclear();
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
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
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
      dummyint = invertRotateRetractM.getStatus() ? invertRotateRetractM.setprepresent() : invertRotateRetractM.setpreclear();
      invertRotateRetractM.setpreval(invertRotateRetractM.getValue());
      invertRotateRetractM.setClear();
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
        reset.gethook();
        clampClosed.gethook();
        bottleInverted.gethook();
        bottleUpright.gethook();
        bottleDrained.gethook();
        wasteTankLevel.gethook();
        cylClampBottleExtendM.gethook();
        invertRotateExtendM.gethook();
        invertRotateRetractM.gethook();
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
