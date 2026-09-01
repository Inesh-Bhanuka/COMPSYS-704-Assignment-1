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
  private int S1622 = 1;
  private int S708 = 1;
  private int S659 = 1;
  private int S667 = 1;
  private int S1301 = 1;
  private int S905 = 1;
  private int S714 = 1;
  private int S745 = 1;
  private int S750 = 1;
  private int S1315 = 1;
  private int S1303 = 1;
  private int S1620 = 1;
  private int S1416 = 1;
  private int S1324 = 1;
  private int S1332 = 1;
  private int S1340 = 1;
  private int S1348 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread1666(int [] tdone, int [] ends){
        S1348=1;
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

  public void thread1665(int [] tdone, int [] ends){
        S1340=1;
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

  public void thread1664(int [] tdone, int [] ends){
        S1332=1;
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

  public void thread1663(int [] tdone, int [] ends){
        S1324=1;
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

  public void thread1661(int [] tdone, int [] ends){
        switch(S1348){
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

  public void thread1660(int [] tdone, int [] ends){
        switch(S1340){
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

  public void thread1659(int [] tdone, int [] ends){
        switch(S1332){
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

  public void thread1658(int [] tdone, int [] ends){
        switch(S1324){
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

  public void thread1656(int [] tdone, int [] ends){
        S1348=1;
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

  public void thread1655(int [] tdone, int [] ends){
        S1340=1;
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

  public void thread1654(int [] tdone, int [] ends){
        S1332=1;
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

  public void thread1653(int [] tdone, int [] ends){
        S1324=1;
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

  public void thread1652(int [] tdone, int [] ends){
        switch(S1620){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1416){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 20
              S1416=1;
              if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 88, column: 20
                S1416=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread1653(tdone,ends);
                thread1654(tdone,ends);
                thread1655(tdone,ends);
                thread1656(tdone,ends);
                int biggest1657 = 0;
                if(ends[10]>=biggest1657){
                  biggest1657=ends[10];
                }
                if(ends[11]>=biggest1657){
                  biggest1657=ends[11];
                }
                if(ends[12]>=biggest1657){
                  biggest1657=ends[12];
                }
                if(ends[13]>=biggest1657){
                  biggest1657=ends[13];
                }
                if(biggest1657 == 1){
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
              S1416=2;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              thread1658(tdone,ends);
              thread1659(tdone,ends);
              thread1660(tdone,ends);
              thread1661(tdone,ends);
              int biggest1662 = 0;
              if(ends[10]>=biggest1662){
                biggest1662=ends[10];
              }
              if(ends[11]>=biggest1662){
                biggest1662=ends[11];
              }
              if(ends[12]>=biggest1662){
                biggest1662=ends[12];
              }
              if(ends[13]>=biggest1662){
                biggest1662=ends[13];
              }
              if(biggest1662 == 1){
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              //FINXME code
              if(biggest1662 == 0){
                S1416=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            break;
          
          case 2 : 
            S1416=2;
            S1416=0;
            if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 20
              S1416=1;
              if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 88, column: 20
                S1416=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                thread1663(tdone,ends);
                thread1664(tdone,ends);
                thread1665(tdone,ends);
                thread1666(tdone,ends);
                int biggest1667 = 0;
                if(ends[10]>=biggest1667){
                  biggest1667=ends[10];
                }
                if(ends[11]>=biggest1667){
                  biggest1667=ends[11];
                }
                if(ends[12]>=biggest1667){
                  biggest1667=ends[12];
                }
                if(ends[13]>=biggest1667){
                  biggest1667=ends[13];
                }
                if(biggest1667 == 1){
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

  public void thread1651(int [] tdone, int [] ends){
        switch(S1315){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1303){
          case 0 : 
            if(empty.getprestatus()){//sysj/lidLoaderController.sysj line: 78, column: 10
              refill.setPresent();//sysj/lidLoaderController.sysj line: 79, column: 4
              currsigs.addElement(refill);
              S1303=1;
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
              S1303=0;
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

  public void thread1649(int [] tdone, int [] ends){
        switch(S750){
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

  public void thread1648(int [] tdone, int [] ends){
        switch(S745){
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

  public void thread1646(int [] tdone, int [] ends){
        S750=1;
    vacOn.setPresent();//sysj/lidLoaderController.sysj line: 58, column: 34
    currsigs.addElement(vacOn);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1645(int [] tdone, int [] ends){
        S745=1;
    armDest.setPresent();//sysj/lidLoaderController.sysj line: 58, column: 14
    currsigs.addElement(armDest);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1644(int [] tdone, int [] ends){
        switch(S1301){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S905){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 34, column: 29
              S905=1;
              if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 29
                S905=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj/lidLoaderController.sysj line: 37, column: 19
                  S714=0;
                  armDest.setPresent();//sysj/lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S905=2;
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
              S905=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S714){
                case 0 : 
                  if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 39, column: 18
                    S714=1;
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
                  S714=1;
                  S714=2;
                  if(pusherRetracted.getprestatus()){//sysj/lidLoaderController.sysj line: 43, column: 20
                    pusherExtend.setPresent();//sysj/lidLoaderController.sysj line: 45, column: 14
                    currsigs.addElement(pusherExtend);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    S714=3;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherExtended.getprestatus()){//sysj/lidLoaderController.sysj line: 44, column: 19
                    S714=3;
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
                  S714=3;
                  S714=4;
                  armSource.setPresent();//sysj/lidLoaderController.sysj line: 50, column: 13
                  currsigs.addElement(armSource);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 4 : 
                  if(armAtSource.getprestatus()){//sysj/lidLoaderController.sysj line: 49, column: 18
                    S714=5;
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
                  S714=5;
                  S714=6;
                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 54, column: 13
                  currsigs.addElement(vacOn);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 6 : 
                  if(WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 53, column: 18
                    S714=7;
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
                  S714=7;
                  S714=8;
                  thread1645(tdone,ends);
                  thread1646(tdone,ends);
                  int biggest1647 = 0;
                  if(ends[6]>=biggest1647){
                    biggest1647=ends[6];
                  }
                  if(ends[7]>=biggest1647){
                    biggest1647=ends[7];
                  }
                  if(biggest1647 == 1){
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 8 : 
                  if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 57, column: 18
                    S714=9;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    thread1648(tdone,ends);
                    thread1649(tdone,ends);
                    int biggest1650 = 0;
                    if(ends[6]>=biggest1650){
                      biggest1650=ends[6];
                    }
                    if(ends[7]>=biggest1650){
                      biggest1650=ends[7];
                    }
                    if(biggest1650 == 1){
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    //FINXME code
                    if(biggest1650 == 0){
                      S714=9;
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                  break;
                
                case 9 : 
                  S714=9;
                  S714=10;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 10 : 
                  if(!WPgripped.getprestatus()){//sysj/lidLoaderController.sysj line: 61, column: 18
                    S714=11;
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
                  S714=11;
                  vacOn.setPresent();//sysj/lidLoaderController.sysj line: 63, column: 12
                  currsigs.addElement(vacOn);
                  S714=12;
                  armDest.setPresent();//sysj/lidLoaderController.sysj line: 65, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
                case 12 : 
                  if(armAtDest.getprestatus()){//sysj/lidLoaderController.sysj line: 64, column: 18
                    S714=13;
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
                  S714=13;
                  lidLoaderLoaded.setPresent();//sysj/lidLoaderController.sysj line: 68, column: 21
                  currsigs.addElement(lidLoaderLoaded);
                  S905=2;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S905=2;
            S905=0;
            if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 34, column: 29
              S905=1;
              if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 29
                S905=2;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                if(lidLoaderLoad.getprestatus()){//sysj/lidLoaderController.sysj line: 37, column: 19
                  S714=0;
                  armDest.setPresent();//sysj/lidLoaderController.sysj line: 40, column: 13
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S905=2;
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

  public void thread1642(int [] tdone, int [] ends){
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

  public void thread1641(int [] tdone, int [] ends){
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

  public void thread1639(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread1638(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread1636(int [] tdone, int [] ends){
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

  public void thread1635(int [] tdone, int [] ends){
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

  public void thread1634(int [] tdone, int [] ends){
        switch(S708){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S659){
          case 0 : 
            S659=0;
            auto_1.setPresent();//sysj/lidLoaderController.sysj line: 19, column: 3
            currsigs.addElement(auto_1);
            S659=1;
            S667=0;
            if(mode.getprestatus()){//sysj/lidLoaderController.sysj line: 21, column: 12
              thread1635(tdone,ends);
              thread1636(tdone,ends);
              int biggest1637 = 0;
              if(ends[3]>=biggest1637){
                biggest1637=ends[3];
              }
              if(ends[4]>=biggest1637){
                biggest1637=ends[4];
              }
              //FINXME code
              if(biggest1637 == 0){
                S667=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S667=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            switch(S667){
              case 0 : 
                thread1638(tdone,ends);
                thread1639(tdone,ends);
                int biggest1640 = 0;
                if(ends[3]>=biggest1640){
                  biggest1640=ends[3];
                }
                if(ends[4]>=biggest1640){
                  biggest1640=ends[4];
                }
                //FINXME code
                if(biggest1640 == 0){
                  S667=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S667=1;
                S667=0;
                if(mode.getprestatus()){//sysj/lidLoaderController.sysj line: 21, column: 12
                  thread1641(tdone,ends);
                  thread1642(tdone,ends);
                  int biggest1643 = 0;
                  if(ends[3]>=biggest1643){
                    biggest1643=ends[3];
                  }
                  if(ends[4]>=biggest1643){
                    biggest1643=ends[4];
                  }
                  //FINXME code
                  if(biggest1643 == 0){
                    S667=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  S667=1;
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

  public void thread1631(int [] tdone, int [] ends){
        S1348=1;
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

  public void thread1630(int [] tdone, int [] ends){
        S1340=1;
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

  public void thread1629(int [] tdone, int [] ends){
        S1332=1;
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

  public void thread1628(int [] tdone, int [] ends){
        S1324=1;
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

  public void thread1627(int [] tdone, int [] ends){
        S1620=1;
    S1416=0;
    if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 86, column: 20
      S1416=1;
      if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 88, column: 20
        S1416=2;
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
      }
      else {
        thread1628(tdone,ends);
        thread1629(tdone,ends);
        thread1630(tdone,ends);
        thread1631(tdone,ends);
        int biggest1632 = 0;
        if(ends[10]>=biggest1632){
          biggest1632=ends[10];
        }
        if(ends[11]>=biggest1632){
          biggest1632=ends[11];
        }
        if(ends[12]>=biggest1632){
          biggest1632=ends[12];
        }
        if(ends[13]>=biggest1632){
          biggest1632=ends[13];
        }
        if(biggest1632 == 1){
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

  public void thread1626(int [] tdone, int [] ends){
        S1315=1;
    S1303=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1625(int [] tdone, int [] ends){
        S1301=1;
    S905=0;
    if(auto_1.getprestatus()){//sysj/lidLoaderController.sysj line: 34, column: 29
      S905=1;
      if(manual_1.getprestatus()){//sysj/lidLoaderController.sysj line: 35, column: 29
        S905=2;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        if(lidLoaderLoad.getprestatus()){//sysj/lidLoaderController.sysj line: 37, column: 19
          S714=0;
          armDest.setPresent();//sysj/lidLoaderController.sysj line: 40, column: 13
          currsigs.addElement(armDest);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          S905=2;
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

  public void thread1624(int [] tdone, int [] ends){
        S708=1;
    S659=0;
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
      switch(S1622){
        case 0 : 
          S1622=0;
          break RUN;
        
        case 1 : 
          S1622=2;
          S1622=2;
          auto_1.setClear();//sysj/lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj/lidLoaderController.sysj line: 15, column: 2
          thread1624(tdone,ends);
          thread1625(tdone,ends);
          thread1626(tdone,ends);
          thread1627(tdone,ends);
          int biggest1633 = 0;
          if(ends[2]>=biggest1633){
            biggest1633=ends[2];
          }
          if(ends[5]>=biggest1633){
            biggest1633=ends[5];
          }
          if(ends[8]>=biggest1633){
            biggest1633=ends[8];
          }
          if(ends[9]>=biggest1633){
            biggest1633=ends[9];
          }
          if(biggest1633 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/lidLoaderController.sysj line: 15, column: 2
          manual_1.setClear();//sysj/lidLoaderController.sysj line: 15, column: 2
          thread1634(tdone,ends);
          thread1644(tdone,ends);
          thread1651(tdone,ends);
          thread1652(tdone,ends);
          int biggest1668 = 0;
          if(ends[2]>=biggest1668){
            biggest1668=ends[2];
          }
          if(ends[5]>=biggest1668){
            biggest1668=ends[5];
          }
          if(ends[8]>=biggest1668){
            biggest1668=ends[8];
          }
          if(ends[9]>=biggest1668){
            biggest1668=ends[9];
          }
          if(biggest1668 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1668 == 0){
            S1622=0;
            active[1]=0;
            ends[1]=0;
            S1622=0;
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
