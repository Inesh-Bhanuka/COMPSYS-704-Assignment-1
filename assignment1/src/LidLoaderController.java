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
  public Signal operatorPermit = new Signal("operatorPermit", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
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
  private LidLoaderTwin t_thread_3;//sysj\lidLoaderController.sysj line: 45, column: 3
  private int lids_thread_3;//sysj\lidLoaderController.sysj line: 46, column: 3
  private WorkpieceTwin w_thread_3;//sysj\lidLoaderController.sysj line: 47, column: 3
  private boolean permitted_thread_3;//sysj\lidLoaderController.sysj line: 56, column: 1
  private int S105626 = 1;
  private int S69620 = 1;
  private int S105094 = 1;
  private int S75533 = 1;
  private int S69645 = 1;
  private int S69629 = 1;
  private int S69624 = 1;
  private int S69646 = 1;
  private int S69737 = 1;
  private int S69799 = 1;
  private int S69804 = 1;
  private int S70696 = 1;
  private int S70691 = 1;
  private int S105624 = 1;
  private int S105270 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread105694(int [] tdone, int [] ends){
        switch(S105624){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S105270){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 20
              S105270=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 118, column: 20
                S105270=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 14
                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 120, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 121, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                  else {
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                }
                else {
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 121, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                  else {
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 118, column: 20
              S105270=2;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 14
                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 120, column: 30
                currsigs.addElement(pusherExtend);
                if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 14
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 121, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                      currsigs.addElement(armDest);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                      currsigs.addElement(armDest);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                      currsigs.addElement(armDest);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                      currsigs.addElement(armDest);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                }
              }
              else {
                if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 14
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 121, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                      currsigs.addElement(armDest);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                      currsigs.addElement(armDest);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                      currsigs.addElement(armDest);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                      currsigs.addElement(armDest);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                }
              }
            }
            break;
          
          case 2 : 
            S105270=2;
            S105270=0;
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 20
              S105270=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 118, column: 20
                S105270=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 14
                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 120, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 121, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                  else {
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                }
                else {
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 121, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                  else {
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                        currsigs.addElement(armDest);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread105692(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105691(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105689(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105688(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105686(int [] tdone, int [] ends){
        switch(S69804){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
        currsigs.addElement(vacOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread105685(int [] tdone, int [] ends){
        switch(S69799){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
        currsigs.addElement(armDest);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread105683(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105682(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105680(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105679(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105677(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105676(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105674(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105673(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105671(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105670(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105668(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105667(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105665(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105664(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105662(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105661(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105659(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105658(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105656(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105655(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105653(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105652(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105650(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105649(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105647(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105646(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105644(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105643(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105641(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105640(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105639(int [] tdone, int [] ends){
        switch(S105094){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S75533){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 50, column: 20
              S75533=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S75533=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S69645=0;
                S69629=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
                  start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                  S69629=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S69624=0;
                  if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                    start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
                    S69624=1;
                    if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                      start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 53, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                      S69645=1;
                      if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                        permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                        S69646=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S69645=2;
                        if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                          System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                          w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                          S69645=3;
                          S70696=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                            S70696=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S70691=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70691=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                S75533=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 70, column: 13
                            S69737=0;
                            if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 14
                              System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 73, column: 7
                              if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                                S69737=1;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                  S69737=2;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                    S69737=3;
                                    if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                      S69737=4;
                                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                        S69737=5;
                                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                          S69737=6;
                                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                            }
                                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                              twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                              S69645=3;
                                              S70696=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70696=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S70691=0;
                                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S70691=1;
                                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    S75533=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                              S69645=3;
                                              S70696=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70696=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S70691=0;
                                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S70691=1;
                                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    S75533=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
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
                                          thread105640(tdone,ends);
                                          thread105641(tdone,ends);
                                          int biggest105642 = 0;
                                          if(ends[4]>=biggest105642){
                                            biggest105642=ends[4];
                                          }
                                          if(ends[5]>=biggest105642){
                                            biggest105642=ends[5];
                                          }
                                          if(biggest105642 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                        currsigs.addElement(vacOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                                else {
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                refill.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 8
                                currsigs.addElement(refill);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S69737=1;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                S69737=2;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                  S69737=3;
                                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                    S69737=4;
                                    if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                      S69737=5;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                        S69737=6;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                          }
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                            S69645=3;
                                            S70696=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                              S70696=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S70691=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70691=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S75533=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                            S69645=3;
                                            S70696=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                              S70696=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S70691=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70691=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S75533=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
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
                                        thread105643(tdone,ends);
                                        thread105644(tdone,ends);
                                        int biggest105645 = 0;
                                        if(ends[4]>=biggest105645){
                                          biggest105645=ends[4];
                                        }
                                        if(ends[5]>=biggest105645){
                                          biggest105645=ends[5];
                                        }
                                        if(biggest105645 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                      currsigs.addElement(vacOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                              else {
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            S69645=3;
                            S70696=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70696=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S70691=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                S70691=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S75533=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
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
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S75533=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S69645){
                case 0 : 
                  switch(S69629){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                        S69629=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S69624){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                              start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
                              S69624=1;
                              if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                                start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 53, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                                S69645=1;
                                if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                                  permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                                  S69646=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S69645=2;
                                  if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                                    System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                                    w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                                    S69645=3;
                                    S70696=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70696=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S70691=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70691=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S75533=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 70, column: 13
                                      S69737=0;
                                      if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 14
                                        System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 73, column: 7
                                        if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                                          S69737=1;
                                          if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                            S69737=2;
                                            if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                              S69737=3;
                                              if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                                S69737=4;
                                                if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                                  S69737=5;
                                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                                    S69737=6;
                                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                                      }
                                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                                        currsigs.addElement(twin);
                                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                        S69645=3;
                                                        S70696=0;
                                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S70696=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S70691=0;
                                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            S70691=1;
                                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                              S75533=2;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                        S69645=3;
                                                        S70696=0;
                                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S70696=1;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          S70691=0;
                                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            S70691=1;
                                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                              ends[3]=2;
                                                              ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                              S75533=2;
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                            else {
                                                              active[3]=1;
                                                              ends[3]=1;
                                                              tdone[3]=1;
                                                            }
                                                          }
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
                                                    thread105646(tdone,ends);
                                                    thread105647(tdone,ends);
                                                    int biggest105648 = 0;
                                                    if(ends[4]>=biggest105648){
                                                      biggest105648=ends[4];
                                                    }
                                                    if(ends[5]>=biggest105648){
                                                      biggest105648=ends[5];
                                                    }
                                                    if(biggest105648 == 1){
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                                  currsigs.addElement(vacOn);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                                          else {
                                            pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                            currsigs.addElement(pusherExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          refill.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 8
                                          currsigs.addElement(refill);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S69737=1;
                                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                          S69737=2;
                                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                            S69737=3;
                                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                              S69737=4;
                                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                                S69737=5;
                                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                                  S69737=6;
                                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                                    }
                                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                                      currsigs.addElement(twin);
                                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                      S69645=3;
                                                      S70696=0;
                                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S70696=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S70691=0;
                                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S70691=1;
                                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            S75533=2;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                      S69645=3;
                                                      S70696=0;
                                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S70696=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S70691=0;
                                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S70691=1;
                                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            S75533=2;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
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
                                                  thread105649(tdone,ends);
                                                  thread105650(tdone,ends);
                                                  int biggest105651 = 0;
                                                  if(ends[4]>=biggest105651){
                                                    biggest105651=ends[4];
                                                  }
                                                  if(ends[5]>=biggest105651){
                                                    biggest105651=ends[5];
                                                  }
                                                  if(biggest105651 == 1){
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                                currsigs.addElement(vacOn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                                        else {
                                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                          currsigs.addElement(pusherExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      S69645=3;
                                      S70696=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70696=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S70691=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S70691=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                            S75533=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                              }
                              else {
                                active[3]=1;
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
                            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 53, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                              S69645=1;
                              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                                permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                                S69646=0;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S69645=2;
                                if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                                  System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                                  w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                                  S69645=3;
                                  S70696=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S70696=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S70691=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70691=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S75533=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 70, column: 13
                                    S69737=0;
                                    if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 14
                                      System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 73, column: 7
                                      if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                                        S69737=1;
                                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                          S69737=2;
                                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                            S69737=3;
                                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                              S69737=4;
                                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                                S69737=5;
                                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                                  S69737=6;
                                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                                    }
                                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                                      currsigs.addElement(twin);
                                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                      S69645=3;
                                                      S70696=0;
                                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S70696=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S70691=0;
                                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S70691=1;
                                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            S75533=2;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                      S69645=3;
                                                      S70696=0;
                                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S70696=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S70691=0;
                                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S70691=1;
                                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                            S75533=2;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
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
                                                  thread105652(tdone,ends);
                                                  thread105653(tdone,ends);
                                                  int biggest105654 = 0;
                                                  if(ends[4]>=biggest105654){
                                                    biggest105654=ends[4];
                                                  }
                                                  if(ends[5]>=biggest105654){
                                                    biggest105654=ends[5];
                                                  }
                                                  if(biggest105654 == 1){
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                                currsigs.addElement(vacOn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                                        else {
                                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                          currsigs.addElement(pusherExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        refill.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 8
                                        currsigs.addElement(refill);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S69737=1;
                                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                        S69737=2;
                                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                          S69737=3;
                                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                            S69737=4;
                                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                              S69737=5;
                                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                                S69737=6;
                                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                                  }
                                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                                    currsigs.addElement(twin);
                                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                    S69645=3;
                                                    S70696=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      S70696=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S70691=0;
                                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S70691=1;
                                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S75533=2;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                    S69645=3;
                                                    S70696=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      S70696=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S70691=0;
                                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S70691=1;
                                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S75533=2;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
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
                                                thread105655(tdone,ends);
                                                thread105656(tdone,ends);
                                                int biggest105657 = 0;
                                                if(ends[4]>=biggest105657){
                                                  biggest105657=ends[4];
                                                }
                                                if(ends[5]>=biggest105657){
                                                  biggest105657=ends[5];
                                                }
                                                if(biggest105657 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                              currsigs.addElement(vacOn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                                      else {
                                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                        currsigs.addElement(pusherExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S69645=3;
                                    S70696=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70696=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S70691=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70691=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S75533=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                      S69629=1;
                      S69629=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                        S69629=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S69624=0;
                        if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                          start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
                          S69624=1;
                          if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                            start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 53, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                            S69645=1;
                            if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                              permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                              S69646=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S69645=2;
                              if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                                System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                                S69645=3;
                                S70696=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S70696=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S70691=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S70691=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S75533=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 70, column: 13
                                  S69737=0;
                                  if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 14
                                    System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 73, column: 7
                                    if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                                      S69737=1;
                                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                        S69737=2;
                                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                          S69737=3;
                                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                            S69737=4;
                                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                              S69737=5;
                                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                                S69737=6;
                                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                                  }
                                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                                    currsigs.addElement(twin);
                                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                    S69645=3;
                                                    S70696=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      S70696=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S70691=0;
                                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S70691=1;
                                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S75533=2;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                    S69645=3;
                                                    S70696=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      S70696=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S70691=0;
                                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S70691=1;
                                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                          S75533=2;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
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
                                                thread105658(tdone,ends);
                                                thread105659(tdone,ends);
                                                int biggest105660 = 0;
                                                if(ends[4]>=biggest105660){
                                                  biggest105660=ends[4];
                                                }
                                                if(ends[5]>=biggest105660){
                                                  biggest105660=ends[5];
                                                }
                                                if(biggest105660 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                              currsigs.addElement(vacOn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                                      else {
                                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                        currsigs.addElement(pusherExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      refill.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 8
                                      currsigs.addElement(refill);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S69737=1;
                                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                      S69737=2;
                                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                        S69737=3;
                                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                          S69737=4;
                                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                            S69737=5;
                                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                              S69737=6;
                                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                                }
                                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                                  currsigs.addElement(twin);
                                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                  S69645=3;
                                                  S70696=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    S70696=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S70691=0;
                                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      S70691=1;
                                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S75533=2;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                                  S69645=3;
                                                  S70696=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    S70696=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S70691=0;
                                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                      S70691=1;
                                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                        S75533=2;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
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
                                              thread105661(tdone,ends);
                                              thread105662(tdone,ends);
                                              int biggest105663 = 0;
                                              if(ends[4]>=biggest105663){
                                                biggest105663=ends[4];
                                              }
                                              if(ends[5]>=biggest105663){
                                                biggest105663=ends[5];
                                              }
                                              if(biggest105663 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                                    else {
                                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  S69645=3;
                                  S70696=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S70696=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S70691=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70691=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S75533=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                  switch(S69646){
                    case 0 : 
                      S69646=0;
                      S69646=1;
                      if(!permitted_thread_3){//sysj\lidLoaderController.sysj line: 58, column: 19
                        permitted_thread_3 = GuiStep.take("LID", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\lidLoaderController.sysj line: 59, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\lidLoaderController.sysj line: 58, column: 13
                        S69646=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!permitted_thread_3){//sysj\lidLoaderController.sysj line: 58, column: 19
                        permitted_thread_3 = GuiStep.take("LID", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\lidLoaderController.sysj line: 59, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\lidLoaderController.sysj line: 58, column: 13
                        S69646=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      S69646=2;
                      S69645=2;
                      if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                        System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                        w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                        S69645=3;
                        S70696=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                          S70696=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S70691=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                            S70691=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 109, column: 5
                              S75533=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 70, column: 13
                          S69737=0;
                          if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 14
                            System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 73, column: 7
                            if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                              S69737=1;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                S69737=2;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                  S69737=3;
                                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                    S69737=4;
                                    if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                      S69737=5;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                        S69737=6;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                          }
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                            S69645=3;
                                            S70696=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                              S70696=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S70691=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70691=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S75533=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                            S69645=3;
                                            S70696=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                              S70696=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S70691=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70691=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S75533=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
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
                                        thread105664(tdone,ends);
                                        thread105665(tdone,ends);
                                        int biggest105666 = 0;
                                        if(ends[4]>=biggest105666){
                                          biggest105666=ends[4];
                                        }
                                        if(ends[5]>=biggest105666){
                                          biggest105666=ends[5];
                                        }
                                        if(biggest105666 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                      currsigs.addElement(vacOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                              else {
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              refill.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 8
                              currsigs.addElement(refill);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S69737=1;
                            if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                              S69737=2;
                              if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                S69737=3;
                                if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                  S69737=4;
                                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                    S69737=5;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                      S69737=6;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                        }
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                          S69645=3;
                                          S70696=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                            S70696=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S70691=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                              S70691=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S75533=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                          S69645=3;
                                          S70696=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                            S70696=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S70691=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                              S70691=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S75533=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread105667(tdone,ends);
                                      thread105668(tdone,ends);
                                      int biggest105669 = 0;
                                      if(ends[4]>=biggest105669){
                                        biggest105669=ends[4];
                                      }
                                      if(ends[5]>=biggest105669){
                                        biggest105669=ends[5];
                                      }
                                      if(biggest105669 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                            else {
                              pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          S69645=3;
                          S70696=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                            S70696=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S70691=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70691=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                S75533=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                  switch(S69737){
                    case 0 : 
                      if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                        S69737=1;
                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                          S69737=2;
                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                            S69737=3;
                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                              S69737=4;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                S69737=5;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                  S69737=6;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                    }
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                      S69645=3;
                                      S70696=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70696=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S70691=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S70691=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                            S75533=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                      S69645=3;
                                      S70696=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70696=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S70691=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S70691=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                            S75533=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread105670(tdone,ends);
                                  thread105671(tdone,ends);
                                  int biggest105672 = 0;
                                  if(ends[4]>=biggest105672){
                                    biggest105672=ends[4];
                                  }
                                  if(ends[5]>=biggest105672){
                                    biggest105672=ends[5];
                                  }
                                  if(biggest105672 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                        else {
                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        refill.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 8
                        currsigs.addElement(refill);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                        S69737=2;
                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                          S69737=3;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                            S69737=4;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                              S69737=5;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                S69737=6;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                  }
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                    S69645=3;
                                    S70696=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70696=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S70691=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70691=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S75533=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                    S69645=3;
                                    S70696=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70696=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S70691=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70691=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S75533=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
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
                                thread105673(tdone,ends);
                                thread105674(tdone,ends);
                                int biggest105675 = 0;
                                if(ends[4]>=biggest105675){
                                  biggest105675=ends[4];
                                }
                                if(ends[5]>=biggest105675){
                                  biggest105675=ends[5];
                                }
                                if(biggest105675 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                      else {
                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                        S69737=3;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                          S69737=4;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                            S69737=5;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                              S69737=6;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                }
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                  S69645=3;
                                  S70696=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S70696=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S70691=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70691=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S75533=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                  S69645=3;
                                  S70696=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S70696=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S70691=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70691=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S75533=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                              thread105676(tdone,ends);
                              thread105677(tdone,ends);
                              int biggest105678 = 0;
                              if(ends[4]>=biggest105678){
                                biggest105678=ends[4];
                              }
                              if(ends[5]>=biggest105678){
                                biggest105678=ends[5];
                              }
                              if(biggest105678 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                      break;
                    
                    case 3 : 
                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                        S69737=4;
                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                          S69737=5;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                            S69737=6;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                              lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                              if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                              }
                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                S69645=3;
                                S70696=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S70696=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S70691=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S70691=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S75533=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                S69645=3;
                                S70696=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S70696=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S70691=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S70691=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S75533=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                            thread105679(tdone,ends);
                            thread105680(tdone,ends);
                            int biggest105681 = 0;
                            if(ends[4]>=biggest105681){
                              biggest105681=ends[4];
                            }
                            if(ends[5]>=biggest105681){
                              biggest105681=ends[5];
                            }
                            if(biggest105681 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                        S69737=5;
                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                          S69737=6;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                            }
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                              S69645=3;
                              S70696=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                S70696=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S70691=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S70691=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S75533=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                              S69645=3;
                              S70696=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                S70696=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S70691=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S70691=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S75533=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                          thread105682(tdone,ends);
                          thread105683(tdone,ends);
                          int biggest105684 = 0;
                          if(ends[4]>=biggest105684){
                            biggest105684=ends[4];
                          }
                          if(ends[5]>=biggest105684){
                            biggest105684=ends[5];
                          }
                          if(biggest105684 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                        currsigs.addElement(vacOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 5 : 
                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                        S69737=6;
                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                          }
                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                            twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                            S69645=3;
                            S70696=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70696=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S70691=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                S70691=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S75533=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                            S69645=3;
                            S70696=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70696=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S70691=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                S70691=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S75533=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
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
                        thread105685(tdone,ends);
                        thread105686(tdone,ends);
                        int biggest105687 = 0;
                        if(ends[4]>=biggest105687){
                          biggest105687=ends[4];
                        }
                        if(ends[5]>=biggest105687){
                          biggest105687=ends[5];
                        }
                        if(biggest105687 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest105687 == 0){
                          S69737=6;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                            }
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                              S69645=3;
                              S70696=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                S70696=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S70691=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S70691=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S75533=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                              S69645=3;
                              S70696=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                S70696=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S70691=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S70691=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                    S75533=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                    
                    case 6 : 
                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                        }
                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                          twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                          S69645=3;
                          S70696=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                            S70696=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S70691=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70691=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                S75533=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                          S69645=3;
                          S70696=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                            S70696=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S70691=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70691=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                S75533=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
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
                
                case 3 : 
                  switch(S70696){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                        S70696=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S70691){
                          case 0 : 
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70691=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                S75533=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 109, column: 5
                              S75533=2;
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
                      S70696=1;
                      S70696=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                        S70696=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S70691=0;
                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                          S70691=1;
                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                            S75533=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                
                case 4 : 
                  S75533=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 5 : 
                  S75533=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S75533=2;
            S75533=0;
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 50, column: 20
              S75533=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S75533=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S69645=0;
                S69629=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
                  start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                  S69629=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S69624=0;
                  if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                    start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
                    S69624=1;
                    if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                      start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 53, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                      S69645=1;
                      if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                        permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                        S69646=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S69645=2;
                        if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                          System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                          w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                          S69645=3;
                          S70696=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                            S70696=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S70691=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70691=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                S75533=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 70, column: 13
                            S69737=0;
                            if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 14
                              System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 73, column: 7
                              if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                                S69737=1;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                  S69737=2;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                    S69737=3;
                                    if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                      S69737=4;
                                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                        S69737=5;
                                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                          S69737=6;
                                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                            }
                                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                              twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                              S69645=3;
                                              S70696=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70696=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S70691=0;
                                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S70691=1;
                                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    S75533=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                              S69645=3;
                                              S70696=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70696=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S70691=0;
                                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S70691=1;
                                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                    S75533=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
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
                                          thread105688(tdone,ends);
                                          thread105689(tdone,ends);
                                          int biggest105690 = 0;
                                          if(ends[4]>=biggest105690){
                                            biggest105690=ends[4];
                                          }
                                          if(ends[5]>=biggest105690){
                                            biggest105690=ends[5];
                                          }
                                          if(biggest105690 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                        currsigs.addElement(vacOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                                else {
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                refill.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 8
                                currsigs.addElement(refill);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S69737=1;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                                S69737=2;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                  S69737=3;
                                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                    S69737=4;
                                    if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                      S69737=5;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                        S69737=6;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                          }
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                            S69645=3;
                                            S70696=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                              S70696=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S70691=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70691=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S75533=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                            S69645=3;
                                            S70696=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                              S70696=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S70691=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                S70691=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                                  S75533=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
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
                                        thread105691(tdone,ends);
                                        thread105692(tdone,ends);
                                        int biggest105693 = 0;
                                        if(ends[4]>=biggest105693){
                                          biggest105693=ends[4];
                                        }
                                        if(ends[5]>=biggest105693){
                                          biggest105693=ends[5];
                                        }
                                        if(biggest105693 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                      currsigs.addElement(vacOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                              else {
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            S69645=3;
                            S70696=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                              S70696=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S70691=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                S70691=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                  S75533=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
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

  public void thread105638(int [] tdone, int [] ends){
        switch(S69620){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 36, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 37, column: 8
            auto_1.setPresent();//sysj\lidLoaderController.sysj line: 37, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\lidLoaderController.sysj line: 38, column: 12
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

  public void thread105636(int [] tdone, int [] ends){
        S105624=1;
    S105270=0;
    if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 117, column: 20
      S105270=1;
      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 118, column: 20
        S105270=2;
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
      else {
        if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 120, column: 14
          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 120, column: 30
          currsigs.addElement(pusherExtend);
          if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 14
            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 121, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                currsigs.addElement(armDest);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                currsigs.addElement(armDest);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
          }
          else {
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                currsigs.addElement(armDest);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                currsigs.addElement(armDest);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
          }
        }
        else {
          if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 121, column: 14
            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 121, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                currsigs.addElement(armDest);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                currsigs.addElement(armDest);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
          }
          else {
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 122, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 122, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                currsigs.addElement(armDest);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 123, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 123, column: 25
                currsigs.addElement(armDest);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
          }
        }
      }
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread105634(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105633(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105631(int [] tdone, int [] ends){
        S69804=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread105630(int [] tdone, int [] ends){
        S69799=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread105629(int [] tdone, int [] ends){
        S105094=1;
    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 45, column: 3
    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 46, column: 3
    w_thread_3 = null;//sysj\lidLoaderController.sysj line: 47, column: 3
    S75533=0;
    if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 50, column: 20
      S75533=1;
      if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S75533=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S69645=0;
        S69629=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
          start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
          S69629=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S69624=0;
          if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
            start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
            S69624=1;
            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
              ends[3]=2;
              ;//sysj\lidLoaderController.sysj line: 53, column: 5
              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
              S69645=1;
              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                S69646=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S69645=2;
                if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                  System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                  w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                  S69645=3;
                  S70696=0;
                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                    S70696=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S70691=0;
                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                      S70691=1;
                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                        ends[3]=2;
                        ;//sysj\lidLoaderController.sysj line: 109, column: 5
                        S75533=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 70, column: 13
                    S69737=0;
                    if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 14
                      System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 73, column: 7
                      if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 23
                        S69737=1;
                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                          S69737=2;
                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                            S69737=3;
                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                              S69737=4;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                                S69737=5;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                  S69737=6;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                    }
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                      S69645=3;
                                      S70696=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70696=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S70691=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S70691=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                            S75533=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                      S69645=3;
                                      S70696=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70696=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S70691=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S70691=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                            S75533=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread105630(tdone,ends);
                                  thread105631(tdone,ends);
                                  int biggest105632 = 0;
                                  if(ends[4]>=biggest105632){
                                    biggest105632=ends[4];
                                  }
                                  if(ends[5]>=biggest105632){
                                    biggest105632=ends[5];
                                  }
                                  if(biggest105632 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                        else {
                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        refill.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 8
                        currsigs.addElement(refill);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S69737=1;
                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 22
                        S69737=2;
                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                          S69737=3;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                            S69737=4;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                              S69737=5;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 22
                                S69737=6;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 99, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 100, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 101, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 101, column: 20
                                  }
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 102, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 103, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 104, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 104, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                    S69645=3;
                                    S70696=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70696=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S70691=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70691=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S75533=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 106, column: 6
                                    S69645=3;
                                    S70696=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                      S70696=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S70691=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                                        S70691=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                                          S75533=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
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
                                thread105633(tdone,ends);
                                thread105634(tdone,ends);
                                int biggest105635 = 0;
                                if(ends[4]>=biggest105635){
                                  biggest105635=ends[4];
                                }
                                if(ends[5]>=biggest105635){
                                  biggest105635=ends[5];
                                }
                                if(biggest105635 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 90, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
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
                      else {
                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    S69645=3;
                    S70696=0;
                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 109, column: 5
                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                      S70696=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S70691=0;
                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 5
                        S70691=1;
                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 109, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 109, column: 5
                          ends[3]=2;
                          ;//sysj\lidLoaderController.sysj line: 109, column: 5
                          S75533=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
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
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
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

  public void thread105628(int [] tdone, int [] ends){
        S69620=1;
    if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 36, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 37, column: 8
        auto_1.setPresent();//sysj\lidLoaderController.sysj line: 37, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\lidLoaderController.sysj line: 38, column: 12
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
      switch(S105626){
        case 0 : 
          S105626=0;
          break RUN;
        
        case 1 : 
          S105626=2;
          S105626=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 32, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 32, column: 2
          thread105628(tdone,ends);
          thread105629(tdone,ends);
          thread105636(tdone,ends);
          int biggest105637 = 0;
          if(ends[2]>=biggest105637){
            biggest105637=ends[2];
          }
          if(ends[3]>=biggest105637){
            biggest105637=ends[3];
          }
          if(ends[6]>=biggest105637){
            biggest105637=ends[6];
          }
          if(biggest105637 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 32, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 32, column: 2
          thread105638(tdone,ends);
          thread105639(tdone,ends);
          thread105694(tdone,ends);
          int biggest105695 = 0;
          if(ends[2]>=biggest105695){
            biggest105695=ends[2];
          }
          if(ends[3]>=biggest105695){
            biggest105695=ends[3];
          }
          if(ends[6]>=biggest105695){
            biggest105695=ends[6];
          }
          if(biggest105695 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest105695 == 0){
            S105626=0;
            active[1]=0;
            ends[1]=0;
            S105626=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
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
          operatorPermit.gethook();
          mode.gethook();
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
          df = true;
        }
        runClockDomain();
      }
      operatorPermit.setpreclear();
      mode.setpreclear();
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
      dummyint = operatorPermit.getStatus() ? operatorPermit.setprepresent() : operatorPermit.setpreclear();
      operatorPermit.setpreval(operatorPermit.getValue());
      operatorPermit.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
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
        operatorPermit.gethook();
        mode.gethook();
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
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
