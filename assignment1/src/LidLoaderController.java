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
  private int S102602 = 1;
  private int S70268 = 1;
  private int S102070 = 1;
  private int S75569 = 1;
  private int S70293 = 1;
  private int S70277 = 1;
  private int S70272 = 1;
  private int S70294 = 1;
  private int S70359 = 1;
  private int S70459 = 1;
  private int S70464 = 1;
  private int S71404 = 1;
  private int S71399 = 1;
  private int S102600 = 1;
  private int S102246 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread102634(int [] tdone, int [] ends){
        switch(S102600){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S102246){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 124, column: 20
              S102246=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 20
                S102246=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 127, column: 14
                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 128, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 128, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 20
              S102246=2;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 127, column: 14
                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 30
                currsigs.addElement(pusherExtend);
                if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 128, column: 14
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 128, column: 14
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
            S102246=2;
            S102246=0;
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 124, column: 20
              S102246=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 20
                S102246=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 127, column: 14
                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 128, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 128, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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

  public void thread102632(int [] tdone, int [] ends){
        switch(S70464){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 33
        currsigs.addElement(vacOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread102631(int [] tdone, int [] ends){
        switch(S70459){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 9
        currsigs.addElement(armDest);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread102629(int [] tdone, int [] ends){
        S70464=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread102628(int [] tdone, int [] ends){
        S70459=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread102626(int [] tdone, int [] ends){
        S70464=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread102625(int [] tdone, int [] ends){
        S70459=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread102623(int [] tdone, int [] ends){
        S70464=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread102622(int [] tdone, int [] ends){
        S70459=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread102620(int [] tdone, int [] ends){
        S70464=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread102619(int [] tdone, int [] ends){
        S70459=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread102617(int [] tdone, int [] ends){
        S70464=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread102616(int [] tdone, int [] ends){
        S70459=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread102614(int [] tdone, int [] ends){
        S70464=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread102613(int [] tdone, int [] ends){
        S70459=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread102611(int [] tdone, int [] ends){
        S70464=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread102610(int [] tdone, int [] ends){
        S70459=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 101, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread102609(int [] tdone, int [] ends){
        switch(S102070){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S75569){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 50, column: 20
              S75569=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S75569=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S70293=0;
                S70277=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
                  start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                  S70277=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S70272=0;
                  if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                    start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
                    S70272=1;
                    if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                      start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 53, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                      S70293=1;
                      if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                        permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                        S70294=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S70293=2;
                        if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                          System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                          w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                          S70293=3;
                          S71404=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                            S71404=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S71399=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71399=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                S75569=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                            t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 71, column: 21
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 72, column: 21
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 73, column: 21
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 74, column: 25
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 74, column: 25
                              S70359=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S70359=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S70293=3;
                            S71404=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71404=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S71399=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                S71399=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S75569=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
              S75569=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S70293){
                case 0 : 
                  switch(S70277){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                        S70277=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S70272){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                              start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
                              S70272=1;
                              if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                                start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 53, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                                S70293=1;
                                if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                                  permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                                  S70294=0;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S70293=2;
                                  if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                                    System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                                    w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                                    S70293=3;
                                    S71404=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S71404=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S71399=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71399=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S75569=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 71, column: 21
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 72, column: 21
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 73, column: 21
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 74, column: 25
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 74, column: 25
                                        S70359=0;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S70359=0;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S70293=3;
                                      S71404=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71404=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S71399=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S71399=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                            S75569=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                              S70293=1;
                              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                                permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                                S70294=0;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S70293=2;
                                if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                                  System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                                  w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                                  S70293=3;
                                  S71404=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S71404=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S71399=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S71399=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S75569=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 71, column: 21
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 72, column: 21
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 73, column: 21
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 74, column: 25
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 74, column: 25
                                      S70359=0;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S70359=0;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S70293=3;
                                    S71404=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S71404=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S71399=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71399=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S75569=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                      S70277=1;
                      S70277=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                        S70277=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S70272=0;
                        if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                          start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
                          S70272=1;
                          if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                            start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 53, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                            S70293=1;
                            if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                              permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                              S70294=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S70293=2;
                              if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                                System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                                S70293=3;
                                S71404=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S71404=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S71399=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S71399=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S75569=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 71, column: 21
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 72, column: 21
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 73, column: 21
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 74, column: 25
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 74, column: 25
                                    S70359=0;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S70359=0;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S70293=3;
                                  S71404=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S71404=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S71399=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S71399=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S75569=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                  switch(S70294){
                    case 0 : 
                      S70294=0;
                      S70294=1;
                      if(!permitted_thread_3){//sysj\lidLoaderController.sysj line: 58, column: 19
                        permitted_thread_3 = GuiStep.take("LID", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\lidLoaderController.sysj line: 59, column: 17
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        ends[3]=2;
                        ;//sysj\lidLoaderController.sysj line: 58, column: 13
                        S70294=2;
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
                        S70294=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      S70294=2;
                      S70293=2;
                      if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                        System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                        w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                        S70293=3;
                        S71404=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                          S71404=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S71399=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                            S71399=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 116, column: 5
                              S75569=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
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
                          t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 71, column: 21
                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 72, column: 21
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 73, column: 21
                            twin.setPresent();//sysj\lidLoaderController.sysj line: 74, column: 25
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 74, column: 25
                            S70359=0;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S70359=0;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S70293=3;
                          S71404=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                            S71404=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S71399=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71399=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                S75569=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                  switch(S70359){
                    case 0 : 
                      S70359=0;
                      S70359=1;
                      if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 14
                        System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 79, column: 7
                        if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 23
                          S70359=2;
                          if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                            S70359=3;
                            if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                              S70359=4;
                              if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 22
                                S70359=5;
                                if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                  S70359=6;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 100, column: 22
                                    S70359=7;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                                      lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                                      if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                                        lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                                      }
                                      t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                                      t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                                        twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                        S70293=3;
                                        S71404=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S71404=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S71399=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                            S71399=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                              S75569=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                        S70293=3;
                                        S71404=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S71404=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S71399=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                            S71399=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                              S75569=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
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
                                    thread102610(tdone,ends);
                                    thread102611(tdone,ends);
                                    int biggest102612 = 0;
                                    if(ends[4]>=biggest102612){
                                      biggest102612=ends[4];
                                    }
                                    if(ends[5]>=biggest102612){
                                      biggest102612=ends[5];
                                    }
                                    if(biggest102612 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 7
                                  currsigs.addElement(vacOn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
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
                            pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
                            currsigs.addElement(pusherExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          refill.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 8
                          currsigs.addElement(refill);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S70359=2;
                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                          S70359=3;
                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                            S70359=4;
                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 22
                              S70359=5;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                S70359=6;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 100, column: 22
                                  S70359=7;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                      S70293=3;
                                      S71404=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71404=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S71399=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S71399=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                            S75569=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                      S70293=3;
                                      S71404=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71404=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S71399=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S71399=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                            S75569=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread102613(tdone,ends);
                                  thread102614(tdone,ends);
                                  int biggest102615 = 0;
                                  if(ends[4]>=biggest102615){
                                    biggest102615=ends[4];
                                  }
                                  if(ends[5]>=biggest102615){
                                    biggest102615=ends[5];
                                  }
                                  if(biggest102615 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
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
                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                    case 1 : 
                      if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 23
                        S70359=2;
                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                          S70359=3;
                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                            S70359=4;
                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 22
                              S70359=5;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                                S70359=6;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 100, column: 22
                                  S70359=7;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                                    }
                                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                      S70293=3;
                                      S71404=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71404=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S71399=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S71399=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                            S75569=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                      S70293=3;
                                      S71404=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71404=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S71399=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S71399=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                            S75569=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread102616(tdone,ends);
                                  thread102617(tdone,ends);
                                  int biggest102618 = 0;
                                  if(ends[4]>=biggest102618){
                                    biggest102618=ends[4];
                                  }
                                  if(ends[5]>=biggest102618){
                                    biggest102618=ends[5];
                                  }
                                  if(biggest102618 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
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
                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        refill.setPresent();//sysj\lidLoaderController.sysj line: 81, column: 8
                        currsigs.addElement(refill);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                        S70359=3;
                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                          S70359=4;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 22
                            S70359=5;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                              S70359=6;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 100, column: 22
                                S70359=7;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                                  }
                                  t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                    S70293=3;
                                    S71404=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S71404=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S71399=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71399=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S75569=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                    S70293=3;
                                    S71404=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S71404=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S71399=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S71399=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                          S75569=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
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
                                thread102619(tdone,ends);
                                thread102620(tdone,ends);
                                int biggest102621 = 0;
                                if(ends[4]>=biggest102621){
                                  biggest102621=ends[4];
                                }
                                if(ends[5]>=biggest102621){
                                  biggest102621=ends[5];
                                }
                                if(biggest102621 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
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
                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 87, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 3 : 
                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 22
                        S70359=4;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 22
                          S70359=5;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                            S70359=6;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 100, column: 22
                              S70359=7;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                                }
                                t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                  S70293=3;
                                  S71404=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S71404=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S71399=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S71399=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S75569=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                  S70293=3;
                                  S71404=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S71404=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S71399=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S71399=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                        S75569=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                              thread102622(tdone,ends);
                              thread102623(tdone,ends);
                              int biggest102624 = 0;
                              if(ends[4]>=biggest102624){
                                biggest102624=ends[4];
                              }
                              if(ends[5]>=biggest102624){
                                biggest102624=ends[5];
                              }
                              if(biggest102624 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
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
                    
                    case 4 : 
                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 22
                        S70359=5;
                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                          S70359=6;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 100, column: 22
                            S70359=7;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                              lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                              if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                                lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                              }
                              t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                                twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                S70293=3;
                                S71404=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S71404=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S71399=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S71399=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S75569=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                                S70293=3;
                                S71404=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S71404=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S71399=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S71399=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                      S75569=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                            thread102625(tdone,ends);
                            thread102626(tdone,ends);
                            int biggest102627 = 0;
                            if(ends[4]>=biggest102627){
                              biggest102627=ends[4];
                            }
                            if(ends[5]>=biggest102627){
                              biggest102627=ends[5];
                            }
                            if(biggest102627 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 5 : 
                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 22
                        S70359=6;
                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 100, column: 22
                          S70359=7;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                            }
                            t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                              S70293=3;
                              S71404=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                S71404=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S71399=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S71399=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S75569=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                              S70293=3;
                              S71404=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                S71404=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S71399=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S71399=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S75569=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                          thread102628(tdone,ends);
                          thread102629(tdone,ends);
                          int biggest102630 = 0;
                          if(ends[4]>=biggest102630){
                            biggest102630=ends[4];
                          }
                          if(ends[5]>=biggest102630){
                            biggest102630=ends[5];
                          }
                          if(biggest102630 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 7
                        currsigs.addElement(vacOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 6 : 
                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 100, column: 22
                        S70359=7;
                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                          }
                          t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                            twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                            S70293=3;
                            S71404=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71404=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S71399=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                S71399=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S75569=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                            S70293=3;
                            S71404=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71404=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S71399=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                S71399=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S75569=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
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
                        thread102631(tdone,ends);
                        thread102632(tdone,ends);
                        int biggest102633 = 0;
                        if(ends[4]>=biggest102633){
                          biggest102633=ends[4];
                        }
                        if(ends[5]>=biggest102633){
                          biggest102633=ends[5];
                        }
                        if(biggest102633 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest102633 == 0){
                          S70359=7;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                            }
                            t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                              S70293=3;
                              S71404=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                S71404=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S71399=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S71399=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S75569=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                              S70293=3;
                              S71404=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                S71404=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S71399=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S71399=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                    S75569=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                    
                    case 7 : 
                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 103, column: 22
                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 105, column: 6
                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 106, column: 6
                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 107, column: 18
                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 107, column: 20
                        }
                        t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 108, column: 6
                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 109, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 110, column: 6
                          twin.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 111, column: 7
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                          S70293=3;
                          S71404=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                            S71404=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S71399=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71399=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                S75569=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 113, column: 6
                          S70293=3;
                          S71404=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                            S71404=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S71399=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71399=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                S75569=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
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
                  switch(S71404){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                        S71404=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S71399){
                          case 0 : 
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71399=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                S75569=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 116, column: 5
                              S75569=2;
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
                      S71404=1;
                      S71404=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                        S71404=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S71399=0;
                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                          S71399=1;
                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 116, column: 5
                            S75569=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                  S75569=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 5 : 
                  S75569=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 6 : 
                  S75569=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S75569=2;
            S75569=0;
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 50, column: 20
              S75569=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S75569=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S70293=0;
                S70277=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
                  start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                  S70277=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S70272=0;
                  if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                    start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
                    S70272=1;
                    if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
                      start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 53, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
                      S70293=1;
                      if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                        permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                        S70294=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S70293=2;
                        if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                          System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                          w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                          S70293=3;
                          S71404=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                            S71404=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S71399=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71399=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                S75569=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                            t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 71, column: 21
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 72, column: 21
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 73, column: 21
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 74, column: 25
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 74, column: 25
                              S70359=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S70359=0;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S70293=3;
                            S71404=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                              S71404=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S71399=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                                S71399=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 116, column: 5
                                  S75569=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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

  public void thread102608(int [] tdone, int [] ends){
        switch(S70268){
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

  public void thread102606(int [] tdone, int [] ends){
        S102600=1;
    S102246=0;
    if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 124, column: 20
      S102246=1;
      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 125, column: 20
        S102246=2;
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
      else {
        if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 127, column: 14
          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 127, column: 30
          currsigs.addElement(pusherExtend);
          if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 128, column: 14
            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
          if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 128, column: 14
            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 128, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 129, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 129, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 130, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 130, column: 25
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

  public void thread102605(int [] tdone, int [] ends){
        S102070=1;
    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 45, column: 3
    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 46, column: 3
    w_thread_3 = null;//sysj\lidLoaderController.sysj line: 47, column: 3
    S75569=0;
    if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 50, column: 20
      S75569=1;
      if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S75569=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S70293=0;
        S70277=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 53, column: 5
          start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
          S70277=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S70272=0;
          if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
            start_in.setACK(true);//sysj\lidLoaderController.sysj line: 53, column: 5
            S70272=1;
            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 53, column: 5
              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 53, column: 5
              ends[3]=2;
              ;//sysj\lidLoaderController.sysj line: 53, column: 5
              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 54, column: 5
              S70293=1;
              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 55, column: 4
                permitted_thread_3 = false;//sysj\lidLoaderController.sysj line: 56, column: 1
                S70294=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S70293=2;
                if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 66, column: 8
                  System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 67, column: 6
                  w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 68, column: 6
                  S70293=3;
                  S71404=0;
                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                    S71404=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S71399=0;
                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                      S71399=1;
                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                        ends[3]=2;
                        ;//sysj\lidLoaderController.sysj line: 116, column: 5
                        S75569=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
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
                    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 71, column: 21
                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 72, column: 21
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "place", "placing lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 73, column: 21
                      twin.setPresent();//sysj\lidLoaderController.sysj line: 74, column: 25
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 74, column: 25
                      S70359=0;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S70359=0;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    S70293=3;
                    S71404=0;
                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 116, column: 5
                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                      S71404=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S71399=0;
                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 116, column: 5
                        S71399=1;
                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 116, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 116, column: 5
                          ends[3]=2;
                          ;//sysj\lidLoaderController.sysj line: 116, column: 5
                          S75569=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
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

  public void thread102604(int [] tdone, int [] ends){
        S70268=1;
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
      switch(S102602){
        case 0 : 
          S102602=0;
          break RUN;
        
        case 1 : 
          S102602=2;
          S102602=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 32, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 32, column: 2
          thread102604(tdone,ends);
          thread102605(tdone,ends);
          thread102606(tdone,ends);
          int biggest102607 = 0;
          if(ends[2]>=biggest102607){
            biggest102607=ends[2];
          }
          if(ends[3]>=biggest102607){
            biggest102607=ends[3];
          }
          if(ends[6]>=biggest102607){
            biggest102607=ends[6];
          }
          if(biggest102607 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 32, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 32, column: 2
          thread102608(tdone,ends);
          thread102609(tdone,ends);
          thread102634(tdone,ends);
          int biggest102635 = 0;
          if(ends[2]>=biggest102635){
            biggest102635=ends[2];
          }
          if(ends[3]>=biggest102635){
            biggest102635=ends[3];
          }
          if(ends[6]>=biggest102635){
            biggest102635=ends[6];
          }
          if(biggest102635 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest102635 == 0){
            S102602=0;
            active[1]=0;
            ends[1]=0;
            S102602=0;
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
