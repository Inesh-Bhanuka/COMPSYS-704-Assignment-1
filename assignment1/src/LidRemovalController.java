import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidRemovalController extends ClockDomain{
  public LidRemovalController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal zAxisLowered = new Signal("zAxisLowered", Signal.INPUT);
  public Signal zAxisLifted = new Signal("zAxisLifted", Signal.INPUT);
  public Signal turnAtHomePos = new Signal("turnAtHomePos", Signal.INPUT);
  public Signal turnAtFinalPos = new Signal("turnAtFinalPos", Signal.INPUT);
  public Signal lidGripped = new Signal("lidGripped", Signal.INPUT);
  public Signal lidBinFull = new Signal("lidBinFull", Signal.INPUT);
  public Signal cylZaxisExtendM = new Signal("cylZaxisExtendM", Signal.INPUT);
  public Signal unscrewTurnExtendM = new Signal("unscrewTurnExtendM", Signal.INPUT);
  public Signal unscrewTurnRetractM = new Signal("unscrewTurnRetractM", Signal.INPUT);
  public Signal lidGripperExtendM = new Signal("lidGripperExtendM", Signal.INPUT);
  public Signal lidEjectExtendM = new Signal("lidEjectExtendM", Signal.INPUT);
  public Signal cylZaxisExtend = new Signal("cylZaxisExtend", Signal.OUTPUT);
  public Signal unscrewTurnExtend = new Signal("unscrewTurnExtend", Signal.OUTPUT);
  public Signal unscrewTurnRetract = new Signal("unscrewTurnRetract", Signal.OUTPUT);
  public Signal lidGripperExtend = new Signal("lidGripperExtend", Signal.OUTPUT);
  public Signal lidEjectExtend = new Signal("lidEjectExtend", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int OK_thread_3;//sysj\lidRemovalController.sysj line: 62, column: 3
  private int BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 63, column: 3
  private WorkpieceTwin w_thread_3;//sysj\lidRemovalController.sysj line: 65, column: 3
  private int code_thread_3;//sysj\lidRemovalController.sysj line: 66, column: 3
  private int S155995 = 1;
  private int S105621 = 1;
  private int S155993 = 1;
  private int S114017 = 1;
  private int S105645 = 1;
  private int S105629 = 1;
  private int S105624 = 1;
  private int S105650 = 1;
  private int S105723 = 1;
  private int S105677 = 1;
  private int S105682 = 1;
  private int S106047 = 1;
  private int S106001 = 1;
  private int S106006 = 1;
  private int S111052 = 1;
  private int S111047 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread156186(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156185(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156183(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156182(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156180(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156179(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156177(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156176(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156174(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156173(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156171(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156170(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156168(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156167(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156165(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156164(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156162(int [] tdone, int [] ends){
        switch(S106006){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
        currsigs.addElement(unscrewTurnExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread156161(int [] tdone, int [] ends){
        switch(S106001){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
        currsigs.addElement(cylZaxisExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread156159(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156158(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156156(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156155(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156153(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156152(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156150(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156149(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156147(int [] tdone, int [] ends){
        switch(S105682){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
        currsigs.addElement(lidGripperExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread156146(int [] tdone, int [] ends){
        switch(S105677){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
        currsigs.addElement(cylZaxisExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread156144(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156143(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156141(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156140(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156138(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156137(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156135(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156134(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156132(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156131(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156129(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156128(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156126(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156125(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156123(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156122(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156120(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156119(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156117(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156116(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156114(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156113(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156111(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156110(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156108(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156107(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156105(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156104(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156102(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156101(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156099(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156098(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156096(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156095(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156093(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156092(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156090(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156089(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156087(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156086(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156084(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156083(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156081(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156080(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156078(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156077(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156075(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156074(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156072(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156071(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156069(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156068(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156066(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156065(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156063(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156062(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156060(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156059(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156057(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156056(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156054(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156053(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156051(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156050(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156048(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156047(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156045(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156044(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156042(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156041(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156039(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156038(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156036(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156035(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156033(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156032(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156030(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156029(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156027(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156026(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156025(int [] tdone, int [] ends){
        switch(S155993){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S114017){
          case 0 : 
            if(reset.getprestatus()){//sysj\lidRemovalController.sysj line: 69, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S114017=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S105645){
                case 0 : 
                  switch(S105629){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 70, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
                        S105629=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S105624){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
                              enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 70, column: 5
                              S105624=1;
                              if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
                                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 70, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 71, column: 5
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 79, column: 5
                                S105645=1;
                                if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 81, column: 8
                                  System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 82, column: 6
                                  S105650=0;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 22
                                    S105650=1;
                                    if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                                      S105650=2;
                                      if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                                        System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                                        S105650=3;
                                        if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                          S105650=4;
                                          if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                            S105650=5;
                                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                              S105650=6;
                                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                                S105650=7;
                                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                  S105650=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                    S105650=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                    S105650=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                      S105650=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                                currsigs.addElement(unscrewTurnRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                                S105650=6;
                                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                                  S105650=7;
                                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                    S105650=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                      S105650=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                      S105650=8;
                                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                        S105650=9;
                                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                            S105645=2;
                                                            S111052=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111052=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S111047=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S111047=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  S114017=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
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
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                        currsigs.addElement(lidEjectExtend);
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                                  currsigs.addElement(unscrewTurnRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S106047=0;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                            S106047=1;
                                            thread156026(tdone,ends);
                                            thread156027(tdone,ends);
                                            int biggest156028 = 0;
                                            if(ends[6]>=biggest156028){
                                              biggest156028=ends[6];
                                            }
                                            if(ends[7]>=biggest156028){
                                              biggest156028=ends[7];
                                            }
                                            if(biggest156028 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                              S106047=1;
                                              thread156029(tdone,ends);
                                              thread156030(tdone,ends);
                                              int biggest156031 = 0;
                                              if(ends[6]>=biggest156031){
                                                biggest156031=ends[6];
                                              }
                                              if(ends[7]>=biggest156031){
                                                biggest156031=ends[7];
                                              }
                                              if(biggest156031 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S105723=0;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                                          S105723=1;
                                          thread156032(tdone,ends);
                                          thread156033(tdone,ends);
                                          int biggest156034 = 0;
                                          if(ends[4]>=biggest156034){
                                            biggest156034=ends[4];
                                          }
                                          if(ends[5]>=biggest156034){
                                            biggest156034=ends[5];
                                          }
                                          if(biggest156034 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                            S105723=1;
                                            thread156035(tdone,ends);
                                            thread156036(tdone,ends);
                                            int biggest156037 = 0;
                                            if(ends[4]>=biggest156037){
                                              biggest156037=ends[4];
                                            }
                                            if(ends[5]>=biggest156037){
                                              biggest156037=ends[5];
                                            }
                                            if(biggest156037 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                                      currsigs.addElement(cylZaxisExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 45
                                      S105650=1;
                                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                                        S105650=2;
                                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                                          S105650=3;
                                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                            S105650=4;
                                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                              S105650=5;
                                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                                S105650=6;
                                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                                  S105650=7;
                                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                    S105650=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                      S105650=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                      S105650=8;
                                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                        S105650=9;
                                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                            S105645=2;
                                                            S111052=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111052=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S111047=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S111047=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  S114017=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
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
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                        currsigs.addElement(lidEjectExtend);
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                                  currsigs.addElement(unscrewTurnRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                                  S105650=6;
                                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                                    S105650=7;
                                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                      S105650=8;
                                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                        S105650=9;
                                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                            S105645=2;
                                                            S111052=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111052=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S111047=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S111047=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  S114017=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
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
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                        currsigs.addElement(lidEjectExtend);
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                        S105650=8;
                                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                          S105650=9;
                                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                              S105645=2;
                                                              S111052=0;
                                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S111052=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                S111047=0;
                                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  S111047=1;
                                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                    ends[3]=2;
                                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                    S114017=1;
                                                                    active[3]=1;
                                                                    ends[3]=1;
                                                                    tdone[3]=1;
                                                                  }
                                                                  else {
                                                                    active[3]=1;
                                                                    ends[3]=1;
                                                                    tdone[3]=1;
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
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            S105645=2;
                                                            S111052=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111052=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S111047=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S111047=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  S114017=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                          currsigs.addElement(lidEjectExtend);
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                                    currsigs.addElement(unscrewTurnRetract);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S106047=0;
                                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                              S106047=1;
                                              thread156038(tdone,ends);
                                              thread156039(tdone,ends);
                                              int biggest156040 = 0;
                                              if(ends[6]>=biggest156040){
                                                biggest156040=ends[6];
                                              }
                                              if(ends[7]>=biggest156040){
                                                biggest156040=ends[7];
                                              }
                                              if(biggest156040 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                                S106047=1;
                                                thread156041(tdone,ends);
                                                thread156042(tdone,ends);
                                                int biggest156043 = 0;
                                                if(ends[6]>=biggest156043){
                                                  biggest156043=ends[6];
                                                }
                                                if(ends[7]>=biggest156043){
                                                  biggest156043=ends[7];
                                                }
                                                if(biggest156043 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          S105723=0;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                                            S105723=1;
                                            thread156044(tdone,ends);
                                            thread156045(tdone,ends);
                                            int biggest156046 = 0;
                                            if(ends[4]>=biggest156046){
                                              biggest156046=ends[4];
                                            }
                                            if(ends[5]>=biggest156046){
                                              biggest156046=ends[5];
                                            }
                                            if(biggest156046 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                              S105723=1;
                                              thread156047(tdone,ends);
                                              thread156048(tdone,ends);
                                              int biggest156049 = 0;
                                              if(ends[4]>=biggest156049){
                                                biggest156049=ends[4];
                                              }
                                              if(ends[5]>=biggest156049){
                                                biggest156049=ends[5];
                                              }
                                              if(biggest156049 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                                        currsigs.addElement(cylZaxisExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  S105645=2;
                                  S111052=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111052=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111047=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111047=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114017=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
                              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 70, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 71, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 79, column: 5
                              S105645=1;
                              if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 81, column: 8
                                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 82, column: 6
                                S105650=0;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 22
                                  S105650=1;
                                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                                    S105650=2;
                                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                                      S105650=3;
                                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                        S105650=4;
                                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                          S105650=5;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                            S105650=6;
                                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                              S105650=7;
                                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                S105650=8;
                                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                  S105650=9;
                                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    S105645=2;
                                                    S111052=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111052=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S111047=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111047=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S114017=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                  currsigs.addElement(lidEjectExtend);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                  S105650=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                    S105650=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                              currsigs.addElement(unscrewTurnRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                              S105650=6;
                                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                                S105650=7;
                                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                  S105650=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                    S105650=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                    S105650=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                      S105650=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                                currsigs.addElement(unscrewTurnRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S106047=0;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                          S106047=1;
                                          thread156050(tdone,ends);
                                          thread156051(tdone,ends);
                                          int biggest156052 = 0;
                                          if(ends[6]>=biggest156052){
                                            biggest156052=ends[6];
                                          }
                                          if(ends[7]>=biggest156052){
                                            biggest156052=ends[7];
                                          }
                                          if(biggest156052 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                            S106047=1;
                                            thread156053(tdone,ends);
                                            thread156054(tdone,ends);
                                            int biggest156055 = 0;
                                            if(ends[6]>=biggest156055){
                                              biggest156055=ends[6];
                                            }
                                            if(ends[7]>=biggest156055){
                                              biggest156055=ends[7];
                                            }
                                            if(biggest156055 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S105723=0;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                                        S105723=1;
                                        thread156056(tdone,ends);
                                        thread156057(tdone,ends);
                                        int biggest156058 = 0;
                                        if(ends[4]>=biggest156058){
                                          biggest156058=ends[4];
                                        }
                                        if(ends[5]>=biggest156058){
                                          biggest156058=ends[5];
                                        }
                                        if(biggest156058 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                          S105723=1;
                                          thread156059(tdone,ends);
                                          thread156060(tdone,ends);
                                          int biggest156061 = 0;
                                          if(ends[4]>=biggest156061){
                                            biggest156061=ends[4];
                                          }
                                          if(ends[5]>=biggest156061){
                                            biggest156061=ends[5];
                                          }
                                          if(biggest156061 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                                    currsigs.addElement(cylZaxisExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 45
                                    S105650=1;
                                    if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                                      S105650=2;
                                      if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                                        System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                                        S105650=3;
                                        if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                          S105650=4;
                                          if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                            S105650=5;
                                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                              S105650=6;
                                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                                S105650=7;
                                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                  S105650=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                    S105650=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                    S105650=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                      S105650=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                                currsigs.addElement(unscrewTurnRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                                S105650=6;
                                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                                  S105650=7;
                                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                    S105650=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                      S105650=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                      S105650=8;
                                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                        S105650=9;
                                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                            S105645=2;
                                                            S111052=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111052=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S111047=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S111047=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                  S114017=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
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
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                        currsigs.addElement(lidEjectExtend);
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                                  currsigs.addElement(unscrewTurnRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S106047=0;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                            S106047=1;
                                            thread156062(tdone,ends);
                                            thread156063(tdone,ends);
                                            int biggest156064 = 0;
                                            if(ends[6]>=biggest156064){
                                              biggest156064=ends[6];
                                            }
                                            if(ends[7]>=biggest156064){
                                              biggest156064=ends[7];
                                            }
                                            if(biggest156064 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                              S106047=1;
                                              thread156065(tdone,ends);
                                              thread156066(tdone,ends);
                                              int biggest156067 = 0;
                                              if(ends[6]>=biggest156067){
                                                biggest156067=ends[6];
                                              }
                                              if(ends[7]>=biggest156067){
                                                biggest156067=ends[7];
                                              }
                                              if(biggest156067 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S105723=0;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                                          S105723=1;
                                          thread156068(tdone,ends);
                                          thread156069(tdone,ends);
                                          int biggest156070 = 0;
                                          if(ends[4]>=biggest156070){
                                            biggest156070=ends[4];
                                          }
                                          if(ends[5]>=biggest156070){
                                            biggest156070=ends[5];
                                          }
                                          if(biggest156070 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                            S105723=1;
                                            thread156071(tdone,ends);
                                            thread156072(tdone,ends);
                                            int biggest156073 = 0;
                                            if(ends[4]>=biggest156073){
                                              biggest156073=ends[4];
                                            }
                                            if(ends[5]>=biggest156073){
                                              biggest156073=ends[5];
                                            }
                                            if(biggest156073 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                                      currsigs.addElement(cylZaxisExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                S105645=2;
                                S111052=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111052=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111047=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111047=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114017=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                      S105629=1;
                      S105629=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 70, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
                        S105629=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S105624=0;
                        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
                          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 70, column: 5
                          S105624=1;
                          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
                            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 70, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 71, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 79, column: 5
                            S105645=1;
                            if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 81, column: 8
                              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 82, column: 6
                              S105650=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 22
                                S105650=1;
                                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                                  S105650=2;
                                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                                    S105650=3;
                                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                      S105650=4;
                                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                        S105650=5;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                          S105650=6;
                                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                            S105650=7;
                                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                              S105650=8;
                                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                S105650=9;
                                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                    S105645=2;
                                                    S111052=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111052=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S111047=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111047=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S114017=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  S105645=2;
                                                  S111052=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111052=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S111047=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111047=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S114017=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                              }
                                              else {
                                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                currsigs.addElement(lidEjectExtend);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                S105650=8;
                                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                  S105650=9;
                                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    S105645=2;
                                                    S111052=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111052=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S111047=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111047=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S114017=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                  currsigs.addElement(lidEjectExtend);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                            currsigs.addElement(unscrewTurnRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                            S105650=6;
                                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                              S105650=7;
                                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                S105650=8;
                                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                  S105650=9;
                                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    S105645=2;
                                                    S111052=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111052=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S111047=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111047=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S114017=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                  currsigs.addElement(lidEjectExtend);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                  S105650=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                    S105650=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                              currsigs.addElement(unscrewTurnRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S106047=0;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                        S106047=1;
                                        thread156074(tdone,ends);
                                        thread156075(tdone,ends);
                                        int biggest156076 = 0;
                                        if(ends[6]>=biggest156076){
                                          biggest156076=ends[6];
                                        }
                                        if(ends[7]>=biggest156076){
                                          biggest156076=ends[7];
                                        }
                                        if(biggest156076 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                          S106047=1;
                                          thread156077(tdone,ends);
                                          thread156078(tdone,ends);
                                          int biggest156079 = 0;
                                          if(ends[6]>=biggest156079){
                                            biggest156079=ends[6];
                                          }
                                          if(ends[7]>=biggest156079){
                                            biggest156079=ends[7];
                                          }
                                          if(biggest156079 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    S105723=0;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                                      S105723=1;
                                      thread156080(tdone,ends);
                                      thread156081(tdone,ends);
                                      int biggest156082 = 0;
                                      if(ends[4]>=biggest156082){
                                        biggest156082=ends[4];
                                      }
                                      if(ends[5]>=biggest156082){
                                        biggest156082=ends[5];
                                      }
                                      if(biggest156082 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                        S105723=1;
                                        thread156083(tdone,ends);
                                        thread156084(tdone,ends);
                                        int biggest156085 = 0;
                                        if(ends[4]>=biggest156085){
                                          biggest156085=ends[4];
                                        }
                                        if(ends[5]>=biggest156085){
                                          biggest156085=ends[5];
                                        }
                                        if(biggest156085 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                                  currsigs.addElement(cylZaxisExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 45
                                  S105650=1;
                                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                                    S105650=2;
                                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                                      S105650=3;
                                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                        S105650=4;
                                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                          S105650=5;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                            S105650=6;
                                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                              S105650=7;
                                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                S105650=8;
                                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                  S105650=9;
                                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    S105645=2;
                                                    S111052=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111052=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S111047=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111047=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S114017=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                  currsigs.addElement(lidEjectExtend);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                  S105650=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                    S105650=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                              currsigs.addElement(unscrewTurnRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                              S105650=6;
                                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                                S105650=7;
                                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                                  S105650=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                    S105650=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      S105645=2;
                                                      S111052=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S111052=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S111047=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111047=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S114017=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                                    S105650=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                                      S105650=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                          S105645=2;
                                                          S111052=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111052=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S111047=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S111047=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                                S114017=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        S105645=2;
                                                        S111052=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                          S111052=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S111047=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                            S111047=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                              S114017=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                                currsigs.addElement(unscrewTurnRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S106047=0;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                          S106047=1;
                                          thread156086(tdone,ends);
                                          thread156087(tdone,ends);
                                          int biggest156088 = 0;
                                          if(ends[6]>=biggest156088){
                                            biggest156088=ends[6];
                                          }
                                          if(ends[7]>=biggest156088){
                                            biggest156088=ends[7];
                                          }
                                          if(biggest156088 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                            S106047=1;
                                            thread156089(tdone,ends);
                                            thread156090(tdone,ends);
                                            int biggest156091 = 0;
                                            if(ends[6]>=biggest156091){
                                              biggest156091=ends[6];
                                            }
                                            if(ends[7]>=biggest156091){
                                              biggest156091=ends[7];
                                            }
                                            if(biggest156091 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S105723=0;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                                        S105723=1;
                                        thread156092(tdone,ends);
                                        thread156093(tdone,ends);
                                        int biggest156094 = 0;
                                        if(ends[4]>=biggest156094){
                                          biggest156094=ends[4];
                                        }
                                        if(ends[5]>=biggest156094){
                                          biggest156094=ends[5];
                                        }
                                        if(biggest156094 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                          S105723=1;
                                          thread156095(tdone,ends);
                                          thread156096(tdone,ends);
                                          int biggest156097 = 0;
                                          if(ends[4]>=biggest156097){
                                            biggest156097=ends[4];
                                          }
                                          if(ends[5]>=biggest156097){
                                            biggest156097=ends[5];
                                          }
                                          if(biggest156097 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                                    currsigs.addElement(cylZaxisExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              S105645=2;
                              S111052=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111052=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S111047=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111047=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S114017=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                  switch(S105650){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 22
                        S105650=1;
                        if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                          S105650=2;
                          if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                            System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                            S105650=3;
                            if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                              S105650=4;
                              if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                S105650=5;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                  S105650=6;
                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                    S105650=7;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                      S105650=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                        S105650=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                    currsigs.addElement(unscrewTurnRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                    S105650=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                      S105650=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S106047=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                S106047=1;
                                thread156098(tdone,ends);
                                thread156099(tdone,ends);
                                int biggest156100 = 0;
                                if(ends[6]>=biggest156100){
                                  biggest156100=ends[6];
                                }
                                if(ends[7]>=biggest156100){
                                  biggest156100=ends[7];
                                }
                                if(biggest156100 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                  S106047=1;
                                  thread156101(tdone,ends);
                                  thread156102(tdone,ends);
                                  int biggest156103 = 0;
                                  if(ends[6]>=biggest156103){
                                    biggest156103=ends[6];
                                  }
                                  if(ends[7]>=biggest156103){
                                    biggest156103=ends[7];
                                  }
                                  if(biggest156103 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S105723=0;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                              S105723=1;
                              thread156104(tdone,ends);
                              thread156105(tdone,ends);
                              int biggest156106 = 0;
                              if(ends[4]>=biggest156106){
                                biggest156106=ends[4];
                              }
                              if(ends[5]>=biggest156106){
                                biggest156106=ends[5];
                              }
                              if(biggest156106 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                S105723=1;
                                thread156107(tdone,ends);
                                thread156108(tdone,ends);
                                int biggest156109 = 0;
                                if(ends[4]>=biggest156109){
                                  biggest156109=ends[4];
                                }
                                if(ends[5]>=biggest156109){
                                  biggest156109=ends[5];
                                }
                                if(biggest156109 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                          currsigs.addElement(cylZaxisExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 45
                          S105650=1;
                          if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                            S105650=2;
                            if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                              System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                              S105650=3;
                              if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                S105650=4;
                                if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                  S105650=5;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                    S105650=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                      S105650=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                      S105650=6;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                        S105650=7;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                            S105650=8;
                                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                              S105650=9;
                                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                  S105645=2;
                                                  S111052=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111052=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S111047=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111047=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S114017=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                              currsigs.addElement(lidEjectExtend);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                        currsigs.addElement(unscrewTurnRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S106047=0;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                  S106047=1;
                                  thread156110(tdone,ends);
                                  thread156111(tdone,ends);
                                  int biggest156112 = 0;
                                  if(ends[6]>=biggest156112){
                                    biggest156112=ends[6];
                                  }
                                  if(ends[7]>=biggest156112){
                                    biggest156112=ends[7];
                                  }
                                  if(biggest156112 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                    S106047=1;
                                    thread156113(tdone,ends);
                                    thread156114(tdone,ends);
                                    int biggest156115 = 0;
                                    if(ends[6]>=biggest156115){
                                      biggest156115=ends[6];
                                    }
                                    if(ends[7]>=biggest156115){
                                      biggest156115=ends[7];
                                    }
                                    if(biggest156115 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S105723=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                                S105723=1;
                                thread156116(tdone,ends);
                                thread156117(tdone,ends);
                                int biggest156118 = 0;
                                if(ends[4]>=biggest156118){
                                  biggest156118=ends[4];
                                }
                                if(ends[5]>=biggest156118){
                                  biggest156118=ends[5];
                                }
                                if(biggest156118 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                  S105723=1;
                                  thread156119(tdone,ends);
                                  thread156120(tdone,ends);
                                  int biggest156121 = 0;
                                  if(ends[4]>=biggest156121){
                                    biggest156121=ends[4];
                                  }
                                  if(ends[5]>=biggest156121){
                                    biggest156121=ends[5];
                                  }
                                  if(biggest156121 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                            currsigs.addElement(cylZaxisExtend);
                            active[3]=1;
                            ends[3]=1;
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
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                        S105650=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                          S105650=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                            S105650=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                              S105650=5;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                S105650=6;
                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                  S105650=7;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                    S105650=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                      S105650=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                      currsigs.addElement(lidEjectExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                      S105650=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                        S105650=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                  currsigs.addElement(unscrewTurnRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                  S105650=6;
                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                    S105650=7;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                      S105650=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                        S105650=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                    currsigs.addElement(unscrewTurnRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S106047=0;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                              S106047=1;
                              thread156122(tdone,ends);
                              thread156123(tdone,ends);
                              int biggest156124 = 0;
                              if(ends[6]>=biggest156124){
                                biggest156124=ends[6];
                              }
                              if(ends[7]>=biggest156124){
                                biggest156124=ends[7];
                              }
                              if(biggest156124 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                S106047=1;
                                thread156125(tdone,ends);
                                thread156126(tdone,ends);
                                int biggest156127 = 0;
                                if(ends[6]>=biggest156127){
                                  biggest156127=ends[6];
                                }
                                if(ends[7]>=biggest156127){
                                  biggest156127=ends[7];
                                }
                                if(biggest156127 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          S105723=0;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                            S105723=1;
                            thread156128(tdone,ends);
                            thread156129(tdone,ends);
                            int biggest156130 = 0;
                            if(ends[4]>=biggest156130){
                              biggest156130=ends[4];
                            }
                            if(ends[5]>=biggest156130){
                              biggest156130=ends[5];
                            }
                            if(biggest156130 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                              S105723=1;
                              thread156131(tdone,ends);
                              thread156132(tdone,ends);
                              int biggest156133 = 0;
                              if(ends[4]>=biggest156133){
                                biggest156133=ends[4];
                              }
                              if(ends[5]>=biggest156133){
                                biggest156133=ends[5];
                              }
                              if(biggest156133 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                        currsigs.addElement(cylZaxisExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                        System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                        S105650=3;
                        if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                          S105650=4;
                          if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                            S105650=5;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                              S105650=6;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                S105650=7;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                  S105650=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S105650=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                    S105650=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                      S105650=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                      currsigs.addElement(lidEjectExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                currsigs.addElement(unscrewTurnRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                S105650=6;
                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                  S105650=7;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                    S105650=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                      S105650=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                      currsigs.addElement(lidEjectExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                      S105650=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                        S105650=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                  currsigs.addElement(unscrewTurnRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S106047=0;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                            S106047=1;
                            thread156134(tdone,ends);
                            thread156135(tdone,ends);
                            int biggest156136 = 0;
                            if(ends[6]>=biggest156136){
                              biggest156136=ends[6];
                            }
                            if(ends[7]>=biggest156136){
                              biggest156136=ends[7];
                            }
                            if(biggest156136 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                              S106047=1;
                              thread156137(tdone,ends);
                              thread156138(tdone,ends);
                              int biggest156139 = 0;
                              if(ends[6]>=biggest156139){
                                biggest156139=ends[6];
                              }
                              if(ends[7]>=biggest156139){
                                biggest156139=ends[7];
                              }
                              if(biggest156139 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        switch(S105723){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                              S105723=1;
                              thread156140(tdone,ends);
                              thread156141(tdone,ends);
                              int biggest156142 = 0;
                              if(ends[4]>=biggest156142){
                                biggest156142=ends[4];
                              }
                              if(ends[5]>=biggest156142){
                                biggest156142=ends[5];
                              }
                              if(biggest156142 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                S105723=1;
                                thread156143(tdone,ends);
                                thread156144(tdone,ends);
                                int biggest156145 = 0;
                                if(ends[4]>=biggest156145){
                                  biggest156145=ends[4];
                                }
                                if(ends[5]>=biggest156145){
                                  biggest156145=ends[5];
                                }
                                if(biggest156145 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                            thread156146(tdone,ends);
                            thread156147(tdone,ends);
                            int biggest156148 = 0;
                            if(ends[4]>=biggest156148){
                              biggest156148=ends[4];
                            }
                            if(ends[5]>=biggest156148){
                              biggest156148=ends[5];
                            }
                            if(biggest156148 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest156148 == 0){
                              System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                              S105650=3;
                              if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                S105650=4;
                                if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                  S105650=5;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                    S105650=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                      S105650=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                      S105650=6;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                        S105650=7;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                            S105650=8;
                                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                              S105650=9;
                                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                  S105645=2;
                                                  S111052=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111052=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S111047=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111047=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S114017=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                              currsigs.addElement(lidEjectExtend);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                        currsigs.addElement(unscrewTurnRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S106047=0;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                  S106047=1;
                                  thread156149(tdone,ends);
                                  thread156150(tdone,ends);
                                  int biggest156151 = 0;
                                  if(ends[6]>=biggest156151){
                                    biggest156151=ends[6];
                                  }
                                  if(ends[7]>=biggest156151){
                                    biggest156151=ends[7];
                                  }
                                  if(biggest156151 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                    S106047=1;
                                    thread156152(tdone,ends);
                                    thread156153(tdone,ends);
                                    int biggest156154 = 0;
                                    if(ends[6]>=biggest156154){
                                      biggest156154=ends[6];
                                    }
                                    if(ends[7]>=biggest156154){
                                      biggest156154=ends[7];
                                    }
                                    if(biggest156154 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                        S105650=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                          S105650=5;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                            S105650=6;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                              S105650=7;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                S105650=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S105650=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                  S105650=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S105650=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                              currsigs.addElement(unscrewTurnRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                              S105650=6;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                S105650=7;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                  S105650=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S105650=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                    S105650=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                      S105650=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                      currsigs.addElement(lidEjectExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                currsigs.addElement(unscrewTurnRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        switch(S106047){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                              S106047=1;
                              thread156155(tdone,ends);
                              thread156156(tdone,ends);
                              int biggest156157 = 0;
                              if(ends[6]>=biggest156157){
                                biggest156157=ends[6];
                              }
                              if(ends[7]>=biggest156157){
                                biggest156157=ends[7];
                              }
                              if(biggest156157 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                S106047=1;
                                thread156158(tdone,ends);
                                thread156159(tdone,ends);
                                int biggest156160 = 0;
                                if(ends[6]>=biggest156160){
                                  biggest156160=ends[6];
                                }
                                if(ends[7]>=biggest156160){
                                  biggest156160=ends[7];
                                }
                                if(biggest156160 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                            thread156161(tdone,ends);
                            thread156162(tdone,ends);
                            int biggest156163 = 0;
                            if(ends[6]>=biggest156163){
                              biggest156163=ends[6];
                            }
                            if(ends[7]>=biggest156163){
                              biggest156163=ends[7];
                            }
                            if(biggest156163 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest156163 == 0){
                              S105650=4;
                              if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                S105650=5;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                  S105650=6;
                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                    S105650=7;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                      S105650=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                        S105650=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                    currsigs.addElement(unscrewTurnRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                    S105650=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                      S105650=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            break;
                          
                        }
                      }
                      break;
                    
                    case 4 : 
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                        S105650=5;
                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                          S105650=6;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                            S105650=7;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                              S105650=8;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                S105650=9;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S105645=2;
                                  S111052=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111052=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111047=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111047=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114017=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                S105650=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S105650=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                            currsigs.addElement(unscrewTurnRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                            S105650=6;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                              S105650=7;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                S105650=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S105650=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                  S105650=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S105650=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                              currsigs.addElement(unscrewTurnRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 5 : 
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                        S105650=6;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                          S105650=7;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                            S105650=8;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                              S105650=9;
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                  S105645=2;
                                  S111052=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111052=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111047=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111047=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114017=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S105645=2;
                                S111052=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111052=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111047=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111047=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114017=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                              S105650=8;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                S105650=9;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S105645=2;
                                  S111052=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111052=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111047=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111047=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114017=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                          currsigs.addElement(unscrewTurnRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                          S105650=6;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                            S105650=7;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                              S105650=8;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                S105650=9;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S105645=2;
                                  S111052=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111052=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111047=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111047=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114017=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                S105650=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S105650=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                            currsigs.addElement(unscrewTurnRetract);
                            active[3]=1;
                            ends[3]=1;
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
                    
                    case 6 : 
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                        S105650=7;
                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                          S105650=8;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                            S105650=9;
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                S105645=2;
                                S111052=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111052=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111047=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111047=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114017=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S105645=2;
                              S111052=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111052=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S111047=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111047=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S114017=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                            S105650=8;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                              S105650=9;
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                  S105645=2;
                                  S111052=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111052=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111047=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111047=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114017=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S105645=2;
                                S111052=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111052=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111047=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111047=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114017=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                        currsigs.addElement(unscrewTurnRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 7 : 
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                        S105650=8;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                          S105650=9;
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                              S105645=2;
                              S111052=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111052=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S111047=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111047=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S114017=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S105645=2;
                            S111052=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              S111052=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S111047=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111047=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S114017=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                          S105650=8;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                            S105650=9;
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                S105645=2;
                                S111052=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111052=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111047=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111047=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114017=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S105645=2;
                              S111052=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111052=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S111047=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111047=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S114017=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
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
                    
                    case 8 : 
                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                        S105650=9;
                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                            S105645=2;
                            S111052=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              S111052=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S111047=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111047=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S114017=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S105645=2;
                          S111052=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                            S111052=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S111047=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                              S111047=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                S114017=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                        currsigs.addElement(lidEjectExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 9 : 
                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                        S105645=2;
                        S111052=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                          S111052=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S111047=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                            S111047=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                              S114017=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 2 : 
                  switch(S111052){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                        S111052=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S111047){
                          case 0 : 
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                              S111047=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                S114017=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                              S114017=1;
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
                      S111052=1;
                      S111052=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                        S111052=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S111047=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                          S111047=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                            S114017=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                
              }
            }
            break;
          
          case 1 : 
            S114017=1;
            S114017=0;
            if(reset.getprestatus()){//sysj\lidRemovalController.sysj line: 69, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S114017=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S105645=0;
              S105629=0;
              if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 70, column: 5
                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
                S105629=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S105624=0;
                if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
                  enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 70, column: 5
                  S105624=1;
                  if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
                    enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
                    ends[3]=2;
                    ;//sysj\lidRemovalController.sysj line: 70, column: 5
                    w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 71, column: 5
                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 79, column: 5
                    S105645=1;
                    if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 81, column: 8
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 82, column: 6
                      S105650=0;
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 22
                        S105650=1;
                        if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                          S105650=2;
                          if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                            System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                            S105650=3;
                            if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                              S105650=4;
                              if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                S105650=5;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                  S105650=6;
                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                    S105650=7;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                      S105650=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                        S105650=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                    currsigs.addElement(unscrewTurnRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                    S105650=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                      S105650=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S106047=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                S106047=1;
                                thread156164(tdone,ends);
                                thread156165(tdone,ends);
                                int biggest156166 = 0;
                                if(ends[6]>=biggest156166){
                                  biggest156166=ends[6];
                                }
                                if(ends[7]>=biggest156166){
                                  biggest156166=ends[7];
                                }
                                if(biggest156166 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                  S106047=1;
                                  thread156167(tdone,ends);
                                  thread156168(tdone,ends);
                                  int biggest156169 = 0;
                                  if(ends[6]>=biggest156169){
                                    biggest156169=ends[6];
                                  }
                                  if(ends[7]>=biggest156169){
                                    biggest156169=ends[7];
                                  }
                                  if(biggest156169 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S105723=0;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                              S105723=1;
                              thread156170(tdone,ends);
                              thread156171(tdone,ends);
                              int biggest156172 = 0;
                              if(ends[4]>=biggest156172){
                                biggest156172=ends[4];
                              }
                              if(ends[5]>=biggest156172){
                                biggest156172=ends[5];
                              }
                              if(biggest156172 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                S105723=1;
                                thread156173(tdone,ends);
                                thread156174(tdone,ends);
                                int biggest156175 = 0;
                                if(ends[4]>=biggest156175){
                                  biggest156175=ends[4];
                                }
                                if(ends[5]>=biggest156175){
                                  biggest156175=ends[5];
                                }
                                if(biggest156175 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                          currsigs.addElement(cylZaxisExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 45
                          S105650=1;
                          if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                            S105650=2;
                            if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                              System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                              S105650=3;
                              if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                                S105650=4;
                                if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                                  S105650=5;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                                    S105650=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                      S105650=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                        S105650=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S105650=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S105645=2;
                                            S111052=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111052=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111047=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111047=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114017=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                                      S105650=6;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                        S105650=7;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                          S105650=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S105650=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S105645=2;
                                              S111052=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111052=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111047=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111047=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114017=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                            S105650=8;
                                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                              S105650=9;
                                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                  S105645=2;
                                                  S111052=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111052=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S111047=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111047=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S114017=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                S105645=2;
                                                S111052=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111052=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111047=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111047=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114017=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                              currsigs.addElement(lidEjectExtend);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                        currsigs.addElement(unscrewTurnRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S106047=0;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                                  S106047=1;
                                  thread156176(tdone,ends);
                                  thread156177(tdone,ends);
                                  int biggest156178 = 0;
                                  if(ends[6]>=biggest156178){
                                    biggest156178=ends[6];
                                  }
                                  if(ends[7]>=biggest156178){
                                    biggest156178=ends[7];
                                  }
                                  if(biggest156178 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                                    S106047=1;
                                    thread156179(tdone,ends);
                                    thread156180(tdone,ends);
                                    int biggest156181 = 0;
                                    if(ends[6]>=biggest156181){
                                      biggest156181=ends[6];
                                    }
                                    if(ends[7]>=biggest156181){
                                      biggest156181=ends[7];
                                    }
                                    if(biggest156181 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S105723=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                                S105723=1;
                                thread156182(tdone,ends);
                                thread156183(tdone,ends);
                                int biggest156184 = 0;
                                if(ends[4]>=biggest156184){
                                  biggest156184=ends[4];
                                }
                                if(ends[5]>=biggest156184){
                                  biggest156184=ends[5];
                                }
                                if(biggest156184 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                                  S105723=1;
                                  thread156185(tdone,ends);
                                  thread156186(tdone,ends);
                                  int biggest156187 = 0;
                                  if(ends[4]>=biggest156187){
                                    biggest156187=ends[4];
                                  }
                                  if(ends[5]>=biggest156187){
                                    biggest156187=ends[5];
                                  }
                                  if(biggest156187 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                            currsigs.addElement(cylZaxisExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
                      S105645=2;
                      S111052=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                        S111052=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S111047=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                          S111047=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                            S114017=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
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

  public void thread156024(int [] tdone, int [] ends){
        switch(S105621){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\lidRemovalController.sysj line: 51, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidRemovalController.sysj line: 54, column: 8
            auto_1.setPresent();//sysj\lidRemovalController.sysj line: 54, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\lidRemovalController.sysj line: 55, column: 13
              manual_1.setPresent();//sysj\lidRemovalController.sysj line: 55, column: 35
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

  public void thread156021(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156020(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156018(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156017(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156015(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156014(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156012(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156011(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156009(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156008(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156006(int [] tdone, int [] ends){
        S105682=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread156005(int [] tdone, int [] ends){
        S105677=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 93, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread156003(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread156002(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread156000(int [] tdone, int [] ends){
        S106006=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread155999(int [] tdone, int [] ends){
        S106001=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 100, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread155998(int [] tdone, int [] ends){
        S155993=1;
    OK_thread_3 = 0;//sysj\lidRemovalController.sysj line: 62, column: 3
    BLOCKED_thread_3 = 2;//sysj\lidRemovalController.sysj line: 63, column: 3
    w_thread_3 = null;//sysj\lidRemovalController.sysj line: 65, column: 3
    code_thread_3 = 0;//sysj\lidRemovalController.sysj line: 66, column: 3
    S114017=0;
    if(reset.getprestatus()){//sysj\lidRemovalController.sysj line: 69, column: 20
      enable_in.setPreempted();
      status_o.setPreempted();
      S114017=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S105645=0;
      S105629=0;
      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 70, column: 5
        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
        S105629=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S105624=0;
        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 70, column: 5
          S105624=1;
          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 70, column: 5
            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 70, column: 5
            ends[3]=2;
            ;//sysj\lidRemovalController.sysj line: 70, column: 5
            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 71, column: 5
            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 79, column: 5
            S105645=1;
            if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 81, column: 8
              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 82, column: 6
              S105650=0;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 22
                S105650=1;
                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                  S105650=2;
                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                    S105650=3;
                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                      S105650=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                        S105650=5;
                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                          S105650=6;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                            S105650=7;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                              S105650=8;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                S105650=9;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S105645=2;
                                  S111052=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111052=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111047=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111047=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114017=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                S105650=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S105650=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                            currsigs.addElement(unscrewTurnRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                            S105650=6;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                              S105650=7;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                S105650=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S105650=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                  S105650=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S105650=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                              currsigs.addElement(unscrewTurnRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S106047=0;
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                        S106047=1;
                        thread155999(tdone,ends);
                        thread156000(tdone,ends);
                        int biggest156001 = 0;
                        if(ends[6]>=biggest156001){
                          biggest156001=ends[6];
                        }
                        if(ends[7]>=biggest156001){
                          biggest156001=ends[7];
                        }
                        if(biggest156001 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                          S106047=1;
                          thread156002(tdone,ends);
                          thread156003(tdone,ends);
                          int biggest156004 = 0;
                          if(ends[6]>=biggest156004){
                            biggest156004=ends[6];
                          }
                          if(ends[7]>=biggest156004){
                            biggest156004=ends[7];
                          }
                          if(biggest156004 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    S105723=0;
                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                      S105723=1;
                      thread156005(tdone,ends);
                      thread156006(tdone,ends);
                      int biggest156007 = 0;
                      if(ends[4]>=biggest156007){
                        biggest156007=ends[4];
                      }
                      if(ends[5]>=biggest156007){
                        biggest156007=ends[5];
                      }
                      if(biggest156007 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                        S105723=1;
                        thread156008(tdone,ends);
                        thread156009(tdone,ends);
                        int biggest156010 = 0;
                        if(ends[4]>=biggest156010){
                          biggest156010=ends[4];
                        }
                        if(ends[5]>=biggest156010){
                          biggest156010=ends[5];
                        }
                        if(biggest156010 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                }
                else {
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                  currsigs.addElement(cylZaxisExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 45
                  S105650=1;
                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 86, column: 22
                    S105650=2;
                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 22
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 95, column: 6
                      S105650=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 22
                        S105650=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 22
                          S105650=5;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 22
                            S105650=6;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                              S105650=7;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                S105650=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S105650=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S105645=2;
                                    S111052=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111052=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111047=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111047=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114017=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                  S105650=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S105650=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                              currsigs.addElement(unscrewTurnRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 109, column: 45
                              S105650=6;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 110, column: 22
                                S105650=7;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                  S105650=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S105650=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S105645=2;
                                      S111052=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111052=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111047=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111047=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114017=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 45
                                    S105650=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                      S105650=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                          S105645=2;
                                          S111052=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111052=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S111047=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111047=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S114017=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S105645=2;
                                        S111052=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111052=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111047=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111047=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114017=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                      currsigs.addElement(lidEjectExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 111, column: 7
                                currsigs.addElement(unscrewTurnRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S106047=0;
                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 23
                          S106047=1;
                          thread156011(tdone,ends);
                          thread156012(tdone,ends);
                          int biggest156013 = 0;
                          if(ends[6]>=biggest156013){
                            biggest156013=ends[6];
                          }
                          if(ends[7]>=biggest156013){
                            biggest156013=ends[7];
                          }
                          if(biggest156013 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 99, column: 46
                            S106047=1;
                            thread156014(tdone,ends);
                            thread156015(tdone,ends);
                            int biggest156016 = 0;
                            if(ends[6]>=biggest156016){
                              biggest156016=ends[6];
                            }
                            if(ends[7]>=biggest156016){
                              biggest156016=ends[7];
                            }
                            if(biggest156016 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      S105723=0;
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 23
                        S105723=1;
                        thread156017(tdone,ends);
                        thread156018(tdone,ends);
                        int biggest156019 = 0;
                        if(ends[4]>=biggest156019){
                          biggest156019=ends[4];
                        }
                        if(ends[5]>=biggest156019){
                          biggest156019=ends[5];
                        }
                        if(biggest156019 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 92, column: 46
                          S105723=1;
                          thread156020(tdone,ends);
                          thread156021(tdone,ends);
                          int biggest156022 = 0;
                          if(ends[4]>=biggest156022){
                            biggest156022=ends[4];
                          }
                          if(ends[5]>=biggest156022){
                            biggest156022=ends[5];
                          }
                          if(biggest156022 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 87, column: 7
                    currsigs.addElement(cylZaxisExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
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
              S105645=2;
              S111052=0;
              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                S111052=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S111047=0;
                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                  S111047=1;
                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                    ends[3]=2;
                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                    S114017=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
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

  public void thread155997(int [] tdone, int [] ends){
        S105621=1;
    if(mode.getprestatus()){//sysj\lidRemovalController.sysj line: 51, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidRemovalController.sysj line: 54, column: 8
        auto_1.setPresent();//sysj\lidRemovalController.sysj line: 54, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\lidRemovalController.sysj line: 55, column: 13
          manual_1.setPresent();//sysj\lidRemovalController.sysj line: 55, column: 35
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
      switch(S155995){
        case 0 : 
          S155995=0;
          break RUN;
        
        case 1 : 
          S155995=2;
          S155995=2;
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 47, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 47, column: 2
          thread155997(tdone,ends);
          thread155998(tdone,ends);
          int biggest156023 = 0;
          if(ends[2]>=biggest156023){
            biggest156023=ends[2];
          }
          if(ends[3]>=biggest156023){
            biggest156023=ends[3];
          }
          if(biggest156023 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 47, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 47, column: 2
          thread156024(tdone,ends);
          thread156025(tdone,ends);
          int biggest156188 = 0;
          if(ends[2]>=biggest156188){
            biggest156188=ends[2];
          }
          if(ends[3]>=biggest156188){
            biggest156188=ends[3];
          }
          if(biggest156188 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest156188 == 0){
            S155995=0;
            active[1]=0;
            ends[1]=0;
            S155995=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
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
          zAxisLowered.gethook();
          zAxisLifted.gethook();
          turnAtHomePos.gethook();
          turnAtFinalPos.gethook();
          lidGripped.gethook();
          lidBinFull.gethook();
          cylZaxisExtendM.gethook();
          unscrewTurnExtendM.gethook();
          unscrewTurnRetractM.gethook();
          lidGripperExtendM.gethook();
          lidEjectExtendM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
      zAxisLowered.setpreclear();
      zAxisLifted.setpreclear();
      turnAtHomePos.setpreclear();
      turnAtFinalPos.setpreclear();
      lidGripped.setpreclear();
      lidBinFull.setpreclear();
      cylZaxisExtendM.setpreclear();
      unscrewTurnExtendM.setpreclear();
      unscrewTurnRetractM.setpreclear();
      lidGripperExtendM.setpreclear();
      lidEjectExtendM.setpreclear();
      cylZaxisExtend.setpreclear();
      unscrewTurnExtend.setpreclear();
      unscrewTurnRetract.setpreclear();
      lidGripperExtend.setpreclear();
      lidEjectExtend.setpreclear();
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
      dummyint = zAxisLowered.getStatus() ? zAxisLowered.setprepresent() : zAxisLowered.setpreclear();
      zAxisLowered.setpreval(zAxisLowered.getValue());
      zAxisLowered.setClear();
      dummyint = zAxisLifted.getStatus() ? zAxisLifted.setprepresent() : zAxisLifted.setpreclear();
      zAxisLifted.setpreval(zAxisLifted.getValue());
      zAxisLifted.setClear();
      dummyint = turnAtHomePos.getStatus() ? turnAtHomePos.setprepresent() : turnAtHomePos.setpreclear();
      turnAtHomePos.setpreval(turnAtHomePos.getValue());
      turnAtHomePos.setClear();
      dummyint = turnAtFinalPos.getStatus() ? turnAtFinalPos.setprepresent() : turnAtFinalPos.setpreclear();
      turnAtFinalPos.setpreval(turnAtFinalPos.getValue());
      turnAtFinalPos.setClear();
      dummyint = lidGripped.getStatus() ? lidGripped.setprepresent() : lidGripped.setpreclear();
      lidGripped.setpreval(lidGripped.getValue());
      lidGripped.setClear();
      dummyint = lidBinFull.getStatus() ? lidBinFull.setprepresent() : lidBinFull.setpreclear();
      lidBinFull.setpreval(lidBinFull.getValue());
      lidBinFull.setClear();
      dummyint = cylZaxisExtendM.getStatus() ? cylZaxisExtendM.setprepresent() : cylZaxisExtendM.setpreclear();
      cylZaxisExtendM.setpreval(cylZaxisExtendM.getValue());
      cylZaxisExtendM.setClear();
      dummyint = unscrewTurnExtendM.getStatus() ? unscrewTurnExtendM.setprepresent() : unscrewTurnExtendM.setpreclear();
      unscrewTurnExtendM.setpreval(unscrewTurnExtendM.getValue());
      unscrewTurnExtendM.setClear();
      dummyint = unscrewTurnRetractM.getStatus() ? unscrewTurnRetractM.setprepresent() : unscrewTurnRetractM.setpreclear();
      unscrewTurnRetractM.setpreval(unscrewTurnRetractM.getValue());
      unscrewTurnRetractM.setClear();
      dummyint = lidGripperExtendM.getStatus() ? lidGripperExtendM.setprepresent() : lidGripperExtendM.setpreclear();
      lidGripperExtendM.setpreval(lidGripperExtendM.getValue());
      lidGripperExtendM.setClear();
      dummyint = lidEjectExtendM.getStatus() ? lidEjectExtendM.setprepresent() : lidEjectExtendM.setpreclear();
      lidEjectExtendM.setpreval(lidEjectExtendM.getValue());
      lidEjectExtendM.setClear();
      cylZaxisExtend.sethook();
      cylZaxisExtend.setClear();
      unscrewTurnExtend.sethook();
      unscrewTurnExtend.setClear();
      unscrewTurnRetract.sethook();
      unscrewTurnRetract.setClear();
      lidGripperExtend.sethook();
      lidGripperExtend.setClear();
      lidEjectExtend.sethook();
      lidEjectExtend.setClear();
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
        zAxisLowered.gethook();
        zAxisLifted.gethook();
        turnAtHomePos.gethook();
        turnAtFinalPos.gethook();
        lidGripped.gethook();
        lidBinFull.gethook();
        cylZaxisExtendM.gethook();
        unscrewTurnExtendM.gethook();
        unscrewTurnRetractM.gethook();
        lidGripperExtendM.gethook();
        lidEjectExtendM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
