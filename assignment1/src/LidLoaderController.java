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
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal refill = new Signal("refill", Signal.OUTPUT);
  public input_Channel start_in = new input_Channel();
  public output_Channel done_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private Workpiece w_thread_3;//sysj\lidLoaderController.sysj line: 41, column: 3
  private int S47458 = 1;
  private int S26176 = 1;
  private int S46926 = 1;
  private int S29634 = 1;
  private int S26200 = 1;
  private int S26184 = 1;
  private int S26179 = 1;
  private int S26227 = 1;
  private int S26289 = 1;
  private int S26294 = 1;
  private int S26939 = 1;
  private int S26934 = 1;
  private int S47456 = 1;
  private int S47102 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread47520(int [] tdone, int [] ends){
        switch(S47456){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S47102){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 20
              S47102=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 20
                S47102=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 14
                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 94, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 20
              S47102=2;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 14
                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 94, column: 30
                currsigs.addElement(pusherExtend);
                if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 14
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 14
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
            S47102=2;
            S47102=0;
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 20
              S47102=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 20
                S47102=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 14
                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 94, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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

  public void thread47518(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47517(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47515(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47514(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47512(int [] tdone, int [] ends){
        switch(S26294){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
        currsigs.addElement(vacOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread47511(int [] tdone, int [] ends){
        switch(S26289){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
        currsigs.addElement(armDest);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread47509(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47508(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47506(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47505(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47503(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47502(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47500(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47499(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47497(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47496(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47494(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47493(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47491(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47490(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47488(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47487(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47485(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47484(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47482(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47481(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47479(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47478(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47476(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47475(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47473(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47472(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47471(int [] tdone, int [] ends){
        switch(S46926){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S29634){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 44, column: 20
              S29634=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 46, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S29634=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S26200=0;
                S26184=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 47, column: 5
                  start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                  S26184=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S26179=0;
                  if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                    start_in.setACK(true);//sysj\lidLoaderController.sysj line: 47, column: 5
                    S26179=1;
                    if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                      start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 47, column: 5
                      w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj\lidLoaderController.sysj line: 48, column: 5
                      S26200=1;
                      if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 50, column: 8
                        S26227=0;
                        if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 14
                          System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 53, column: 7
                          if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 54, column: 23
                            S26227=1;
                            if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                              S26227=2;
                              if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                                S26227=3;
                                if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                  S26227=4;
                                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                    S26227=5;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                      S26227=6;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                        S26200=2;
                                        S26939=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                          S26939=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S26934=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                            S26934=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                              S29634=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      thread47472(tdone,ends);
                                      thread47473(tdone,ends);
                                      int biggest47474 = 0;
                                      if(ends[4]>=biggest47474){
                                        biggest47474=ends[4];
                                      }
                                      if(ends[5]>=biggest47474){
                                        biggest47474=ends[5];
                                      }
                                      if(biggest47474 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                              pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            refill.setPresent();//sysj\lidLoaderController.sysj line: 55, column: 8
                            currsigs.addElement(refill);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S26227=1;
                          if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                            S26227=2;
                            if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                              S26227=3;
                              if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                S26227=4;
                                if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                  S26227=5;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                    S26227=6;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                      S26200=2;
                                      S26939=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                        S26939=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S26934=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                          S26934=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                            S29634=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    thread47475(tdone,ends);
                                    thread47476(tdone,ends);
                                    int biggest47477 = 0;
                                    if(ends[4]>=biggest47477){
                                      biggest47477=ends[4];
                                    }
                                    if(ends[5]>=biggest47477){
                                      biggest47477=ends[5];
                                    }
                                    if(biggest47477 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                  currsigs.addElement(vacOn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                            pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                            currsigs.addElement(pusherExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S26200=2;
                        S26939=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                          S26939=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S26934=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                            S26934=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 83, column: 5
                              S29634=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
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
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 46, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S29634=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S26200){
                case 0 : 
                  switch(S26184){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 47, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                        S26184=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S26179){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                              start_in.setACK(true);//sysj\lidLoaderController.sysj line: 47, column: 5
                              S26179=1;
                              if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                                start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 47, column: 5
                                w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj\lidLoaderController.sysj line: 48, column: 5
                                S26200=1;
                                if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 50, column: 8
                                  S26227=0;
                                  if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 14
                                    System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 53, column: 7
                                    if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 54, column: 23
                                      S26227=1;
                                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                                        S26227=2;
                                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                                          S26227=3;
                                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                            S26227=4;
                                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                              S26227=5;
                                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                                S26227=6;
                                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                                  S26200=2;
                                                  S26939=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    S26939=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S26934=0;
                                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                      S26934=1;
                                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                                        S29634=2;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                thread47478(tdone,ends);
                                                thread47479(tdone,ends);
                                                int biggest47480 = 0;
                                                if(ends[4]>=biggest47480){
                                                  biggest47480=ends[4];
                                                }
                                                if(ends[5]>=biggest47480){
                                                  biggest47480=ends[5];
                                                }
                                                if(biggest47480 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                              currsigs.addElement(vacOn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                                        currsigs.addElement(pusherExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      refill.setPresent();//sysj\lidLoaderController.sysj line: 55, column: 8
                                      currsigs.addElement(refill);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S26227=1;
                                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                                      S26227=2;
                                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                                        S26227=3;
                                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                          S26227=4;
                                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                            S26227=5;
                                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                              S26227=6;
                                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                                S26200=2;
                                                S26939=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  S26939=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S26934=0;
                                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    S26934=1;
                                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                                      S29634=2;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                              thread47481(tdone,ends);
                                              thread47482(tdone,ends);
                                              int biggest47483 = 0;
                                              if(ends[4]>=biggest47483){
                                                biggest47483=ends[4];
                                              }
                                              if(ends[5]>=biggest47483){
                                                biggest47483=ends[5];
                                              }
                                              if(biggest47483 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  S26200=2;
                                  S26939=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                    S26939=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S26934=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                      S26934=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                        S29634=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 47, column: 5
                              w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj\lidLoaderController.sysj line: 48, column: 5
                              S26200=1;
                              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 50, column: 8
                                S26227=0;
                                if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 14
                                  System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 53, column: 7
                                  if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 54, column: 23
                                    S26227=1;
                                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                                      S26227=2;
                                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                                        S26227=3;
                                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                          S26227=4;
                                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                            S26227=5;
                                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                              S26227=6;
                                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                                S26200=2;
                                                S26939=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  S26939=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S26934=0;
                                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    S26934=1;
                                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                                      S29634=2;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                              thread47484(tdone,ends);
                                              thread47485(tdone,ends);
                                              int biggest47486 = 0;
                                              if(ends[4]>=biggest47486){
                                                biggest47486=ends[4];
                                              }
                                              if(ends[5]>=biggest47486){
                                                biggest47486=ends[5];
                                              }
                                              if(biggest47486 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    refill.setPresent();//sysj\lidLoaderController.sysj line: 55, column: 8
                                    currsigs.addElement(refill);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S26227=1;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                                    S26227=2;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                                      S26227=3;
                                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                        S26227=4;
                                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                          S26227=5;
                                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                            S26227=6;
                                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                              S26200=2;
                                              S26939=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                S26939=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S26934=0;
                                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  S26934=1;
                                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    S29634=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
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
                                            thread47487(tdone,ends);
                                            thread47488(tdone,ends);
                                            int biggest47489 = 0;
                                            if(ends[4]>=biggest47489){
                                              biggest47489=ends[4];
                                            }
                                            if(ends[5]>=biggest47489){
                                              biggest47489=ends[5];
                                            }
                                            if(biggest47489 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                          currsigs.addElement(vacOn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S26200=2;
                                S26939=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                  S26939=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S26934=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                    S26934=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                      S29634=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                      S26184=1;
                      S26184=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 47, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                        S26184=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S26179=0;
                        if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                          start_in.setACK(true);//sysj\lidLoaderController.sysj line: 47, column: 5
                          S26179=1;
                          if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                            start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 47, column: 5
                            w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj\lidLoaderController.sysj line: 48, column: 5
                            S26200=1;
                            if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 50, column: 8
                              S26227=0;
                              if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 14
                                System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 53, column: 7
                                if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 54, column: 23
                                  S26227=1;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                                    S26227=2;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                                      S26227=3;
                                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                        S26227=4;
                                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                          S26227=5;
                                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                            S26227=6;
                                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                              S26200=2;
                                              S26939=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                S26939=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S26934=0;
                                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  S26934=1;
                                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                                    S29634=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
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
                                            thread47490(tdone,ends);
                                            thread47491(tdone,ends);
                                            int biggest47492 = 0;
                                            if(ends[4]>=biggest47492){
                                              biggest47492=ends[4];
                                            }
                                            if(ends[5]>=biggest47492){
                                              biggest47492=ends[5];
                                            }
                                            if(biggest47492 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                          currsigs.addElement(vacOn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  refill.setPresent();//sysj\lidLoaderController.sysj line: 55, column: 8
                                  currsigs.addElement(refill);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S26227=1;
                                if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                                  S26227=2;
                                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                                    S26227=3;
                                    if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                      S26227=4;
                                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                        S26227=5;
                                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                          S26227=6;
                                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                            S26200=2;
                                            S26939=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                              S26939=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S26934=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                S26934=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                                  S29634=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
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
                                          thread47493(tdone,ends);
                                          thread47494(tdone,ends);
                                          int biggest47495 = 0;
                                          if(ends[4]>=biggest47495){
                                            biggest47495=ends[4];
                                          }
                                          if(ends[5]>=biggest47495){
                                            biggest47495=ends[5];
                                          }
                                          if(biggest47495 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                        currsigs.addElement(vacOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              S26200=2;
                              S26939=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                S26939=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S26934=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                  S26934=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                    S29634=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                  switch(S26227){
                    case 0 : 
                      if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 54, column: 23
                        S26227=1;
                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                          S26227=2;
                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                            S26227=3;
                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                              S26227=4;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                S26227=5;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                  S26227=6;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                    S26200=2;
                                    S26939=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                      S26939=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S26934=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                        S26934=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                          S29634=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  thread47496(tdone,ends);
                                  thread47497(tdone,ends);
                                  int biggest47498 = 0;
                                  if(ends[4]>=biggest47498){
                                    biggest47498=ends[4];
                                  }
                                  if(ends[5]>=biggest47498){
                                    biggest47498=ends[5];
                                  }
                                  if(biggest47498 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        refill.setPresent();//sysj\lidLoaderController.sysj line: 55, column: 8
                        currsigs.addElement(refill);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                        S26227=2;
                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                          S26227=3;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                            S26227=4;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                              S26227=5;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                S26227=6;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                  S26200=2;
                                  S26939=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                    S26939=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S26934=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                      S26934=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                        S29634=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                thread47499(tdone,ends);
                                thread47500(tdone,ends);
                                int biggest47501 = 0;
                                if(ends[4]>=biggest47501){
                                  biggest47501=ends[4];
                                }
                                if(ends[5]>=biggest47501){
                                  biggest47501=ends[5];
                                }
                                if(biggest47501 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                        S26227=3;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                          S26227=4;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                            S26227=5;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                              S26227=6;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                S26200=2;
                                S26939=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                  S26939=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S26934=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                    S26934=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                      S29634=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              thread47502(tdone,ends);
                              thread47503(tdone,ends);
                              int biggest47504 = 0;
                              if(ends[4]>=biggest47504){
                                biggest47504=ends[4];
                              }
                              if(ends[5]>=biggest47504){
                                biggest47504=ends[5];
                              }
                              if(biggest47504 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                        S26227=4;
                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                          S26227=5;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                            S26227=6;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                              S26200=2;
                              S26939=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                S26939=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S26934=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                  S26934=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                    S29634=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            thread47505(tdone,ends);
                            thread47506(tdone,ends);
                            int biggest47507 = 0;
                            if(ends[4]>=biggest47507){
                              biggest47507=ends[4];
                            }
                            if(ends[5]>=biggest47507){
                              biggest47507=ends[5];
                            }
                            if(biggest47507 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                        S26227=5;
                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                          S26227=6;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                            S26200=2;
                            S26939=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                              S26939=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S26934=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                S26934=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                  S29634=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                          thread47508(tdone,ends);
                          thread47509(tdone,ends);
                          int biggest47510 = 0;
                          if(ends[4]>=biggest47510){
                            biggest47510=ends[4];
                          }
                          if(ends[5]>=biggest47510){
                            biggest47510=ends[5];
                          }
                          if(biggest47510 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                        currsigs.addElement(vacOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 5 : 
                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                        S26227=6;
                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                          S26200=2;
                          S26939=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                            S26939=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S26934=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                              S26934=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                S29634=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                        thread47511(tdone,ends);
                        thread47512(tdone,ends);
                        int biggest47513 = 0;
                        if(ends[4]>=biggest47513){
                          biggest47513=ends[4];
                        }
                        if(ends[5]>=biggest47513){
                          biggest47513=ends[5];
                        }
                        if(biggest47513 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest47513 == 0){
                          S26227=6;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                            S26200=2;
                            S26939=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                              S26939=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S26934=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                S26934=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                  S29634=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                      }
                      break;
                    
                    case 6 : 
                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                        S26200=2;
                        S26939=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                          S26939=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S26934=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                            S26934=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 83, column: 5
                              S29634=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
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
                  switch(S26939){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                        S26939=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S26934){
                          case 0 : 
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                              S26934=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                S29634=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 83, column: 5
                              S29634=2;
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
                      S26939=1;
                      S26939=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                        S26939=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S26934=0;
                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                          S26934=1;
                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 83, column: 5
                            S29634=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
          
          case 2 : 
            S29634=2;
            S29634=0;
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 44, column: 20
              S29634=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 46, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S29634=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S26200=0;
                S26184=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 47, column: 5
                  start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                  S26184=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S26179=0;
                  if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                    start_in.setACK(true);//sysj\lidLoaderController.sysj line: 47, column: 5
                    S26179=1;
                    if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
                      start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 47, column: 5
                      w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj\lidLoaderController.sysj line: 48, column: 5
                      S26200=1;
                      if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 50, column: 8
                        S26227=0;
                        if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 14
                          System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 53, column: 7
                          if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 54, column: 23
                            S26227=1;
                            if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                              S26227=2;
                              if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                                S26227=3;
                                if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                  S26227=4;
                                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                    S26227=5;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                      S26227=6;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                        S26200=2;
                                        S26939=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                          S26939=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S26934=0;
                                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                            S26934=1;
                                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                              S29634=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      thread47514(tdone,ends);
                                      thread47515(tdone,ends);
                                      int biggest47516 = 0;
                                      if(ends[4]>=biggest47516){
                                        biggest47516=ends[4];
                                      }
                                      if(ends[5]>=biggest47516){
                                        biggest47516=ends[5];
                                      }
                                      if(biggest47516 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                              pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            refill.setPresent();//sysj\lidLoaderController.sysj line: 55, column: 8
                            currsigs.addElement(refill);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S26227=1;
                          if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                            S26227=2;
                            if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                              S26227=3;
                              if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                                S26227=4;
                                if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                  S26227=5;
                                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                                    S26227=6;
                                    if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                      w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                      S26200=2;
                                      S26939=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                        S26939=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S26934=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                          S26934=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                            S29634=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    thread47517(tdone,ends);
                                    thread47518(tdone,ends);
                                    int biggest47519 = 0;
                                    if(ends[4]>=biggest47519){
                                      biggest47519=ends[4];
                                    }
                                    if(ends[5]>=biggest47519){
                                      biggest47519=ends[5];
                                    }
                                    if(biggest47519 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                  currsigs.addElement(vacOn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                            pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                            currsigs.addElement(pusherExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S26200=2;
                        S26939=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                          S26939=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S26934=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                            S26934=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 83, column: 5
                              S29634=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
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

  public void thread47470(int [] tdone, int [] ends){
        switch(S26176){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 32, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 33, column: 8
            auto_1.setPresent();//sysj\lidLoaderController.sysj line: 33, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\lidLoaderController.sysj line: 34, column: 12
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

  public void thread47468(int [] tdone, int [] ends){
        S47456=1;
    S47102=0;
    if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 20
      S47102=1;
      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 92, column: 20
        S47102=2;
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
      else {
        if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 94, column: 14
          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 94, column: 30
          currsigs.addElement(pusherExtend);
          if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 14
            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
          if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 14
            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
            if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 96, column: 14
              armSource.setPresent();//sysj\lidLoaderController.sysj line: 96, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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
              if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj\lidLoaderController.sysj line: 97, column: 25
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

  public void thread47466(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47465(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47463(int [] tdone, int [] ends){
        S26294=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread47462(int [] tdone, int [] ends){
        S26289=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread47461(int [] tdone, int [] ends){
        S46926=1;
    w_thread_3 = null;//sysj\lidLoaderController.sysj line: 41, column: 3
    S29634=0;
    if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 44, column: 20
      S29634=1;
      if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 46, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S29634=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S26200=0;
        S26184=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 47, column: 5
          start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
          S26184=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S26179=0;
          if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
            start_in.setACK(true);//sysj\lidLoaderController.sysj line: 47, column: 5
            S26179=1;
            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 47, column: 5
              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 47, column: 5
              ends[3]=2;
              ;//sysj\lidLoaderController.sysj line: 47, column: 5
              w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj\lidLoaderController.sysj line: 48, column: 5
              S26200=1;
              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 50, column: 8
                S26227=0;
                if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 52, column: 14
                  System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 53, column: 7
                  if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 54, column: 23
                    S26227=1;
                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                      S26227=2;
                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                        S26227=3;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                          S26227=4;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                            S26227=5;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                              S26227=6;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                                S26200=2;
                                S26939=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                  S26939=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S26934=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                    S26934=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                      S29634=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              thread47462(tdone,ends);
                              thread47463(tdone,ends);
                              int biggest47464 = 0;
                              if(ends[4]>=biggest47464){
                                biggest47464=ends[4];
                              }
                              if(ends[5]>=biggest47464){
                                biggest47464=ends[5];
                              }
                              if(biggest47464 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                      currsigs.addElement(pusherExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    refill.setPresent();//sysj\lidLoaderController.sysj line: 55, column: 8
                    currsigs.addElement(refill);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  S26227=1;
                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 60, column: 22
                    S26227=2;
                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 22
                      S26227=3;
                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 66, column: 22
                        S26227=4;
                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                          S26227=5;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 74, column: 22
                            S26227=6;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 77, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 79, column: 6
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 80, column: 6
                              S26200=2;
                              S26939=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                S26939=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S26934=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                                  S26934=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 83, column: 5
                                    S29634=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            thread47465(tdone,ends);
                            thread47466(tdone,ends);
                            int biggest47467 = 0;
                            if(ends[4]>=biggest47467){
                              biggest47467=ends[4];
                            }
                            if(ends[5]>=biggest47467){
                              biggest47467=ends[5];
                            }
                            if(biggest47467 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 67, column: 7
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
                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 61, column: 7
                    currsigs.addElement(pusherExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                S26200=2;
                S26939=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 83, column: 5
                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                  S26939=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S26934=0;
                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 83, column: 5
                    S26934=1;
                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 83, column: 5
                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 83, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 83, column: 5
                      S29634=2;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
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
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread47460(int [] tdone, int [] ends){
        S26176=1;
    if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 32, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 33, column: 8
        auto_1.setPresent();//sysj\lidLoaderController.sysj line: 33, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\lidLoaderController.sysj line: 34, column: 12
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
      switch(S47458){
        case 0 : 
          S47458=0;
          break RUN;
        
        case 1 : 
          S47458=2;
          S47458=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 28, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 28, column: 2
          thread47460(tdone,ends);
          thread47461(tdone,ends);
          thread47468(tdone,ends);
          int biggest47469 = 0;
          if(ends[2]>=biggest47469){
            biggest47469=ends[2];
          }
          if(ends[3]>=biggest47469){
            biggest47469=ends[3];
          }
          if(ends[6]>=biggest47469){
            biggest47469=ends[6];
          }
          if(biggest47469 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 28, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 28, column: 2
          thread47470(tdone,ends);
          thread47471(tdone,ends);
          thread47520(tdone,ends);
          int biggest47521 = 0;
          if(ends[2]>=biggest47521){
            biggest47521=ends[2];
          }
          if(ends[3]>=biggest47521){
            biggest47521=ends[3];
          }
          if(ends[6]>=biggest47521){
            biggest47521=ends[6];
          }
          if(biggest47521 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest47521 == 0){
            S47458=0;
            active[1]=0;
            ends[1]=0;
            S47458=0;
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
