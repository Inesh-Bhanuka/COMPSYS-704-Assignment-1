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
  private int S3112 = 1;
  private int S2198 = 1;
  private int S2149 = 1;
  private int S2157 = 1;
  private int S2791 = 1;
  private int S2395 = 1;
  private int S2204 = 1;
  private int S2235 = 1;
  private int S2240 = 1;
  private int S2805 = 1;
  private int S2793 = 1;
  private int S3110 = 1;
  private int S2906 = 1;
  private int S2814 = 1;
  private int S2822 = 1;
  private int S2830 = 1;
  private int S2838 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread3156(int [] tdone, int [] ends){
        S2838=1;
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

  public void thread3155(int [] tdone, int [] ends){
        S2830=1;
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

  public void thread3154(int [] tdone, int [] ends){
        S2822=1;
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

  public void thread3153(int [] tdone, int [] ends){
        S2814=1;
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

  public void thread3151(int [] tdone, int [] ends){
        switch(S2838){
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

  public void thread3150(int [] tdone, int [] ends){
        switch(S2830){
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

  public void thread3149(int [] tdone, int [] ends){
        switch(S2822){
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

  public void thread3148(int [] tdone, int [] ends){
        switch(S2814){
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

  public void thread3146(int [] tdone, int [] ends){
        S2838=1;
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

  public void thread3145(int [] tdone, int [] ends){
        S2830=1;
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

  public void thread3144(int [] tdone, int [] ends){
        S2822=1;
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

  public void thread3143(int [] tdone, int [] ends){
        S2814=1;
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

  public void thread3142(int [] tdone, int [] ends){
        switch(S3110){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2906){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
              S2906=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
                S2906=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread3143(tdone,ends);
                thread3144(tdone,ends);
                thread3145(tdone,ends);
                thread3146(tdone,ends);
                int biggest3147 = 0;
                if(ends[10]>=biggest3147){
                  biggest3147=ends[10];
                }
                if(ends[11]>=biggest3147){
                  biggest3147=ends[11];
                }
                if(ends[12]>=biggest3147){
                  biggest3147=ends[12];
                }
                if(ends[13]>=biggest3147){
                  biggest3147=ends[13];
                }
                if(biggest3147 == 1){
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
              S2906=2;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              thread3148(tdone,ends);
              thread3149(tdone,ends);
              thread3150(tdone,ends);
              thread3151(tdone,ends);
              int biggest3152 = 0;
              if(ends[10]>=biggest3152){
                biggest3152=ends[10];
              }
              if(ends[11]>=biggest3152){
                biggest3152=ends[11];
              }
              if(ends[12]>=biggest3152){
                biggest3152=ends[12];
              }
              if(ends[13]>=biggest3152){
                biggest3152=ends[13];
              }
              if(biggest3152 == 1){
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              //FINXME code
              if(biggest3152 == 0){
                S2906=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            break;
          
          case 2 : 
            S2906=2;
            S2906=0;
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
              S2906=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
                S2906=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread3153(tdone,ends);
                thread3154(tdone,ends);
                thread3155(tdone,ends);
                thread3156(tdone,ends);
                int biggest3157 = 0;
                if(ends[10]>=biggest3157){
                  biggest3157=ends[10];
                }
                if(ends[11]>=biggest3157){
                  biggest3157=ends[11];
                }
                if(ends[12]>=biggest3157){
                  biggest3157=ends[12];
                }
                if(ends[13]>=biggest3157){
                  biggest3157=ends[13];
                }
                if(biggest3157 == 1){
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

  public void thread3141(int [] tdone, int [] ends){
        switch(S2805){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2793){
          case 0 : 
            if(empty.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 10
              refill.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 4
              currsigs.addElement(refill);
              S2793=1;
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
              S2793=0;
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

  public void thread3139(int [] tdone, int [] ends){
        switch(S2240){
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

  public void thread3138(int [] tdone, int [] ends){
        switch(S2235){
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

  public void thread3136(int [] tdone, int [] ends){
        S2240=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 34
    currsigs.addElement(vacOn);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3135(int [] tdone, int [] ends){
        S2235=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 14
    currsigs.addElement(armDest);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3134(int [] tdone, int [] ends){
        switch(S2791){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2395){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
              S2395=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
                S2395=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
                  S2204=0;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S2395=2;
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
              S2395=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S2204){
                case 0 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 39, column: 18
                    S2204=1;
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
                  S2204=1;
                  S2204=2;
                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 43, column: 20
                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 45, column: 14
                    currsigs.addElement(pusherExtend);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    S2204=3;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 44, column: 19
                    S2204=3;
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
                  S2204=3;
                  S2204=4;
                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 50, column: 13
                  currsigs.addElement(armSource);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 4 : 
                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 49, column: 18
                    S2204=5;
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
                  S2204=5;
                  S2204=6;
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 54, column: 13
                  currsigs.addElement(vacOn);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 6 : 
                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 53, column: 18
                    S2204=7;
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
                  S2204=7;
                  S2204=8;
                  thread3135(tdone,ends);
                  thread3136(tdone,ends);
                  int biggest3137 = 0;
                  if(ends[6]>=biggest3137){
                    biggest3137=ends[6];
                  }
                  if(ends[7]>=biggest3137){
                    biggest3137=ends[7];
                  }
                  if(biggest3137 == 1){
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 8 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 57, column: 18
                    S2204=9;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    thread3138(tdone,ends);
                    thread3139(tdone,ends);
                    int biggest3140 = 0;
                    if(ends[6]>=biggest3140){
                      biggest3140=ends[6];
                    }
                    if(ends[7]>=biggest3140){
                      biggest3140=ends[7];
                    }
                    if(biggest3140 == 1){
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    //FINXME code
                    if(biggest3140 == 0){
                      S2204=9;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                  break;
                
                case 9 : 
                  S2204=9;
                  S2204=10;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 10 : 
                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 18
                    S2204=11;
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
                  S2204=11;
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 63, column: 12
                  currsigs.addElement(vacOn);
                  S2204=12;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 65, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 12 : 
                  if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 64, column: 18
                    S2204=13;
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
                  S2204=13;
                  lidLoaderLoaded.setPresent();//sysj\lidLoaderController.sysj line: 68, column: 21
                  currsigs.addElement(lidLoaderLoaded);
                  S2395=2;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S2395=2;
            S2395=0;
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
              S2395=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
                S2395=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
                  S2204=0;
                  armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S2395=2;
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

  public void thread3132(int [] tdone, int [] ends){
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

  public void thread3131(int [] tdone, int [] ends){
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

  public void thread3129(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread3128(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread3126(int [] tdone, int [] ends){
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

  public void thread3125(int [] tdone, int [] ends){
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

  public void thread3124(int [] tdone, int [] ends){
        switch(S2198){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2149){
          case 0 : 
            S2149=0;
            auto_1.setPresent();//sysj\lidLoaderController.sysj line: 19, column: 3
            currsigs.addElement(auto_1);
            S2149=1;
            S2157=0;
            if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 21, column: 12
              thread3125(tdone,ends);
              thread3126(tdone,ends);
              int biggest3127 = 0;
              if(ends[3]>=biggest3127){
                biggest3127=ends[3];
              }
              if(ends[4]>=biggest3127){
                biggest3127=ends[4];
              }
              //FINXME code
              if(biggest3127 == 0){
                S2157=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S2157=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            switch(S2157){
              case 0 : 
                thread3128(tdone,ends);
                thread3129(tdone,ends);
                int biggest3130 = 0;
                if(ends[3]>=biggest3130){
                  biggest3130=ends[3];
                }
                if(ends[4]>=biggest3130){
                  biggest3130=ends[4];
                }
                //FINXME code
                if(biggest3130 == 0){
                  S2157=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S2157=1;
                S2157=0;
                if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 21, column: 12
                  thread3131(tdone,ends);
                  thread3132(tdone,ends);
                  int biggest3133 = 0;
                  if(ends[3]>=biggest3133){
                    biggest3133=ends[3];
                  }
                  if(ends[4]>=biggest3133){
                    biggest3133=ends[4];
                  }
                  //FINXME code
                  if(biggest3133 == 0){
                    S2157=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  S2157=1;
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

  public void thread3121(int [] tdone, int [] ends){
        S2838=1;
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

  public void thread3120(int [] tdone, int [] ends){
        S2830=1;
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

  public void thread3119(int [] tdone, int [] ends){
        S2822=1;
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

  public void thread3118(int [] tdone, int [] ends){
        S2814=1;
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

  public void thread3117(int [] tdone, int [] ends){
        S3110=1;
    S2906=0;
    if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 20
      S2906=1;
      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 88, column: 20
        S2906=2;
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
      }
      else {
        thread3118(tdone,ends);
        thread3119(tdone,ends);
        thread3120(tdone,ends);
        thread3121(tdone,ends);
        int biggest3122 = 0;
        if(ends[10]>=biggest3122){
          biggest3122=ends[10];
        }
        if(ends[11]>=biggest3122){
          biggest3122=ends[11];
        }
        if(ends[12]>=biggest3122){
          biggest3122=ends[12];
        }
        if(ends[13]>=biggest3122){
          biggest3122=ends[13];
        }
        if(biggest3122 == 1){
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

  public void thread3116(int [] tdone, int [] ends){
        S2805=1;
    S2793=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread3115(int [] tdone, int [] ends){
        S2791=1;
    S2395=0;
    if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 34, column: 29
      S2395=1;
      if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 29
        S2395=2;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        if(lidLoaderLoad.getprestatus()){//sysj\lidLoaderController.sysj line: 37, column: 19
          S2204=0;
          armDest.setPresent();//sysj\lidLoaderController.sysj line: 40, column: 13
          currsigs.addElement(armDest);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          S2395=2;
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

  public void thread3114(int [] tdone, int [] ends){
        S2198=1;
    S2149=0;
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
      switch(S3112){
        case 0 : 
          S3112=0;
          break RUN;
        
        case 1 : 
          S3112=2;
          S3112=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          thread3114(tdone,ends);
          thread3115(tdone,ends);
          thread3116(tdone,ends);
          thread3117(tdone,ends);
          int biggest3123 = 0;
          if(ends[2]>=biggest3123){
            biggest3123=ends[2];
          }
          if(ends[5]>=biggest3123){
            biggest3123=ends[5];
          }
          if(ends[8]>=biggest3123){
            biggest3123=ends[8];
          }
          if(ends[9]>=biggest3123){
            biggest3123=ends[9];
          }
          if(biggest3123 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 15, column: 2
          thread3124(tdone,ends);
          thread3134(tdone,ends);
          thread3141(tdone,ends);
          thread3142(tdone,ends);
          int biggest3158 = 0;
          if(ends[2]>=biggest3158){
            biggest3158=ends[2];
          }
          if(ends[5]>=biggest3158){
            biggest3158=ends[5];
          }
          if(ends[8]>=biggest3158){
            biggest3158=ends[8];
          }
          if(ends[9]>=biggest3158){
            biggest3158=ends[9];
          }
          if(biggest3158 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3158 == 0){
            S3112=0;
            active[1]=0;
            ends[1]=0;
            S3112=0;
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
