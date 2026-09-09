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
  private LidLoaderTwin t_thread_3;//sysj/lidLoaderController.sysj line: 44, column: 3
  private int lids_thread_3;//sysj/lidLoaderController.sysj line: 45, column: 3
  private WorkpieceTwin w_thread_3;//sysj/lidLoaderController.sysj line: 46, column: 3
  private int S85301 = 1;
  private int S56351 = 1;
  private int S84769 = 1;
  private int S61088 = 1;
  private int S56376 = 1;
  private int S56360 = 1;
  private int S56355 = 1;
  private int S56404 = 1;
  private int S56466 = 1;
  private int S56471 = 1;
  private int S57167 = 1;
  private int S57162 = 1;
  private int S85299 = 1;
  private int S84945 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread85363(int [] tdone, int [] ends){
        switch(S85299){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S84945){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 106, column: 20
              S84945=1;
              if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 107, column: 20
                S84945=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 109, column: 14
                  pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 109, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 110, column: 14
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 110, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                  if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 110, column: 14
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 110, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 107, column: 20
              S84945=2;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 109, column: 14
                pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 109, column: 30
                currsigs.addElement(pusherExtend);
                if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 110, column: 14
                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 110, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                  if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 110, column: 14
                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 110, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                  if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
            S84945=2;
            S84945=0;
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 106, column: 20
              S84945=1;
              if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 107, column: 20
                S84945=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 109, column: 14
                  pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 109, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 110, column: 14
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 110, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                  if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 110, column: 14
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 110, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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

  public void thread85361(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85360(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85358(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85357(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85355(int [] tdone, int [] ends){
        switch(S56471){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
        currsigs.addElement(vacOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread85354(int [] tdone, int [] ends){
        switch(S56466){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
        currsigs.addElement(armDest);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread85352(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85351(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85349(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85348(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85346(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85345(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85343(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85342(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85340(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85339(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85337(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85336(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85334(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85333(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85331(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85330(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85328(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85327(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85325(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85324(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85322(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85321(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85319(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85318(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85316(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85315(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85314(int [] tdone, int [] ends){
        switch(S84769){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S61088){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 49, column: 20
              S61088=1;
              if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 51, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S61088=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S56376=0;
                S56360=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 52, column: 5
                  start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                  S56360=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S56355=0;
                  if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                    start_in.setACK(true);//sysj/lidLoaderController.sysj line: 52, column: 5
                    S56355=1;
                    if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                      start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                      ends[3]=2;
                      ;//sysj/lidLoaderController.sysj line: 52, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj/lidLoaderController.sysj line: 53, column: 5
                      S56376=1;
                      if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj/lidLoaderController.sysj line: 55, column: 8
                        System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj/lidLoaderController.sysj line: 56, column: 6
                        w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj/lidLoaderController.sysj line: 57, column: 6
                        S56376=2;
                        S57167=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                          S57167=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S57162=0;
                          if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                            done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                            S57162=1;
                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 98, column: 5
                              S61088=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 59, column: 13
                          S56404=0;
                          if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 61, column: 14
                            System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 62, column: 7
                            if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 23
                              S56404=1;
                              if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                S56404=2;
                                if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                  S56404=3;
                                  if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                    S56404=4;
                                    if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                      S56404=5;
                                      if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                        S56404=6;
                                        if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                          w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                          if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                            lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                          }
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                            twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                            S56376=2;
                                            S57167=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                              S57167=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S57162=0;
                                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                S57162=1;
                                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  S61088=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                            S56376=2;
                                            S57167=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                              S57167=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S57162=0;
                                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                S57162=1;
                                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  S61088=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
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
                                        thread85315(tdone,ends);
                                        thread85316(tdone,ends);
                                        int biggest85317 = 0;
                                        if(ends[4]>=biggest85317){
                                          biggest85317=ends[4];
                                        }
                                        if(ends[5]>=biggest85317){
                                          biggest85317=ends[5];
                                        }
                                        if(biggest85317 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                      currsigs.addElement(vacOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                                pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              refill.setPresent();//sysj/lidLoaderController.sysj line: 64, column: 8
                              currsigs.addElement(refill);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S56404=1;
                            if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                              S56404=2;
                              if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                S56404=3;
                                if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                  S56404=4;
                                  if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                    S56404=5;
                                    if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                      S56404=6;
                                      if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                        w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                        if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                          lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                        }
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                          twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                          S56376=2;
                                          S57167=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                            S57167=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S57162=0;
                                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                              S57162=1;
                                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                ends[3]=2;
                                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                S61088=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                          S56376=2;
                                          S57167=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                            S57167=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S57162=0;
                                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                              S57162=1;
                                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                ends[3]=2;
                                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                S61088=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread85318(tdone,ends);
                                      thread85319(tdone,ends);
                                      int biggest85320 = 0;
                                      if(ends[4]>=biggest85320){
                                        biggest85320=ends[4];
                                      }
                                      if(ends[5]>=biggest85320){
                                        biggest85320=ends[5];
                                      }
                                      if(biggest85320 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                              pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          S56376=2;
                          S57167=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                            S57167=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S57162=0;
                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                              S57162=1;
                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                S61088=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 51, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S61088=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S56376){
                case 0 : 
                  switch(S56360){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 52, column: 5
                        start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                        S56360=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S56355){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                              start_in.setACK(true);//sysj/lidLoaderController.sysj line: 52, column: 5
                              S56355=1;
                              if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                                start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 52, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj/lidLoaderController.sysj line: 53, column: 5
                                S56376=1;
                                if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj/lidLoaderController.sysj line: 55, column: 8
                                  System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj/lidLoaderController.sysj line: 56, column: 6
                                  w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj/lidLoaderController.sysj line: 57, column: 6
                                  S56376=2;
                                  S57167=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57167=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57162=0;
                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57162=1;
                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S61088=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 59, column: 13
                                    S56404=0;
                                    if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 61, column: 14
                                      System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 62, column: 7
                                      if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 23
                                        S56404=1;
                                        if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                          S56404=2;
                                          if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                            S56404=3;
                                            if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                              S56404=4;
                                              if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                                S56404=5;
                                                if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                                  S56404=6;
                                                  if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                                    w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                                    lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                                    if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                                      lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                                    }
                                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                                      twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                                      currsigs.addElement(twin);
                                                      twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                      S56376=2;
                                                      S57167=0;
                                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S57167=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S57162=0;
                                                        if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          S57162=1;
                                                          if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                            ends[3]=2;
                                                            ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                            S61088=2;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                      S56376=2;
                                                      S57167=0;
                                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S57167=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S57162=0;
                                                        if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          S57162=1;
                                                          if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                            ends[3]=2;
                                                            ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                            S61088=2;
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                          else {
                                                            active[3]=1;
                                                            ends[3]=1;
                                                            tdone[3]=1;
                                                          }
                                                        }
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
                                                  thread85321(tdone,ends);
                                                  thread85322(tdone,ends);
                                                  int biggest85323 = 0;
                                                  if(ends[4]>=biggest85323){
                                                    biggest85323=ends[4];
                                                  }
                                                  if(ends[5]>=biggest85323){
                                                    biggest85323=ends[5];
                                                  }
                                                  if(biggest85323 == 1){
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                                currsigs.addElement(vacOn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                                          pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                          currsigs.addElement(pusherExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        refill.setPresent();//sysj/lidLoaderController.sysj line: 64, column: 8
                                        currsigs.addElement(refill);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S56404=1;
                                      if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                        S56404=2;
                                        if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                          S56404=3;
                                          if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                            S56404=4;
                                            if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                              S56404=5;
                                              if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                                S56404=6;
                                                if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                                  w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                                  lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                                  if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                                    lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                                  }
                                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                                    twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                                    currsigs.addElement(twin);
                                                    twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                    S56376=2;
                                                    S57167=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S57167=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S57162=0;
                                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S57162=1;
                                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          ends[3]=2;
                                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          S61088=2;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                    S56376=2;
                                                    S57167=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S57167=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S57162=0;
                                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S57162=1;
                                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          ends[3]=2;
                                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          S61088=2;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
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
                                                thread85324(tdone,ends);
                                                thread85325(tdone,ends);
                                                int biggest85326 = 0;
                                                if(ends[4]>=biggest85326){
                                                  biggest85326=ends[4];
                                                }
                                                if(ends[5]>=biggest85326){
                                                  biggest85326=ends[5];
                                                }
                                                if(biggest85326 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                              currsigs.addElement(vacOn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                                        pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                        currsigs.addElement(pusherExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S56376=2;
                                    S57167=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57167=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57162=0;
                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S57162=1;
                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                          S61088=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
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
                            if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                              start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 52, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj/lidLoaderController.sysj line: 53, column: 5
                              S56376=1;
                              if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj/lidLoaderController.sysj line: 55, column: 8
                                System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj/lidLoaderController.sysj line: 56, column: 6
                                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj/lidLoaderController.sysj line: 57, column: 6
                                S56376=2;
                                S57167=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57167=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S57162=0;
                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57162=1;
                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S61088=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 59, column: 13
                                  S56404=0;
                                  if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 61, column: 14
                                    System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 62, column: 7
                                    if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 23
                                      S56404=1;
                                      if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                        S56404=2;
                                        if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                          S56404=3;
                                          if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                            S56404=4;
                                            if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                              S56404=5;
                                              if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                                S56404=6;
                                                if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                                  w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                                  lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                                  if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                                    lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                                  }
                                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                                    twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                                    currsigs.addElement(twin);
                                                    twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                    S56376=2;
                                                    S57167=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S57167=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S57162=0;
                                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S57162=1;
                                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          ends[3]=2;
                                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          S61088=2;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                    S56376=2;
                                                    S57167=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S57167=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S57162=0;
                                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S57162=1;
                                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          ends[3]=2;
                                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                          S61088=2;
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                        else {
                                                          active[3]=1;
                                                          ends[3]=1;
                                                          tdone[3]=1;
                                                        }
                                                      }
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
                                                thread85327(tdone,ends);
                                                thread85328(tdone,ends);
                                                int biggest85329 = 0;
                                                if(ends[4]>=biggest85329){
                                                  biggest85329=ends[4];
                                                }
                                                if(ends[5]>=biggest85329){
                                                  biggest85329=ends[5];
                                                }
                                                if(biggest85329 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                              currsigs.addElement(vacOn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                                        pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                        currsigs.addElement(pusherExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      refill.setPresent();//sysj/lidLoaderController.sysj line: 64, column: 8
                                      currsigs.addElement(refill);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S56404=1;
                                    if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                      S56404=2;
                                      if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                        S56404=3;
                                        if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                          S56404=4;
                                          if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                            S56404=5;
                                            if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                              S56404=6;
                                              if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                                w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                                lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                                if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                                  lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                                }
                                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                                  twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                                  currsigs.addElement(twin);
                                                  twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                  S56376=2;
                                                  S57167=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    S57167=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S57162=0;
                                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S57162=1;
                                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        ends[3]=2;
                                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S61088=2;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                  S56376=2;
                                                  S57167=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    S57167=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S57162=0;
                                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S57162=1;
                                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        ends[3]=2;
                                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S61088=2;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
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
                                              thread85330(tdone,ends);
                                              thread85331(tdone,ends);
                                              int biggest85332 = 0;
                                              if(ends[4]>=biggest85332){
                                                biggest85332=ends[4];
                                              }
                                              if(ends[5]>=biggest85332){
                                                biggest85332=ends[5];
                                              }
                                              if(biggest85332 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                                      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  S56376=2;
                                  S57167=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57167=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57162=0;
                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57162=1;
                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S61088=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
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
                      S56360=1;
                      S56360=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 52, column: 5
                        start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                        S56360=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S56355=0;
                        if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                          start_in.setACK(true);//sysj/lidLoaderController.sysj line: 52, column: 5
                          S56355=1;
                          if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                            start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                            ends[3]=2;
                            ;//sysj/lidLoaderController.sysj line: 52, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj/lidLoaderController.sysj line: 53, column: 5
                            S56376=1;
                            if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj/lidLoaderController.sysj line: 55, column: 8
                              System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj/lidLoaderController.sysj line: 56, column: 6
                              w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj/lidLoaderController.sysj line: 57, column: 6
                              S56376=2;
                              S57167=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                S57167=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57162=0;
                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57162=1;
                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S61088=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 59, column: 13
                                S56404=0;
                                if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 61, column: 14
                                  System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 62, column: 7
                                  if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 23
                                    S56404=1;
                                    if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                      S56404=2;
                                      if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                        S56404=3;
                                        if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                          S56404=4;
                                          if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                            S56404=5;
                                            if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                              S56404=6;
                                              if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                                w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                                lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                                if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                                  lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                                }
                                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                                  twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                                  currsigs.addElement(twin);
                                                  twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                  S56376=2;
                                                  S57167=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    S57167=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S57162=0;
                                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S57162=1;
                                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        ends[3]=2;
                                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S61088=2;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                  S56376=2;
                                                  S57167=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    S57167=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S57162=0;
                                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S57162=1;
                                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        ends[3]=2;
                                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                        S61088=2;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                    }
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
                                              thread85333(tdone,ends);
                                              thread85334(tdone,ends);
                                              int biggest85335 = 0;
                                              if(ends[4]>=biggest85335){
                                                biggest85335=ends[4];
                                              }
                                              if(ends[5]>=biggest85335){
                                                biggest85335=ends[5];
                                              }
                                              if(biggest85335 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                                      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    refill.setPresent();//sysj/lidLoaderController.sysj line: 64, column: 8
                                    currsigs.addElement(refill);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S56404=1;
                                  if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                    S56404=2;
                                    if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                      S56404=3;
                                      if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                        S56404=4;
                                        if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                          S56404=5;
                                          if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                            S56404=6;
                                            if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                              w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                              lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                              if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                                lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                              }
                                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                                twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                                currsigs.addElement(twin);
                                                twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                S56376=2;
                                                S57167=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  S57167=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S57162=0;
                                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    S57162=1;
                                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      ends[3]=2;
                                                      ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S61088=2;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                                S56376=2;
                                                S57167=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  S57167=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S57162=0;
                                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                    S57162=1;
                                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      ends[3]=2;
                                                      ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                      S61088=2;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                  }
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
                                            thread85336(tdone,ends);
                                            thread85337(tdone,ends);
                                            int biggest85338 = 0;
                                            if(ends[4]>=biggest85338){
                                              biggest85338=ends[4];
                                            }
                                            if(ends[5]>=biggest85338){
                                              biggest85338=ends[5];
                                            }
                                            if(biggest85338 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                          currsigs.addElement(vacOn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                                    pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S56376=2;
                                S57167=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57167=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S57162=0;
                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57162=1;
                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S61088=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
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
                  switch(S56404){
                    case 0 : 
                      if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 23
                        S56404=1;
                        if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                          S56404=2;
                          if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                            S56404=3;
                            if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                              S56404=4;
                              if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                S56404=5;
                                if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                  S56404=6;
                                  if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                    w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                    if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                      lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                    }
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                      twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                      S56376=2;
                                      S57167=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S57167=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S57162=0;
                                        if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                          done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                          S57162=1;
                                          if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                            ends[3]=2;
                                            ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                            S61088=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                      S56376=2;
                                      S57167=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S57167=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S57162=0;
                                        if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                          done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                          S57162=1;
                                          if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                            ends[3]=2;
                                            ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                            S61088=2;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
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
                                  thread85339(tdone,ends);
                                  thread85340(tdone,ends);
                                  int biggest85341 = 0;
                                  if(ends[4]>=biggest85341){
                                    biggest85341=ends[4];
                                  }
                                  if(ends[5]>=biggest85341){
                                    biggest85341=ends[5];
                                  }
                                  if(biggest85341 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                          pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        refill.setPresent();//sysj/lidLoaderController.sysj line: 64, column: 8
                        currsigs.addElement(refill);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                        S56404=2;
                        if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                          S56404=3;
                          if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                            S56404=4;
                            if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                              S56404=5;
                              if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                S56404=6;
                                if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                  w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                  if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                    lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                  }
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                    twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                    S56376=2;
                                    S57167=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57167=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57162=0;
                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S57162=1;
                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                          S61088=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                    S56376=2;
                                    S57167=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57167=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57162=0;
                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S57162=1;
                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                          S61088=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
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
                                thread85342(tdone,ends);
                                thread85343(tdone,ends);
                                int biggest85344 = 0;
                                if(ends[4]>=biggest85344){
                                  biggest85344=ends[4];
                                }
                                if(ends[5]>=biggest85344){
                                  biggest85344=ends[5];
                                }
                                if(biggest85344 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                        pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                        S56404=3;
                        if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                          S56404=4;
                          if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                            S56404=5;
                            if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                              S56404=6;
                              if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                  lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                }
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                  twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                  S56376=2;
                                  S57167=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57167=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57162=0;
                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57162=1;
                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S61088=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                  S56376=2;
                                  S57167=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57167=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57162=0;
                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57162=1;
                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S61088=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                              thread85345(tdone,ends);
                              thread85346(tdone,ends);
                              int biggest85347 = 0;
                              if(ends[4]>=biggest85347){
                                biggest85347=ends[4];
                              }
                              if(ends[5]>=biggest85347){
                                biggest85347=ends[5];
                              }
                              if(biggest85347 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                      if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                        S56404=4;
                        if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                          S56404=5;
                          if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                            S56404=6;
                            if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                              w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                              lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                              if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                              }
                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                S56376=2;
                                S57167=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57167=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S57162=0;
                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57162=1;
                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S61088=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                S56376=2;
                                S57167=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57167=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S57162=0;
                                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57162=1;
                                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S61088=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
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
                            thread85348(tdone,ends);
                            thread85349(tdone,ends);
                            int biggest85350 = 0;
                            if(ends[4]>=biggest85350){
                              biggest85350=ends[4];
                            }
                            if(ends[5]>=biggest85350){
                              biggest85350=ends[5];
                            }
                            if(biggest85350 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                        S56404=5;
                        if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                          S56404=6;
                          if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                            w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                            if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                              lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                            }
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                              twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                              S56376=2;
                              S57167=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                S57167=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57162=0;
                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57162=1;
                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S61088=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                              S56376=2;
                              S57167=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                S57167=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57162=0;
                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57162=1;
                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S61088=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                          thread85351(tdone,ends);
                          thread85352(tdone,ends);
                          int biggest85353 = 0;
                          if(ends[4]>=biggest85353){
                            biggest85353=ends[4];
                          }
                          if(ends[5]>=biggest85353){
                            biggest85353=ends[5];
                          }
                          if(biggest85353 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                        currsigs.addElement(vacOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 5 : 
                      if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                        S56404=6;
                        if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                          w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                          lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                          if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                            lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                          }
                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                            twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                            S56376=2;
                            S57167=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                              S57167=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S57162=0;
                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                S57162=1;
                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  ends[3]=2;
                                  ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S61088=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                            S56376=2;
                            S57167=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                              S57167=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S57162=0;
                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                S57162=1;
                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  ends[3]=2;
                                  ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S61088=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
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
                        thread85354(tdone,ends);
                        thread85355(tdone,ends);
                        int biggest85356 = 0;
                        if(ends[4]>=biggest85356){
                          biggest85356=ends[4];
                        }
                        if(ends[5]>=biggest85356){
                          biggest85356=ends[5];
                        }
                        if(biggest85356 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest85356 == 0){
                          S56404=6;
                          if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                            w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                            if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                              lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                            }
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                              twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                              S56376=2;
                              S57167=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                S57167=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57162=0;
                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57162=1;
                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S61088=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                              S56376=2;
                              S57167=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                S57167=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57162=0;
                                if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                  S57162=1;
                                  if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S61088=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
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
                      if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                        w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                        lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                        if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                          lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                        }
                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                          twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                          S56376=2;
                          S57167=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                            S57167=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S57162=0;
                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                              S57162=1;
                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                S61088=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                          S56376=2;
                          S57167=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                            S57167=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S57162=0;
                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                              S57162=1;
                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                S61088=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
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
                  switch(S57167){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                        S57167=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S57162){
                          case 0 : 
                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                              S57162=1;
                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                S61088=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
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
                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 98, column: 5
                              S61088=2;
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
                      S57167=1;
                      S57167=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                        S57167=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S57162=0;
                        if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                          done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                          S57162=1;
                          if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                            ends[3]=2;
                            ;//sysj/lidLoaderController.sysj line: 98, column: 5
                            S61088=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                  S61088=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 4 : 
                  S61088=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S61088=2;
            S61088=0;
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 49, column: 20
              S61088=1;
              if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 51, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S61088=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S56376=0;
                S56360=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 52, column: 5
                  start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                  S56360=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S56355=0;
                  if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                    start_in.setACK(true);//sysj/lidLoaderController.sysj line: 52, column: 5
                    S56355=1;
                    if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
                      start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
                      ends[3]=2;
                      ;//sysj/lidLoaderController.sysj line: 52, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj/lidLoaderController.sysj line: 53, column: 5
                      S56376=1;
                      if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj/lidLoaderController.sysj line: 55, column: 8
                        System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj/lidLoaderController.sysj line: 56, column: 6
                        w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj/lidLoaderController.sysj line: 57, column: 6
                        S56376=2;
                        S57167=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                          S57167=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S57162=0;
                          if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                            done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                            S57162=1;
                            if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                              ends[3]=2;
                              ;//sysj/lidLoaderController.sysj line: 98, column: 5
                              S61088=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 59, column: 13
                          S56404=0;
                          if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 61, column: 14
                            System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 62, column: 7
                            if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 23
                              S56404=1;
                              if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                                S56404=2;
                                if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                  S56404=3;
                                  if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                    S56404=4;
                                    if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                      S56404=5;
                                      if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                        S56404=6;
                                        if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                          w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                          if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                            lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                          }
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                            twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                            S56376=2;
                                            S57167=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                              S57167=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S57162=0;
                                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                S57162=1;
                                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  S61088=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                            S56376=2;
                                            S57167=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                              done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                              S57167=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S57162=0;
                                              if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                S57162=1;
                                                if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                  S61088=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
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
                                        thread85357(tdone,ends);
                                        thread85358(tdone,ends);
                                        int biggest85359 = 0;
                                        if(ends[4]>=biggest85359){
                                          biggest85359=ends[4];
                                        }
                                        if(ends[5]>=biggest85359){
                                          biggest85359=ends[5];
                                        }
                                        if(biggest85359 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                      currsigs.addElement(vacOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                                pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              refill.setPresent();//sysj/lidLoaderController.sysj line: 64, column: 8
                              currsigs.addElement(refill);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S56404=1;
                            if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                              S56404=2;
                              if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                                S56404=3;
                                if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                                  S56404=4;
                                  if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                                    S56404=5;
                                    if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                      S56404=6;
                                      if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                        w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                        if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                          lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                        }
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                          twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                          S56376=2;
                                          S57167=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                            S57167=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S57162=0;
                                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                              S57162=1;
                                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                ends[3]=2;
                                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                S61088=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                          S56376=2;
                                          S57167=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                            S57167=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S57162=0;
                                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                              S57162=1;
                                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                                ends[3]=2;
                                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                                S61088=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
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
                                      thread85360(tdone,ends);
                                      thread85361(tdone,ends);
                                      int biggest85362 = 0;
                                      if(ends[4]>=biggest85362){
                                        biggest85362=ends[4];
                                      }
                                      if(ends[5]>=biggest85362){
                                        biggest85362=ends[5];
                                      }
                                      if(biggest85362 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                              pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          S56376=2;
                          S57167=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                            S57167=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S57162=0;
                            if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                              S57162=1;
                              if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                S61088=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
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

  public void thread85313(int [] tdone, int [] ends){
        switch(S56351){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/lidLoaderController.sysj line: 36, column: 8
            auto_1.setPresent();//sysj/lidLoaderController.sysj line: 36, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj/lidLoaderController.sysj line: 37, column: 12
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

  public void thread85311(int [] tdone, int [] ends){
        S85299=1;
    S84945=0;
    if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 106, column: 20
      S84945=1;
      if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 107, column: 20
        S84945=2;
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
      else {
        if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 109, column: 14
          pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 109, column: 30
          currsigs.addElement(pusherExtend);
          if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 110, column: 14
            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 110, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
              armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
            if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
              armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
          if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 110, column: 14
            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 110, column: 23
            currsigs.addElement(vacOn);
            if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
              armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
            if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 111, column: 14
              armSource.setPresent();//sysj/lidLoaderController.sysj line: 111, column: 27
              currsigs.addElement(armSource);
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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
              if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 112, column: 14
                armDest.setPresent();//sysj/lidLoaderController.sysj line: 112, column: 25
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

  public void thread85309(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85308(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85306(int [] tdone, int [] ends){
        S56471=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85305(int [] tdone, int [] ends){
        S56466=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85304(int [] tdone, int [] ends){
        S84769=1;
    t_thread_3 = new LidLoaderTwin();//sysj/lidLoaderController.sysj line: 44, column: 3
    lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 45, column: 3
    w_thread_3 = null;//sysj/lidLoaderController.sysj line: 46, column: 3
    S61088=0;
    if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 49, column: 20
      S61088=1;
      if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 51, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S61088=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S56376=0;
        S56360=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 52, column: 5
          start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
          S56360=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S56355=0;
          if(!start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
            start_in.setACK(true);//sysj/lidLoaderController.sysj line: 52, column: 5
            S56355=1;
            if(start_in.isREQ()){//sysj/lidLoaderController.sysj line: 52, column: 5
              start_in.setACK(false);//sysj/lidLoaderController.sysj line: 52, column: 5
              ends[3]=2;
              ;//sysj/lidLoaderController.sysj line: 52, column: 5
              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj/lidLoaderController.sysj line: 53, column: 5
              S56376=1;
              if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj/lidLoaderController.sysj line: 55, column: 8
                System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj/lidLoaderController.sysj line: 56, column: 6
                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj/lidLoaderController.sysj line: 57, column: 6
                S56376=2;
                S57167=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                  done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                  S57167=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S57162=0;
                  if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                    done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                    S57162=1;
                    if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                      ends[3]=2;
                      ;//sysj/lidLoaderController.sysj line: 98, column: 5
                      S61088=2;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                if(w_thread_3 != null){//sysj/lidLoaderController.sysj line: 59, column: 13
                  S56404=0;
                  if(magazineEmpty.getprestatus()){//sysj/lidLoaderController.sysj line: 61, column: 14
                    System.out.println("[LID] Magazine empty, refilling.");//sysj/lidLoaderController.sysj line: 62, column: 7
                    if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 63, column: 23
                      S56404=1;
                      if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                        S56404=2;
                        if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                          S56404=3;
                          if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                            S56404=4;
                            if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                              S56404=5;
                              if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                                S56404=6;
                                if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                  w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                  if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                    lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                  }
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                    twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                    S56376=2;
                                    S57167=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57167=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57162=0;
                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S57162=1;
                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                          S61088=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                    S56376=2;
                                    S57167=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57167=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57162=0;
                                      if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S57162=1;
                                        if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                          S61088=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
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
                                thread85305(tdone,ends);
                                thread85306(tdone,ends);
                                int biggest85307 = 0;
                                if(ends[4]>=biggest85307){
                                  biggest85307=ends[4];
                                }
                                if(ends[5]>=biggest85307){
                                  biggest85307=ends[5];
                                }
                                if(biggest85307 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                        pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      refill.setPresent();//sysj/lidLoaderController.sysj line: 64, column: 8
                      currsigs.addElement(refill);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    S56404=1;
                    if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 69, column: 22
                      S56404=2;
                      if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 72, column: 22
                        S56404=3;
                        if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 75, column: 22
                          S56404=4;
                          if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 22
                            S56404=5;
                            if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 83, column: 22
                              S56404=6;
                              if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 22
                                w_thread_3.lid();//sysj/lidLoaderController.sysj line: 88, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj/lidLoaderController.sysj line: 89, column: 6
                                if(lids_thread_3 < 0) {//sysj/lidLoaderController.sysj line: 90, column: 18
                                  lids_thread_3 = 3;//sysj/lidLoaderController.sysj line: 90, column: 20
                                }
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj/lidLoaderController.sysj line: 91, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj/lidLoaderController.sysj line: 92, column: 6
                                  twin.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj/lidLoaderController.sysj line: 93, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                  S56376=2;
                                  S57167=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57167=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57162=0;
                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57162=1;
                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S61088=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj/lidLoaderController.sysj line: 95, column: 6
                                  S56376=2;
                                  S57167=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                    S57167=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57162=0;
                                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                                      S57162=1;
                                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                                        S61088=2;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
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
                              thread85308(tdone,ends);
                              thread85309(tdone,ends);
                              int biggest85310 = 0;
                              if(ends[4]>=biggest85310){
                                biggest85310=ends[4];
                              }
                              if(ends[5]>=biggest85310){
                                biggest85310=ends[5];
                              }
                              if(biggest85310 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj/lidLoaderController.sysj line: 76, column: 7
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
                      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 70, column: 7
                      currsigs.addElement(pusherExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  S56376=2;
                  S57167=0;
                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj/lidLoaderController.sysj line: 98, column: 5
                    done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                    S57167=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S57162=0;
                    if(done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                      done_o.setVal(w_thread_3);//sysj/lidLoaderController.sysj line: 98, column: 5
                      S57162=1;
                      if(!done_o.isACK()){//sysj/lidLoaderController.sysj line: 98, column: 5
                        done_o.setREQ(false);//sysj/lidLoaderController.sysj line: 98, column: 5
                        ends[3]=2;
                        ;//sysj/lidLoaderController.sysj line: 98, column: 5
                        S61088=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
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
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread85303(int [] tdone, int [] ends){
        S56351=1;
    if(mode.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/lidLoaderController.sysj line: 36, column: 8
        auto_1.setPresent();//sysj/lidLoaderController.sysj line: 36, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj/lidLoaderController.sysj line: 37, column: 12
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
      switch(S85301){
        case 0 : 
          S85301=0;
          break RUN;
        
        case 1 : 
          S85301=2;
          S85301=2;
          auto_1.setClear();//sysj/lidLoaderController.sysj line: 31, column: 2
          manual_1.setClear();//sysj/lidLoaderController.sysj line: 31, column: 2
          thread85303(tdone,ends);
          thread85304(tdone,ends);
          thread85311(tdone,ends);
          int biggest85312 = 0;
          if(ends[2]>=biggest85312){
            biggest85312=ends[2];
          }
          if(ends[3]>=biggest85312){
            biggest85312=ends[3];
          }
          if(ends[6]>=biggest85312){
            biggest85312=ends[6];
          }
          if(biggest85312 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/lidLoaderController.sysj line: 31, column: 2
          manual_1.setClear();//sysj/lidLoaderController.sysj line: 31, column: 2
          thread85313(tdone,ends);
          thread85314(tdone,ends);
          thread85363(tdone,ends);
          int biggest85364 = 0;
          if(ends[2]>=biggest85364){
            biggest85364=ends[2];
          }
          if(ends[3]>=biggest85364){
            biggest85364=ends[3];
          }
          if(ends[6]>=biggest85364){
            biggest85364=ends[6];
          }
          if(biggest85364 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest85364 == 0){
            S85301=0;
            active[1]=0;
            ends[1]=0;
            S85301=0;
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
