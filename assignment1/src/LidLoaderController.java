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
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal empty = new Signal("empty", Signal.INPUT);
  public Signal refilled = new Signal("refilled", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal lidLoaderLoad = new Signal("lidLoaderLoad", Signal.INPUT);
  public Signal pusherExtendM = new Signal("pusherExtendM", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal refill = new Signal("refill", Signal.OUTPUT);
  public Signal lidLoaderLoaded = new Signal("lidLoaderLoaded", Signal.OUTPUT);
  private Signal auto_1;
  private Signal manual_1;
  private int S2363 = 1;
  private int S1449 = 1;
  private int S1400 = 1;
  private int S1408 = 1;
  private int S2042 = 1;
  private int S1646 = 1;
  private int S1455 = 1;
  private int S1486 = 1;
  private int S1491 = 1;
  private int S2056 = 1;
  private int S2044 = 1;
  private int S2361 = 1;
  private int S2157 = 1;
  private int S2065 = 1;
  private int S2073 = 1;
  private int S2081 = 1;
  private int S2089 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread2407(int [] tdone, int [] ends){
        S2089=1;
    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 27
      armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 37
      currsigs.addElement(armDest);
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void thread2406(int [] tdone, int [] ends){
        S2081=1;
    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 93, column: 27
      armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 39
      currsigs.addElement(armSource);
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread2405(int [] tdone, int [] ends){
        S2073=1;
    if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 27
      vacOn.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 35
      currsigs.addElement(vacOn);
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread2404(int [] tdone, int [] ends){
        S2065=1;
    if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 27
      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 89, column: 42
      currsigs.addElement(pusherExtend);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread2402(int [] tdone, int [] ends){
        switch(S2089){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 27
          armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 37
          currsigs.addElement(armDest);
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        else {
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        break;
      
    }
  }

  public void thread2401(int [] tdone, int [] ends){
        switch(S2081){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 93, column: 27
          armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 39
          currsigs.addElement(armSource);
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        break;
      
    }
  }

  public void thread2400(int [] tdone, int [] ends){
        switch(S2073){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 27
          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 35
          currsigs.addElement(vacOn);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread2399(int [] tdone, int [] ends){
        switch(S2065){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 27
          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 89, column: 42
          currsigs.addElement(pusherExtend);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread2397(int [] tdone, int [] ends){
        S2089=1;
    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 27
      armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 37
      currsigs.addElement(armDest);
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void thread2396(int [] tdone, int [] ends){
        S2081=1;
    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 93, column: 27
      armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 39
      currsigs.addElement(armSource);
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread2395(int [] tdone, int [] ends){
        S2073=1;
    if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 27
      vacOn.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 35
      currsigs.addElement(vacOn);
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread2394(int [] tdone, int [] ends){
        S2065=1;
    if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 27
      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 89, column: 42
      currsigs.addElement(pusherExtend);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread2393(int [] tdone, int [] ends){
        switch(S2361){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2157){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
              S2157=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
                S2157=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread2394(tdone,ends);
                thread2395(tdone,ends);
                thread2396(tdone,ends);
                thread2397(tdone,ends);
                int biggest2398 = 0;
                if(ends[10]>=biggest2398){
                  biggest2398=ends[10];
                }
                if(ends[11]>=biggest2398){
                  biggest2398=ends[11];
                }
                if(ends[12]>=biggest2398){
                  biggest2398=ends[12];
                }
                if(ends[13]>=biggest2398){
                  biggest2398=ends[13];
                }
                if(biggest2398 == 1){
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
              }
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
              S2157=2;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              thread2399(tdone,ends);
              thread2400(tdone,ends);
              thread2401(tdone,ends);
              thread2402(tdone,ends);
              int biggest2403 = 0;
              if(ends[10]>=biggest2403){
                biggest2403=ends[10];
              }
              if(ends[11]>=biggest2403){
                biggest2403=ends[11];
              }
              if(ends[12]>=biggest2403){
                biggest2403=ends[12];
              }
              if(ends[13]>=biggest2403){
                biggest2403=ends[13];
              }
              if(biggest2403 == 1){
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              //FINXME code
              if(biggest2403 == 0){
                S2157=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            break;
          
          case 2 : 
            S2157=2;
            S2157=0;
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
              S2157=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
                S2157=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread2404(tdone,ends);
                thread2405(tdone,ends);
                thread2406(tdone,ends);
                thread2407(tdone,ends);
                int biggest2408 = 0;
                if(ends[10]>=biggest2408){
                  biggest2408=ends[10];
                }
                if(ends[11]>=biggest2408){
                  biggest2408=ends[11];
                }
                if(ends[12]>=biggest2408){
                  biggest2408=ends[12];
                }
                if(ends[13]>=biggest2408){
                  biggest2408=ends[13];
                }
                if(biggest2408 == 1){
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
              }
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2392(int [] tdone, int [] ends){
        switch(S2056){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2044){
          case 0 : 
            if(empty.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 10
              refill.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 4
              currsigs.addElement(refill);
              S2044=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 80, column: 10
              S2044=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2390(int [] tdone, int [] ends){
        switch(S1491){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 34
        currsigs.addElement(vacOn);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread2389(int [] tdone, int [] ends){
        switch(S1486){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 14
        currsigs.addElement(armDest);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread2387(int [] tdone, int [] ends){
        S1491=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 34
    currsigs.addElement(vacOn);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2386(int [] tdone, int [] ends){
        S1486=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 14
    currsigs.addElement(armDest);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2385(int [] tdone, int [] ends){
        switch(S2042){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1646){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
              S1646=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
                S1646=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
                  S1455=0;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S1646=2;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
              S1646=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1455){
                case 0 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 39, column: 18
                    S1455=1;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                    currsigs.addElement(armDest);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 1 : 
                  S1455=1;
                  S1455=2;
                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 43, column: 20
                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 45, column: 14
                    currsigs.addElement(pusherExtend);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    S1455=3;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 44, column: 19
                    S1455=3;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 45, column: 14
                    currsigs.addElement(pusherExtend);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 3 : 
                  S1455=3;
                  S1455=4;
                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 50, column: 13
                  currsigs.addElement(armSource);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 4 : 
                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 49, column: 18
                    S1455=5;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 50, column: 13
                    currsigs.addElement(armSource);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 5 : 
                  S1455=5;
                  S1455=6;
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 54, column: 13
                  currsigs.addElement(vacOn);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 6 : 
                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 53, column: 18
                    S1455=7;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 54, column: 13
                    currsigs.addElement(vacOn);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 7 : 
                  S1455=7;
                  S1455=8;
                  thread2386(tdone,ends);
                  thread2387(tdone,ends);
                  int biggest2388 = 0;
                  if(ends[6]>=biggest2388){
                    biggest2388=ends[6];
                  }
                  if(ends[7]>=biggest2388){
                    biggest2388=ends[7];
                  }
                  if(biggest2388 == 1){
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 8 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 57, column: 18
                    S1455=9;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    thread2389(tdone,ends);
                    thread2390(tdone,ends);
                    int biggest2391 = 0;
                    if(ends[6]>=biggest2391){
                      biggest2391=ends[6];
                    }
                    if(ends[7]>=biggest2391){
                      biggest2391=ends[7];
                    }
                    if(biggest2391 == 1){
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    //FINXME code
                    if(biggest2391 == 0){
                      S1455=9;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                  break;
                
                case 9 : 
                  S1455=9;
                  S1455=10;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 10 : 
                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 18
                    S1455=11;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 11 : 
                  S1455=11;
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 63, column: 12
                  currsigs.addElement(vacOn);
                  S1455=12;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 65, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 12 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 64, column: 18
                    S1455=13;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    armDest.setPresent();//sysj\lidLoaderController.sysj line: 65, column: 13
                    currsigs.addElement(armDest);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 13 : 
                  S1455=13;
                  lidLoaderLoaded.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 21
                  currsigs.addElement(lidLoaderLoaded);
                  S1646=2;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S1646=2;
            S1646=0;
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
              S1646=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
                S1646=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
                  S1455=0;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S1646=2;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2383(int [] tdone, int [] ends){
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\lidLoaderController.sysj line: 25, column: 10
      manual_1.setPresent();//sysj\lidLoaderController.sysj line: 25, column: 32
      currsigs.addElement(manual_1);
      active[4]=0;
      ends[4]=0;
      tdone[4]=1;
    }
    else {
      active[4]=0;
      ends[4]=0;
      tdone[4]=1;
    }
  }

  public void thread2382(int [] tdone, int [] ends){
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 23, column: 10
      auto_1.setPresent();//sysj\lidLoaderController.sysj line: 23, column: 32
      currsigs.addElement(auto_1);
      active[3]=0;
      ends[3]=0;
      tdone[3]=1;
    }
    else {
      active[3]=0;
      ends[3]=0;
      tdone[3]=1;
    }
  }

  public void thread2380(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread2379(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread2377(int [] tdone, int [] ends){
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\lidLoaderController.sysj line: 25, column: 10
      manual_1.setPresent();//sysj\lidLoaderController.sysj line: 25, column: 32
      currsigs.addElement(manual_1);
      active[4]=0;
      ends[4]=0;
      tdone[4]=1;
    }
    else {
      active[4]=0;
      ends[4]=0;
      tdone[4]=1;
    }
  }

  public void thread2376(int [] tdone, int [] ends){
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 23, column: 10
      auto_1.setPresent();//sysj\lidLoaderController.sysj line: 23, column: 32
      currsigs.addElement(auto_1);
      active[3]=0;
      ends[3]=0;
      tdone[3]=1;
    }
    else {
      active[3]=0;
      ends[3]=0;
      tdone[3]=1;
    }
  }

  public void thread2375(int [] tdone, int [] ends){
        switch(S1449){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1400){
          case 0 : 
            S1400=0;
            auto_1.setPresent();//sysj\lidLoaderController.sysj line: 19, column: 3
            currsigs.addElement(auto_1);
            S1400=1;
            S1408=0;
            if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 21, column: 12
              thread2376(tdone,ends);
              thread2377(tdone,ends);
              int biggest2378 = 0;
              if(ends[3]>=biggest2378){
                biggest2378=ends[3];
              }
              if(ends[4]>=biggest2378){
                biggest2378=ends[4];
              }
              //FINXME code
              if(biggest2378 == 0){
                S1408=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S1408=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            switch(S1408){
              case 0 : 
                thread2379(tdone,ends);
                thread2380(tdone,ends);
                int biggest2381 = 0;
                if(ends[3]>=biggest2381){
                  biggest2381=ends[3];
                }
                if(ends[4]>=biggest2381){
                  biggest2381=ends[4];
                }
                //FINXME code
                if(biggest2381 == 0){
                  S1408=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S1408=1;
                S1408=0;
                if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 21, column: 12
                  thread2382(tdone,ends);
                  thread2383(tdone,ends);
                  int biggest2384 = 0;
                  if(ends[3]>=biggest2384){
                    biggest2384=ends[3];
                  }
                  if(ends[4]>=biggest2384){
                    biggest2384=ends[4];
                  }
                  //FINXME code
                  if(biggest2384 == 0){
                    S1408=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  S1408=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2372(int [] tdone, int [] ends){
        S2089=1;
    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 95, column: 27
      armDest.setPresent();//sysj\lidLoaderController.sysj line: 95, column: 37
      currsigs.addElement(armDest);
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void thread2371(int [] tdone, int [] ends){
        S2081=1;
    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 93, column: 27
      armSource.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 39
      currsigs.addElement(armSource);
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread2370(int [] tdone, int [] ends){
        S2073=1;
    if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 91, column: 27
      vacOn.setPresent();//sysj\lidLoaderController.sysj line: 91, column: 35
      currsigs.addElement(vacOn);
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread2369(int [] tdone, int [] ends){
        S2065=1;
    if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 89, column: 27
      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 89, column: 42
      currsigs.addElement(pusherExtend);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread2368(int [] tdone, int [] ends){
        S2361=1;
    S2157=0;
    if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
      S2157=1;
      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
        S2157=2;
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
      }
      else {
        thread2369(tdone,ends);
        thread2370(tdone,ends);
        thread2371(tdone,ends);
        thread2372(tdone,ends);
        int biggest2373 = 0;
        if(ends[10]>=biggest2373){
          biggest2373=ends[10];
        }
        if(ends[11]>=biggest2373){
          biggest2373=ends[11];
        }
        if(ends[12]>=biggest2373){
          biggest2373=ends[12];
        }
        if(ends[13]>=biggest2373){
          biggest2373=ends[13];
        }
        if(biggest2373 == 1){
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
      }
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread2367(int [] tdone, int [] ends){
        S2056=1;
    S2044=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2366(int [] tdone, int [] ends){
        S2042=1;
    S1646=0;
    if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
      S1646=1;
      if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
        S1646=2;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
          S1455=0;
          armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
          currsigs.addElement(armDest);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          S1646=2;
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread2365(int [] tdone, int [] ends){
        S1449=1;
    S1400=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2363){
        case 0 : 
          S2363=0;
          break RUN;
        
        case 1 : 
          S2363=2;
          S2363=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          thread2365(tdone,ends);
          thread2366(tdone,ends);
          thread2367(tdone,ends);
          thread2368(tdone,ends);
          int biggest2374 = 0;
          if(ends[2]>=biggest2374){
            biggest2374=ends[2];
          }
          if(ends[5]>=biggest2374){
            biggest2374=ends[5];
          }
          if(ends[8]>=biggest2374){
            biggest2374=ends[8];
          }
          if(ends[9]>=biggest2374){
            biggest2374=ends[9];
          }
          if(biggest2374 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          thread2375(tdone,ends);
          thread2385(tdone,ends);
          thread2392(tdone,ends);
          thread2393(tdone,ends);
          int biggest2409 = 0;
          if(ends[2]>=biggest2409){
            biggest2409=ends[2];
          }
          if(ends[5]>=biggest2409){
            biggest2409=ends[5];
          }
          if(ends[8]>=biggest2409){
            biggest2409=ends[8];
          }
          if(ends[9]>=biggest2409){
            biggest2409=ends[9];
          }
          if(biggest2409 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2409 == 0){
            S2363=0;
            active[1]=0;
            ends[1]=0;
            S2363=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          refilled.gethook();
          mode.gethook();
          lidLoaderLoad.gethook();
          pusherExtendM.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      refilled.setpreclear();
      mode.setpreclear();
      lidLoaderLoad.setpreclear();
      pusherExtendM.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      refill.setpreclear();
      lidLoaderLoaded.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = empty.getStatus() ? empty.setprepresent() : empty.setpreclear();
      empty.setpreval(empty.getValue());
      empty.setClear();
      dummyint = refilled.getStatus() ? refilled.setprepresent() : refilled.setpreclear();
      refilled.setpreval(refilled.getValue());
      refilled.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = lidLoaderLoad.getStatus() ? lidLoaderLoad.setprepresent() : lidLoaderLoad.setpreclear();
      lidLoaderLoad.setpreval(lidLoaderLoad.getValue());
      lidLoaderLoad.setClear();
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
      lidLoaderLoaded.sethook();
      lidLoaderLoaded.setClear();
      auto_1.setClear();
      manual_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        refilled.gethook();
        mode.gethook();
        lidLoaderLoad.gethook();
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
