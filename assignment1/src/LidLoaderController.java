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
  private int S2974 = 1;
  private int S2060 = 1;
  private int S2011 = 1;
  private int S2019 = 1;
  private int S2653 = 1;
  private int S2257 = 1;
  private int S2066 = 1;
  private int S2097 = 1;
  private int S2102 = 1;
  private int S2667 = 1;
  private int S2655 = 1;
  private int S2972 = 1;
  private int S2768 = 1;
  private int S2676 = 1;
  private int S2684 = 1;
  private int S2692 = 1;
  private int S2700 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread3018(int [] tdone, int [] ends){
        S2700=1;
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

  public void thread3017(int [] tdone, int [] ends){
        S2692=1;
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

  public void thread3016(int [] tdone, int [] ends){
        S2684=1;
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

  public void thread3015(int [] tdone, int [] ends){
        S2676=1;
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

  public void thread3013(int [] tdone, int [] ends){
        switch(S2700){
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

  public void thread3012(int [] tdone, int [] ends){
        switch(S2692){
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

  public void thread3011(int [] tdone, int [] ends){
        switch(S2684){
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

  public void thread3010(int [] tdone, int [] ends){
        switch(S2676){
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

  public void thread3008(int [] tdone, int [] ends){
        S2700=1;
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

  public void thread3007(int [] tdone, int [] ends){
        S2692=1;
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

  public void thread3006(int [] tdone, int [] ends){
        S2684=1;
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

  public void thread3005(int [] tdone, int [] ends){
        S2676=1;
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

  public void thread3004(int [] tdone, int [] ends){
        switch(S2972){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2768){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
              S2768=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
                S2768=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread3005(tdone,ends);
                thread3006(tdone,ends);
                thread3007(tdone,ends);
                thread3008(tdone,ends);
                int biggest3009 = 0;
                if(ends[10]>=biggest3009){
                  biggest3009=ends[10];
                }
                if(ends[11]>=biggest3009){
                  biggest3009=ends[11];
                }
                if(ends[12]>=biggest3009){
                  biggest3009=ends[12];
                }
                if(ends[13]>=biggest3009){
                  biggest3009=ends[13];
                }
                if(biggest3009 == 1){
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
              S2768=2;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              thread3010(tdone,ends);
              thread3011(tdone,ends);
              thread3012(tdone,ends);
              thread3013(tdone,ends);
              int biggest3014 = 0;
              if(ends[10]>=biggest3014){
                biggest3014=ends[10];
              }
              if(ends[11]>=biggest3014){
                biggest3014=ends[11];
              }
              if(ends[12]>=biggest3014){
                biggest3014=ends[12];
              }
              if(ends[13]>=biggest3014){
                biggest3014=ends[13];
              }
              if(biggest3014 == 1){
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              //FINXME code
              if(biggest3014 == 0){
                S2768=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            break;
          
          case 2 : 
            S2768=2;
            S2768=0;
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
              S2768=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
                S2768=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread3015(tdone,ends);
                thread3016(tdone,ends);
                thread3017(tdone,ends);
                thread3018(tdone,ends);
                int biggest3019 = 0;
                if(ends[10]>=biggest3019){
                  biggest3019=ends[10];
                }
                if(ends[11]>=biggest3019){
                  biggest3019=ends[11];
                }
                if(ends[12]>=biggest3019){
                  biggest3019=ends[12];
                }
                if(ends[13]>=biggest3019){
                  biggest3019=ends[13];
                }
                if(biggest3019 == 1){
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

  public void thread3003(int [] tdone, int [] ends){
        switch(S2667){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2655){
          case 0 : 
            if(empty.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 10
              refill.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 4
              currsigs.addElement(refill);
              S2655=1;
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
              S2655=0;
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

  public void thread3001(int [] tdone, int [] ends){
        switch(S2102){
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

  public void thread3000(int [] tdone, int [] ends){
        switch(S2097){
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

  public void thread2998(int [] tdone, int [] ends){
        S2102=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 34
    currsigs.addElement(vacOn);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2997(int [] tdone, int [] ends){
        S2097=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 14
    currsigs.addElement(armDest);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2996(int [] tdone, int [] ends){
        switch(S2653){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2257){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
              S2257=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
                S2257=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
                  S2066=0;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S2257=2;
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
              S2257=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S2066){
                case 0 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 39, column: 18
                    S2066=1;
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
                  S2066=1;
                  S2066=2;
                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 43, column: 20
                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 45, column: 14
                    currsigs.addElement(pusherExtend);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    S2066=3;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 44, column: 19
                    S2066=3;
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
                  S2066=3;
                  S2066=4;
                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 50, column: 13
                  currsigs.addElement(armSource);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 4 : 
                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 49, column: 18
                    S2066=5;
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
                  S2066=5;
                  S2066=6;
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 54, column: 13
                  currsigs.addElement(vacOn);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 6 : 
                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 53, column: 18
                    S2066=7;
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
                  S2066=7;
                  S2066=8;
                  thread2997(tdone,ends);
                  thread2998(tdone,ends);
                  int biggest2999 = 0;
                  if(ends[6]>=biggest2999){
                    biggest2999=ends[6];
                  }
                  if(ends[7]>=biggest2999){
                    biggest2999=ends[7];
                  }
                  if(biggest2999 == 1){
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 8 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 57, column: 18
                    S2066=9;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    thread3000(tdone,ends);
                    thread3001(tdone,ends);
                    int biggest3002 = 0;
                    if(ends[6]>=biggest3002){
                      biggest3002=ends[6];
                    }
                    if(ends[7]>=biggest3002){
                      biggest3002=ends[7];
                    }
                    if(biggest3002 == 1){
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    //FINXME code
                    if(biggest3002 == 0){
                      S2066=9;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                  break;
                
                case 9 : 
                  S2066=9;
                  S2066=10;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 10 : 
                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 18
                    S2066=11;
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
                  S2066=11;
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 63, column: 12
                  currsigs.addElement(vacOn);
                  S2066=12;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 65, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 12 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 64, column: 18
                    S2066=13;
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
                  S2066=13;
                  lidLoaderLoaded.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 21
                  currsigs.addElement(lidLoaderLoaded);
                  S2257=2;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S2257=2;
            S2257=0;
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
              S2257=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
                S2257=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
                  S2066=0;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S2257=2;
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

  public void thread2994(int [] tdone, int [] ends){
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

  public void thread2993(int [] tdone, int [] ends){
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

  public void thread2991(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread2990(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread2988(int [] tdone, int [] ends){
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

  public void thread2987(int [] tdone, int [] ends){
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

  public void thread2986(int [] tdone, int [] ends){
        switch(S2060){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2011){
          case 0 : 
            S2011=0;
            auto_1.setPresent();//sysj\lidLoaderController.sysj line: 19, column: 3
            currsigs.addElement(auto_1);
            S2011=1;
            S2019=0;
            if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 21, column: 12
              thread2987(tdone,ends);
              thread2988(tdone,ends);
              int biggest2989 = 0;
              if(ends[3]>=biggest2989){
                biggest2989=ends[3];
              }
              if(ends[4]>=biggest2989){
                biggest2989=ends[4];
              }
              //FINXME code
              if(biggest2989 == 0){
                S2019=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S2019=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            switch(S2019){
              case 0 : 
                thread2990(tdone,ends);
                thread2991(tdone,ends);
                int biggest2992 = 0;
                if(ends[3]>=biggest2992){
                  biggest2992=ends[3];
                }
                if(ends[4]>=biggest2992){
                  biggest2992=ends[4];
                }
                //FINXME code
                if(biggest2992 == 0){
                  S2019=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S2019=1;
                S2019=0;
                if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 21, column: 12
                  thread2993(tdone,ends);
                  thread2994(tdone,ends);
                  int biggest2995 = 0;
                  if(ends[3]>=biggest2995){
                    biggest2995=ends[3];
                  }
                  if(ends[4]>=biggest2995){
                    biggest2995=ends[4];
                  }
                  //FINXME code
                  if(biggest2995 == 0){
                    S2019=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  S2019=1;
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

  public void thread2983(int [] tdone, int [] ends){
        S2700=1;
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

  public void thread2982(int [] tdone, int [] ends){
        S2692=1;
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

  public void thread2981(int [] tdone, int [] ends){
        S2684=1;
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

  public void thread2980(int [] tdone, int [] ends){
        S2676=1;
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

  public void thread2979(int [] tdone, int [] ends){
        S2972=1;
    S2768=0;
    if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
      S2768=1;
      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
        S2768=2;
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
      }
      else {
        thread2980(tdone,ends);
        thread2981(tdone,ends);
        thread2982(tdone,ends);
        thread2983(tdone,ends);
        int biggest2984 = 0;
        if(ends[10]>=biggest2984){
          biggest2984=ends[10];
        }
        if(ends[11]>=biggest2984){
          biggest2984=ends[11];
        }
        if(ends[12]>=biggest2984){
          biggest2984=ends[12];
        }
        if(ends[13]>=biggest2984){
          biggest2984=ends[13];
        }
        if(biggest2984 == 1){
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

  public void thread2978(int [] tdone, int [] ends){
        S2667=1;
    S2655=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2977(int [] tdone, int [] ends){
        S2653=1;
    S2257=0;
    if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
      S2257=1;
      if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
        S2257=2;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
          S2066=0;
          armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
          currsigs.addElement(armDest);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          S2257=2;
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

  public void thread2976(int [] tdone, int [] ends){
        S2060=1;
    S2011=0;
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
      switch(S2974){
        case 0 : 
          S2974=0;
          break RUN;
        
        case 1 : 
          S2974=2;
          S2974=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          thread2976(tdone,ends);
          thread2977(tdone,ends);
          thread2978(tdone,ends);
          thread2979(tdone,ends);
          int biggest2985 = 0;
          if(ends[2]>=biggest2985){
            biggest2985=ends[2];
          }
          if(ends[5]>=biggest2985){
            biggest2985=ends[5];
          }
          if(ends[8]>=biggest2985){
            biggest2985=ends[8];
          }
          if(ends[9]>=biggest2985){
            biggest2985=ends[9];
          }
          if(biggest2985 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          thread2986(tdone,ends);
          thread2996(tdone,ends);
          thread3003(tdone,ends);
          thread3004(tdone,ends);
          int biggest3020 = 0;
          if(ends[2]>=biggest3020){
            biggest3020=ends[2];
          }
          if(ends[5]>=biggest3020){
            biggest3020=ends[5];
          }
          if(ends[8]>=biggest3020){
            biggest3020=ends[8];
          }
          if(ends[9]>=biggest3020){
            biggest3020=ends[9];
          }
          if(biggest3020 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3020 == 0){
            S2974=0;
            active[1]=0;
            ends[1]=0;
            S2974=0;
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
