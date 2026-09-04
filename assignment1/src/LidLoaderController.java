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
  private Workpiece w_thread_3;//sysj/lidLoaderController.sysj line: 41, column: 3
  private int S39294 = 1;
  private int S18012 = 1;
  private int S38762 = 1;
  private int S21470 = 1;
  private int S18036 = 1;
  private int S18020 = 1;
  private int S18015 = 1;
  private int S18063 = 1;
  private int S18125 = 1;
  private int S18130 = 1;
  private int S18775 = 1;
  private int S18770 = 1;
  private int S39292 = 1;
  private int S38938 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread39356(int [] tdone, int [] ends){
        switch(S39292){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S38938){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 91, column: 20
              S38938=1;
              if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 92, column: 20
                S38938=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 94, column: 14
                  pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 94, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 14
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                  if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 14
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 92, column: 20
              S38938=2;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 94, column: 14
                pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 94, column: 30
                currsigs.addElement(pusherExtend);
                if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 14
                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                  if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 14
                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                  if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
            S38938=2;
            S38938=0;
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 91, column: 20
              S38938=1;
              if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 92, column: 20
                S38938=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 94, column: 14
                  pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 94, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 14
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                  if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 14
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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

  public void thread39354(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39353(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39351(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39350(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39348(int [] tdone, int [] ends){
        switch(S18130){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
        currsigs.addElement(vacOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread39347(int [] tdone, int [] ends){
        switch(S18125){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
        currsigs.addElement(armDest);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread39345(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39344(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39342(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39341(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39339(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39338(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39336(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39335(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39333(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39332(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39330(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39329(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39327(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39326(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39324(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39323(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39321(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39320(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39318(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39317(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39315(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39314(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39312(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39311(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39309(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39308(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39307(int [] tdone, int [] ends){
        switch(S38762){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S21470){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 44, column: 20
              S21470=1;
              if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 46, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S21470=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S18036=0;
                S18020=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 47, column: 5
                  start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                  S18020=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S18015=0;
                  if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                    start_in.setACK(true);//sysj/lidLoaderController.sysj line: 47, column: 5
                    S18015=1;
                    if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                      start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                      ends[3]=2;
                      ;//sysj/lidLoaderController.sysj line: 47, column: 5
                      w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/lidLoaderController.sysj line: 48, column: 5
                      S18036=1;
                      if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 50, column: 8
                        S18063=0;
                        if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 52, column: 14
                          System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 53, column: 7
                          if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 54, column: 23
                            S18063=1;
                            if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                              S18063=2;
                              if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                                S18063=3;
                                if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                  S18063=4;
                                  if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                    S18063=5;
                                    if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                      S18063=6;
                                      if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                        w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                        S18036=2;
                                        S18775=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                          S18775=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S18770=0;
                                          if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                            done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                            S18770=1;
                                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                              ends[3]=2;
                                              ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                              S21470=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      thread39308(tdone,ends);
                                      thread39309(tdone,ends);
                                      int biggest39310 = 0;
                                      if(ends[4]>=biggest39310){
                                        biggest39310=ends[4];
                                      }
                                      if(ends[5]>=biggest39310){
                                        biggest39310=ends[5];
                                      }
                                      if(biggest39310 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                              pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            refill.setPresent();//sysj/lidLoaderController.sysj line: 55, column: 8
                            currsigs.addElement(refill);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S18063=1;
                          if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                            S18063=2;
                            if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                              S18063=3;
                              if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                S18063=4;
                                if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                  S18063=5;
                                  if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                    S18063=6;
                                    if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                      w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                      S18036=2;
                                      S18775=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                        S18775=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S18770=0;
                                        if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                          done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                          S18770=1;
                                          if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                            ends[3]=2;
                                            ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                            S21470=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    thread39311(tdone,ends);
                                    thread39312(tdone,ends);
                                    int biggest39313 = 0;
                                    if(ends[4]>=biggest39313){
                                      biggest39313=ends[4];
                                    }
                                    if(ends[5]>=biggest39313){
                                      biggest39313=ends[5];
                                    }
                                    if(biggest39313 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                  currsigs.addElement(vacOn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                            pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                            currsigs.addElement(pusherExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S18036=2;
                        S18775=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                          S18775=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S18770=0;
                          if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                            done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                            S18770=1;
                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 83, column: 5
                              S21470=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
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
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 46, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S21470=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S18036){
                case 0 : 
                  switch(S18020){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 47, column: 5
                        start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                        S18020=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S18015){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                              start_in.setACK(true);//sysj/lidLoaderController.sysj line: 47, column: 5
                              S18015=1;
                              if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                                start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 47, column: 5
                                w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/lidLoaderController.sysj line: 48, column: 5
                                S18036=1;
                                if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 50, column: 8
                                  S18063=0;
                                  if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 52, column: 14
                                    System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 53, column: 7
                                    if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 54, column: 23
                                      S18063=1;
                                      if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                                        S18063=2;
                                        if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                                          S18063=3;
                                          if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                            S18063=4;
                                            if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                              S18063=5;
                                              if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                                S18063=6;
                                                if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                                  w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                                  S18036=2;
                                                  S18775=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    S18775=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S18770=0;
                                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                      S18770=1;
                                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                        ends[3]=2;
                                                        ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                                        S21470=2;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
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
                                                thread39314(tdone,ends);
                                                thread39315(tdone,ends);
                                                int biggest39316 = 0;
                                                if(ends[4]>=biggest39316){
                                                  biggest39316=ends[4];
                                                }
                                                if(ends[5]>=biggest39316){
                                                  biggest39316=ends[5];
                                                }
                                                if(biggest39316 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                              currsigs.addElement(vacOn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                                        pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                                        currsigs.addElement(pusherExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      refill.setPresent();//sysj/lidLoaderController.sysj line: 55, column: 8
                                      currsigs.addElement(refill);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S18063=1;
                                    if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                                      S18063=2;
                                      if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                                        S18063=3;
                                        if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                          S18063=4;
                                          if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                            S18063=5;
                                            if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                              S18063=6;
                                              if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                                w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                                S18036=2;
                                                S18775=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  S18775=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S18770=0;
                                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    S18770=1;
                                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                      ends[3]=2;
                                                      ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                                      S21470=2;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                              thread39317(tdone,ends);
                                              thread39318(tdone,ends);
                                              int biggest39319 = 0;
                                              if(ends[4]>=biggest39319){
                                                biggest39319=ends[4];
                                              }
                                              if(ends[5]>=biggest39319){
                                                biggest39319=ends[5];
                                              }
                                              if(biggest39319 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                                      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  S18036=2;
                                  S18775=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                    S18775=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S18770=0;
                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                      S18770=1;
                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                        ends[3]=2;
                                        ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                        S21470=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                            if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                              start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 47, column: 5
                              w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/lidLoaderController.sysj line: 48, column: 5
                              S18036=1;
                              if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 50, column: 8
                                S18063=0;
                                if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 52, column: 14
                                  System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 53, column: 7
                                  if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 54, column: 23
                                    S18063=1;
                                    if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                                      S18063=2;
                                      if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                                        S18063=3;
                                        if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                          S18063=4;
                                          if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                            S18063=5;
                                            if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                              S18063=6;
                                              if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                                w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                                S18036=2;
                                                S18775=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  S18775=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S18770=0;
                                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    S18770=1;
                                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                      ends[3]=2;
                                                      ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                                      S21470=2;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
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
                                              thread39320(tdone,ends);
                                              thread39321(tdone,ends);
                                              int biggest39322 = 0;
                                              if(ends[4]>=biggest39322){
                                                biggest39322=ends[4];
                                              }
                                              if(ends[5]>=biggest39322){
                                                biggest39322=ends[5];
                                              }
                                              if(biggest39322 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                                      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    refill.setPresent();//sysj/lidLoaderController.sysj line: 55, column: 8
                                    currsigs.addElement(refill);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S18063=1;
                                  if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                                    S18063=2;
                                    if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                                      S18063=3;
                                      if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                        S18063=4;
                                        if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                          S18063=5;
                                          if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                            S18063=6;
                                            if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                              w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                              S18036=2;
                                              S18775=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                S18775=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S18770=0;
                                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  S18770=1;
                                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    ends[3]=2;
                                                    ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    S21470=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
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
                                            thread39323(tdone,ends);
                                            thread39324(tdone,ends);
                                            int biggest39325 = 0;
                                            if(ends[4]>=biggest39325){
                                              biggest39325=ends[4];
                                            }
                                            if(ends[5]>=biggest39325){
                                              biggest39325=ends[5];
                                            }
                                            if(biggest39325 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                          currsigs.addElement(vacOn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                                    pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S18036=2;
                                S18775=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                  S18775=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S18770=0;
                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                    S18770=1;
                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                      S21470=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                      S18020=1;
                      S18020=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 47, column: 5
                        start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                        S18020=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S18015=0;
                        if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                          start_in.setACK(true);//sysj/lidLoaderController.sysj line: 47, column: 5
                          S18015=1;
                          if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                            start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                            ends[3]=2;
                            ;//sysj/lidLoaderController.sysj line: 47, column: 5
                            w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/lidLoaderController.sysj line: 48, column: 5
                            S18036=1;
                            if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 50, column: 8
                              S18063=0;
                              if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 52, column: 14
                                System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 53, column: 7
                                if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 54, column: 23
                                  S18063=1;
                                  if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                                    S18063=2;
                                    if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                                      S18063=3;
                                      if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                        S18063=4;
                                        if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                          S18063=5;
                                          if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                            S18063=6;
                                            if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                              w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                              S18036=2;
                                              S18775=0;
                                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                S18775=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S18770=0;
                                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  S18770=1;
                                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    ends[3]=2;
                                                    ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                                    S21470=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
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
                                            thread39326(tdone,ends);
                                            thread39327(tdone,ends);
                                            int biggest39328 = 0;
                                            if(ends[4]>=biggest39328){
                                              biggest39328=ends[4];
                                            }
                                            if(ends[5]>=biggest39328){
                                              biggest39328=ends[5];
                                            }
                                            if(biggest39328 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                          currsigs.addElement(vacOn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                                    pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  refill.setPresent();//sysj/lidLoaderController.sysj line: 55, column: 8
                                  currsigs.addElement(refill);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S18063=1;
                                if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                                  S18063=2;
                                  if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                                    S18063=3;
                                    if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                      S18063=4;
                                      if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                        S18063=5;
                                        if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                          S18063=6;
                                          if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                            w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                            S18036=2;
                                            S18775=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                              S18775=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S18770=0;
                                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                S18770=1;
                                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                                  S21470=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
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
                                          thread39329(tdone,ends);
                                          thread39330(tdone,ends);
                                          int biggest39331 = 0;
                                          if(ends[4]>=biggest39331){
                                            biggest39331=ends[4];
                                          }
                                          if(ends[5]>=biggest39331){
                                            biggest39331=ends[5];
                                          }
                                          if(biggest39331 == 1){
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                      }
                                      else {
                                        vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                        currsigs.addElement(vacOn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                                  pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                                  currsigs.addElement(pusherExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              S18036=2;
                              S18775=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                S18775=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S18770=0;
                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                  S18770=1;
                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                    S21470=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                  switch(S18063){
                    case 0 : 
                      if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 54, column: 23
                        S18063=1;
                        if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                          S18063=2;
                          if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                            S18063=3;
                            if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                              S18063=4;
                              if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                S18063=5;
                                if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                  S18063=6;
                                  if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                    w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                    S18036=2;
                                    S18775=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                      S18775=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S18770=0;
                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                        S18770=1;
                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                          S21470=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                                  thread39332(tdone,ends);
                                  thread39333(tdone,ends);
                                  int biggest39334 = 0;
                                  if(ends[4]>=biggest39334){
                                    biggest39334=ends[4];
                                  }
                                  if(ends[5]>=biggest39334){
                                    biggest39334=ends[5];
                                  }
                                  if(biggest39334 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                          pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        refill.setPresent();//sysj/lidLoaderController.sysj line: 55, column: 8
                        currsigs.addElement(refill);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                        S18063=2;
                        if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                          S18063=3;
                          if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                            S18063=4;
                            if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                              S18063=5;
                              if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                S18063=6;
                                if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                  w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                  S18036=2;
                                  S18775=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                    S18775=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S18770=0;
                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                      S18770=1;
                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                        ends[3]=2;
                                        ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                        S21470=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                                thread39335(tdone,ends);
                                thread39336(tdone,ends);
                                int biggest39337 = 0;
                                if(ends[4]>=biggest39337){
                                  biggest39337=ends[4];
                                }
                                if(ends[5]>=biggest39337){
                                  biggest39337=ends[5];
                                }
                                if(biggest39337 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                        pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                        S18063=3;
                        if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                          S18063=4;
                          if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                            S18063=5;
                            if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                              S18063=6;
                              if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                S18036=2;
                                S18775=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                  S18775=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S18770=0;
                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                    S18770=1;
                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                      S21470=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              thread39338(tdone,ends);
                              thread39339(tdone,ends);
                              int biggest39340 = 0;
                              if(ends[4]>=biggest39340){
                                biggest39340=ends[4];
                              }
                              if(ends[5]>=biggest39340){
                                biggest39340=ends[5];
                              }
                              if(biggest39340 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                      if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                        S18063=4;
                        if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                          S18063=5;
                          if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                            S18063=6;
                            if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                              w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                              S18036=2;
                              S18775=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                S18775=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S18770=0;
                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                  S18770=1;
                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                    S21470=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            thread39341(tdone,ends);
                            thread39342(tdone,ends);
                            int biggest39343 = 0;
                            if(ends[4]>=biggest39343){
                              biggest39343=ends[4];
                            }
                            if(ends[5]>=biggest39343){
                              biggest39343=ends[5];
                            }
                            if(biggest39343 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                        S18063=5;
                        if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                          S18063=6;
                          if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                            w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                            S18036=2;
                            S18775=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                              S18775=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S18770=0;
                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                S18770=1;
                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                  ends[3]=2;
                                  ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                  S21470=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                          thread39344(tdone,ends);
                          thread39345(tdone,ends);
                          int biggest39346 = 0;
                          if(ends[4]>=biggest39346){
                            biggest39346=ends[4];
                          }
                          if(ends[5]>=biggest39346){
                            biggest39346=ends[5];
                          }
                          if(biggest39346 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                        currsigs.addElement(vacOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 5 : 
                      if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                        S18063=6;
                        if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                          w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                          S18036=2;
                          S18775=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                            S18775=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S18770=0;
                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                              S18770=1;
                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                S21470=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
                        thread39347(tdone,ends);
                        thread39348(tdone,ends);
                        int biggest39349 = 0;
                        if(ends[4]>=biggest39349){
                          biggest39349=ends[4];
                        }
                        if(ends[5]>=biggest39349){
                          biggest39349=ends[5];
                        }
                        if(biggest39349 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest39349 == 0){
                          S18063=6;
                          if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                            w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                            S18036=2;
                            S18775=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                              S18775=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S18770=0;
                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                S18770=1;
                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                  ends[3]=2;
                                  ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                  S21470=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
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
                      if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                        w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                        S18036=2;
                        S18775=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                          S18775=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S18770=0;
                          if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                            done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                            S18770=1;
                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 83, column: 5
                              S21470=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
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
                  switch(S18775){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                        S18775=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S18770){
                          case 0 : 
                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                              S18770=1;
                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                S21470=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 83, column: 5
                              S21470=2;
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
                      S18775=1;
                      S18775=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                        S18775=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S18770=0;
                        if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                          done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                          S18770=1;
                          if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                            ends[3]=2;
                            ;//sysj/lidLoaderController.sysj line: 83, column: 5
                            S21470=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            S21470=2;
            S21470=0;
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 44, column: 20
              S21470=1;
              if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 46, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S21470=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S18036=0;
                S18020=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 47, column: 5
                  start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                  S18020=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S18015=0;
                  if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                    start_in.setACK(true);//sysj/lidLoaderController.sysj line: 47, column: 5
                    S18015=1;
                    if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
                      start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
                      ends[3]=2;
                      ;//sysj/lidLoaderController.sysj line: 47, column: 5
                      w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/lidLoaderController.sysj line: 48, column: 5
                      S18036=1;
                      if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 50, column: 8
                        S18063=0;
                        if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 52, column: 14
                          System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 53, column: 7
                          if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 54, column: 23
                            S18063=1;
                            if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                              S18063=2;
                              if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                                S18063=3;
                                if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                  S18063=4;
                                  if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                    S18063=5;
                                    if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                      S18063=6;
                                      if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                        w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                        System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                        S18036=2;
                                        S18775=0;
                                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                          S18775=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S18770=0;
                                          if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                            done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                            S18770=1;
                                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                              ends[3]=2;
                                              ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                              S21470=2;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
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
                                      thread39350(tdone,ends);
                                      thread39351(tdone,ends);
                                      int biggest39352 = 0;
                                      if(ends[4]>=biggest39352){
                                        biggest39352=ends[4];
                                      }
                                      if(ends[5]>=biggest39352){
                                        biggest39352=ends[5];
                                      }
                                      if(biggest39352 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                              pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            refill.setPresent();//sysj/lidLoaderController.sysj line: 55, column: 8
                            currsigs.addElement(refill);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S18063=1;
                          if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                            S18063=2;
                            if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                              S18063=3;
                              if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                                S18063=4;
                                if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                  S18063=5;
                                  if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                                    S18063=6;
                                    if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                      w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                      S18036=2;
                                      S18775=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                        S18775=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S18770=0;
                                        if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                          done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                          S18770=1;
                                          if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                            ends[3]=2;
                                            ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                            S21470=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
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
                                    thread39353(tdone,ends);
                                    thread39354(tdone,ends);
                                    int biggest39355 = 0;
                                    if(ends[4]>=biggest39355){
                                      biggest39355=ends[4];
                                    }
                                    if(ends[5]>=biggest39355){
                                      biggest39355=ends[5];
                                    }
                                    if(biggest39355 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                  currsigs.addElement(vacOn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                            pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                            currsigs.addElement(pusherExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S18036=2;
                        S18775=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                          S18775=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S18770=0;
                          if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                            done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                            S18770=1;
                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 83, column: 5
                              S21470=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
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

  public void thread39306(int [] tdone, int [] ends){
        switch(S18012){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj/lidLoaderController.sysj line: 32, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/lidLoaderController.sysj line: 33, column: 8
            auto_1.setPresent();//sysj/lidLoaderController.sysj line: 33, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj/lidLoaderController.sysj line: 34, column: 12
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

  public void thread39304(int [] tdone, int [] ends){
        S39292=1;
    S38938=0;
    if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 91, column: 20
      S38938=1;
      if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 92, column: 20
        S38938=2;
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
      else {
        if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 94, column: 14
          pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 94, column: 30
          currsigs.addElement(pusherExtend);
          if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 14
            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
              armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
            if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
              armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
          if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 14
            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
              armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
            if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 96, column: 14
              armSource.setPresent();//sysj/lidLoaderController.sysj line: 96, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 97, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 97, column: 25
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

  public void thread39302(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39301(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39299(int [] tdone, int [] ends){
        S18130=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread39298(int [] tdone, int [] ends){
        S18125=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 75, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread39297(int [] tdone, int [] ends){
        S38762=1;
    w_thread_3 = null;//sysj/lidLoaderController.sysj line: 41, column: 3
    S21470=0;
    if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 44, column: 20
      S21470=1;
      if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 46, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S21470=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S18036=0;
        S18020=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 47, column: 5
          start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
          S18020=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S18015=0;
          if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
            start_in.setACK(true);//sysj/lidLoaderController.sysj line: 47, column: 5
            S18015=1;
            if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 47, column: 5
              start_in.setACK(false);//sysj/lidLoaderController.sysj line: 47, column: 5
              ends[3]=2;
              ;//sysj/lidLoaderController.sysj line: 47, column: 5
              w_thread_3 = (Workpiece)(start_in.getVal() == null ? null : ((Workpiece)start_in.getVal()));//sysj/lidLoaderController.sysj line: 48, column: 5
              S18036=1;
              if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 50, column: 8
                S18063=0;
                if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 52, column: 14
                  System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 53, column: 7
                  if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 54, column: 23
                    S18063=1;
                    if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                      S18063=2;
                      if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                        S18063=3;
                        if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                          S18063=4;
                          if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                            S18063=5;
                            if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                              S18063=6;
                              if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                                w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                                S18036=2;
                                S18775=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                  S18775=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S18770=0;
                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                    S18770=1;
                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                      S21470=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                              thread39298(tdone,ends);
                              thread39299(tdone,ends);
                              int biggest39300 = 0;
                              if(ends[4]>=biggest39300){
                                biggest39300=ends[4];
                              }
                              if(ends[5]>=biggest39300){
                                biggest39300=ends[5];
                              }
                              if(biggest39300 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                      currsigs.addElement(pusherExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    refill.setPresent();//sysj/lidLoaderController.sysj line: 55, column: 8
                    currsigs.addElement(refill);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  S18063=1;
                  if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 60, column: 22
                    S18063=2;
                    if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 22
                      S18063=3;
                      if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 66, column: 22
                        S18063=4;
                        if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                          S18063=5;
                          if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 74, column: 22
                            S18063=6;
                            if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 77, column: 22
                              w_thread_3.lid();//sysj/lidLoaderController.sysj line: 79, column: 6
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 80, column: 6
                              S18036=2;
                              S18775=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                S18775=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S18770=0;
                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                                  S18770=1;
                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidLoaderController.sysj line: 83, column: 5
                                    S21470=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
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
                            thread39301(tdone,ends);
                            thread39302(tdone,ends);
                            int biggest39303 = 0;
                            if(ends[4]>=biggest39303){
                              biggest39303=ends[4];
                            }
                            if(ends[5]>=biggest39303){
                              biggest39303=ends[5];
                            }
                            if(biggest39303 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          vacOn.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        armSource.setPresent();//sysj/lidLoaderController.sysj line: 67, column: 7
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
                    pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 61, column: 7
                    currsigs.addElement(pusherExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                S18036=2;
                S18775=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 83, column: 5
                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                  S18775=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S18770=0;
                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 83, column: 5
                    S18770=1;
                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 83, column: 5
                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 83, column: 5
                      ends[3]=2;
                      ;//sysj/lidLoaderController.sysj line: 83, column: 5
                      S21470=2;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
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

  public void thread39296(int [] tdone, int [] ends){
        S18012=1;
    if(mode.getprestatus()){//sysj/lidLoaderController.sysj line: 32, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/lidLoaderController.sysj line: 33, column: 8
        auto_1.setPresent();//sysj/lidLoaderController.sysj line: 33, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj/lidLoaderController.sysj line: 34, column: 12
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
      switch(S39294){
        case 0 : 
          S39294=0;
          break RUN;
        
        case 1 : 
          S39294=2;
          S39294=2;
          auto_1.setClear();//sysj/lidLoaderController.sysj line: 28, column: 2
          manual_1.setClear();//sysj/lidLoaderController.sysj line: 28, column: 2
          thread39296(tdone,ends);
          thread39297(tdone,ends);
          thread39304(tdone,ends);
          int biggest39305 = 0;
          if(ends[2]>=biggest39305){
            biggest39305=ends[2];
          }
          if(ends[3]>=biggest39305){
            biggest39305=ends[3];
          }
          if(ends[6]>=biggest39305){
            biggest39305=ends[6];
          }
          if(biggest39305 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/lidLoaderController.sysj line: 28, column: 2
          manual_1.setClear();//sysj/lidLoaderController.sysj line: 28, column: 2
          thread39306(tdone,ends);
          thread39307(tdone,ends);
          thread39356(tdone,ends);
          int biggest39357 = 0;
          if(ends[2]>=biggest39357){
            biggest39357=ends[2];
          }
          if(ends[3]>=biggest39357){
            biggest39357=ends[3];
          }
          if(ends[6]>=biggest39357){
            biggest39357=ends[6];
          }
          if(biggest39357 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest39357 == 0){
            S39294=0;
            active[1]=0;
            ends[1]=0;
            S39294=0;
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
