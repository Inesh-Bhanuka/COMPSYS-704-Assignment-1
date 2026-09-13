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
  private int OK_thread_3;//sysj\liquidDumperController.sysj line: 70, column: 3
  private int BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 71, column: 3
  private int WARN_thread_3;//sysj\liquidDumperController.sysj line: 72, column: 3
  private int TANK_CAPACITY_thread_3;//sysj\liquidDumperController.sysj line: 74, column: 3
  private int TANK_WARN_thread_3;//sysj\liquidDumperController.sysj line: 75, column: 3
  private WorkpieceTwin w_thread_3;//sysj\liquidDumperController.sysj line: 77, column: 3
  private int level_thread_3;//sysj\liquidDumperController.sysj line: 78, column: 3
  private int code_thread_3;//sysj\liquidDumperController.sysj line: 79, column: 3
  private int S224879 = 1;
  private int S156757 = 1;
  private int S224877 = 1;
  private int S168111 = 1;
  private int S156781 = 1;
  private int S156765 = 1;
  private int S156760 = 1;
  private int S156786 = 1;
  private int S156859 = 1;
  private int S156813 = 1;
  private int S156818 = 1;
  private int S157208 = 1;
  private int S157137 = 1;
  private int S157142 = 1;
  private int S157147 = 1;
  private int S157815 = 1;
  private int S157769 = 1;
  private int S157774 = 1;
  private int S166576 = 1;
  private int S166571 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread225214(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225213(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225211(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225210(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225208(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225207(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225206(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225204(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225203(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225202(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225200(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225199(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225197(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225196(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225194(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225193(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225191(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225190(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225188(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225187(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225186(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225184(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225183(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225182(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225180(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225179(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225177(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225176(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225174(int [] tdone, int [] ends){
        switch(S157774){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
        currsigs.addElement(invertRotateRetract);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread225173(int [] tdone, int [] ends){
        switch(S157769){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread225171(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225170(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225168(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225167(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225165(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225164(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225162(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225161(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225159(int [] tdone, int [] ends){
        switch(S157147){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
        currsigs.addElement(drainValveOnOff);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread225158(int [] tdone, int [] ends){
        switch(S157142){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
        currsigs.addElement(invertRotateExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread225157(int [] tdone, int [] ends){
        switch(S157137){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread225155(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225154(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225153(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225151(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225150(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225149(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225147(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225146(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225144(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225143(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225141(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225140(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225139(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225137(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225136(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225135(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225133(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225132(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225130(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225129(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225127(int [] tdone, int [] ends){
        switch(S156818){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
        currsigs.addElement(invertRotateExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread225126(int [] tdone, int [] ends){
        switch(S156813){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread225124(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225123(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225121(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225120(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225118(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225117(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225116(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225114(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225113(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225112(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225110(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225109(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225107(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225106(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225104(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225103(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225101(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225100(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225098(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225097(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225096(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225094(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225093(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225092(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225090(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225089(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225087(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225086(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225084(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225083(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225081(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225080(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225078(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225077(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225076(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225074(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225073(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225072(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225070(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225069(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225067(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225066(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225064(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225063(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225061(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225060(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225058(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225057(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225056(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225054(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225053(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225052(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225050(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225049(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225047(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225046(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225044(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225043(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225041(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225040(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225038(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225037(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225036(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225034(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225033(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225032(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225030(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225029(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225027(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225026(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225024(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225023(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225021(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225020(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225018(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225017(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225016(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225014(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread225013(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread225012(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread225010(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225009(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225007(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread225006(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread225004(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225003(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread225001(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread225000(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224998(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224997(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224996(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224994(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224993(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224992(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224990(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224989(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224987(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224986(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224984(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224983(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224981(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224980(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224978(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224977(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224976(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224974(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224973(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224972(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224970(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224969(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224967(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224966(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224964(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224963(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224961(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224960(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224958(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224957(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224956(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224954(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224953(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224952(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224950(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224949(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224947(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224946(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224944(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224943(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224941(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224940(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224938(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224937(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224936(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224934(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224933(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224932(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224930(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224929(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224927(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224926(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224925(int [] tdone, int [] ends){
        switch(S224877){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S168111){
          case 0 : 
            if(reset.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S168111=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S156781){
                case 0 : 
                  switch(S156765){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 83, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
                        S156765=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S156760){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
                              enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 83, column: 5
                              S156760=1;
                              if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
                                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 83, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 84, column: 5
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 92, column: 5
                                S156781=1;
                                if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 94, column: 8
                                  System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 95, column: 6
                                  S156786=0;
                                  if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 22
                                    S156786=1;
                                    if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                                      S156786=2;
                                      if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                                        S156786=3;
                                        if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                          S156786=4;
                                          if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                            S156786=5;
                                            if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                              w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                              System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                              level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                              if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                                level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                                }
                                                S156786=6;
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                    S156781=2;
                                                    S166576=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166576=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S166571=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S166571=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          S168111=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  S156781=2;
                                                  S166576=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166576=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S166571=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166571=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S168111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                              }
                                              else {
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                                }
                                                S156786=6;
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                    S156781=2;
                                                    S166576=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166576=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S166571=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S166571=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          S168111=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  S156781=2;
                                                  S166576=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166576=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S166571=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166571=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S168111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                            S157815=0;
                                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                              S157815=1;
                                              thread224926(tdone,ends);
                                              thread224927(tdone,ends);
                                              int biggest224928 = 0;
                                              if(ends[9]>=biggest224928){
                                                biggest224928=ends[9];
                                              }
                                              if(ends[10]>=biggest224928){
                                                biggest224928=ends[10];
                                              }
                                              if(biggest224928 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                                S157815=1;
                                                thread224929(tdone,ends);
                                                thread224930(tdone,ends);
                                                int biggest224931 = 0;
                                                if(ends[9]>=biggest224931){
                                                  biggest224931=ends[9];
                                                }
                                                if(ends[10]>=biggest224931){
                                                  biggest224931=ends[10];
                                                }
                                                if(biggest224931 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          S157208=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                            S157208=1;
                                            thread224932(tdone,ends);
                                            thread224933(tdone,ends);
                                            thread224934(tdone,ends);
                                            int biggest224935 = 0;
                                            if(ends[6]>=biggest224935){
                                              biggest224935=ends[6];
                                            }
                                            if(ends[7]>=biggest224935){
                                              biggest224935=ends[7];
                                            }
                                            if(ends[8]>=biggest224935){
                                              biggest224935=ends[8];
                                            }
                                            if(biggest224935 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                              S157208=1;
                                              thread224936(tdone,ends);
                                              thread224937(tdone,ends);
                                              thread224938(tdone,ends);
                                              int biggest224939 = 0;
                                              if(ends[6]>=biggest224939){
                                                biggest224939=ends[6];
                                              }
                                              if(ends[7]>=biggest224939){
                                                biggest224939=ends[7];
                                              }
                                              if(ends[8]>=biggest224939){
                                                biggest224939=ends[8];
                                              }
                                              if(biggest224939 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S156859=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                                          S156859=1;
                                          thread224940(tdone,ends);
                                          thread224941(tdone,ends);
                                          int biggest224942 = 0;
                                          if(ends[4]>=biggest224942){
                                            biggest224942=ends[4];
                                          }
                                          if(ends[5]>=biggest224942){
                                            biggest224942=ends[5];
                                          }
                                          if(biggest224942 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                            S156859=1;
                                            thread224943(tdone,ends);
                                            thread224944(tdone,ends);
                                            int biggest224945 = 0;
                                            if(ends[4]>=biggest224945){
                                              biggest224945=ends[4];
                                            }
                                            if(ends[5]>=biggest224945){
                                              biggest224945=ends[5];
                                            }
                                            if(biggest224945 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
                                      currsigs.addElement(cylClampBottleExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 45
                                      S156786=1;
                                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                                        S156786=2;
                                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                                          S156786=3;
                                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                            S156786=4;
                                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                              S156786=5;
                                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                                  }
                                                  S156786=6;
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                      S156781=2;
                                                      S166576=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S166576=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S166571=0;
                                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          S166571=1;
                                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                            S168111=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    S156781=2;
                                                    S166576=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166576=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S166571=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S166571=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          S168111=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                                  }
                                                  S156786=6;
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                      S156781=2;
                                                      S166576=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S166576=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S166571=0;
                                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          S166571=1;
                                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                            S168111=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    S156781=2;
                                                    S166576=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166576=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S166571=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S166571=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          S168111=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
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
                                              S157815=0;
                                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                                S157815=1;
                                                thread224946(tdone,ends);
                                                thread224947(tdone,ends);
                                                int biggest224948 = 0;
                                                if(ends[9]>=biggest224948){
                                                  biggest224948=ends[9];
                                                }
                                                if(ends[10]>=biggest224948){
                                                  biggest224948=ends[10];
                                                }
                                                if(biggest224948 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                                  S157815=1;
                                                  thread224949(tdone,ends);
                                                  thread224950(tdone,ends);
                                                  int biggest224951 = 0;
                                                  if(ends[9]>=biggest224951){
                                                    biggest224951=ends[9];
                                                  }
                                                  if(ends[10]>=biggest224951){
                                                    biggest224951=ends[10];
                                                  }
                                                  if(biggest224951 == 1){
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            S157208=0;
                                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                              S157208=1;
                                              thread224952(tdone,ends);
                                              thread224953(tdone,ends);
                                              thread224954(tdone,ends);
                                              int biggest224955 = 0;
                                              if(ends[6]>=biggest224955){
                                                biggest224955=ends[6];
                                              }
                                              if(ends[7]>=biggest224955){
                                                biggest224955=ends[7];
                                              }
                                              if(ends[8]>=biggest224955){
                                                biggest224955=ends[8];
                                              }
                                              if(biggest224955 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                                S157208=1;
                                                thread224956(tdone,ends);
                                                thread224957(tdone,ends);
                                                thread224958(tdone,ends);
                                                int biggest224959 = 0;
                                                if(ends[6]>=biggest224959){
                                                  biggest224959=ends[6];
                                                }
                                                if(ends[7]>=biggest224959){
                                                  biggest224959=ends[7];
                                                }
                                                if(ends[8]>=biggest224959){
                                                  biggest224959=ends[8];
                                                }
                                                if(biggest224959 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          S156859=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                                            S156859=1;
                                            thread224960(tdone,ends);
                                            thread224961(tdone,ends);
                                            int biggest224962 = 0;
                                            if(ends[4]>=biggest224962){
                                              biggest224962=ends[4];
                                            }
                                            if(ends[5]>=biggest224962){
                                              biggest224962=ends[5];
                                            }
                                            if(biggest224962 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                              S156859=1;
                                              thread224963(tdone,ends);
                                              thread224964(tdone,ends);
                                              int biggest224965 = 0;
                                              if(ends[4]>=biggest224965){
                                                biggest224965=ends[4];
                                              }
                                              if(ends[5]>=biggest224965){
                                                biggest224965=ends[5];
                                              }
                                              if(biggest224965 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
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
                                  S156781=2;
                                  S166576=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166576=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S166571=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166571=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S168111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                            if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
                              enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 83, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 84, column: 5
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 92, column: 5
                              S156781=1;
                              if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 94, column: 8
                                System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 95, column: 6
                                S156786=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 22
                                  S156786=1;
                                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                                    S156786=2;
                                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                                      S156786=3;
                                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                        S156786=4;
                                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                          S156786=5;
                                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                              }
                                              S156786=6;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                  S156781=2;
                                                  S166576=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166576=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S166571=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166571=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S168111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                              }
                                              else {
                                                S156781=2;
                                                S166576=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  S166576=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S166571=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166571=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S168111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                              }
                                              S156786=6;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                  S156781=2;
                                                  S166576=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166576=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S166571=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166571=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S168111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                              }
                                              else {
                                                S156781=2;
                                                S166576=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  S166576=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S166571=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166571=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S168111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                          S157815=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                            S157815=1;
                                            thread224966(tdone,ends);
                                            thread224967(tdone,ends);
                                            int biggest224968 = 0;
                                            if(ends[9]>=biggest224968){
                                              biggest224968=ends[9];
                                            }
                                            if(ends[10]>=biggest224968){
                                              biggest224968=ends[10];
                                            }
                                            if(biggest224968 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                              S157815=1;
                                              thread224969(tdone,ends);
                                              thread224970(tdone,ends);
                                              int biggest224971 = 0;
                                              if(ends[9]>=biggest224971){
                                                biggest224971=ends[9];
                                              }
                                              if(ends[10]>=biggest224971){
                                                biggest224971=ends[10];
                                              }
                                              if(biggest224971 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S157208=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                          S157208=1;
                                          thread224972(tdone,ends);
                                          thread224973(tdone,ends);
                                          thread224974(tdone,ends);
                                          int biggest224975 = 0;
                                          if(ends[6]>=biggest224975){
                                            biggest224975=ends[6];
                                          }
                                          if(ends[7]>=biggest224975){
                                            biggest224975=ends[7];
                                          }
                                          if(ends[8]>=biggest224975){
                                            biggest224975=ends[8];
                                          }
                                          if(biggest224975 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                            S157208=1;
                                            thread224976(tdone,ends);
                                            thread224977(tdone,ends);
                                            thread224978(tdone,ends);
                                            int biggest224979 = 0;
                                            if(ends[6]>=biggest224979){
                                              biggest224979=ends[6];
                                            }
                                            if(ends[7]>=biggest224979){
                                              biggest224979=ends[7];
                                            }
                                            if(ends[8]>=biggest224979){
                                              biggest224979=ends[8];
                                            }
                                            if(biggest224979 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S156859=0;
                                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                                        S156859=1;
                                        thread224980(tdone,ends);
                                        thread224981(tdone,ends);
                                        int biggest224982 = 0;
                                        if(ends[4]>=biggest224982){
                                          biggest224982=ends[4];
                                        }
                                        if(ends[5]>=biggest224982){
                                          biggest224982=ends[5];
                                        }
                                        if(biggest224982 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                          S156859=1;
                                          thread224983(tdone,ends);
                                          thread224984(tdone,ends);
                                          int biggest224985 = 0;
                                          if(ends[4]>=biggest224985){
                                            biggest224985=ends[4];
                                          }
                                          if(ends[5]>=biggest224985){
                                            biggest224985=ends[5];
                                          }
                                          if(biggest224985 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
                                    currsigs.addElement(cylClampBottleExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 45
                                    S156786=1;
                                    if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                                      S156786=2;
                                      if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                                        S156786=3;
                                        if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                          S156786=4;
                                          if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                            S156786=5;
                                            if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                              w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                              System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                              level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                              if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                                level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                                }
                                                S156786=6;
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                    S156781=2;
                                                    S166576=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166576=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S166571=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S166571=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          S168111=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  S156781=2;
                                                  S166576=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166576=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S166571=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166571=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S168111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                              }
                                              else {
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                                }
                                                S156786=6;
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                    S156781=2;
                                                    S166576=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166576=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S166571=0;
                                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S166571=1;
                                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                          S168111=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  S156781=2;
                                                  S166576=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166576=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S166571=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166571=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S168111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                            S157815=0;
                                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                              S157815=1;
                                              thread224986(tdone,ends);
                                              thread224987(tdone,ends);
                                              int biggest224988 = 0;
                                              if(ends[9]>=biggest224988){
                                                biggest224988=ends[9];
                                              }
                                              if(ends[10]>=biggest224988){
                                                biggest224988=ends[10];
                                              }
                                              if(biggest224988 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                                S157815=1;
                                                thread224989(tdone,ends);
                                                thread224990(tdone,ends);
                                                int biggest224991 = 0;
                                                if(ends[9]>=biggest224991){
                                                  biggest224991=ends[9];
                                                }
                                                if(ends[10]>=biggest224991){
                                                  biggest224991=ends[10];
                                                }
                                                if(biggest224991 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          S157208=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                            S157208=1;
                                            thread224992(tdone,ends);
                                            thread224993(tdone,ends);
                                            thread224994(tdone,ends);
                                            int biggest224995 = 0;
                                            if(ends[6]>=biggest224995){
                                              biggest224995=ends[6];
                                            }
                                            if(ends[7]>=biggest224995){
                                              biggest224995=ends[7];
                                            }
                                            if(ends[8]>=biggest224995){
                                              biggest224995=ends[8];
                                            }
                                            if(biggest224995 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                              S157208=1;
                                              thread224996(tdone,ends);
                                              thread224997(tdone,ends);
                                              thread224998(tdone,ends);
                                              int biggest224999 = 0;
                                              if(ends[6]>=biggest224999){
                                                biggest224999=ends[6];
                                              }
                                              if(ends[7]>=biggest224999){
                                                biggest224999=ends[7];
                                              }
                                              if(ends[8]>=biggest224999){
                                                biggest224999=ends[8];
                                              }
                                              if(biggest224999 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S156859=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                                          S156859=1;
                                          thread225000(tdone,ends);
                                          thread225001(tdone,ends);
                                          int biggest225002 = 0;
                                          if(ends[4]>=biggest225002){
                                            biggest225002=ends[4];
                                          }
                                          if(ends[5]>=biggest225002){
                                            biggest225002=ends[5];
                                          }
                                          if(biggest225002 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                            S156859=1;
                                            thread225003(tdone,ends);
                                            thread225004(tdone,ends);
                                            int biggest225005 = 0;
                                            if(ends[4]>=biggest225005){
                                              biggest225005=ends[4];
                                            }
                                            if(ends[5]>=biggest225005){
                                              biggest225005=ends[5];
                                            }
                                            if(biggest225005 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
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
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                      S156765=1;
                      S156765=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 83, column: 5
                        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
                        S156765=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S156760=0;
                        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
                          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 83, column: 5
                          S156760=1;
                          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
                            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 83, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 84, column: 5
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 92, column: 5
                            S156781=1;
                            if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 94, column: 8
                              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 95, column: 6
                              S156786=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 22
                                S156786=1;
                                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                                  S156786=2;
                                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                                    S156786=3;
                                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                      S156786=4;
                                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                        S156786=5;
                                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                            }
                                            S156786=6;
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                S156781=2;
                                                S166576=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  S166576=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S166571=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166571=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S168111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              S156781=2;
                                              S166576=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                S166576=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S166571=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  S166571=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S168111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                            }
                                            S156786=6;
                                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                S156781=2;
                                                S166576=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  S166576=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S166571=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166571=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S168111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              S156781=2;
                                              S166576=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                S166576=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S166571=0;
                                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  S166571=1;
                                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S168111=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
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
                                        S157815=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                          S157815=1;
                                          thread225006(tdone,ends);
                                          thread225007(tdone,ends);
                                          int biggest225008 = 0;
                                          if(ends[9]>=biggest225008){
                                            biggest225008=ends[9];
                                          }
                                          if(ends[10]>=biggest225008){
                                            biggest225008=ends[10];
                                          }
                                          if(biggest225008 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                            S157815=1;
                                            thread225009(tdone,ends);
                                            thread225010(tdone,ends);
                                            int biggest225011 = 0;
                                            if(ends[9]>=biggest225011){
                                              biggest225011=ends[9];
                                            }
                                            if(ends[10]>=biggest225011){
                                              biggest225011=ends[10];
                                            }
                                            if(biggest225011 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S157208=0;
                                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                        S157208=1;
                                        thread225012(tdone,ends);
                                        thread225013(tdone,ends);
                                        thread225014(tdone,ends);
                                        int biggest225015 = 0;
                                        if(ends[6]>=biggest225015){
                                          biggest225015=ends[6];
                                        }
                                        if(ends[7]>=biggest225015){
                                          biggest225015=ends[7];
                                        }
                                        if(ends[8]>=biggest225015){
                                          biggest225015=ends[8];
                                        }
                                        if(biggest225015 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                          S157208=1;
                                          thread225016(tdone,ends);
                                          thread225017(tdone,ends);
                                          thread225018(tdone,ends);
                                          int biggest225019 = 0;
                                          if(ends[6]>=biggest225019){
                                            biggest225019=ends[6];
                                          }
                                          if(ends[7]>=biggest225019){
                                            biggest225019=ends[7];
                                          }
                                          if(ends[8]>=biggest225019){
                                            biggest225019=ends[8];
                                          }
                                          if(biggest225019 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    S156859=0;
                                    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                                      S156859=1;
                                      thread225020(tdone,ends);
                                      thread225021(tdone,ends);
                                      int biggest225022 = 0;
                                      if(ends[4]>=biggest225022){
                                        biggest225022=ends[4];
                                      }
                                      if(ends[5]>=biggest225022){
                                        biggest225022=ends[5];
                                      }
                                      if(biggest225022 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                        S156859=1;
                                        thread225023(tdone,ends);
                                        thread225024(tdone,ends);
                                        int biggest225025 = 0;
                                        if(ends[4]>=biggest225025){
                                          biggest225025=ends[4];
                                        }
                                        if(ends[5]>=biggest225025){
                                          biggest225025=ends[5];
                                        }
                                        if(biggest225025 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
                                  currsigs.addElement(cylClampBottleExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 45
                                  S156786=1;
                                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                                    S156786=2;
                                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                                      S156786=3;
                                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                        S156786=4;
                                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                          S156786=5;
                                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                              }
                                              S156786=6;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                  S156781=2;
                                                  S166576=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166576=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S166571=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166571=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S168111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                              }
                                              else {
                                                S156781=2;
                                                S166576=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  S166576=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S166571=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166571=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S168111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                              }
                                              S156786=6;
                                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  ends[3]=2;
                                                  ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                                  S156781=2;
                                                  S166576=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166576=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S166571=0;
                                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S166571=1;
                                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                        S168111=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                              }
                                              else {
                                                S156781=2;
                                                S166576=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                  S166576=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S166571=0;
                                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                                    S166571=1;
                                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                      S168111=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                          S157815=0;
                                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                            S157815=1;
                                            thread225026(tdone,ends);
                                            thread225027(tdone,ends);
                                            int biggest225028 = 0;
                                            if(ends[9]>=biggest225028){
                                              biggest225028=ends[9];
                                            }
                                            if(ends[10]>=biggest225028){
                                              biggest225028=ends[10];
                                            }
                                            if(biggest225028 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                              S157815=1;
                                              thread225029(tdone,ends);
                                              thread225030(tdone,ends);
                                              int biggest225031 = 0;
                                              if(ends[9]>=biggest225031){
                                                biggest225031=ends[9];
                                              }
                                              if(ends[10]>=biggest225031){
                                                biggest225031=ends[10];
                                              }
                                              if(biggest225031 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S157208=0;
                                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                          S157208=1;
                                          thread225032(tdone,ends);
                                          thread225033(tdone,ends);
                                          thread225034(tdone,ends);
                                          int biggest225035 = 0;
                                          if(ends[6]>=biggest225035){
                                            biggest225035=ends[6];
                                          }
                                          if(ends[7]>=biggest225035){
                                            biggest225035=ends[7];
                                          }
                                          if(ends[8]>=biggest225035){
                                            biggest225035=ends[8];
                                          }
                                          if(biggest225035 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                            S157208=1;
                                            thread225036(tdone,ends);
                                            thread225037(tdone,ends);
                                            thread225038(tdone,ends);
                                            int biggest225039 = 0;
                                            if(ends[6]>=biggest225039){
                                              biggest225039=ends[6];
                                            }
                                            if(ends[7]>=biggest225039){
                                              biggest225039=ends[7];
                                            }
                                            if(ends[8]>=biggest225039){
                                              biggest225039=ends[8];
                                            }
                                            if(biggest225039 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S156859=0;
                                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                                        S156859=1;
                                        thread225040(tdone,ends);
                                        thread225041(tdone,ends);
                                        int biggest225042 = 0;
                                        if(ends[4]>=biggest225042){
                                          biggest225042=ends[4];
                                        }
                                        if(ends[5]>=biggest225042){
                                          biggest225042=ends[5];
                                        }
                                        if(biggest225042 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                          S156859=1;
                                          thread225043(tdone,ends);
                                          thread225044(tdone,ends);
                                          int biggest225045 = 0;
                                          if(ends[4]>=biggest225045){
                                            biggest225045=ends[4];
                                          }
                                          if(ends[5]>=biggest225045){
                                            biggest225045=ends[5];
                                          }
                                          if(biggest225045 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
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
                              S156781=2;
                              S166576=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166576=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S166571=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166571=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S168111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                  switch(S156786){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 22
                        S156786=1;
                        if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                          S156786=2;
                          if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                            S156786=3;
                            if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                              S156786=4;
                              if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                S156786=5;
                                if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                  w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                  System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                  level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                    }
                                    S156786=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                    }
                                    S156786=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                S157815=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                  S157815=1;
                                  thread225046(tdone,ends);
                                  thread225047(tdone,ends);
                                  int biggest225048 = 0;
                                  if(ends[9]>=biggest225048){
                                    biggest225048=ends[9];
                                  }
                                  if(ends[10]>=biggest225048){
                                    biggest225048=ends[10];
                                  }
                                  if(biggest225048 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                    S157815=1;
                                    thread225049(tdone,ends);
                                    thread225050(tdone,ends);
                                    int biggest225051 = 0;
                                    if(ends[9]>=biggest225051){
                                      biggest225051=ends[9];
                                    }
                                    if(ends[10]>=biggest225051){
                                      biggest225051=ends[10];
                                    }
                                    if(biggest225051 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S157208=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                S157208=1;
                                thread225052(tdone,ends);
                                thread225053(tdone,ends);
                                thread225054(tdone,ends);
                                int biggest225055 = 0;
                                if(ends[6]>=biggest225055){
                                  biggest225055=ends[6];
                                }
                                if(ends[7]>=biggest225055){
                                  biggest225055=ends[7];
                                }
                                if(ends[8]>=biggest225055){
                                  biggest225055=ends[8];
                                }
                                if(biggest225055 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                  S157208=1;
                                  thread225056(tdone,ends);
                                  thread225057(tdone,ends);
                                  thread225058(tdone,ends);
                                  int biggest225059 = 0;
                                  if(ends[6]>=biggest225059){
                                    biggest225059=ends[6];
                                  }
                                  if(ends[7]>=biggest225059){
                                    biggest225059=ends[7];
                                  }
                                  if(ends[8]>=biggest225059){
                                    biggest225059=ends[8];
                                  }
                                  if(biggest225059 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S156859=0;
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                              S156859=1;
                              thread225060(tdone,ends);
                              thread225061(tdone,ends);
                              int biggest225062 = 0;
                              if(ends[4]>=biggest225062){
                                biggest225062=ends[4];
                              }
                              if(ends[5]>=biggest225062){
                                biggest225062=ends[5];
                              }
                              if(biggest225062 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                S156859=1;
                                thread225063(tdone,ends);
                                thread225064(tdone,ends);
                                int biggest225065 = 0;
                                if(ends[4]>=biggest225065){
                                  biggest225065=ends[4];
                                }
                                if(ends[5]>=biggest225065){
                                  biggest225065=ends[5];
                                }
                                if(biggest225065 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
                          currsigs.addElement(cylClampBottleExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 45
                          S156786=1;
                          if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                            S156786=2;
                            if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                              S156786=3;
                              if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                S156786=4;
                                if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                  S156786=5;
                                  if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                    w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                    if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                      }
                                      S156786=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                          S156781=2;
                                          S166576=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166576=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S166571=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S166571=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                S168111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                      }
                                      S156786=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                          S156781=2;
                                          S166576=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166576=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S166571=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S166571=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                S168111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                  S157815=0;
                                  if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                    S157815=1;
                                    thread225066(tdone,ends);
                                    thread225067(tdone,ends);
                                    int biggest225068 = 0;
                                    if(ends[9]>=biggest225068){
                                      biggest225068=ends[9];
                                    }
                                    if(ends[10]>=biggest225068){
                                      biggest225068=ends[10];
                                    }
                                    if(biggest225068 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                      S157815=1;
                                      thread225069(tdone,ends);
                                      thread225070(tdone,ends);
                                      int biggest225071 = 0;
                                      if(ends[9]>=biggest225071){
                                        biggest225071=ends[9];
                                      }
                                      if(ends[10]>=biggest225071){
                                        biggest225071=ends[10];
                                      }
                                      if(biggest225071 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S157208=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                  S157208=1;
                                  thread225072(tdone,ends);
                                  thread225073(tdone,ends);
                                  thread225074(tdone,ends);
                                  int biggest225075 = 0;
                                  if(ends[6]>=biggest225075){
                                    biggest225075=ends[6];
                                  }
                                  if(ends[7]>=biggest225075){
                                    biggest225075=ends[7];
                                  }
                                  if(ends[8]>=biggest225075){
                                    biggest225075=ends[8];
                                  }
                                  if(biggest225075 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                    S157208=1;
                                    thread225076(tdone,ends);
                                    thread225077(tdone,ends);
                                    thread225078(tdone,ends);
                                    int biggest225079 = 0;
                                    if(ends[6]>=biggest225079){
                                      biggest225079=ends[6];
                                    }
                                    if(ends[7]>=biggest225079){
                                      biggest225079=ends[7];
                                    }
                                    if(ends[8]>=biggest225079){
                                      biggest225079=ends[8];
                                    }
                                    if(biggest225079 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S156859=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                                S156859=1;
                                thread225080(tdone,ends);
                                thread225081(tdone,ends);
                                int biggest225082 = 0;
                                if(ends[4]>=biggest225082){
                                  biggest225082=ends[4];
                                }
                                if(ends[5]>=biggest225082){
                                  biggest225082=ends[5];
                                }
                                if(biggest225082 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                  S156859=1;
                                  thread225083(tdone,ends);
                                  thread225084(tdone,ends);
                                  int biggest225085 = 0;
                                  if(ends[4]>=biggest225085){
                                    biggest225085=ends[4];
                                  }
                                  if(ends[5]>=biggest225085){
                                    biggest225085=ends[5];
                                  }
                                  if(biggest225085 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
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
                      if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                        S156786=2;
                        if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                          S156786=3;
                          if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                            S156786=4;
                            if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                              S156786=5;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                  }
                                  S156786=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    S156781=2;
                                    S166576=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166576=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S166571=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166571=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S168111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                  }
                                  S156786=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    S156781=2;
                                    S166576=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166576=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S166571=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166571=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S168111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                              S157815=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                S157815=1;
                                thread225086(tdone,ends);
                                thread225087(tdone,ends);
                                int biggest225088 = 0;
                                if(ends[9]>=biggest225088){
                                  biggest225088=ends[9];
                                }
                                if(ends[10]>=biggest225088){
                                  biggest225088=ends[10];
                                }
                                if(biggest225088 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                  S157815=1;
                                  thread225089(tdone,ends);
                                  thread225090(tdone,ends);
                                  int biggest225091 = 0;
                                  if(ends[9]>=biggest225091){
                                    biggest225091=ends[9];
                                  }
                                  if(ends[10]>=biggest225091){
                                    biggest225091=ends[10];
                                  }
                                  if(biggest225091 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S157208=0;
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                              S157208=1;
                              thread225092(tdone,ends);
                              thread225093(tdone,ends);
                              thread225094(tdone,ends);
                              int biggest225095 = 0;
                              if(ends[6]>=biggest225095){
                                biggest225095=ends[6];
                              }
                              if(ends[7]>=biggest225095){
                                biggest225095=ends[7];
                              }
                              if(ends[8]>=biggest225095){
                                biggest225095=ends[8];
                              }
                              if(biggest225095 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                S157208=1;
                                thread225096(tdone,ends);
                                thread225097(tdone,ends);
                                thread225098(tdone,ends);
                                int biggest225099 = 0;
                                if(ends[6]>=biggest225099){
                                  biggest225099=ends[6];
                                }
                                if(ends[7]>=biggest225099){
                                  biggest225099=ends[7];
                                }
                                if(ends[8]>=biggest225099){
                                  biggest225099=ends[8];
                                }
                                if(biggest225099 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          S156859=0;
                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                            S156859=1;
                            thread225100(tdone,ends);
                            thread225101(tdone,ends);
                            int biggest225102 = 0;
                            if(ends[4]>=biggest225102){
                              biggest225102=ends[4];
                            }
                            if(ends[5]>=biggest225102){
                              biggest225102=ends[5];
                            }
                            if(biggest225102 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                              S156859=1;
                              thread225103(tdone,ends);
                              thread225104(tdone,ends);
                              int biggest225105 = 0;
                              if(ends[4]>=biggest225105){
                                biggest225105=ends[4];
                              }
                              if(ends[5]>=biggest225105){
                                biggest225105=ends[5];
                              }
                              if(biggest225105 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
                        currsigs.addElement(cylClampBottleExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                        S156786=3;
                        if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                          S156786=4;
                          if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                            S156786=5;
                            if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                              w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                              System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                              level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                              if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                }
                                S156786=6;
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                    S156781=2;
                                    S166576=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166576=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S166571=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166571=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S168111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  S156781=2;
                                  S166576=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166576=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S166571=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166571=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S168111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                  System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                  code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                }
                                S156786=6;
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                  System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                    S156781=2;
                                    S166576=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166576=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S166571=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166571=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S168111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  S156781=2;
                                  S166576=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166576=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S166571=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166571=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S168111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                            S157815=0;
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                              S157815=1;
                              thread225106(tdone,ends);
                              thread225107(tdone,ends);
                              int biggest225108 = 0;
                              if(ends[9]>=biggest225108){
                                biggest225108=ends[9];
                              }
                              if(ends[10]>=biggest225108){
                                biggest225108=ends[10];
                              }
                              if(biggest225108 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                S157815=1;
                                thread225109(tdone,ends);
                                thread225110(tdone,ends);
                                int biggest225111 = 0;
                                if(ends[9]>=biggest225111){
                                  biggest225111=ends[9];
                                }
                                if(ends[10]>=biggest225111){
                                  biggest225111=ends[10];
                                }
                                if(biggest225111 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          S157208=0;
                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                            S157208=1;
                            thread225112(tdone,ends);
                            thread225113(tdone,ends);
                            thread225114(tdone,ends);
                            int biggest225115 = 0;
                            if(ends[6]>=biggest225115){
                              biggest225115=ends[6];
                            }
                            if(ends[7]>=biggest225115){
                              biggest225115=ends[7];
                            }
                            if(ends[8]>=biggest225115){
                              biggest225115=ends[8];
                            }
                            if(biggest225115 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                              S157208=1;
                              thread225116(tdone,ends);
                              thread225117(tdone,ends);
                              thread225118(tdone,ends);
                              int biggest225119 = 0;
                              if(ends[6]>=biggest225119){
                                biggest225119=ends[6];
                              }
                              if(ends[7]>=biggest225119){
                                biggest225119=ends[7];
                              }
                              if(ends[8]>=biggest225119){
                                biggest225119=ends[8];
                              }
                              if(biggest225119 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        switch(S156859){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                              S156859=1;
                              thread225120(tdone,ends);
                              thread225121(tdone,ends);
                              int biggest225122 = 0;
                              if(ends[4]>=biggest225122){
                                biggest225122=ends[4];
                              }
                              if(ends[5]>=biggest225122){
                                biggest225122=ends[5];
                              }
                              if(biggest225122 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                S156859=1;
                                thread225123(tdone,ends);
                                thread225124(tdone,ends);
                                int biggest225125 = 0;
                                if(ends[4]>=biggest225125){
                                  biggest225125=ends[4];
                                }
                                if(ends[5]>=biggest225125){
                                  biggest225125=ends[5];
                                }
                                if(biggest225125 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                            thread225126(tdone,ends);
                            thread225127(tdone,ends);
                            int biggest225128 = 0;
                            if(ends[4]>=biggest225128){
                              biggest225128=ends[4];
                            }
                            if(ends[5]>=biggest225128){
                              biggest225128=ends[5];
                            }
                            if(biggest225128 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest225128 == 0){
                              S156786=3;
                              if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                S156786=4;
                                if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                  S156786=5;
                                  if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                    w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                    if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                      }
                                      S156786=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                          S156781=2;
                                          S166576=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166576=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S166571=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S166571=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                S168111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                      }
                                      S156786=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                          S156781=2;
                                          S166576=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166576=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S166571=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S166571=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                S168111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                  S157815=0;
                                  if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                    S157815=1;
                                    thread225129(tdone,ends);
                                    thread225130(tdone,ends);
                                    int biggest225131 = 0;
                                    if(ends[9]>=biggest225131){
                                      biggest225131=ends[9];
                                    }
                                    if(ends[10]>=biggest225131){
                                      biggest225131=ends[10];
                                    }
                                    if(biggest225131 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                      S157815=1;
                                      thread225132(tdone,ends);
                                      thread225133(tdone,ends);
                                      int biggest225134 = 0;
                                      if(ends[9]>=biggest225134){
                                        biggest225134=ends[9];
                                      }
                                      if(ends[10]>=biggest225134){
                                        biggest225134=ends[10];
                                      }
                                      if(biggest225134 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S157208=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                  S157208=1;
                                  thread225135(tdone,ends);
                                  thread225136(tdone,ends);
                                  thread225137(tdone,ends);
                                  int biggest225138 = 0;
                                  if(ends[6]>=biggest225138){
                                    biggest225138=ends[6];
                                  }
                                  if(ends[7]>=biggest225138){
                                    biggest225138=ends[7];
                                  }
                                  if(ends[8]>=biggest225138){
                                    biggest225138=ends[8];
                                  }
                                  if(biggest225138 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                    S157208=1;
                                    thread225139(tdone,ends);
                                    thread225140(tdone,ends);
                                    thread225141(tdone,ends);
                                    int biggest225142 = 0;
                                    if(ends[6]>=biggest225142){
                                      biggest225142=ends[6];
                                    }
                                    if(ends[7]>=biggest225142){
                                      biggest225142=ends[7];
                                    }
                                    if(ends[8]>=biggest225142){
                                      biggest225142=ends[8];
                                    }
                                    if(biggest225142 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                        S156786=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                          S156786=5;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                              }
                              S156786=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                  S156781=2;
                                  S166576=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166576=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S166571=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166571=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S168111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                              }
                              S156786=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                  S156781=2;
                                  S166576=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166576=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S166571=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166571=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S168111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                          S157815=0;
                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                            S157815=1;
                            thread225143(tdone,ends);
                            thread225144(tdone,ends);
                            int biggest225145 = 0;
                            if(ends[9]>=biggest225145){
                              biggest225145=ends[9];
                            }
                            if(ends[10]>=biggest225145){
                              biggest225145=ends[10];
                            }
                            if(biggest225145 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                              S157815=1;
                              thread225146(tdone,ends);
                              thread225147(tdone,ends);
                              int biggest225148 = 0;
                              if(ends[9]>=biggest225148){
                                biggest225148=ends[9];
                              }
                              if(ends[10]>=biggest225148){
                                biggest225148=ends[10];
                              }
                              if(biggest225148 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        switch(S157208){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                              S157208=1;
                              thread225149(tdone,ends);
                              thread225150(tdone,ends);
                              thread225151(tdone,ends);
                              int biggest225152 = 0;
                              if(ends[6]>=biggest225152){
                                biggest225152=ends[6];
                              }
                              if(ends[7]>=biggest225152){
                                biggest225152=ends[7];
                              }
                              if(ends[8]>=biggest225152){
                                biggest225152=ends[8];
                              }
                              if(biggest225152 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                S157208=1;
                                thread225153(tdone,ends);
                                thread225154(tdone,ends);
                                thread225155(tdone,ends);
                                int biggest225156 = 0;
                                if(ends[6]>=biggest225156){
                                  biggest225156=ends[6];
                                }
                                if(ends[7]>=biggest225156){
                                  biggest225156=ends[7];
                                }
                                if(ends[8]>=biggest225156){
                                  biggest225156=ends[8];
                                }
                                if(biggest225156 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                            thread225157(tdone,ends);
                            thread225158(tdone,ends);
                            thread225159(tdone,ends);
                            int biggest225160 = 0;
                            if(ends[6]>=biggest225160){
                              biggest225160=ends[6];
                            }
                            if(ends[7]>=biggest225160){
                              biggest225160=ends[7];
                            }
                            if(ends[8]>=biggest225160){
                              biggest225160=ends[8];
                            }
                            if(biggest225160 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest225160 == 0){
                              S156786=4;
                              if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                S156786=5;
                                if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                  w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                  System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                  level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                    }
                                    S156786=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                    }
                                    S156786=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                S157815=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                  S157815=1;
                                  thread225161(tdone,ends);
                                  thread225162(tdone,ends);
                                  int biggest225163 = 0;
                                  if(ends[9]>=biggest225163){
                                    biggest225163=ends[9];
                                  }
                                  if(ends[10]>=biggest225163){
                                    biggest225163=ends[10];
                                  }
                                  if(biggest225163 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                    S157815=1;
                                    thread225164(tdone,ends);
                                    thread225165(tdone,ends);
                                    int biggest225166 = 0;
                                    if(ends[9]>=biggest225166){
                                      biggest225166=ends[9];
                                    }
                                    if(ends[10]>=biggest225166){
                                      biggest225166=ends[10];
                                    }
                                    if(biggest225166 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                        S156786=5;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                            }
                            S156786=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S156781=2;
                              S166576=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166576=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S166571=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166571=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S168111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                            }
                            S156786=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S156781=2;
                              S166576=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166576=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S166571=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166571=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S168111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                        switch(S157815){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                              S157815=1;
                              thread225167(tdone,ends);
                              thread225168(tdone,ends);
                              int biggest225169 = 0;
                              if(ends[9]>=biggest225169){
                                biggest225169=ends[9];
                              }
                              if(ends[10]>=biggest225169){
                                biggest225169=ends[10];
                              }
                              if(biggest225169 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                S157815=1;
                                thread225170(tdone,ends);
                                thread225171(tdone,ends);
                                int biggest225172 = 0;
                                if(ends[9]>=biggest225172){
                                  biggest225172=ends[9];
                                }
                                if(ends[10]>=biggest225172){
                                  biggest225172=ends[10];
                                }
                                if(biggest225172 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                            thread225173(tdone,ends);
                            thread225174(tdone,ends);
                            int biggest225175 = 0;
                            if(ends[9]>=biggest225175){
                              biggest225175=ends[9];
                            }
                            if(ends[10]>=biggest225175){
                              biggest225175=ends[10];
                            }
                            if(biggest225175 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest225175 == 0){
                              S156786=5;
                              if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                  level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                  }
                                  S156786=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    S156781=2;
                                    S166576=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166576=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S166571=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166571=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S168111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                  if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                    System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                    code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                  }
                                  S156786=6;
                                  if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                    System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    S156781=2;
                                    S166576=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166576=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S166571=0;
                                      if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166571=1;
                                        if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S168111=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                      if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                        w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                        System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                        level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                        if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                          level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                          }
                          S156786=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 144, column: 22
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                              S156781=2;
                              S166576=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166576=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S166571=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166571=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S168111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S156781=2;
                            S166576=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                              S166576=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S166571=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166571=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S168111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                          if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                            System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                            code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                          }
                          S156786=6;
                          if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                            System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 144, column: 22
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                              S156781=2;
                              S166576=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166576=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S166571=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166571=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S168111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S156781=2;
                            S166576=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                              S166576=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S166571=0;
                              if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166571=1;
                                if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S168111=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                      if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 146, column: 34
                        level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 146, column: 51
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\liquidDumperController.sysj line: 144, column: 22
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                          S156781=2;
                          S166576=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                            S166576=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S166571=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                              S166571=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                S168111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          ends[3]=2;
                          ;//sysj\liquidDumperController.sysj line: 144, column: 22
                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                          S156781=2;
                          S166576=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                            S166576=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S166571=0;
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                              S166571=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                S168111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                  switch(S166576){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                        S166576=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S166571){
                          case 0 : 
                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                              S166571=1;
                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                S168111=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                              ends[3]=2;
                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                              S168111=1;
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
                      S166576=1;
                      S166576=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                        S166576=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S166571=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                          S166571=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                            S168111=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                  S168111=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 1 : 
            S168111=1;
            S168111=0;
            if(reset.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S168111=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S156781=0;
              S156765=0;
              if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 83, column: 5
                enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
                S156765=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S156760=0;
                if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
                  enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 83, column: 5
                  S156760=1;
                  if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
                    enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
                    ends[3]=2;
                    ;//sysj\liquidDumperController.sysj line: 83, column: 5
                    w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 84, column: 5
                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 92, column: 5
                    S156781=1;
                    if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 94, column: 8
                      System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 95, column: 6
                      S156786=0;
                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 22
                        S156786=1;
                        if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                          S156786=2;
                          if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                            S156786=3;
                            if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                              S156786=4;
                              if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                S156786=5;
                                if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                  w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                  System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                  level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                  if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                    level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                    }
                                    S156786=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                    if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                      System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                      code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                    }
                                    S156786=6;
                                    if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                      System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                        code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S156781=2;
                                      S166576=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S166576=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S166571=0;
                                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166571=1;
                                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            ends[3]=2;
                                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S168111=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                S157815=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                  S157815=1;
                                  thread225176(tdone,ends);
                                  thread225177(tdone,ends);
                                  int biggest225178 = 0;
                                  if(ends[9]>=biggest225178){
                                    biggest225178=ends[9];
                                  }
                                  if(ends[10]>=biggest225178){
                                    biggest225178=ends[10];
                                  }
                                  if(biggest225178 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                    S157815=1;
                                    thread225179(tdone,ends);
                                    thread225180(tdone,ends);
                                    int biggest225181 = 0;
                                    if(ends[9]>=biggest225181){
                                      biggest225181=ends[9];
                                    }
                                    if(ends[10]>=biggest225181){
                                      biggest225181=ends[10];
                                    }
                                    if(biggest225181 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S157208=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                S157208=1;
                                thread225182(tdone,ends);
                                thread225183(tdone,ends);
                                thread225184(tdone,ends);
                                int biggest225185 = 0;
                                if(ends[6]>=biggest225185){
                                  biggest225185=ends[6];
                                }
                                if(ends[7]>=biggest225185){
                                  biggest225185=ends[7];
                                }
                                if(ends[8]>=biggest225185){
                                  biggest225185=ends[8];
                                }
                                if(biggest225185 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                  S157208=1;
                                  thread225186(tdone,ends);
                                  thread225187(tdone,ends);
                                  thread225188(tdone,ends);
                                  int biggest225189 = 0;
                                  if(ends[6]>=biggest225189){
                                    biggest225189=ends[6];
                                  }
                                  if(ends[7]>=biggest225189){
                                    biggest225189=ends[7];
                                  }
                                  if(ends[8]>=biggest225189){
                                    biggest225189=ends[8];
                                  }
                                  if(biggest225189 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S156859=0;
                            if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                              S156859=1;
                              thread225190(tdone,ends);
                              thread225191(tdone,ends);
                              int biggest225192 = 0;
                              if(ends[4]>=biggest225192){
                                biggest225192=ends[4];
                              }
                              if(ends[5]>=biggest225192){
                                biggest225192=ends[5];
                              }
                              if(biggest225192 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                S156859=1;
                                thread225193(tdone,ends);
                                thread225194(tdone,ends);
                                int biggest225195 = 0;
                                if(ends[4]>=biggest225195){
                                  biggest225195=ends[4];
                                }
                                if(ends[5]>=biggest225195){
                                  biggest225195=ends[5];
                                }
                                if(biggest225195 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
                          currsigs.addElement(cylClampBottleExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 45
                          S156786=1;
                          if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                            S156786=2;
                            if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                              S156786=3;
                              if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                                S156786=4;
                                if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                                  S156786=5;
                                  if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                                    w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                                    System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                                    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                                    if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                                      level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                      }
                                      S156786=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                          S156781=2;
                                          S166576=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166576=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S166571=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S166571=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                S168111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                                      if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                        System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                        code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                                      }
                                      S156786=6;
                                      if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                        System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                        if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          ends[3]=2;
                                          ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                          code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                          S156781=2;
                                          S166576=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166576=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S166571=0;
                                            if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S166571=1;
                                              if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                                ends[3]=2;
                                                ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                                S168111=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S156781=2;
                                        S166576=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                          status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                          S166576=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S166571=0;
                                          if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                            S166571=1;
                                            if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                              status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                              ends[3]=2;
                                              ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                              S168111=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                  S157815=0;
                                  if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                                    S157815=1;
                                    thread225196(tdone,ends);
                                    thread225197(tdone,ends);
                                    int biggest225198 = 0;
                                    if(ends[9]>=biggest225198){
                                      biggest225198=ends[9];
                                    }
                                    if(ends[10]>=biggest225198){
                                      biggest225198=ends[10];
                                    }
                                    if(biggest225198 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                                      S157815=1;
                                      thread225199(tdone,ends);
                                      thread225200(tdone,ends);
                                      int biggest225201 = 0;
                                      if(ends[9]>=biggest225201){
                                        biggest225201=ends[9];
                                      }
                                      if(ends[10]>=biggest225201){
                                        biggest225201=ends[10];
                                      }
                                      if(biggest225201 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S157208=0;
                                if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                                  S157208=1;
                                  thread225202(tdone,ends);
                                  thread225203(tdone,ends);
                                  thread225204(tdone,ends);
                                  int biggest225205 = 0;
                                  if(ends[6]>=biggest225205){
                                    biggest225205=ends[6];
                                  }
                                  if(ends[7]>=biggest225205){
                                    biggest225205=ends[7];
                                  }
                                  if(ends[8]>=biggest225205){
                                    biggest225205=ends[8];
                                  }
                                  if(biggest225205 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                                    S157208=1;
                                    thread225206(tdone,ends);
                                    thread225207(tdone,ends);
                                    thread225208(tdone,ends);
                                    int biggest225209 = 0;
                                    if(ends[6]>=biggest225209){
                                      biggest225209=ends[6];
                                    }
                                    if(ends[7]>=biggest225209){
                                      biggest225209=ends[7];
                                    }
                                    if(ends[8]>=biggest225209){
                                      biggest225209=ends[8];
                                    }
                                    if(biggest225209 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S156859=0;
                              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                                S156859=1;
                                thread225210(tdone,ends);
                                thread225211(tdone,ends);
                                int biggest225212 = 0;
                                if(ends[4]>=biggest225212){
                                  biggest225212=ends[4];
                                }
                                if(ends[5]>=biggest225212){
                                  biggest225212=ends[5];
                                }
                                if(biggest225212 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                                  S156859=1;
                                  thread225213(tdone,ends);
                                  thread225214(tdone,ends);
                                  int biggest225215 = 0;
                                  if(ends[4]>=biggest225215){
                                    biggest225215=ends[4];
                                  }
                                  if(ends[5]>=biggest225215){
                                    biggest225215=ends[5];
                                  }
                                  if(biggest225215 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
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
                      S156781=2;
                      S166576=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                        S166576=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S166571=0;
                        if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                          S166571=1;
                          if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                            status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                            ends[3]=2;
                            ;//sysj\liquidDumperController.sysj line: 152, column: 5
                            S168111=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
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

  public void thread224924(int [] tdone, int [] ends){
        switch(S156757){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\liquidDumperController.sysj line: 59, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\liquidDumperController.sysj line: 62, column: 8
            auto_1.setPresent();//sysj\liquidDumperController.sysj line: 62, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\liquidDumperController.sysj line: 63, column: 13
              manual_1.setPresent();//sysj\liquidDumperController.sysj line: 63, column: 35
              currsigs.addElement(manual_1);
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
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread224921(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224920(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224918(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224917(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224915(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224914(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224913(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224911(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224910(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224909(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224907(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224906(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224904(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224903(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224901(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224900(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224898(int [] tdone, int [] ends){
        S156818=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 46
    currsigs.addElement(invertRotateExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread224897(int [] tdone, int [] ends){
        S156813=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 106, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread224895(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224894(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224893(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224891(int [] tdone, int [] ends){
        S157147=1;
    drainValveOnOff.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 81
    currsigs.addElement(drainValveOnOff);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread224890(int [] tdone, int [] ends){
        S157142=1;
    invertRotateExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 46
    currsigs.addElement(invertRotateExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread224889(int [] tdone, int [] ends){
        S157137=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 113, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread224887(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224886(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224884(int [] tdone, int [] ends){
        S157774=1;
    invertRotateRetract.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 46
    currsigs.addElement(invertRotateRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread224883(int [] tdone, int [] ends){
        S157769=1;
    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 119, column: 9
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread224882(int [] tdone, int [] ends){
        S224877=1;
    OK_thread_3 = 0;//sysj\liquidDumperController.sysj line: 70, column: 3
    BLOCKED_thread_3 = 2;//sysj\liquidDumperController.sysj line: 71, column: 3
    WARN_thread_3 = 3;//sysj\liquidDumperController.sysj line: 72, column: 3
    TANK_CAPACITY_thread_3 = RecyclingCapacity.WASTE_TANK;//sysj\liquidDumperController.sysj line: 74, column: 3
    TANK_WARN_thread_3 = RecyclingCapacity.WASTE_TANK_WARN;//sysj\liquidDumperController.sysj line: 75, column: 3
    w_thread_3 = null;//sysj\liquidDumperController.sysj line: 77, column: 3
    level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 78, column: 3
    code_thread_3 = 0;//sysj\liquidDumperController.sysj line: 79, column: 3
    S168111=0;
    if(reset.getprestatus()){//sysj\liquidDumperController.sysj line: 82, column: 20
      enable_in.setPreempted();
      status_o.setPreempted();
      S168111=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S156781=0;
      S156765=0;
      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 83, column: 5
        enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
        S156765=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S156760=0;
        if(!enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
          enable_in.setACK(true);//sysj\liquidDumperController.sysj line: 83, column: 5
          S156760=1;
          if(enable_in.isREQ()){//sysj\liquidDumperController.sysj line: 83, column: 5
            enable_in.setACK(false);//sysj\liquidDumperController.sysj line: 83, column: 5
            ends[3]=2;
            ;//sysj\liquidDumperController.sysj line: 83, column: 5
            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\liquidDumperController.sysj line: 84, column: 5
            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 92, column: 5
            S156781=1;
            if(w_thread_3 != null){//sysj\liquidDumperController.sysj line: 94, column: 8
              System.out.println("[LD] Draining " + w_thread_3 + " (" + w_thread_3.filledMl() + "ml).");//sysj\liquidDumperController.sysj line: 95, column: 6
              S156786=0;
              if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 22
                S156786=1;
                if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                  S156786=2;
                  if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                    S156786=3;
                    if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                      S156786=4;
                      if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                        S156786=5;
                        if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                          w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                          System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                          level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                          if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                            level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                            }
                            S156786=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S156781=2;
                              S166576=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166576=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S166571=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166571=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S168111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                            if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                              System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                              code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                            }
                            S156786=6;
                            if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                              System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                ends[3]=2;
                                ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S156781=2;
                              S166576=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                S166576=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S166571=0;
                                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166571=1;
                                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    ends[3]=2;
                                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S168111=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                        S157815=0;
                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                          S157815=1;
                          thread224883(tdone,ends);
                          thread224884(tdone,ends);
                          int biggest224885 = 0;
                          if(ends[9]>=biggest224885){
                            biggest224885=ends[9];
                          }
                          if(ends[10]>=biggest224885){
                            biggest224885=ends[10];
                          }
                          if(biggest224885 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                            S157815=1;
                            thread224886(tdone,ends);
                            thread224887(tdone,ends);
                            int biggest224888 = 0;
                            if(ends[9]>=biggest224888){
                              biggest224888=ends[9];
                            }
                            if(ends[10]>=biggest224888){
                              biggest224888=ends[10];
                            }
                            if(biggest224888 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      S157208=0;
                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                        S157208=1;
                        thread224889(tdone,ends);
                        thread224890(tdone,ends);
                        thread224891(tdone,ends);
                        int biggest224892 = 0;
                        if(ends[6]>=biggest224892){
                          biggest224892=ends[6];
                        }
                        if(ends[7]>=biggest224892){
                          biggest224892=ends[7];
                        }
                        if(ends[8]>=biggest224892){
                          biggest224892=ends[8];
                        }
                        if(biggest224892 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                          S157208=1;
                          thread224893(tdone,ends);
                          thread224894(tdone,ends);
                          thread224895(tdone,ends);
                          int biggest224896 = 0;
                          if(ends[6]>=biggest224896){
                            biggest224896=ends[6];
                          }
                          if(ends[7]>=biggest224896){
                            biggest224896=ends[7];
                          }
                          if(ends[8]>=biggest224896){
                            biggest224896=ends[8];
                          }
                          if(biggest224896 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    S156859=0;
                    if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                      S156859=1;
                      thread224897(tdone,ends);
                      thread224898(tdone,ends);
                      int biggest224899 = 0;
                      if(ends[4]>=biggest224899){
                        biggest224899=ends[4];
                      }
                      if(ends[5]>=biggest224899){
                        biggest224899=ends[5];
                      }
                      if(biggest224899 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                        S156859=1;
                        thread224900(tdone,ends);
                        thread224901(tdone,ends);
                        int biggest224902 = 0;
                        if(ends[4]>=biggest224902){
                          biggest224902=ends[4];
                        }
                        if(ends[5]>=biggest224902){
                          biggest224902=ends[5];
                        }
                        if(biggest224902 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                }
                else {
                  cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(cylClampBottleExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 98, column: 45
                  S156786=1;
                  if(clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 99, column: 22
                    S156786=2;
                    if(bottleInverted.getprestatus()){//sysj\liquidDumperController.sysj line: 104, column: 22
                      S156786=3;
                      if(bottleDrained.getprestatus()){//sysj\liquidDumperController.sysj line: 111, column: 22
                        S156786=4;
                        if(bottleUpright.getprestatus()){//sysj\liquidDumperController.sysj line: 117, column: 22
                          S156786=5;
                          if(!clampClosed.getprestatus()){//sysj\liquidDumperController.sysj line: 123, column: 22
                            w_thread_3.drain();//sysj\liquidDumperController.sysj line: 125, column: 6
                            System.out.println("[LD] " + w_thread_3 + " drained to the waste sink, now at " + w_thread_3.filledMl() + "ml.");//sysj\liquidDumperController.sysj line: 126, column: 6
                            level_thread_3 = 0;//sysj\liquidDumperController.sysj line: 129, column: 6
                            if(wasteTankLevel.getprestatus()){//sysj\liquidDumperController.sysj line: 130, column: 14
                              level_thread_3 = ((Integer)(wasteTankLevel.getpreval() == null ? null : ((Integer)wasteTankLevel.getpreval()))).intValue();//sysj\liquidDumperController.sysj line: 131, column: 7
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                              }
                              S156786=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                  S156781=2;
                                  S166576=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166576=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S166571=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166571=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S168111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 134, column: 6
                              if(level_thread_3 >= TANK_WARN_thread_3) {//sysj\liquidDumperController.sysj line: 135, column: 28
                                System.out.println("[LD] Waste tank near capacity (" + level_thread_3 + " of " + TANK_CAPACITY_thread_3 + ").");//sysj\liquidDumperController.sysj line: 136, column: 7
                                code_thread_3 = WARN_thread_3;//sysj\liquidDumperController.sysj line: 137, column: 7
                              }
                              S156786=6;
                              if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 139, column: 9
                                System.out.println("[LD] Waste tank is full; no further bottles until it is emptied.");//sysj\liquidDumperController.sysj line: 140, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\liquidDumperController.sysj line: 141, column: 7
                                if(level_thread_3 >= TANK_CAPACITY_thread_3){//sysj\liquidDumperController.sysj line: 144, column: 28
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  ends[3]=2;
                                  ;//sysj\liquidDumperController.sysj line: 144, column: 22
                                  code_thread_3 = OK_thread_3;//sysj\liquidDumperController.sysj line: 148, column: 22
                                  S156781=2;
                                  S166576=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166576=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S166571=0;
                                    if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S166571=1;
                                      if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                        status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                        ends[3]=2;
                                        ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                        S168111=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                S156781=2;
                                S166576=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                  status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                  S166576=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S166571=0;
                                  if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                                    S166571=1;
                                    if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                                      status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                                      ends[3]=2;
                                      ;//sysj\liquidDumperController.sysj line: 152, column: 5
                                      S168111=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                          S157815=0;
                          if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 23
                            S157815=1;
                            thread224903(tdone,ends);
                            thread224904(tdone,ends);
                            int biggest224905 = 0;
                            if(ends[9]>=biggest224905){
                              biggest224905=ends[9];
                            }
                            if(ends[10]>=biggest224905){
                              biggest224905=ends[10];
                            }
                            if(biggest224905 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(invertRotateRetractM.getprestatus()){//sysj\liquidDumperController.sysj line: 118, column: 46
                              S157815=1;
                              thread224906(tdone,ends);
                              thread224907(tdone,ends);
                              int biggest224908 = 0;
                              if(ends[9]>=biggest224908){
                                biggest224908=ends[9];
                              }
                              if(ends[10]>=biggest224908){
                                biggest224908=ends[10];
                              }
                              if(biggest224908 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        S157208=0;
                        if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 23
                          S157208=1;
                          thread224909(tdone,ends);
                          thread224910(tdone,ends);
                          thread224911(tdone,ends);
                          int biggest224912 = 0;
                          if(ends[6]>=biggest224912){
                            biggest224912=ends[6];
                          }
                          if(ends[7]>=biggest224912){
                            biggest224912=ends[7];
                          }
                          if(ends[8]>=biggest224912){
                            biggest224912=ends[8];
                          }
                          if(biggest224912 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(drainValveOnOffM.getprestatus()){//sysj\liquidDumperController.sysj line: 112, column: 46
                            S157208=1;
                            thread224913(tdone,ends);
                            thread224914(tdone,ends);
                            thread224915(tdone,ends);
                            int biggest224916 = 0;
                            if(ends[6]>=biggest224916){
                              biggest224916=ends[6];
                            }
                            if(ends[7]>=biggest224916){
                              biggest224916=ends[7];
                            }
                            if(ends[8]>=biggest224916){
                              biggest224916=ends[8];
                            }
                            if(biggest224916 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      S156859=0;
                      if(auto_1.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 23
                        S156859=1;
                        thread224917(tdone,ends);
                        thread224918(tdone,ends);
                        int biggest224919 = 0;
                        if(ends[4]>=biggest224919){
                          biggest224919=ends[4];
                        }
                        if(ends[5]>=biggest224919){
                          biggest224919=ends[5];
                        }
                        if(biggest224919 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(invertRotateExtendM.getprestatus()){//sysj\liquidDumperController.sysj line: 105, column: 46
                          S156859=1;
                          thread224920(tdone,ends);
                          thread224921(tdone,ends);
                          int biggest224922 = 0;
                          if(ends[4]>=biggest224922){
                            biggest224922=ends[4];
                          }
                          if(ends[5]>=biggest224922){
                            biggest224922=ends[5];
                          }
                          if(biggest224922 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    cylClampBottleExtend.setPresent();//sysj\liquidDumperController.sysj line: 100, column: 7
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
              S156781=2;
              S166576=0;
              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\liquidDumperController.sysj line: 152, column: 5
                status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                S166576=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S166571=0;
                if(status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                  status_o.setVal(new Integer(code_thread_3));//sysj\liquidDumperController.sysj line: 152, column: 5
                  S166571=1;
                  if(!status_o.isACK()){//sysj\liquidDumperController.sysj line: 152, column: 5
                    status_o.setREQ(false);//sysj\liquidDumperController.sysj line: 152, column: 5
                    ends[3]=2;
                    ;//sysj\liquidDumperController.sysj line: 152, column: 5
                    S168111=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
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

  public void thread224881(int [] tdone, int [] ends){
        S156757=1;
    if(mode.getprestatus()){//sysj\liquidDumperController.sysj line: 59, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\liquidDumperController.sysj line: 62, column: 8
        auto_1.setPresent();//sysj\liquidDumperController.sysj line: 62, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\liquidDumperController.sysj line: 63, column: 13
          manual_1.setPresent();//sysj\liquidDumperController.sysj line: 63, column: 35
          currsigs.addElement(manual_1);
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
      switch(S224879){
        case 0 : 
          S224879=0;
          break RUN;
        
        case 1 : 
          S224879=2;
          S224879=2;
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 55, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 55, column: 2
          thread224881(tdone,ends);
          thread224882(tdone,ends);
          int biggest224923 = 0;
          if(ends[2]>=biggest224923){
            biggest224923=ends[2];
          }
          if(ends[3]>=biggest224923){
            biggest224923=ends[3];
          }
          if(biggest224923 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\liquidDumperController.sysj line: 55, column: 2
          manual_1.setClear();//sysj\liquidDumperController.sysj line: 55, column: 2
          thread224924(tdone,ends);
          thread224925(tdone,ends);
          int biggest225216 = 0;
          if(ends[2]>=biggest225216){
            biggest225216=ends[2];
          }
          if(ends[3]>=biggest225216){
            biggest225216=ends[3];
          }
          if(biggest225216 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest225216 == 0){
            S224879=0;
            active[1]=0;
            ends[1]=0;
            S224879=0;
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
