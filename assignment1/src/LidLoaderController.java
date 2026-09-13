import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidLoaderController extends ClockDomain{
  public LidLoaderController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal lidAtPickup = new Signal("lidAtPickup", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal magazineEmpty = new Signal("magazineEmpty", Signal.INPUT);
  public Signal refilled = new Signal("refilled", Signal.INPUT);
  public Signal pusherExtendM = new Signal("pusherExtendM", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal refillM = new Signal("refillM", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal refill = new Signal("refill", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private LidLoaderTwin t_thread_3;//sysj\lidLoaderController.sysj line: 50, column: 3
  private int lids_thread_3;//sysj\lidLoaderController.sysj line: 51, column: 3
  private WorkpieceTwin w_thread_3;//sysj\lidLoaderController.sysj line: 52, column: 3
  private int S103323 = 1;
  private int S78149 = 1;
  private int S103321 = 1;
  private int S82345 = 1;
  private int S78173 = 1;
  private int S78157 = 1;
  private int S78152 = 1;
  private int S78175 = 1;
  private int S78182 = 1;
  private int S78457 = 1;
  private int S78462 = 1;
  private int S80832 = 1;
  private int S80827 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread103415(int [] tdone, int [] ends){
        switch(S78462){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
        currsigs.addElement(vacOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread103414(int [] tdone, int [] ends){
        switch(S78457){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
        currsigs.addElement(armDest);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread103412(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103411(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103409(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103408(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103406(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103405(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103403(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103402(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103400(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103399(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103397(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103396(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103394(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103393(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103391(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103390(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103388(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103387(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103385(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103384(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103382(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103381(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103379(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103378(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103376(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103375(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103373(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103372(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103370(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103369(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103367(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103366(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103364(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103363(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103361(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103360(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103358(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103357(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103355(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103354(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103352(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103351(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103349(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103348(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103346(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103345(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103343(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103342(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103340(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103339(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103337(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103336(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103334(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103333(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103331(int [] tdone, int [] ends){
        S78462=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread103330(int [] tdone, int [] ends){
        S78457=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 118, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread103329(int [] tdone, int [] ends){
        switch(S103321){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S82345){
          case 0 : 
            if(reset.getprestatus()){//sysj\lidLoaderController.sysj line: 55, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S82345=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S78173){
                case 0 : 
                  switch(S78157){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 56, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
                        S78157=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S78152){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
                              start_in.setACK(true);//sysj\lidLoaderController.sysj line: 56, column: 5
                              S78152=1;
                              if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
                                start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 56, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 57, column: 5
                                S78173=1;
                                if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 60, column: 8
                                  System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 61, column: 6
                                  w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 62, column: 6
                                  S78173=2;
                                  S80832=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80832=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S80827=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80827=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S82345=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 64, column: 13
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 65, column: 21
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 66, column: 21
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 67, column: 21
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 25
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 68, column: 25
                                      S78175=0;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S78175=0;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S78173=2;
                                    S80832=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80832=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S80827=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80827=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S82345=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
                              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 56, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 57, column: 5
                              S78173=1;
                              if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 60, column: 8
                                System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 61, column: 6
                                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 62, column: 6
                                S78173=2;
                                S80832=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80832=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S80827=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80827=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S82345=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 64, column: 13
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 65, column: 21
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 66, column: 21
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 67, column: 21
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 25
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 68, column: 25
                                    S78175=0;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S78175=0;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S78173=2;
                                  S80832=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80832=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S80827=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80827=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S82345=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                          
                        }
                      }
                      break;
                    
                    case 1 : 
                      S78157=1;
                      S78157=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 56, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
                        S78157=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S78152=0;
                        if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
                          start_in.setACK(true);//sysj\lidLoaderController.sysj line: 56, column: 5
                          S78152=1;
                          if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
                            start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 56, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 57, column: 5
                            S78173=1;
                            if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 60, column: 8
                              System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 61, column: 6
                              w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 62, column: 6
                              S78173=2;
                              S80832=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                S80832=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S80827=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80827=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S82345=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 64, column: 13
                                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 65, column: 21
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 66, column: 21
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 67, column: 21
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 25
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 68, column: 25
                                  S78175=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S78175=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S78173=2;
                                S80832=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80832=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S80827=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80827=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S82345=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 1 : 
                  switch(S78175){
                    case 0 : 
                      S78175=0;
                      S78175=1;
                      if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 14
                        System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 73, column: 7
                        S78182=0;
                        if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                          S78182=1;
                          if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 23
                            S78175=2;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 22
                              S78175=3;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                S78175=4;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                  S78175=5;
                                  if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                    S78175=6;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
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
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 45
                                S78175=3;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                  S78175=4;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                    S78175=5;
                                    if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                      S78175=6;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            refill.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 8
                            currsigs.addElement(refill);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(refillM.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 46
                            S78182=1;
                            if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 23
                              S78175=2;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 22
                                S78175=3;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                  S78175=4;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                    S78175=5;
                                    if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                      S78175=6;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 45
                                  S78175=3;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                    S78175=4;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                      S78175=5;
                                      if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                        S78175=6;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              refill.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 8
                              currsigs.addElement(refill);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S78175=2;
                        if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 22
                          S78175=3;
                          if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                            S78175=4;
                            if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                              S78175=5;
                              if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                S78175=6;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                            pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                            currsigs.addElement(pusherExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 45
                            S78175=3;
                            if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                              S78175=4;
                              if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                S78175=5;
                                if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                  S78175=6;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
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
                              pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                    
                    case 1 : 
                      switch(S78182){
                        case 0 : 
                          if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                            S78182=1;
                            if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 23
                              S78175=2;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 22
                                S78175=3;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                  S78175=4;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                    S78175=5;
                                    if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                      S78175=6;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 45
                                  S78175=3;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                    S78175=4;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                      S78175=5;
                                      if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                        S78175=6;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              refill.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 8
                              currsigs.addElement(refill);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(refillM.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 46
                              S78182=1;
                              if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 23
                                S78175=2;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 22
                                  S78175=3;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                    S78175=4;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                      S78175=5;
                                      if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                        S78175=6;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 45
                                    S78175=3;
                                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                      S78175=4;
                                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                        S78175=5;
                                        if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                          S78175=6;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
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
                                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                refill.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 8
                                currsigs.addElement(refill);
                                active[3]=1;
                                ends[3]=1;
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
                          if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 23
                            S78175=2;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 22
                              S78175=3;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                S78175=4;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                  S78175=5;
                                  if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                    S78175=6;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
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
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 45
                                S78175=3;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                                  S78175=4;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                    S78175=5;
                                    if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                      S78175=6;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            refill.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 8
                            currsigs.addElement(refill);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          break;
                        
                      }
                      break;
                    
                    case 2 : 
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 22
                        S78175=3;
                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                          S78175=4;
                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                            S78175=5;
                            if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                              S78175=6;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 90, column: 45
                          S78175=3;
                          if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                            S78175=4;
                            if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                              S78175=5;
                              if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                S78175=6;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                            pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                            currsigs.addElement(pusherExtend);
                            active[3]=1;
                            ends[3]=1;
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
                    
                    case 3 : 
                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 22
                        S78175=4;
                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                          S78175=5;
                          if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                            S78175=6;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 92, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                        S78175=5;
                        if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                          S78175=6;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                    
                    case 5 : 
                      if(lidAtPickup.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                        S78175=6;
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
                    
                    case 6 : 
                      S78175=6;
                      S78175=7;
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                        S78175=8;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 22
                          S78175=9;
                          if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                            S78175=10;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                              S78175=11;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                S78175=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                  S78175=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread103330(tdone,ends);
                                  thread103331(tdone,ends);
                                  int biggest103332 = 0;
                                  if(ends[4]>=biggest103332){
                                    biggest103332=ends[4];
                                  }
                                  if(ends[5]>=biggest103332){
                                    biggest103332=ends[5];
                                  }
                                  if(biggest103332 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                  S78175=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                    S78175=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
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
                                    thread103333(tdone,ends);
                                    thread103334(tdone,ends);
                                    int biggest103335 = 0;
                                    if(ends[4]>=biggest103335){
                                      biggest103335=ends[4];
                                    }
                                    if(ends[5]>=biggest103335){
                                      biggest103335=ends[5];
                                    }
                                    if(biggest103335 == 1){
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
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 45
                              S78175=10;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                                S78175=11;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                  S78175=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                    S78175=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
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
                                    thread103336(tdone,ends);
                                    thread103337(tdone,ends);
                                    int biggest103338 = 0;
                                    if(ends[4]>=biggest103338){
                                      biggest103338=ends[4];
                                    }
                                    if(ends[5]>=biggest103338){
                                      biggest103338=ends[5];
                                    }
                                    if(biggest103338 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                    S78175=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                      S78175=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread103339(tdone,ends);
                                      thread103340(tdone,ends);
                                      int biggest103341 = 0;
                                      if(ends[4]>=biggest103341){
                                        biggest103341=ends[4];
                                      }
                                      if(ends[5]>=biggest103341){
                                        biggest103341=ends[5];
                                      }
                                      if(biggest103341 == 1){
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
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 108, column: 7
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 45
                          S78175=8;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 22
                            S78175=9;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                              S78175=10;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                                S78175=11;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                  S78175=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                    S78175=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
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
                                    thread103342(tdone,ends);
                                    thread103343(tdone,ends);
                                    int biggest103344 = 0;
                                    if(ends[4]>=biggest103344){
                                      biggest103344=ends[4];
                                    }
                                    if(ends[5]>=biggest103344){
                                      biggest103344=ends[5];
                                    }
                                    if(biggest103344 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                    S78175=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                      S78175=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread103345(tdone,ends);
                                      thread103346(tdone,ends);
                                      int biggest103347 = 0;
                                      if(ends[4]>=biggest103347){
                                        biggest103347=ends[4];
                                      }
                                      if(ends[5]>=biggest103347){
                                        biggest103347=ends[5];
                                      }
                                      if(biggest103347 == 1){
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
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 45
                                S78175=10;
                                if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                                  S78175=11;
                                  if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                    S78175=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                      S78175=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread103348(tdone,ends);
                                      thread103349(tdone,ends);
                                      int biggest103350 = 0;
                                      if(ends[4]>=biggest103350){
                                        biggest103350=ends[4];
                                      }
                                      if(ends[5]>=biggest103350){
                                        biggest103350=ends[5];
                                      }
                                      if(biggest103350 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                      S78175=12;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                        S78175=13;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                          }
                                          t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                            S78173=2;
                                            S80832=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80832=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S80827=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S80827=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  S82345=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                            S78173=2;
                                            S80832=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80832=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S80827=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S80827=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  S82345=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
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
                                        thread103351(tdone,ends);
                                        thread103352(tdone,ends);
                                        int biggest103353 = 0;
                                        if(ends[4]>=biggest103353){
                                          biggest103353=ends[4];
                                        }
                                        if(ends[5]>=biggest103353){
                                          biggest103353=ends[5];
                                        }
                                        if(biggest103353 == 1){
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
                                }
                                else {
                                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                                  currsigs.addElement(vacOn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 108, column: 7
                            currsigs.addElement(armSource);
                            active[3]=1;
                            ends[3]=1;
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
                    
                    case 7 : 
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 22
                        S78175=8;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 22
                          S78175=9;
                          if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                            S78175=10;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                              S78175=11;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                S78175=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                  S78175=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread103354(tdone,ends);
                                  thread103355(tdone,ends);
                                  int biggest103356 = 0;
                                  if(ends[4]>=biggest103356){
                                    biggest103356=ends[4];
                                  }
                                  if(ends[5]>=biggest103356){
                                    biggest103356=ends[5];
                                  }
                                  if(biggest103356 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                  S78175=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                    S78175=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
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
                                    thread103357(tdone,ends);
                                    thread103358(tdone,ends);
                                    int biggest103359 = 0;
                                    if(ends[4]>=biggest103359){
                                      biggest103359=ends[4];
                                    }
                                    if(ends[5]>=biggest103359){
                                      biggest103359=ends[5];
                                    }
                                    if(biggest103359 == 1){
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
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 45
                              S78175=10;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                                S78175=11;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                  S78175=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                    S78175=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
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
                                    thread103360(tdone,ends);
                                    thread103361(tdone,ends);
                                    int biggest103362 = 0;
                                    if(ends[4]>=biggest103362){
                                      biggest103362=ends[4];
                                    }
                                    if(ends[5]>=biggest103362){
                                      biggest103362=ends[5];
                                    }
                                    if(biggest103362 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                    S78175=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                      S78175=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread103363(tdone,ends);
                                      thread103364(tdone,ends);
                                      int biggest103365 = 0;
                                      if(ends[4]>=biggest103365){
                                        biggest103365=ends[4];
                                      }
                                      if(ends[5]>=biggest103365){
                                        biggest103365=ends[5];
                                      }
                                      if(biggest103365 == 1){
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
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 108, column: 7
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 45
                          S78175=8;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 22
                            S78175=9;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                              S78175=10;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                                S78175=11;
                                if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                  S78175=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                    S78175=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
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
                                    thread103366(tdone,ends);
                                    thread103367(tdone,ends);
                                    int biggest103368 = 0;
                                    if(ends[4]>=biggest103368){
                                      biggest103368=ends[4];
                                    }
                                    if(ends[5]>=biggest103368){
                                      biggest103368=ends[5];
                                    }
                                    if(biggest103368 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                    S78175=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                      S78175=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread103369(tdone,ends);
                                      thread103370(tdone,ends);
                                      int biggest103371 = 0;
                                      if(ends[4]>=biggest103371){
                                        biggest103371=ends[4];
                                      }
                                      if(ends[5]>=biggest103371){
                                        biggest103371=ends[5];
                                      }
                                      if(biggest103371 == 1){
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
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 45
                                S78175=10;
                                if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                                  S78175=11;
                                  if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                    S78175=12;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                      S78175=13;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                        }
                                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                          S78173=2;
                                          S80832=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80832=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S80827=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80827=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S82345=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread103372(tdone,ends);
                                      thread103373(tdone,ends);
                                      int biggest103374 = 0;
                                      if(ends[4]>=biggest103374){
                                        biggest103374=ends[4];
                                      }
                                      if(ends[5]>=biggest103374){
                                        biggest103374=ends[5];
                                      }
                                      if(biggest103374 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                      S78175=12;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                        S78175=13;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                          }
                                          t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                            S78173=2;
                                            S80832=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80832=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S80827=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S80827=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  S82345=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                            S78173=2;
                                            S80832=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S80832=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S80827=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                S80827=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                                  S82345=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
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
                                        thread103375(tdone,ends);
                                        thread103376(tdone,ends);
                                        int biggest103377 = 0;
                                        if(ends[4]>=biggest103377){
                                          biggest103377=ends[4];
                                        }
                                        if(ends[5]>=biggest103377){
                                          biggest103377=ends[5];
                                        }
                                        if(biggest103377 == 1){
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
                                }
                                else {
                                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                                  currsigs.addElement(vacOn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 108, column: 7
                            currsigs.addElement(armSource);
                            active[3]=1;
                            ends[3]=1;
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
                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 22
                        S78175=9;
                        if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                          S78175=10;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                            S78175=11;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                              S78175=12;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                S78175=13;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                  }
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                    S78173=2;
                                    S80832=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80832=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S80827=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80827=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S82345=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                    S78173=2;
                                    S80832=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80832=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S80827=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80827=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S82345=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
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
                                thread103378(tdone,ends);
                                thread103379(tdone,ends);
                                int biggest103380 = 0;
                                if(ends[4]>=biggest103380){
                                  biggest103380=ends[4];
                                }
                                if(ends[5]>=biggest103380){
                                  biggest103380=ends[5];
                                }
                                if(biggest103380 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                S78175=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                  S78175=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread103381(tdone,ends);
                                  thread103382(tdone,ends);
                                  int biggest103383 = 0;
                                  if(ends[4]>=biggest103383){
                                    biggest103383=ends[4];
                                  }
                                  if(ends[5]>=biggest103383){
                                    biggest103383=ends[5];
                                  }
                                  if(biggest103383 == 1){
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
                          }
                          else {
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 45
                            S78175=10;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                              S78175=11;
                              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                                S78175=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                  S78175=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread103384(tdone,ends);
                                  thread103385(tdone,ends);
                                  int biggest103386 = 0;
                                  if(ends[4]>=biggest103386){
                                    biggest103386=ends[4];
                                  }
                                  if(ends[5]>=biggest103386){
                                    biggest103386=ends[5];
                                  }
                                  if(biggest103386 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                  S78175=12;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                    S78175=13;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                        S78173=2;
                                        S80832=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80832=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S80827=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S80827=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                              S82345=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
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
                                    thread103387(tdone,ends);
                                    thread103388(tdone,ends);
                                    int biggest103389 = 0;
                                    if(ends[4]>=biggest103389){
                                      biggest103389=ends[4];
                                    }
                                    if(ends[5]>=biggest103389){
                                      biggest103389=ends[5];
                                    }
                                    if(biggest103389 == 1){
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
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 108, column: 7
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 9 : 
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 22
                        S78175=10;
                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                          S78175=11;
                          if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                            S78175=12;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                              S78175=13;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                }
                                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                  S78173=2;
                                  S80832=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80832=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S80827=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80827=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S82345=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                  S78173=2;
                                  S80832=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80832=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S80827=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80827=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S82345=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                              thread103390(tdone,ends);
                              thread103391(tdone,ends);
                              int biggest103392 = 0;
                              if(ends[4]>=biggest103392){
                                biggest103392=ends[4];
                              }
                              if(ends[5]>=biggest103392){
                                biggest103392=ends[5];
                              }
                              if(biggest103392 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                              S78175=12;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                S78175=13;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                  }
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                    S78173=2;
                                    S80832=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80832=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S80827=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80827=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S82345=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                    S78173=2;
                                    S80832=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80832=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S80827=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80827=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S82345=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
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
                                thread103393(tdone,ends);
                                thread103394(tdone,ends);
                                int biggest103395 = 0;
                                if(ends[4]>=biggest103395){
                                  biggest103395=ends[4];
                                }
                                if(ends[5]>=biggest103395){
                                  biggest103395=ends[5];
                                }
                                if(biggest103395 == 1){
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
                        }
                        else {
                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 45
                          S78175=10;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                            S78175=11;
                            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                              S78175=12;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                S78175=13;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                  }
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                    S78173=2;
                                    S80832=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80832=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S80827=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80827=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S82345=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                    S78173=2;
                                    S80832=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80832=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S80827=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80827=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S82345=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
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
                                thread103396(tdone,ends);
                                thread103397(tdone,ends);
                                int biggest103398 = 0;
                                if(ends[4]>=biggest103398){
                                  biggest103398=ends[4];
                                }
                                if(ends[5]>=biggest103398){
                                  biggest103398=ends[5];
                                }
                                if(biggest103398 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                                S78175=12;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                                  S78175=13;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                      S78173=2;
                                      S80832=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S80832=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S80827=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                          S80827=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                            S82345=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread103399(tdone,ends);
                                  thread103400(tdone,ends);
                                  int biggest103401 = 0;
                                  if(ends[4]>=biggest103401){
                                    biggest103401=ends[4];
                                  }
                                  if(ends[5]>=biggest103401){
                                    biggest103401=ends[5];
                                  }
                                  if(biggest103401 == 1){
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
                          }
                          else {
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
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
                    
                    case 10 : 
                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 22
                        S78175=11;
                        if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                          S78175=12;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                            S78175=13;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                              lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                              if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                              }
                              t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                S78173=2;
                                S80832=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80832=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S80827=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80827=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S82345=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                S78173=2;
                                S80832=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80832=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S80827=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80827=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S82345=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                            thread103402(tdone,ends);
                            thread103403(tdone,ends);
                            int biggest103404 = 0;
                            if(ends[4]>=biggest103404){
                              biggest103404=ends[4];
                            }
                            if(ends[5]>=biggest103404){
                              biggest103404=ends[5];
                            }
                            if(biggest103404 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                            S78175=12;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                              S78175=13;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                                }
                                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                  S78173=2;
                                  S80832=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80832=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S80827=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80827=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S82345=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                  S78173=2;
                                  S80832=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80832=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S80827=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S80827=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                        S82345=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                              thread103405(tdone,ends);
                              thread103406(tdone,ends);
                              int biggest103407 = 0;
                              if(ends[4]>=biggest103407){
                                biggest103407=ends[4];
                              }
                              if(ends[5]>=biggest103407){
                                biggest103407=ends[5];
                              }
                              if(biggest103407 == 1){
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
                      }
                      else {
                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 7
                        currsigs.addElement(vacOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 11 : 
                      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 22
                        S78175=12;
                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                          S78175=13;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                            }
                            t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                              S78173=2;
                              S80832=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                S80832=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S80827=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80827=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S82345=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                              S78173=2;
                              S80832=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                S80832=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S80827=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80827=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S82345=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                          thread103408(tdone,ends);
                          thread103409(tdone,ends);
                          int biggest103410 = 0;
                          if(ends[4]>=biggest103410){
                            biggest103410=ends[4];
                          }
                          if(ends[5]>=biggest103410){
                            biggest103410=ends[5];
                          }
                          if(biggest103410 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 116, column: 45
                          S78175=12;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                            S78175=13;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                              lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                              if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                                lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                              }
                              t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                                twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                S78173=2;
                                S80832=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80832=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S80827=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80827=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S82345=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                                S78173=2;
                                S80832=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80832=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S80827=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S80827=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                      S82345=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                            thread103411(tdone,ends);
                            thread103412(tdone,ends);
                            int biggest103413 = 0;
                            if(ends[4]>=biggest103413){
                              biggest103413=ends[4];
                            }
                            if(ends[5]>=biggest103413){
                              biggest103413=ends[5];
                            }
                            if(biggest103413 == 1){
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
                    
                    case 12 : 
                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 22
                        S78175=13;
                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                          }
                          t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                            twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                            S78173=2;
                            S80832=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                              S80832=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S80827=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                S80827=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S82345=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                            S78173=2;
                            S80832=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                              S80832=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S80827=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                S80827=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S82345=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
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
                        thread103414(tdone,ends);
                        thread103415(tdone,ends);
                        int biggest103416 = 0;
                        if(ends[4]>=biggest103416){
                          biggest103416=ends[4];
                        }
                        if(ends[5]>=biggest103416){
                          biggest103416=ends[5];
                        }
                        if(biggest103416 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest103416 == 0){
                          S78175=13;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                            }
                            t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                              S78173=2;
                              S80832=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                S80832=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S80827=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80827=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S82345=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                              S78173=2;
                              S80832=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                S80832=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S80827=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                                  S80827=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                    S82345=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                    
                    case 13 : 
                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 22
                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 122, column: 6
                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 123, column: 6
                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 124, column: 18
                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 124, column: 20
                        }
                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 125, column: 6
                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 126, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 127, column: 6
                          twin.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 128, column: 7
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                          S78173=2;
                          S80832=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                            S80832=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S80827=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                              S80827=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                S82345=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 130, column: 6
                          S78173=2;
                          S80832=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                            S80832=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S80827=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                              S80827=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                S82345=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
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
                
                case 2 : 
                  switch(S80832){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                        S80832=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S80827){
                          case 0 : 
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                              S80827=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 134, column: 5
                                S82345=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                              S82345=1;
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
                      S80832=1;
                      S80832=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                        S80832=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S80827=0;
                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                          S80827=1;
                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                            S82345=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                  S82345=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 4 : 
                  S82345=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 5 : 
                  S82345=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 1 : 
            S82345=1;
            S82345=0;
            if(reset.getprestatus()){//sysj\lidLoaderController.sysj line: 55, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S82345=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S78173=0;
              S78157=0;
              if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 56, column: 5
                start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
                S78157=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S78152=0;
                if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
                  start_in.setACK(true);//sysj\lidLoaderController.sysj line: 56, column: 5
                  S78152=1;
                  if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
                    start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
                    ends[3]=2;
                    ;//sysj\lidLoaderController.sysj line: 56, column: 5
                    w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 57, column: 5
                    S78173=1;
                    if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 60, column: 8
                      System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 61, column: 6
                      w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 62, column: 6
                      S78173=2;
                      S80832=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                        S80832=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S80827=0;
                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                          S80827=1;
                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 134, column: 5
                            S82345=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 64, column: 13
                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 65, column: 21
                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 66, column: 21
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 67, column: 21
                          twin.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 25
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 68, column: 25
                          S78175=0;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S78175=0;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S78173=2;
                        S80832=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                          S80832=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S80827=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                            S80827=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 134, column: 5
                              S82345=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
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

  public void thread103328(int [] tdone, int [] ends){
        switch(S78149){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 41, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 42, column: 8
            auto_1.setPresent();//sysj\lidLoaderController.sysj line: 42, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\lidLoaderController.sysj line: 43, column: 12
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

  public void thread103326(int [] tdone, int [] ends){
        S103321=1;
    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 50, column: 3
    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 51, column: 3
    w_thread_3 = null;//sysj\lidLoaderController.sysj line: 52, column: 3
    S82345=0;
    if(reset.getprestatus()){//sysj\lidLoaderController.sysj line: 55, column: 20
      start_in.setPreempted();
      done_o.setPreempted();
      S82345=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S78173=0;
      S78157=0;
      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 56, column: 5
        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
        S78157=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S78152=0;
        if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
          start_in.setACK(true);//sysj\lidLoaderController.sysj line: 56, column: 5
          S78152=1;
          if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 56, column: 5
            start_in.setACK(false);//sysj\lidLoaderController.sysj line: 56, column: 5
            ends[3]=2;
            ;//sysj\lidLoaderController.sysj line: 56, column: 5
            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 57, column: 5
            S78173=1;
            if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 60, column: 8
              System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 61, column: 6
              w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 62, column: 6
              S78173=2;
              S80832=0;
              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                S80832=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S80827=0;
                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                  S80827=1;
                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                    ends[3]=2;
                    ;//sysj\lidLoaderController.sysj line: 134, column: 5
                    S82345=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
            else {
              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 64, column: 13
                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 65, column: 21
                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 66, column: 21
                if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 67, column: 21
                  twin.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 25
                  currsigs.addElement(twin);
                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 68, column: 25
                  S78175=0;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S78175=0;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                S78173=2;
                S80832=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 134, column: 5
                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                  S80832=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S80827=0;
                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 134, column: 5
                    S80827=1;
                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 134, column: 5
                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 134, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 134, column: 5
                      S82345=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
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
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
      }
    }
  }

  public void thread103325(int [] tdone, int [] ends){
        S78149=1;
    if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 41, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 42, column: 8
        auto_1.setPresent();//sysj\lidLoaderController.sysj line: 42, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\lidLoaderController.sysj line: 43, column: 12
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
      switch(S103323){
        case 0 : 
          S103323=0;
          break RUN;
        
        case 1 : 
          S103323=2;
          S103323=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 37, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 37, column: 2
          thread103325(tdone,ends);
          thread103326(tdone,ends);
          int biggest103327 = 0;
          if(ends[2]>=biggest103327){
            biggest103327=ends[2];
          }
          if(ends[3]>=biggest103327){
            biggest103327=ends[3];
          }
          if(biggest103327 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 37, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 37, column: 2
          thread103328(tdone,ends);
          thread103329(tdone,ends);
          int biggest103417 = 0;
          if(ends[2]>=biggest103417){
            biggest103417=ends[2];
          }
          if(ends[3]>=biggest103417){
            biggest103417=ends[3];
          }
          if(biggest103417 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest103417 == 0){
            S103323=0;
            active[1]=0;
            ends[1]=0;
            S103323=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
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
          start_in.gethook();
          done_o.gethook();
          mode.gethook();
          reset.gethook();
          pusherExtended.gethook();
          pusherRetracted.gethook();
          lidAtPickup.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          magazineEmpty.gethook();
          refilled.gethook();
          pusherExtendM.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          refillM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
      pusherExtended.setpreclear();
      pusherRetracted.setpreclear();
      lidAtPickup.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      magazineEmpty.setpreclear();
      refilled.setpreclear();
      pusherExtendM.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      refillM.setpreclear();
      twin.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      refill.setpreclear();
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
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = lidAtPickup.getStatus() ? lidAtPickup.setprepresent() : lidAtPickup.setpreclear();
      lidAtPickup.setpreval(lidAtPickup.getValue());
      lidAtPickup.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = magazineEmpty.getStatus() ? magazineEmpty.setprepresent() : magazineEmpty.setpreclear();
      magazineEmpty.setpreval(magazineEmpty.getValue());
      magazineEmpty.setClear();
      dummyint = refilled.getStatus() ? refilled.setprepresent() : refilled.setpreclear();
      refilled.setpreval(refilled.getValue());
      refilled.setClear();
      dummyint = pusherExtendM.getStatus() ? pusherExtendM.setprepresent() : pusherExtendM.setpreclear();
      pusherExtendM.setpreval(pusherExtendM.getValue());
      pusherExtendM.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      dummyint = refillM.getStatus() ? refillM.setprepresent() : refillM.setpreclear();
      refillM.setpreval(refillM.getValue());
      refillM.setClear();
      twin.sethook();
      twin.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      refill.sethook();
      refill.setClear();
      auto_1.setClear();
      manual_1.setClear();
      start_in.sethook();
      done_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        start_in.gethook();
        done_o.gethook();
        mode.gethook();
        reset.gethook();
        pusherExtended.gethook();
        pusherRetracted.gethook();
        lidAtPickup.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        magazineEmpty.gethook();
        refilled.gethook();
        pusherExtendM.gethook();
        vacOnM.gethook();
        armSourceM.gethook();
        armDestM.gethook();
        refillM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
