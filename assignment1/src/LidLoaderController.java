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
  private int S3075 = 1;
  private int S2161 = 1;
  private int S2112 = 1;
  private int S2120 = 1;
  private int S2754 = 1;
  private int S2358 = 1;
  private int S2167 = 1;
  private int S2198 = 1;
  private int S2203 = 1;
  private int S2768 = 1;
  private int S2756 = 1;
  private int S3073 = 1;
  private int S2869 = 1;
  private int S2777 = 1;
  private int S2785 = 1;
  private int S2793 = 1;
  private int S2801 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread3119(int [] tdone, int [] ends){
        S2801=1;
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

  public void thread3118(int [] tdone, int [] ends){
        S2793=1;
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

  public void thread3117(int [] tdone, int [] ends){
        S2785=1;
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

  public void thread3116(int [] tdone, int [] ends){
        S2777=1;
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

  public void thread3114(int [] tdone, int [] ends){
        switch(S2801){
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

  public void thread3113(int [] tdone, int [] ends){
        switch(S2793){
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

  public void thread3112(int [] tdone, int [] ends){
        switch(S2785){
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

  public void thread3111(int [] tdone, int [] ends){
        switch(S2777){
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

  public void thread3109(int [] tdone, int [] ends){
        S2801=1;
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

  public void thread3108(int [] tdone, int [] ends){
        S2793=1;
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

  public void thread3107(int [] tdone, int [] ends){
        S2785=1;
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

  public void thread3106(int [] tdone, int [] ends){
        S2777=1;
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

  public void thread3105(int [] tdone, int [] ends){
        switch(S3073){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2869){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
              S2869=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
                S2869=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread3106(tdone,ends);
                thread3107(tdone,ends);
                thread3108(tdone,ends);
                thread3109(tdone,ends);
                int biggest3110 = 0;
                if(ends[10]>=biggest3110){
                  biggest3110=ends[10];
                }
                if(ends[11]>=biggest3110){
                  biggest3110=ends[11];
                }
                if(ends[12]>=biggest3110){
                  biggest3110=ends[12];
                }
                if(ends[13]>=biggest3110){
                  biggest3110=ends[13];
                }
                if(biggest3110 == 1){
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
              S2869=2;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              thread3111(tdone,ends);
              thread3112(tdone,ends);
              thread3113(tdone,ends);
              thread3114(tdone,ends);
              int biggest3115 = 0;
              if(ends[10]>=biggest3115){
                biggest3115=ends[10];
              }
              if(ends[11]>=biggest3115){
                biggest3115=ends[11];
              }
              if(ends[12]>=biggest3115){
                biggest3115=ends[12];
              }
              if(ends[13]>=biggest3115){
                biggest3115=ends[13];
              }
              if(biggest3115 == 1){
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              //FINXME code
              if(biggest3115 == 0){
                S2869=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            break;
          
          case 2 : 
            S2869=2;
            S2869=0;
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
              S2869=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
                S2869=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread3116(tdone,ends);
                thread3117(tdone,ends);
                thread3118(tdone,ends);
                thread3119(tdone,ends);
                int biggest3120 = 0;
                if(ends[10]>=biggest3120){
                  biggest3120=ends[10];
                }
                if(ends[11]>=biggest3120){
                  biggest3120=ends[11];
                }
                if(ends[12]>=biggest3120){
                  biggest3120=ends[12];
                }
                if(ends[13]>=biggest3120){
                  biggest3120=ends[13];
                }
                if(biggest3120 == 1){
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

  public void thread3104(int [] tdone, int [] ends){
        switch(S2768){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2756){
          case 0 : 
            if(empty.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 10
              refill.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 4
              currsigs.addElement(refill);
              S2756=1;
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
              S2756=0;
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

  public void thread3102(int [] tdone, int [] ends){
        switch(S2203){
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

  public void thread3101(int [] tdone, int [] ends){
        switch(S2198){
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

  public void thread3099(int [] tdone, int [] ends){
        S2203=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 34
    currsigs.addElement(vacOn);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3098(int [] tdone, int [] ends){
        S2198=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 14
    currsigs.addElement(armDest);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3097(int [] tdone, int [] ends){
        switch(S2754){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2358){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
              S2358=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
                S2358=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
                  S2167=0;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S2358=2;
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
              S2358=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S2167){
                case 0 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 39, column: 18
                    S2167=1;
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
                  S2167=1;
                  S2167=2;
                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 43, column: 20
                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 45, column: 14
                    currsigs.addElement(pusherExtend);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    S2167=3;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 44, column: 19
                    S2167=3;
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
                  S2167=3;
                  S2167=4;
                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 50, column: 13
                  currsigs.addElement(armSource);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 4 : 
                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 49, column: 18
                    S2167=5;
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
                  S2167=5;
                  S2167=6;
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 54, column: 13
                  currsigs.addElement(vacOn);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 6 : 
                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 53, column: 18
                    S2167=7;
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
                  S2167=7;
                  S2167=8;
                  thread3098(tdone,ends);
                  thread3099(tdone,ends);
                  int biggest3100 = 0;
                  if(ends[6]>=biggest3100){
                    biggest3100=ends[6];
                  }
                  if(ends[7]>=biggest3100){
                    biggest3100=ends[7];
                  }
                  if(biggest3100 == 1){
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 8 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 57, column: 18
                    S2167=9;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    thread3101(tdone,ends);
                    thread3102(tdone,ends);
                    int biggest3103 = 0;
                    if(ends[6]>=biggest3103){
                      biggest3103=ends[6];
                    }
                    if(ends[7]>=biggest3103){
                      biggest3103=ends[7];
                    }
                    if(biggest3103 == 1){
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    //FINXME code
                    if(biggest3103 == 0){
                      S2167=9;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                  break;
                
                case 9 : 
                  S2167=9;
                  S2167=10;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 10 : 
                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 18
                    S2167=11;
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
                  S2167=11;
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 63, column: 12
                  currsigs.addElement(vacOn);
                  S2167=12;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 65, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 12 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 64, column: 18
                    S2167=13;
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
                  S2167=13;
                  lidLoaderLoaded.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 21
                  currsigs.addElement(lidLoaderLoaded);
                  S2358=2;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S2358=2;
            S2358=0;
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
              S2358=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
                S2358=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
                  S2167=0;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S2358=2;
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

  public void thread3095(int [] tdone, int [] ends){
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

  public void thread3094(int [] tdone, int [] ends){
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

  public void thread3092(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread3091(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread3089(int [] tdone, int [] ends){
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

  public void thread3088(int [] tdone, int [] ends){
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

  public void thread3087(int [] tdone, int [] ends){
        switch(S2161){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2112){
          case 0 : 
            S2112=0;
            auto_1.setPresent();//sysj\lidLoaderController.sysj line: 19, column: 3
            currsigs.addElement(auto_1);
            S2112=1;
            S2120=0;
            if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 21, column: 12
              thread3088(tdone,ends);
              thread3089(tdone,ends);
              int biggest3090 = 0;
              if(ends[3]>=biggest3090){
                biggest3090=ends[3];
              }
              if(ends[4]>=biggest3090){
                biggest3090=ends[4];
              }
              //FINXME code
              if(biggest3090 == 0){
                S2120=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S2120=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            switch(S2120){
              case 0 : 
                thread3091(tdone,ends);
                thread3092(tdone,ends);
                int biggest3093 = 0;
                if(ends[3]>=biggest3093){
                  biggest3093=ends[3];
                }
                if(ends[4]>=biggest3093){
                  biggest3093=ends[4];
                }
                //FINXME code
                if(biggest3093 == 0){
                  S2120=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S2120=1;
                S2120=0;
                if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 21, column: 12
                  thread3094(tdone,ends);
                  thread3095(tdone,ends);
                  int biggest3096 = 0;
                  if(ends[3]>=biggest3096){
                    biggest3096=ends[3];
                  }
                  if(ends[4]>=biggest3096){
                    biggest3096=ends[4];
                  }
                  //FINXME code
                  if(biggest3096 == 0){
                    S2120=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  S2120=1;
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

  public void thread3084(int [] tdone, int [] ends){
        S2801=1;
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

  public void thread3083(int [] tdone, int [] ends){
        S2793=1;
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

  public void thread3082(int [] tdone, int [] ends){
        S2785=1;
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

  public void thread3081(int [] tdone, int [] ends){
        S2777=1;
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

  public void thread3080(int [] tdone, int [] ends){
        S3073=1;
    S2869=0;
    if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
      S2869=1;
      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
        S2869=2;
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
      }
      else {
        thread3081(tdone,ends);
        thread3082(tdone,ends);
        thread3083(tdone,ends);
        thread3084(tdone,ends);
        int biggest3085 = 0;
        if(ends[10]>=biggest3085){
          biggest3085=ends[10];
        }
        if(ends[11]>=biggest3085){
          biggest3085=ends[11];
        }
        if(ends[12]>=biggest3085){
          biggest3085=ends[12];
        }
        if(ends[13]>=biggest3085){
          biggest3085=ends[13];
        }
        if(biggest3085 == 1){
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

  public void thread3079(int [] tdone, int [] ends){
        S2768=1;
    S2756=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread3078(int [] tdone, int [] ends){
        S2754=1;
    S2358=0;
    if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
      S2358=1;
      if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
        S2358=2;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
          S2167=0;
          armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
          currsigs.addElement(armDest);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          S2358=2;
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

  public void thread3077(int [] tdone, int [] ends){
        S2161=1;
    S2112=0;
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
      switch(S3075){
        case 0 : 
          S3075=0;
          break RUN;
        
        case 1 : 
          S3075=2;
          S3075=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          thread3077(tdone,ends);
          thread3078(tdone,ends);
          thread3079(tdone,ends);
          thread3080(tdone,ends);
          int biggest3086 = 0;
          if(ends[2]>=biggest3086){
            biggest3086=ends[2];
          }
          if(ends[5]>=biggest3086){
            biggest3086=ends[5];
          }
          if(ends[8]>=biggest3086){
            biggest3086=ends[8];
          }
          if(ends[9]>=biggest3086){
            biggest3086=ends[9];
          }
          if(biggest3086 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          thread3087(tdone,ends);
          thread3097(tdone,ends);
          thread3104(tdone,ends);
          thread3105(tdone,ends);
          int biggest3121 = 0;
          if(ends[2]>=biggest3121){
            biggest3121=ends[2];
          }
          if(ends[5]>=biggest3121){
            biggest3121=ends[5];
          }
          if(ends[8]>=biggest3121){
            biggest3121=ends[8];
          }
          if(ends[9]>=biggest3121){
            biggest3121=ends[9];
          }
          if(biggest3121 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3121 == 0){
            S3075=0;
            active[1]=0;
            ends[1]=0;
            S3075=0;
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
