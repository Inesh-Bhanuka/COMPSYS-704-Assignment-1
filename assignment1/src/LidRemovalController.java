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
  private int OK_thread_3;//sysj\lidRemovalController.sysj line: 71, column: 3
  private int BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 72, column: 3
  private WorkpieceTwin w_thread_3;//sysj\lidRemovalController.sysj line: 74, column: 3
  private int code_thread_3;//sysj\lidRemovalController.sysj line: 75, column: 3
  private int S154714 = 1;
  private int S104340 = 1;
  private int S154712 = 1;
  private int S112736 = 1;
  private int S104364 = 1;
  private int S104348 = 1;
  private int S104343 = 1;
  private int S104369 = 1;
  private int S104442 = 1;
  private int S104396 = 1;
  private int S104401 = 1;
  private int S104766 = 1;
  private int S104720 = 1;
  private int S104725 = 1;
  private int S109771 = 1;
  private int S109766 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread154905(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154904(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154902(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154901(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154899(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154898(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154896(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154895(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154893(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154892(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154890(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154889(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154887(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154886(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154884(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154883(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154881(int [] tdone, int [] ends){
        switch(S104725){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
        currsigs.addElement(unscrewTurnExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread154880(int [] tdone, int [] ends){
        switch(S104720){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
        currsigs.addElement(cylZaxisExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread154878(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154877(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154875(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154874(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154872(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154871(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154869(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154868(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154866(int [] tdone, int [] ends){
        switch(S104401){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
        currsigs.addElement(lidGripperExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread154865(int [] tdone, int [] ends){
        switch(S104396){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
        currsigs.addElement(cylZaxisExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread154863(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154862(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154860(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154859(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154857(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154856(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154854(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154853(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154851(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154850(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154848(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154847(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154845(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154844(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154842(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154841(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154839(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154838(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154836(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154835(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154833(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154832(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154830(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154829(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154827(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154826(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154824(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154823(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154821(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154820(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154818(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154817(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154815(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154814(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154812(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154811(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154809(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154808(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154806(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154805(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154803(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154802(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154800(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154799(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154797(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154796(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154794(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154793(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154791(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154790(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154788(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154787(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154785(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154784(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154782(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154781(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154779(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154778(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154776(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154775(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154773(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154772(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154770(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154769(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154767(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154766(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154764(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154763(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154761(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154760(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154758(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154757(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154755(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154754(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154752(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154751(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154749(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154748(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154746(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154745(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154744(int [] tdone, int [] ends){
        switch(S154712){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S112736){
          case 0 : 
            if(reset.getprestatus()){//sysj\lidRemovalController.sysj line: 78, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S112736=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S104364){
                case 0 : 
                  switch(S104348){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 79, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
                        S104348=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S104343){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
                              enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 79, column: 5
                              S104343=1;
                              if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
                                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 79, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 80, column: 5
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 88, column: 5
                                S104364=1;
                                if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 90, column: 8
                                  System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 91, column: 6
                                  S104369=0;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 22
                                    S104369=1;
                                    if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                      S104369=2;
                                      if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                                        System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                                        S104369=3;
                                        if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                          S104369=4;
                                          if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                            S104369=5;
                                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                              S104369=6;
                                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                                S104369=7;
                                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                  S104369=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                    S104369=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                    S104369=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                      S104369=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                                currsigs.addElement(unscrewTurnRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                                S104369=6;
                                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                                  S104369=7;
                                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                    S104369=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                      S104369=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                      S104369=8;
                                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                        S104369=9;
                                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                            S104364=2;
                                                            S109771=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109771=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S109766=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S109766=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  S112736=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
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
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                          S104766=0;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                            S104766=1;
                                            thread154745(tdone,ends);
                                            thread154746(tdone,ends);
                                            int biggest154747 = 0;
                                            if(ends[6]>=biggest154747){
                                              biggest154747=ends[6];
                                            }
                                            if(ends[7]>=biggest154747){
                                              biggest154747=ends[7];
                                            }
                                            if(biggest154747 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                              S104766=1;
                                              thread154748(tdone,ends);
                                              thread154749(tdone,ends);
                                              int biggest154750 = 0;
                                              if(ends[6]>=biggest154750){
                                                biggest154750=ends[6];
                                              }
                                              if(ends[7]>=biggest154750){
                                                biggest154750=ends[7];
                                              }
                                              if(biggest154750 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S104442=0;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                                          S104442=1;
                                          thread154751(tdone,ends);
                                          thread154752(tdone,ends);
                                          int biggest154753 = 0;
                                          if(ends[4]>=biggest154753){
                                            biggest154753=ends[4];
                                          }
                                          if(ends[5]>=biggest154753){
                                            biggest154753=ends[5];
                                          }
                                          if(biggest154753 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                            S104442=1;
                                            thread154754(tdone,ends);
                                            thread154755(tdone,ends);
                                            int biggest154756 = 0;
                                            if(ends[4]>=biggest154756){
                                              biggest154756=ends[4];
                                            }
                                            if(ends[5]>=biggest154756){
                                              biggest154756=ends[5];
                                            }
                                            if(biggest154756 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
                                      currsigs.addElement(cylZaxisExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 45
                                      S104369=1;
                                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                        S104369=2;
                                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                                          S104369=3;
                                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                            S104369=4;
                                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                              S104369=5;
                                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                                S104369=6;
                                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                                  S104369=7;
                                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                    S104369=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                      S104369=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                      S104369=8;
                                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                        S104369=9;
                                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                            S104364=2;
                                                            S109771=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109771=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S109766=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S109766=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  S112736=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
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
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                                  currsigs.addElement(unscrewTurnRetract);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                                  S104369=6;
                                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                                    S104369=7;
                                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                      S104369=8;
                                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                        S104369=9;
                                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                            S104364=2;
                                                            S109771=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109771=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S109766=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S109766=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  S112736=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
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
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                        currsigs.addElement(lidEjectExtend);
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                        S104369=8;
                                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                          S104369=9;
                                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                              S104364=2;
                                                              S109771=0;
                                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S109771=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                S109766=0;
                                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  S109766=1;
                                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                    ends[3]=2;
                                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                    S112736=1;
                                                                    active[3]=1;
                                                                    ends[3]=1;
                                                                    tdone[3]=1;
                                                                  }
                                                                  else {
                                                                    active[3]=1;
                                                                    ends[3]=1;
                                                                    tdone[3]=1;
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
                                                            S104364=2;
                                                            S109771=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109771=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S109766=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S109766=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  S112736=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                            S104766=0;
                                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                              S104766=1;
                                              thread154757(tdone,ends);
                                              thread154758(tdone,ends);
                                              int biggest154759 = 0;
                                              if(ends[6]>=biggest154759){
                                                biggest154759=ends[6];
                                              }
                                              if(ends[7]>=biggest154759){
                                                biggest154759=ends[7];
                                              }
                                              if(biggest154759 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                                S104766=1;
                                                thread154760(tdone,ends);
                                                thread154761(tdone,ends);
                                                int biggest154762 = 0;
                                                if(ends[6]>=biggest154762){
                                                  biggest154762=ends[6];
                                                }
                                                if(ends[7]>=biggest154762){
                                                  biggest154762=ends[7];
                                                }
                                                if(biggest154762 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          S104442=0;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                                            S104442=1;
                                            thread154763(tdone,ends);
                                            thread154764(tdone,ends);
                                            int biggest154765 = 0;
                                            if(ends[4]>=biggest154765){
                                              biggest154765=ends[4];
                                            }
                                            if(ends[5]>=biggest154765){
                                              biggest154765=ends[5];
                                            }
                                            if(biggest154765 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                              S104442=1;
                                              thread154766(tdone,ends);
                                              thread154767(tdone,ends);
                                              int biggest154768 = 0;
                                              if(ends[4]>=biggest154768){
                                                biggest154768=ends[4];
                                              }
                                              if(ends[5]>=biggest154768){
                                                biggest154768=ends[5];
                                              }
                                              if(biggest154768 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
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
                                  S104364=2;
                                  S109771=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109771=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S109766=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109766=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S112736=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
                              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 79, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 80, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 88, column: 5
                              S104364=1;
                              if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 90, column: 8
                                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 91, column: 6
                                S104369=0;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 22
                                  S104369=1;
                                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                    S104369=2;
                                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                                      S104369=3;
                                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                        S104369=4;
                                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                          S104369=5;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                            S104369=6;
                                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                              S104369=7;
                                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                S104369=8;
                                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                  S104369=9;
                                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    S104364=2;
                                                    S109771=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109771=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S109766=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109766=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S112736=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                  currsigs.addElement(lidEjectExtend);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                  S104369=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                    S104369=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                              currsigs.addElement(unscrewTurnRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                              S104369=6;
                                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                                S104369=7;
                                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                  S104369=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                    S104369=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                    S104369=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                      S104369=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                        S104766=0;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                          S104766=1;
                                          thread154769(tdone,ends);
                                          thread154770(tdone,ends);
                                          int biggest154771 = 0;
                                          if(ends[6]>=biggest154771){
                                            biggest154771=ends[6];
                                          }
                                          if(ends[7]>=biggest154771){
                                            biggest154771=ends[7];
                                          }
                                          if(biggest154771 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                            S104766=1;
                                            thread154772(tdone,ends);
                                            thread154773(tdone,ends);
                                            int biggest154774 = 0;
                                            if(ends[6]>=biggest154774){
                                              biggest154774=ends[6];
                                            }
                                            if(ends[7]>=biggest154774){
                                              biggest154774=ends[7];
                                            }
                                            if(biggest154774 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S104442=0;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                                        S104442=1;
                                        thread154775(tdone,ends);
                                        thread154776(tdone,ends);
                                        int biggest154777 = 0;
                                        if(ends[4]>=biggest154777){
                                          biggest154777=ends[4];
                                        }
                                        if(ends[5]>=biggest154777){
                                          biggest154777=ends[5];
                                        }
                                        if(biggest154777 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                          S104442=1;
                                          thread154778(tdone,ends);
                                          thread154779(tdone,ends);
                                          int biggest154780 = 0;
                                          if(ends[4]>=biggest154780){
                                            biggest154780=ends[4];
                                          }
                                          if(ends[5]>=biggest154780){
                                            biggest154780=ends[5];
                                          }
                                          if(biggest154780 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
                                    currsigs.addElement(cylZaxisExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 45
                                    S104369=1;
                                    if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                      S104369=2;
                                      if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                                        System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                                        S104369=3;
                                        if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                          S104369=4;
                                          if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                            S104369=5;
                                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                              S104369=6;
                                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                                S104369=7;
                                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                  S104369=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                    S104369=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                    S104369=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                      S104369=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                                currsigs.addElement(unscrewTurnRetract);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                                S104369=6;
                                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                                  S104369=7;
                                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                    S104369=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                      S104369=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                      currsigs.addElement(lidEjectExtend);
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                      S104369=8;
                                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                        S104369=9;
                                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                            S104364=2;
                                                            S109771=0;
                                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109771=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              S109766=0;
                                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S109766=1;
                                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  ends[3]=2;
                                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                  S112736=1;
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
                                                                }
                                                                else {
                                                                  active[3]=1;
                                                                  ends[3]=1;
                                                                  tdone[3]=1;
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
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                          S104766=0;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                            S104766=1;
                                            thread154781(tdone,ends);
                                            thread154782(tdone,ends);
                                            int biggest154783 = 0;
                                            if(ends[6]>=biggest154783){
                                              biggest154783=ends[6];
                                            }
                                            if(ends[7]>=biggest154783){
                                              biggest154783=ends[7];
                                            }
                                            if(biggest154783 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                              S104766=1;
                                              thread154784(tdone,ends);
                                              thread154785(tdone,ends);
                                              int biggest154786 = 0;
                                              if(ends[6]>=biggest154786){
                                                biggest154786=ends[6];
                                              }
                                              if(ends[7]>=biggest154786){
                                                biggest154786=ends[7];
                                              }
                                              if(biggest154786 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        S104442=0;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                                          S104442=1;
                                          thread154787(tdone,ends);
                                          thread154788(tdone,ends);
                                          int biggest154789 = 0;
                                          if(ends[4]>=biggest154789){
                                            biggest154789=ends[4];
                                          }
                                          if(ends[5]>=biggest154789){
                                            biggest154789=ends[5];
                                          }
                                          if(biggest154789 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                            S104442=1;
                                            thread154790(tdone,ends);
                                            thread154791(tdone,ends);
                                            int biggest154792 = 0;
                                            if(ends[4]>=biggest154792){
                                              biggest154792=ends[4];
                                            }
                                            if(ends[5]>=biggest154792){
                                              biggest154792=ends[5];
                                            }
                                            if(biggest154792 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
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
                                S104364=2;
                                S109771=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109771=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S109766=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109766=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S112736=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                      S104348=1;
                      S104348=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 79, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
                        S104348=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S104343=0;
                        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
                          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 79, column: 5
                          S104343=1;
                          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
                            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 79, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 80, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 88, column: 5
                            S104364=1;
                            if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 90, column: 8
                              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 91, column: 6
                              S104369=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 22
                                S104369=1;
                                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                  S104369=2;
                                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                                    S104369=3;
                                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                      S104369=4;
                                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                        S104369=5;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                          S104369=6;
                                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                            S104369=7;
                                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                              S104369=8;
                                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                S104369=9;
                                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                    S104364=2;
                                                    S109771=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109771=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S109766=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109766=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S112736=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
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
                                                  S104364=2;
                                                  S109771=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109771=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S109766=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109766=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S112736=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                              }
                                              else {
                                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                currsigs.addElement(lidEjectExtend);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                S104369=8;
                                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                  S104369=9;
                                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    S104364=2;
                                                    S109771=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109771=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S109766=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109766=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S112736=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                            currsigs.addElement(unscrewTurnRetract);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                            S104369=6;
                                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                              S104369=7;
                                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                S104369=8;
                                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                  S104369=9;
                                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    S104364=2;
                                                    S109771=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109771=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S109766=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109766=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S112736=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                  currsigs.addElement(lidEjectExtend);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                  S104369=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                    S104369=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                      S104766=0;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                        S104766=1;
                                        thread154793(tdone,ends);
                                        thread154794(tdone,ends);
                                        int biggest154795 = 0;
                                        if(ends[6]>=biggest154795){
                                          biggest154795=ends[6];
                                        }
                                        if(ends[7]>=biggest154795){
                                          biggest154795=ends[7];
                                        }
                                        if(biggest154795 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                          S104766=1;
                                          thread154796(tdone,ends);
                                          thread154797(tdone,ends);
                                          int biggest154798 = 0;
                                          if(ends[6]>=biggest154798){
                                            biggest154798=ends[6];
                                          }
                                          if(ends[7]>=biggest154798){
                                            biggest154798=ends[7];
                                          }
                                          if(biggest154798 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    S104442=0;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                                      S104442=1;
                                      thread154799(tdone,ends);
                                      thread154800(tdone,ends);
                                      int biggest154801 = 0;
                                      if(ends[4]>=biggest154801){
                                        biggest154801=ends[4];
                                      }
                                      if(ends[5]>=biggest154801){
                                        biggest154801=ends[5];
                                      }
                                      if(biggest154801 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                        S104442=1;
                                        thread154802(tdone,ends);
                                        thread154803(tdone,ends);
                                        int biggest154804 = 0;
                                        if(ends[4]>=biggest154804){
                                          biggest154804=ends[4];
                                        }
                                        if(ends[5]>=biggest154804){
                                          biggest154804=ends[5];
                                        }
                                        if(biggest154804 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
                                  currsigs.addElement(cylZaxisExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 45
                                  S104369=1;
                                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                    S104369=2;
                                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                                      S104369=3;
                                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                        S104369=4;
                                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                          S104369=5;
                                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                            S104369=6;
                                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                              S104369=7;
                                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                S104369=8;
                                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                  S104369=9;
                                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
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
                                                    S104364=2;
                                                    S109771=0;
                                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109771=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S109766=0;
                                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109766=1;
                                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S112736=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                }
                                                else {
                                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                  currsigs.addElement(lidEjectExtend);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                  S104369=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                    S104369=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                              currsigs.addElement(unscrewTurnRetract);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                              S104369=6;
                                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                                S104369=7;
                                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                                  S104369=8;
                                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                    S104369=9;
                                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
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
                                                      S104364=2;
                                                      S109771=0;
                                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S109771=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S109766=0;
                                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109766=1;
                                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S112736=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                                    currsigs.addElement(lidEjectExtend);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                                    S104369=8;
                                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                                      S104369=9;
                                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                          S104364=2;
                                                          S109771=0;
                                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109771=1;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            S109766=0;
                                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S109766=1;
                                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                ends[3]=2;
                                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                                S112736=1;
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
                                                              }
                                                              else {
                                                                active[3]=1;
                                                                ends[3]=1;
                                                                tdone[3]=1;
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
                                                        S104364=2;
                                                        S109771=0;
                                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                          S109771=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S109766=0;
                                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                            S109766=1;
                                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                              S112736=1;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                        S104766=0;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                          S104766=1;
                                          thread154805(tdone,ends);
                                          thread154806(tdone,ends);
                                          int biggest154807 = 0;
                                          if(ends[6]>=biggest154807){
                                            biggest154807=ends[6];
                                          }
                                          if(ends[7]>=biggest154807){
                                            biggest154807=ends[7];
                                          }
                                          if(biggest154807 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                            S104766=1;
                                            thread154808(tdone,ends);
                                            thread154809(tdone,ends);
                                            int biggest154810 = 0;
                                            if(ends[6]>=biggest154810){
                                              biggest154810=ends[6];
                                            }
                                            if(ends[7]>=biggest154810){
                                              biggest154810=ends[7];
                                            }
                                            if(biggest154810 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      S104442=0;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                                        S104442=1;
                                        thread154811(tdone,ends);
                                        thread154812(tdone,ends);
                                        int biggest154813 = 0;
                                        if(ends[4]>=biggest154813){
                                          biggest154813=ends[4];
                                        }
                                        if(ends[5]>=biggest154813){
                                          biggest154813=ends[5];
                                        }
                                        if(biggest154813 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                          S104442=1;
                                          thread154814(tdone,ends);
                                          thread154815(tdone,ends);
                                          int biggest154816 = 0;
                                          if(ends[4]>=biggest154816){
                                            biggest154816=ends[4];
                                          }
                                          if(ends[5]>=biggest154816){
                                            biggest154816=ends[5];
                                          }
                                          if(biggest154816 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
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
                              S104364=2;
                              S109771=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                S109771=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S109766=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109766=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S112736=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                  switch(S104369){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 22
                        S104369=1;
                        if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                          S104369=2;
                          if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                            System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                            S104369=3;
                            if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                              S104369=4;
                              if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                S104369=5;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                  S104369=6;
                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                    S104369=7;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                      S104369=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                        S104369=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                    currsigs.addElement(unscrewTurnRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                    S104369=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                      S104369=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                              S104766=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                S104766=1;
                                thread154817(tdone,ends);
                                thread154818(tdone,ends);
                                int biggest154819 = 0;
                                if(ends[6]>=biggest154819){
                                  biggest154819=ends[6];
                                }
                                if(ends[7]>=biggest154819){
                                  biggest154819=ends[7];
                                }
                                if(biggest154819 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                  S104766=1;
                                  thread154820(tdone,ends);
                                  thread154821(tdone,ends);
                                  int biggest154822 = 0;
                                  if(ends[6]>=biggest154822){
                                    biggest154822=ends[6];
                                  }
                                  if(ends[7]>=biggest154822){
                                    biggest154822=ends[7];
                                  }
                                  if(biggest154822 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S104442=0;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                              S104442=1;
                              thread154823(tdone,ends);
                              thread154824(tdone,ends);
                              int biggest154825 = 0;
                              if(ends[4]>=biggest154825){
                                biggest154825=ends[4];
                              }
                              if(ends[5]>=biggest154825){
                                biggest154825=ends[5];
                              }
                              if(biggest154825 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                S104442=1;
                                thread154826(tdone,ends);
                                thread154827(tdone,ends);
                                int biggest154828 = 0;
                                if(ends[4]>=biggest154828){
                                  biggest154828=ends[4];
                                }
                                if(ends[5]>=biggest154828){
                                  biggest154828=ends[5];
                                }
                                if(biggest154828 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
                          currsigs.addElement(cylZaxisExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 45
                          S104369=1;
                          if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                            S104369=2;
                            if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                              System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                              S104369=3;
                              if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                S104369=4;
                                if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                  S104369=5;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                    S104369=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                      S104369=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                      S104369=6;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                        S104369=7;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                            S104369=8;
                                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                              S104369=9;
                                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                  S104364=2;
                                                  S109771=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109771=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S109766=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109766=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S112736=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                S104766=0;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                  S104766=1;
                                  thread154829(tdone,ends);
                                  thread154830(tdone,ends);
                                  int biggest154831 = 0;
                                  if(ends[6]>=biggest154831){
                                    biggest154831=ends[6];
                                  }
                                  if(ends[7]>=biggest154831){
                                    biggest154831=ends[7];
                                  }
                                  if(biggest154831 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                    S104766=1;
                                    thread154832(tdone,ends);
                                    thread154833(tdone,ends);
                                    int biggest154834 = 0;
                                    if(ends[6]>=biggest154834){
                                      biggest154834=ends[6];
                                    }
                                    if(ends[7]>=biggest154834){
                                      biggest154834=ends[7];
                                    }
                                    if(biggest154834 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S104442=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                                S104442=1;
                                thread154835(tdone,ends);
                                thread154836(tdone,ends);
                                int biggest154837 = 0;
                                if(ends[4]>=biggest154837){
                                  biggest154837=ends[4];
                                }
                                if(ends[5]>=biggest154837){
                                  biggest154837=ends[5];
                                }
                                if(biggest154837 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                  S104442=1;
                                  thread154838(tdone,ends);
                                  thread154839(tdone,ends);
                                  int biggest154840 = 0;
                                  if(ends[4]>=biggest154840){
                                    biggest154840=ends[4];
                                  }
                                  if(ends[5]>=biggest154840){
                                    biggest154840=ends[5];
                                  }
                                  if(biggest154840 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
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
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                        S104369=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                          S104369=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                            S104369=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                              S104369=5;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                S104369=6;
                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                  S104369=7;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                    S104369=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                      S104369=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                      currsigs.addElement(lidEjectExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                      S104369=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                        S104369=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                  currsigs.addElement(unscrewTurnRetract);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                  S104369=6;
                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                    S104369=7;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                      S104369=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                        S104369=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                            S104766=0;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                              S104766=1;
                              thread154841(tdone,ends);
                              thread154842(tdone,ends);
                              int biggest154843 = 0;
                              if(ends[6]>=biggest154843){
                                biggest154843=ends[6];
                              }
                              if(ends[7]>=biggest154843){
                                biggest154843=ends[7];
                              }
                              if(biggest154843 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                S104766=1;
                                thread154844(tdone,ends);
                                thread154845(tdone,ends);
                                int biggest154846 = 0;
                                if(ends[6]>=biggest154846){
                                  biggest154846=ends[6];
                                }
                                if(ends[7]>=biggest154846){
                                  biggest154846=ends[7];
                                }
                                if(biggest154846 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          S104442=0;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                            S104442=1;
                            thread154847(tdone,ends);
                            thread154848(tdone,ends);
                            int biggest154849 = 0;
                            if(ends[4]>=biggest154849){
                              biggest154849=ends[4];
                            }
                            if(ends[5]>=biggest154849){
                              biggest154849=ends[5];
                            }
                            if(biggest154849 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                              S104442=1;
                              thread154850(tdone,ends);
                              thread154851(tdone,ends);
                              int biggest154852 = 0;
                              if(ends[4]>=biggest154852){
                                biggest154852=ends[4];
                              }
                              if(ends[5]>=biggest154852){
                                biggest154852=ends[5];
                              }
                              if(biggest154852 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
                        currsigs.addElement(cylZaxisExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                        System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                        S104369=3;
                        if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                          S104369=4;
                          if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                            S104369=5;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                              S104369=6;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                S104369=7;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                  S104369=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                    S104369=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                    S104369=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                      S104369=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                currsigs.addElement(unscrewTurnRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                S104369=6;
                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                  S104369=7;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                    S104369=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                      S104369=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                      currsigs.addElement(lidEjectExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                      S104369=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                        S104369=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                          S104766=0;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                            S104766=1;
                            thread154853(tdone,ends);
                            thread154854(tdone,ends);
                            int biggest154855 = 0;
                            if(ends[6]>=biggest154855){
                              biggest154855=ends[6];
                            }
                            if(ends[7]>=biggest154855){
                              biggest154855=ends[7];
                            }
                            if(biggest154855 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                              S104766=1;
                              thread154856(tdone,ends);
                              thread154857(tdone,ends);
                              int biggest154858 = 0;
                              if(ends[6]>=biggest154858){
                                biggest154858=ends[6];
                              }
                              if(ends[7]>=biggest154858){
                                biggest154858=ends[7];
                              }
                              if(biggest154858 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        switch(S104442){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                              S104442=1;
                              thread154859(tdone,ends);
                              thread154860(tdone,ends);
                              int biggest154861 = 0;
                              if(ends[4]>=biggest154861){
                                biggest154861=ends[4];
                              }
                              if(ends[5]>=biggest154861){
                                biggest154861=ends[5];
                              }
                              if(biggest154861 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                S104442=1;
                                thread154862(tdone,ends);
                                thread154863(tdone,ends);
                                int biggest154864 = 0;
                                if(ends[4]>=biggest154864){
                                  biggest154864=ends[4];
                                }
                                if(ends[5]>=biggest154864){
                                  biggest154864=ends[5];
                                }
                                if(biggest154864 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                            thread154865(tdone,ends);
                            thread154866(tdone,ends);
                            int biggest154867 = 0;
                            if(ends[4]>=biggest154867){
                              biggest154867=ends[4];
                            }
                            if(ends[5]>=biggest154867){
                              biggest154867=ends[5];
                            }
                            if(biggest154867 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest154867 == 0){
                              System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                              S104369=3;
                              if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                S104369=4;
                                if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                  S104369=5;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                    S104369=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                      S104369=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                      S104369=6;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                        S104369=7;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                            S104369=8;
                                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                              S104369=9;
                                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                  S104364=2;
                                                  S109771=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109771=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S109766=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109766=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S112736=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                S104766=0;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                  S104766=1;
                                  thread154868(tdone,ends);
                                  thread154869(tdone,ends);
                                  int biggest154870 = 0;
                                  if(ends[6]>=biggest154870){
                                    biggest154870=ends[6];
                                  }
                                  if(ends[7]>=biggest154870){
                                    biggest154870=ends[7];
                                  }
                                  if(biggest154870 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                    S104766=1;
                                    thread154871(tdone,ends);
                                    thread154872(tdone,ends);
                                    int biggest154873 = 0;
                                    if(ends[6]>=biggest154873){
                                      biggest154873=ends[6];
                                    }
                                    if(ends[7]>=biggest154873){
                                      biggest154873=ends[7];
                                    }
                                    if(biggest154873 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                        S104369=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                          S104369=5;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                            S104369=6;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                              S104369=7;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                S104369=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                  S104369=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                  S104369=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                    S104369=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                              currsigs.addElement(unscrewTurnRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                              S104369=6;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                S104369=7;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                  S104369=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                    S104369=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                    S104369=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                      S104369=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                        switch(S104766){
                          case 0 : 
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                              S104766=1;
                              thread154874(tdone,ends);
                              thread154875(tdone,ends);
                              int biggest154876 = 0;
                              if(ends[6]>=biggest154876){
                                biggest154876=ends[6];
                              }
                              if(ends[7]>=biggest154876){
                                biggest154876=ends[7];
                              }
                              if(biggest154876 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                S104766=1;
                                thread154877(tdone,ends);
                                thread154878(tdone,ends);
                                int biggest154879 = 0;
                                if(ends[6]>=biggest154879){
                                  biggest154879=ends[6];
                                }
                                if(ends[7]>=biggest154879){
                                  biggest154879=ends[7];
                                }
                                if(biggest154879 == 1){
                                  active[3]=1;
                                  ends[3]=1;
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
                            thread154880(tdone,ends);
                            thread154881(tdone,ends);
                            int biggest154882 = 0;
                            if(ends[6]>=biggest154882){
                              biggest154882=ends[6];
                            }
                            if(ends[7]>=biggest154882){
                              biggest154882=ends[7];
                            }
                            if(biggest154882 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            //FINXME code
                            if(biggest154882 == 0){
                              S104369=4;
                              if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                S104369=5;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                  S104369=6;
                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                    S104369=7;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                      S104369=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                        S104369=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                    currsigs.addElement(unscrewTurnRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                    S104369=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                      S104369=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                        S104369=5;
                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                          S104369=6;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                            S104369=7;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                              S104369=8;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                S104369=9;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  S104364=2;
                                  S109771=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109771=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S109766=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109766=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S112736=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                S104369=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                  S104369=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                            currsigs.addElement(unscrewTurnRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                            S104369=6;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                              S104369=7;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                S104369=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                  S104369=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                  S104369=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                    S104369=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                        S104369=6;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                          S104369=7;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                            S104369=8;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                              S104369=9;
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                  S104364=2;
                                  S109771=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109771=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S109766=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109766=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S112736=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S104364=2;
                                S109771=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109771=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S109766=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109766=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S112736=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                              S104369=8;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                S104369=9;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  S104364=2;
                                  S109771=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109771=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S109766=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109766=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S112736=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                          currsigs.addElement(unscrewTurnRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                          S104369=6;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                            S104369=7;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                              S104369=8;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                S104369=9;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  S104364=2;
                                  S109771=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109771=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S109766=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109766=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S112736=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                S104369=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                  S104369=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                        S104369=7;
                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                          S104369=8;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                            S104369=9;
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                S104364=2;
                                S109771=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109771=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S109766=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109766=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S112736=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              S104364=2;
                              S109771=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                S109771=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S109766=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109766=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S112736=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                            S104369=8;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                              S104369=9;
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                  S104364=2;
                                  S109771=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109771=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S109766=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109766=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S112736=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
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
                                S104364=2;
                                S109771=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109771=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S109766=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109766=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S112736=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                        currsigs.addElement(unscrewTurnRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 7 : 
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                        S104369=8;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                          S104369=9;
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                              S104364=2;
                              S109771=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                S109771=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S109766=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109766=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S112736=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
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
                            S104364=2;
                            S109771=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                              S109771=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S109766=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                S109766=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S112736=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                          S104369=8;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                            S104369=9;
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                S104364=2;
                                S109771=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109771=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S109766=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109766=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S112736=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
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
                              S104364=2;
                              S109771=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                S109771=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S109766=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S109766=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S112736=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                        S104369=9;
                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                            S104364=2;
                            S109771=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                              S109771=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S109766=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                S109766=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                  S112736=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
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
                          S104364=2;
                          S109771=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                            S109771=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S109766=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                              S109766=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                S112736=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                        currsigs.addElement(lidEjectExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 9 : 
                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                        S104364=2;
                        S109771=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                          S109771=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S109766=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                            S109766=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                              S112736=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                  switch(S109771){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                        S109771=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S109766){
                          case 0 : 
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                              S109766=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                S112736=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                              S112736=1;
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
                      S109771=1;
                      S109771=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                        S109771=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S109766=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                          S109766=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                            S112736=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S112736=1;
            S112736=0;
            if(reset.getprestatus()){//sysj\lidRemovalController.sysj line: 78, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S112736=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S104364=0;
              S104348=0;
              if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 79, column: 5
                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
                S104348=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S104343=0;
                if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
                  enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 79, column: 5
                  S104343=1;
                  if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
                    enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
                    ends[3]=2;
                    ;//sysj\lidRemovalController.sysj line: 79, column: 5
                    w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 80, column: 5
                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 88, column: 5
                    S104364=1;
                    if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 90, column: 8
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 91, column: 6
                      S104369=0;
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 22
                        S104369=1;
                        if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                          S104369=2;
                          if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                            System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                            S104369=3;
                            if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                              S104369=4;
                              if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                S104369=5;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                  S104369=6;
                                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                    S104369=7;
                                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                      S104369=8;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                        S104369=9;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
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
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                    currsigs.addElement(unscrewTurnRetract);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                    S104369=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                      S104369=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                              S104766=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                S104766=1;
                                thread154883(tdone,ends);
                                thread154884(tdone,ends);
                                int biggest154885 = 0;
                                if(ends[6]>=biggest154885){
                                  biggest154885=ends[6];
                                }
                                if(ends[7]>=biggest154885){
                                  biggest154885=ends[7];
                                }
                                if(biggest154885 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                  S104766=1;
                                  thread154886(tdone,ends);
                                  thread154887(tdone,ends);
                                  int biggest154888 = 0;
                                  if(ends[6]>=biggest154888){
                                    biggest154888=ends[6];
                                  }
                                  if(ends[7]>=biggest154888){
                                    biggest154888=ends[7];
                                  }
                                  if(biggest154888 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            S104442=0;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                              S104442=1;
                              thread154889(tdone,ends);
                              thread154890(tdone,ends);
                              int biggest154891 = 0;
                              if(ends[4]>=biggest154891){
                                biggest154891=ends[4];
                              }
                              if(ends[5]>=biggest154891){
                                biggest154891=ends[5];
                              }
                              if(biggest154891 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                S104442=1;
                                thread154892(tdone,ends);
                                thread154893(tdone,ends);
                                int biggest154894 = 0;
                                if(ends[4]>=biggest154894){
                                  biggest154894=ends[4];
                                }
                                if(ends[5]>=biggest154894){
                                  biggest154894=ends[5];
                                }
                                if(biggest154894 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
                          currsigs.addElement(cylZaxisExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 45
                          S104369=1;
                          if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                            S104369=2;
                            if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                              System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                              S104369=3;
                              if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                                S104369=4;
                                if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                                  S104369=5;
                                  if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                                    S104369=6;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                      S104369=7;
                                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                        S104369=8;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                          S104369=9;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
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
                                            S104364=2;
                                            S109771=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109771=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S109766=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109766=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S112736=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                                      S104369=6;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                        S104369=7;
                                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                          S104369=8;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                            S104369=9;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
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
                                              S104364=2;
                                              S109771=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S109771=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S109766=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109766=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S112736=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                            S104369=8;
                                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                              S104369=9;
                                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                                  S104364=2;
                                                  S109771=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109771=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S109766=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S109766=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                        S112736=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
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
                                                S104364=2;
                                                S109771=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                  S109771=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S109766=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                                    S109766=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                      S112736=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                            }
                                            else {
                                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                                S104766=0;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                                  S104766=1;
                                  thread154895(tdone,ends);
                                  thread154896(tdone,ends);
                                  int biggest154897 = 0;
                                  if(ends[6]>=biggest154897){
                                    biggest154897=ends[6];
                                  }
                                  if(ends[7]>=biggest154897){
                                    biggest154897=ends[7];
                                  }
                                  if(biggest154897 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                                    S104766=1;
                                    thread154898(tdone,ends);
                                    thread154899(tdone,ends);
                                    int biggest154900 = 0;
                                    if(ends[6]>=biggest154900){
                                      biggest154900=ends[6];
                                    }
                                    if(ends[7]>=biggest154900){
                                      biggest154900=ends[7];
                                    }
                                    if(biggest154900 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              S104442=0;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                                S104442=1;
                                thread154901(tdone,ends);
                                thread154902(tdone,ends);
                                int biggest154903 = 0;
                                if(ends[4]>=biggest154903){
                                  biggest154903=ends[4];
                                }
                                if(ends[5]>=biggest154903){
                                  biggest154903=ends[5];
                                }
                                if(biggest154903 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                                  S104442=1;
                                  thread154904(tdone,ends);
                                  thread154905(tdone,ends);
                                  int biggest154906 = 0;
                                  if(ends[4]>=biggest154906){
                                    biggest154906=ends[4];
                                  }
                                  if(ends[5]>=biggest154906){
                                    biggest154906=ends[5];
                                  }
                                  if(biggest154906 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
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
                      S104364=2;
                      S109771=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                        S109771=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S109766=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                          S109766=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                            S112736=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
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

  public void thread154743(int [] tdone, int [] ends){
        switch(S104340){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\lidRemovalController.sysj line: 62, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidRemovalController.sysj line: 63, column: 8
            auto_1.setPresent();//sysj\lidRemovalController.sysj line: 63, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\lidRemovalController.sysj line: 64, column: 12
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

  public void thread154740(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154739(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154737(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154736(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154734(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154733(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154731(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154730(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154728(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154727(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154725(int [] tdone, int [] ends){
        S104401=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread154724(int [] tdone, int [] ends){
        S104396=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread154722(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154721(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154719(int [] tdone, int [] ends){
        S104725=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread154718(int [] tdone, int [] ends){
        S104720=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 109, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread154717(int [] tdone, int [] ends){
        S154712=1;
    OK_thread_3 = 0;//sysj\lidRemovalController.sysj line: 71, column: 3
    BLOCKED_thread_3 = 2;//sysj\lidRemovalController.sysj line: 72, column: 3
    w_thread_3 = null;//sysj\lidRemovalController.sysj line: 74, column: 3
    code_thread_3 = 0;//sysj\lidRemovalController.sysj line: 75, column: 3
    S112736=0;
    if(reset.getprestatus()){//sysj\lidRemovalController.sysj line: 78, column: 20
      enable_in.setPreempted();
      status_o.setPreempted();
      S112736=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S104364=0;
      S104348=0;
      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 79, column: 5
        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
        S104348=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S104343=0;
        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 79, column: 5
          S104343=1;
          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 79, column: 5
            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 79, column: 5
            ends[3]=2;
            ;//sysj\lidRemovalController.sysj line: 79, column: 5
            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 80, column: 5
            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 88, column: 5
            S104364=1;
            if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 90, column: 8
              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 91, column: 6
              S104369=0;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 22
                S104369=1;
                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                  S104369=2;
                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                    S104369=3;
                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                      S104369=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                        S104369=5;
                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                          S104369=6;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                            S104369=7;
                            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                              S104369=8;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                S104369=9;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
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
                                  S104364=2;
                                  S109771=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                    S109771=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S109766=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109766=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S112736=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                              }
                              else {
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                S104369=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                  S104369=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                            currsigs.addElement(unscrewTurnRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                            S104369=6;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                              S104369=7;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                S104369=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                  S104369=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                  S104369=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                    S104369=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                      S104766=0;
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                        S104766=1;
                        thread154718(tdone,ends);
                        thread154719(tdone,ends);
                        int biggest154720 = 0;
                        if(ends[6]>=biggest154720){
                          biggest154720=ends[6];
                        }
                        if(ends[7]>=biggest154720){
                          biggest154720=ends[7];
                        }
                        if(biggest154720 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                          S104766=1;
                          thread154721(tdone,ends);
                          thread154722(tdone,ends);
                          int biggest154723 = 0;
                          if(ends[6]>=biggest154723){
                            biggest154723=ends[6];
                          }
                          if(ends[7]>=biggest154723){
                            biggest154723=ends[7];
                          }
                          if(biggest154723 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    S104442=0;
                    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                      S104442=1;
                      thread154724(tdone,ends);
                      thread154725(tdone,ends);
                      int biggest154726 = 0;
                      if(ends[4]>=biggest154726){
                        biggest154726=ends[4];
                      }
                      if(ends[5]>=biggest154726){
                        biggest154726=ends[5];
                      }
                      if(biggest154726 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                        S104442=1;
                        thread154727(tdone,ends);
                        thread154728(tdone,ends);
                        int biggest154729 = 0;
                        if(ends[4]>=biggest154729){
                          biggest154729=ends[4];
                        }
                        if(ends[5]>=biggest154729){
                          biggest154729=ends[5];
                        }
                        if(biggest154729 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                }
                else {
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
                  currsigs.addElement(cylZaxisExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 94, column: 45
                  S104369=1;
                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                    S104369=2;
                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 100, column: 22
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 104, column: 6
                      S104369=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 107, column: 22
                        S104369=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 115, column: 22
                          S104369=5;
                          if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 22
                            S104369=6;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                              S104369=7;
                              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                S104369=8;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                  S104369=9;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
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
                                    S104364=2;
                                    S109771=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                      S109771=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S109766=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109766=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S112736=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                  S104369=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                    S104369=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
                              currsigs.addElement(unscrewTurnRetract);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(unscrewTurnRetractM.getprestatus()){//sysj\lidRemovalController.sysj line: 118, column: 45
                              S104369=6;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 119, column: 22
                                S104369=7;
                                if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 22
                                  S104369=8;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                    S104369=9;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
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
                                      S104364=2;
                                      S109771=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                        S109771=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S109766=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109766=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S112736=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                  }
                                  else {
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 124, column: 45
                                    S104369=8;
                                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 125, column: 22
                                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 131, column: 6
                                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 132, column: 6
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 6
                                      S104369=9;
                                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 137, column: 7
                                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 138, column: 7
                                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 140, column: 38
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 141, column: 22
                                          S104364=2;
                                          S109771=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109771=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S109766=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S109766=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                                S112736=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
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
                                        S104364=2;
                                        S109771=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                          S109771=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S109766=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                                            S109766=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 145, column: 5
                                              S112736=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                    }
                                    else {
                                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 126, column: 7
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
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 120, column: 7
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
                        S104766=0;
                        if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 23
                          S104766=1;
                          thread154730(tdone,ends);
                          thread154731(tdone,ends);
                          int biggest154732 = 0;
                          if(ends[6]>=biggest154732){
                            biggest154732=ends[6];
                          }
                          if(ends[7]>=biggest154732){
                            biggest154732=ends[7];
                          }
                          if(biggest154732 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 46
                            S104766=1;
                            thread154733(tdone,ends);
                            thread154734(tdone,ends);
                            int biggest154735 = 0;
                            if(ends[6]>=biggest154735){
                              biggest154735=ends[6];
                            }
                            if(ends[7]>=biggest154735){
                              biggest154735=ends[7];
                            }
                            if(biggest154735 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      S104442=0;
                      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 23
                        S104442=1;
                        thread154736(tdone,ends);
                        thread154737(tdone,ends);
                        int biggest154738 = 0;
                        if(ends[4]>=biggest154738){
                          biggest154738=ends[4];
                        }
                        if(ends[5]>=biggest154738){
                          biggest154738=ends[5];
                        }
                        if(biggest154738 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 46
                          S104442=1;
                          thread154739(tdone,ends);
                          thread154740(tdone,ends);
                          int biggest154741 = 0;
                          if(ends[4]>=biggest154741){
                            biggest154741=ends[4];
                          }
                          if(ends[5]>=biggest154741){
                            biggest154741=ends[5];
                          }
                          if(biggest154741 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 7
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
              S104364=2;
              S109771=0;
              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 145, column: 5
                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                S109771=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S109766=0;
                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 145, column: 5
                  S109766=1;
                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 145, column: 5
                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 145, column: 5
                    ends[3]=2;
                    ;//sysj\lidRemovalController.sysj line: 145, column: 5
                    S112736=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
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

  public void thread154716(int [] tdone, int [] ends){
        S104340=1;
    if(mode.getprestatus()){//sysj\lidRemovalController.sysj line: 62, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidRemovalController.sysj line: 63, column: 8
        auto_1.setPresent();//sysj\lidRemovalController.sysj line: 63, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\lidRemovalController.sysj line: 64, column: 12
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
      switch(S154714){
        case 0 : 
          S154714=0;
          break RUN;
        
        case 1 : 
          S154714=2;
          S154714=2;
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 58, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 58, column: 2
          thread154716(tdone,ends);
          thread154717(tdone,ends);
          int biggest154742 = 0;
          if(ends[2]>=biggest154742){
            biggest154742=ends[2];
          }
          if(ends[3]>=biggest154742){
            biggest154742=ends[3];
          }
          if(biggest154742 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 58, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 58, column: 2
          thread154743(tdone,ends);
          thread154744(tdone,ends);
          int biggest154907 = 0;
          if(ends[2]>=biggest154907){
            biggest154907=ends[2];
          }
          if(ends[3]>=biggest154907){
            biggest154907=ends[3];
          }
          if(biggest154907 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest154907 == 0){
            S154714=0;
            active[1]=0;
            ends[1]=0;
            S154714=0;
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
