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
  private int S8733 = 1;
  private int S7819 = 1;
  private int S7770 = 1;
  private int S7778 = 1;
  private int S8412 = 1;
  private int S8016 = 1;
  private int S7825 = 1;
  private int S7856 = 1;
  private int S7861 = 1;
  private int S8426 = 1;
  private int S8414 = 1;
  private int S8731 = 1;
  private int S8527 = 1;
  private int S8435 = 1;
  private int S8443 = 1;
  private int S8451 = 1;
  private int S8459 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread8777(int [] tdone, int [] ends){
        S8459=1;
    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 27
      armDest.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 37
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

  public void thread8776(int [] tdone, int [] ends){
        S8451=1;
    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 93, column: 27
      armSource.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 39
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

  public void thread8775(int [] tdone, int [] ends){
        S8443=1;
    if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 91, column: 27
      vacOn.setPresent();//sysj/lidLoaderController.sysj line: 91, column: 35
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

  public void thread8774(int [] tdone, int [] ends){
        S8435=1;
    if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 89, column: 27
      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 89, column: 42
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

  public void thread8772(int [] tdone, int [] ends){
        switch(S8459){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 27
          armDest.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 37
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

  public void thread8771(int [] tdone, int [] ends){
        switch(S8451){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 93, column: 27
          armSource.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 39
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

  public void thread8770(int [] tdone, int [] ends){
        switch(S8443){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 91, column: 27
          vacOn.setPresent();//sysj/lidLoaderController.sysj line: 91, column: 35
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

  public void thread8769(int [] tdone, int [] ends){
        switch(S8435){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 89, column: 27
          pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 89, column: 42
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

  public void thread8767(int [] tdone, int [] ends){
        S8459=1;
    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 27
      armDest.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 37
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

  public void thread8766(int [] tdone, int [] ends){
        S8451=1;
    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 93, column: 27
      armSource.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 39
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

  public void thread8765(int [] tdone, int [] ends){
        S8443=1;
    if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 91, column: 27
      vacOn.setPresent();//sysj/lidLoaderController.sysj line: 91, column: 35
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

  public void thread8764(int [] tdone, int [] ends){
        S8435=1;
    if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 89, column: 27
      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 89, column: 42
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

  public void thread8763(int [] tdone, int [] ends){
        switch(S8731){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S8527){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 20
              S8527=1;
              if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 88, column: 20
                S8527=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread8764(tdone,ends);
                thread8765(tdone,ends);
                thread8766(tdone,ends);
                thread8767(tdone,ends);
                int biggest8768 = 0;
                if(ends[10]>=biggest8768){
                  biggest8768=ends[10];
                }
                if(ends[11]>=biggest8768){
                  biggest8768=ends[11];
                }
                if(ends[12]>=biggest8768){
                  biggest8768=ends[12];
                }
                if(ends[13]>=biggest8768){
                  biggest8768=ends[13];
                }
                if(biggest8768 == 1){
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
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 88, column: 20
              S8527=2;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              thread8769(tdone,ends);
              thread8770(tdone,ends);
              thread8771(tdone,ends);
              thread8772(tdone,ends);
              int biggest8773 = 0;
              if(ends[10]>=biggest8773){
                biggest8773=ends[10];
              }
              if(ends[11]>=biggest8773){
                biggest8773=ends[11];
              }
              if(ends[12]>=biggest8773){
                biggest8773=ends[12];
              }
              if(ends[13]>=biggest8773){
                biggest8773=ends[13];
              }
              if(biggest8773 == 1){
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              //FINXME code
              if(biggest8773 == 0){
                S8527=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            break;
          
          case 2 : 
            S8527=2;
            S8527=0;
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 20
              S8527=1;
              if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 88, column: 20
                S8527=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread8774(tdone,ends);
                thread8775(tdone,ends);
                thread8776(tdone,ends);
                thread8777(tdone,ends);
                int biggest8778 = 0;
                if(ends[10]>=biggest8778){
                  biggest8778=ends[10];
                }
                if(ends[11]>=biggest8778){
                  biggest8778=ends[11];
                }
                if(ends[12]>=biggest8778){
                  biggest8778=ends[12];
                }
                if(ends[13]>=biggest8778){
                  biggest8778=ends[13];
                }
                if(biggest8778 == 1){
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

  public void thread8762(int [] tdone, int [] ends){
        switch(S8426){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S8414){
          case 0 : 
            if(empty.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 10
              refill.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 4
              currsigs.addElement(refill);
              S8414=1;
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
            if(refilled.getprestatus()){//sysj/lidLoaderController.sysj line: 80, column: 10
              S8414=0;
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

  public void thread8760(int [] tdone, int [] ends){
        switch(S7861){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj/lidLoaderController.sysj line: 58, column: 34
        currsigs.addElement(vacOn);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread8759(int [] tdone, int [] ends){
        switch(S7856){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj/lidLoaderController.sysj line: 58, column: 14
        currsigs.addElement(armDest);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread8757(int [] tdone, int [] ends){
        S7861=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 58, column: 34
    currsigs.addElement(vacOn);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread8756(int [] tdone, int [] ends){
        S7856=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 58, column: 14
    currsigs.addElement(armDest);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread8755(int [] tdone, int [] ends){
        switch(S8412){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S8016){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 34, column: 29
              S8016=1;
              if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 29
                S8016=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj/lidLoaderController.sysj line: 37, column: 19
                  S7825=0;
                  armDest.setPresent();//sysj/lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S8016=2;
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
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 29
              S8016=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S7825){
                case 0 : 
                  if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 39, column: 18
                    S7825=1;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    armDest.setPresent();//sysj/lidLoaderController.sysj line: 40, column: 13
                    currsigs.addElement(armDest);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 1 : 
                  S7825=1;
                  S7825=2;
                  if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 43, column: 20
                    pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 45, column: 14
                    currsigs.addElement(pusherExtend);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    S7825=3;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 44, column: 19
                    S7825=3;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 45, column: 14
                    currsigs.addElement(pusherExtend);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 3 : 
                  S7825=3;
                  S7825=4;
                  armSource.setPresent();//sysj/lidLoaderController.sysj line: 50, column: 13
                  currsigs.addElement(armSource);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 4 : 
                  if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 49, column: 18
                    S7825=5;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    armSource.setPresent();//sysj/lidLoaderController.sysj line: 50, column: 13
                    currsigs.addElement(armSource);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 5 : 
                  S7825=5;
                  S7825=6;
                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 54, column: 13
                  currsigs.addElement(vacOn);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 6 : 
                  if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 53, column: 18
                    S7825=7;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 54, column: 13
                    currsigs.addElement(vacOn);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 7 : 
                  S7825=7;
                  S7825=8;
                  thread8756(tdone,ends);
                  thread8757(tdone,ends);
                  int biggest8758 = 0;
                  if(ends[6]>=biggest8758){
                    biggest8758=ends[6];
                  }
                  if(ends[7]>=biggest8758){
                    biggest8758=ends[7];
                  }
                  if(biggest8758 == 1){
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 8 : 
                  if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 57, column: 18
                    S7825=9;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    thread8759(tdone,ends);
                    thread8760(tdone,ends);
                    int biggest8761 = 0;
                    if(ends[6]>=biggest8761){
                      biggest8761=ends[6];
                    }
                    if(ends[7]>=biggest8761){
                      biggest8761=ends[7];
                    }
                    if(biggest8761 == 1){
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    //FINXME code
                    if(biggest8761 == 0){
                      S7825=9;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                  break;
                
                case 9 : 
                  S7825=9;
                  S7825=10;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 10 : 
                  if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 61, column: 18
                    S7825=11;
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
                  S7825=11;
                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 63, column: 12
                  currsigs.addElement(vacOn);
                  S7825=12;
                  armDest.setPresent();//sysj/lidLoaderController.sysj line: 65, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 12 : 
                  if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 64, column: 18
                    S7825=13;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    armDest.setPresent();//sysj/lidLoaderController.sysj line: 65, column: 13
                    currsigs.addElement(armDest);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 13 : 
                  S7825=13;
                  lidLoaderLoaded.setPresent();//sysj/lidLoaderController.sysj line: 68, column: 21
                  currsigs.addElement(lidLoaderLoaded);
                  S8016=2;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S8016=2;
            S8016=0;
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 34, column: 29
              S8016=1;
              if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 29
                S8016=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj/lidLoaderController.sysj line: 37, column: 19
                  S7825=0;
                  armDest.setPresent();//sysj/lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S8016=2;
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

  public void thread8753(int [] tdone, int [] ends){
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj/lidLoaderController.sysj line: 25, column: 10
      manual_1.setPresent();//sysj/lidLoaderController.sysj line: 25, column: 32
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

  public void thread8752(int [] tdone, int [] ends){
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/lidLoaderController.sysj line: 23, column: 10
      auto_1.setPresent();//sysj/lidLoaderController.sysj line: 23, column: 32
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

  public void thread8750(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread8749(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread8747(int [] tdone, int [] ends){
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj/lidLoaderController.sysj line: 25, column: 10
      manual_1.setPresent();//sysj/lidLoaderController.sysj line: 25, column: 32
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

  public void thread8746(int [] tdone, int [] ends){
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/lidLoaderController.sysj line: 23, column: 10
      auto_1.setPresent();//sysj/lidLoaderController.sysj line: 23, column: 32
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

  public void thread8745(int [] tdone, int [] ends){
        switch(S7819){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S7770){
          case 0 : 
            S7770=0;
            auto_1.setPresent();//sysj/lidLoaderController.sysj line: 19, column: 3
            currsigs.addElement(auto_1);
            S7770=1;
            S7778=0;
            if(mode.getprestatus()){//sysj/lidLoaderController.sysj line: 21, column: 12
              thread8746(tdone,ends);
              thread8747(tdone,ends);
              int biggest8748 = 0;
              if(ends[3]>=biggest8748){
                biggest8748=ends[3];
              }
              if(ends[4]>=biggest8748){
                biggest8748=ends[4];
              }
              //FINXME code
              if(biggest8748 == 0){
                S7778=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S7778=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            switch(S7778){
              case 0 : 
                thread8749(tdone,ends);
                thread8750(tdone,ends);
                int biggest8751 = 0;
                if(ends[3]>=biggest8751){
                  biggest8751=ends[3];
                }
                if(ends[4]>=biggest8751){
                  biggest8751=ends[4];
                }
                //FINXME code
                if(biggest8751 == 0){
                  S7778=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S7778=1;
                S7778=0;
                if(mode.getprestatus()){//sysj/lidLoaderController.sysj line: 21, column: 12
                  thread8752(tdone,ends);
                  thread8753(tdone,ends);
                  int biggest8754 = 0;
                  if(ends[3]>=biggest8754){
                    biggest8754=ends[3];
                  }
                  if(ends[4]>=biggest8754){
                    biggest8754=ends[4];
                  }
                  //FINXME code
                  if(biggest8754 == 0){
                    S7778=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  S7778=1;
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

  public void thread8742(int [] tdone, int [] ends){
        S8459=1;
    if(armDestM.getprestatus()){//sysj/lidLoaderController.sysj line: 95, column: 27
      armDest.setPresent();//sysj/lidLoaderController.sysj line: 95, column: 37
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

  public void thread8741(int [] tdone, int [] ends){
        S8451=1;
    if(armSourceM.getprestatus()){//sysj/lidLoaderController.sysj line: 93, column: 27
      armSource.setPresent();//sysj/lidLoaderController.sysj line: 93, column: 39
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

  public void thread8740(int [] tdone, int [] ends){
        S8443=1;
    if(vacOnM.getprestatus()){//sysj/lidLoaderController.sysj line: 91, column: 27
      vacOn.setPresent();//sysj/lidLoaderController.sysj line: 91, column: 35
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

  public void thread8739(int [] tdone, int [] ends){
        S8435=1;
    if(pusherExtendM.getprestatus()){//sysj/lidLoaderController.sysj line: 89, column: 27
      pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 89, column: 42
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

  public void thread8738(int [] tdone, int [] ends){
        S8731=1;
    S8527=0;
    if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 20
      S8527=1;
      if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 88, column: 20
        S8527=2;
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
      }
      else {
        thread8739(tdone,ends);
        thread8740(tdone,ends);
        thread8741(tdone,ends);
        thread8742(tdone,ends);
        int biggest8743 = 0;
        if(ends[10]>=biggest8743){
          biggest8743=ends[10];
        }
        if(ends[11]>=biggest8743){
          biggest8743=ends[11];
        }
        if(ends[12]>=biggest8743){
          biggest8743=ends[12];
        }
        if(ends[13]>=biggest8743){
          biggest8743=ends[13];
        }
        if(biggest8743 == 1){
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

  public void thread8737(int [] tdone, int [] ends){
        S8426=1;
    S8414=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread8736(int [] tdone, int [] ends){
        S8412=1;
    S8016=0;
    if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 34, column: 29
      S8016=1;
      if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 29
        S8016=2;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        if(lidLoaderLoad.getprestatus()){//sysj/lidLoaderController.sysj line: 37, column: 19
          S7825=0;
          armDest.setPresent();//sysj/lidLoaderController.sysj line: 40, column: 13
          currsigs.addElement(armDest);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          S8016=2;
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

  public void thread8735(int [] tdone, int [] ends){
        S7819=1;
    S7770=0;
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
      switch(S8733){
        case 0 : 
          S8733=0;
          break RUN;
        
        case 1 : 
          S8733=2;
          S8733=2;
          auto_1.setClear();//sysj/lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj/lidLoaderController.sysj line: 15, column: 2
          thread8735(tdone,ends);
          thread8736(tdone,ends);
          thread8737(tdone,ends);
          thread8738(tdone,ends);
          int biggest8744 = 0;
          if(ends[2]>=biggest8744){
            biggest8744=ends[2];
          }
          if(ends[5]>=biggest8744){
            biggest8744=ends[5];
          }
          if(ends[8]>=biggest8744){
            biggest8744=ends[8];
          }
          if(ends[9]>=biggest8744){
            biggest8744=ends[9];
          }
          if(biggest8744 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj/lidLoaderController.sysj line: 15, column: 2
          thread8745(tdone,ends);
          thread8755(tdone,ends);
          thread8762(tdone,ends);
          thread8763(tdone,ends);
          int biggest8779 = 0;
          if(ends[2]>=biggest8779){
            biggest8779=ends[2];
          }
          if(ends[5]>=biggest8779){
            biggest8779=ends[5];
          }
          if(ends[8]>=biggest8779){
            biggest8779=ends[8];
          }
          if(ends[9]>=biggest8779){
            biggest8779=ends[9];
          }
          if(biggest8779 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest8779 == 0){
            S8733=0;
            active[1]=0;
            ends[1]=0;
            S8733=0;
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
