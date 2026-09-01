import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidLoaderPlant extends ClockDomain{
  public LidLoaderPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal empty = new Signal("empty", Signal.OUTPUT);
  public Signal refilled = new Signal("refilled", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal capPos_1;
  private int capcount_thread_6;//sysj/lidLoaderPlant.sysj line: 76, column: 3
  private int S627 = 1;
  private int S42 = 1;
  private int S14 = 1;
  private int S83 = 1;
  private int S55 = 1;
  private int S127 = 1;
  private int S97 = 1;
  private int S92 = 1;
  private int S195 = 1;
  private int S149 = 1;
  private int S131 = 1;
  private int S263 = 1;
  private int S313 = 1;
  private int S271 = 1;
  private int S279 = 1;
  private int S287 = 1;
  private int S295 = 1;
  private int S303 = 1;
  private int S311 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread654(int [] tdone, int [] ends){
        switch(S311){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj/lidLoaderPlant.sysj line: 103, column: 24
          emptyE.setPresent();//sysj/lidLoaderPlant.sysj line: 103, column: 31
          currsigs.addElement(emptyE);
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

  public void thread653(int [] tdone, int [] ends){
        switch(S303){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj/lidLoaderPlant.sysj line: 101, column: 24
          armAtDestE.setPresent();//sysj/lidLoaderPlant.sysj line: 101, column: 35
          currsigs.addElement(armAtDestE);
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

  public void thread652(int [] tdone, int [] ends){
        switch(S295){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj/lidLoaderPlant.sysj line: 99, column: 24
          armAtSourceE.setPresent();//sysj/lidLoaderPlant.sysj line: 99, column: 37
          currsigs.addElement(armAtSourceE);
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

  public void thread651(int [] tdone, int [] ends){
        switch(S287){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj/lidLoaderPlant.sysj line: 97, column: 24
          WPgrippedE.setPresent();//sysj/lidLoaderPlant.sysj line: 97, column: 35
          currsigs.addElement(WPgrippedE);
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

  public void thread650(int [] tdone, int [] ends){
        switch(S279){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj/lidLoaderPlant.sysj line: 95, column: 24
          pusherExtendedE.setPresent();//sysj/lidLoaderPlant.sysj line: 95, column: 40
          currsigs.addElement(pusherExtendedE);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread649(int [] tdone, int [] ends){
        switch(S271){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj/lidLoaderPlant.sysj line: 93, column: 24
          pusherRetractedE.setPresent();//sysj/lidLoaderPlant.sysj line: 93, column: 41
          currsigs.addElement(pusherRetractedE);
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
  }

  public void thread648(int [] tdone, int [] ends){
        switch(S313){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread649(tdone,ends);
        thread650(tdone,ends);
        thread651(tdone,ends);
        thread652(tdone,ends);
        thread653(tdone,ends);
        thread654(tdone,ends);
        int biggest655 = 0;
        if(ends[8]>=biggest655){
          biggest655=ends[8];
        }
        if(ends[9]>=biggest655){
          biggest655=ends[9];
        }
        if(ends[10]>=biggest655){
          biggest655=ends[10];
        }
        if(ends[11]>=biggest655){
          biggest655=ends[11];
        }
        if(ends[12]>=biggest655){
          biggest655=ends[12];
        }
        if(ends[13]>=biggest655){
          biggest655=ends[13];
        }
        if(biggest655 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest655 == 0){
          S313=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread647(int [] tdone, int [] ends){
        switch(S263){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj/lidLoaderPlant.sysj line: 78, column: 12
          if(capcount_thread_6 > 0) {//sysj/lidLoaderPlant.sysj line: 79, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj/lidLoaderPlant.sysj line: 80, column: 6
          }
          System.out.println("[Plant] capcount = " + capcount_thread_6);//sysj/lidLoaderPlant.sysj line: 81, column: 5
          if(refill.getprestatus()){//sysj/lidLoaderPlant.sysj line: 83, column: 12
            capcount_thread_6 = 5;//sysj/lidLoaderPlant.sysj line: 84, column: 5
            if(capcount_thread_6 == 0){//sysj/lidLoaderPlant.sysj line: 86, column: 7
              empty.setPresent();//sysj/lidLoaderPlant.sysj line: 87, column: 5
              currsigs.addElement(empty);
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
            if(capcount_thread_6 == 0){//sysj/lidLoaderPlant.sysj line: 86, column: 7
              empty.setPresent();//sysj/lidLoaderPlant.sysj line: 87, column: 5
              currsigs.addElement(empty);
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
          if(refill.getprestatus()){//sysj/lidLoaderPlant.sysj line: 83, column: 12
            capcount_thread_6 = 5;//sysj/lidLoaderPlant.sysj line: 84, column: 5
            if(capcount_thread_6 == 0){//sysj/lidLoaderPlant.sysj line: 86, column: 7
              empty.setPresent();//sysj/lidLoaderPlant.sysj line: 87, column: 5
              currsigs.addElement(empty);
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
            if(capcount_thread_6 == 0){//sysj/lidLoaderPlant.sysj line: 86, column: 7
              empty.setPresent();//sysj/lidLoaderPlant.sysj line: 87, column: 5
              currsigs.addElement(empty);
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
        break;
      
    }
  }

  public void thread646(int [] tdone, int [] ends){
        switch(S195){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S149){
          case 0 : 
            if(empty.getprestatus()){//sysj/lidLoaderPlant.sysj line: 60, column: 10
              S149=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S131){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj/lidLoaderPlant.sysj line: 62, column: 13
                    S131=1;
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
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj/lidLoaderPlant.sysj line: 63, column: 13
                    capPos_1.setPresent();//sysj/lidLoaderPlant.sysj line: 65, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj/lidLoaderPlant.sysj line: 65, column: 7
                    S131=2;
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
                
                case 2 : 
                  if(pusherRetracted.getprestatus()){//sysj/lidLoaderPlant.sysj line: 66, column: 13
                    capDec_1.setPresent();//sysj/lidLoaderPlant.sysj line: 67, column: 7
                    currsigs.addElement(capDec_1);
                    S131=0;
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
                
              }
            }
            break;
          
          case 1 : 
            if(refill.getprestatus()){//sysj/lidLoaderPlant.sysj line: 70, column: 10
              refilled.setPresent();//sysj/lidLoaderPlant.sysj line: 71, column: 4
              currsigs.addElement(refilled);
              S149=0;
              S131=0;
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
          
        }
        break;
      
    }
  }

  public void thread645(int [] tdone, int [] ends){
        switch(S127){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S97){
          case 0 : 
            switch(S92){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj/lidLoaderPlant.sysj line: 40, column: 12
                  S92=1;
                  if(armAtSource.getprestatus()){//sysj/lidLoaderPlant.sysj line: 43, column: 14
                    capPos_1.setPresent();//sysj/lidLoaderPlant.sysj line: 44, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj/lidLoaderPlant.sysj line: 44, column: 7
                    S97=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S97=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj/lidLoaderPlant.sysj line: 41, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S97=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj/lidLoaderPlant.sysj line: 37, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj/lidLoaderPlant.sysj line: 38, column: 8
                    capPos_1.setPresent();//sysj/lidLoaderPlant.sysj line: 39, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj/lidLoaderPlant.sysj line: 39, column: 6
                    S92=0;
                    WPgripped.setPresent();//sysj/lidLoaderPlant.sysj line: 41, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S97=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S97=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S97=1;
            S97=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj/lidLoaderPlant.sysj line: 37, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj/lidLoaderPlant.sysj line: 38, column: 8
                capPos_1.setPresent();//sysj/lidLoaderPlant.sysj line: 39, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj/lidLoaderPlant.sysj line: 39, column: 6
                S92=0;
                WPgripped.setPresent();//sysj/lidLoaderPlant.sysj line: 41, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S97=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S97=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread644(int [] tdone, int [] ends){
        switch(S83){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S55){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj/lidLoaderPlant.sysj line: 26, column: 10
              S55=1;
              pusherExtended.setPresent();//sysj/lidLoaderPlant.sysj line: 30, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj/lidLoaderPlant.sysj line: 27, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj/lidLoaderPlant.sysj line: 29, column: 10
              S55=0;
              pusherRetracted.setPresent();//sysj/lidLoaderPlant.sysj line: 27, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj/lidLoaderPlant.sysj line: 30, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread643(int [] tdone, int [] ends){
        switch(S42){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S14){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj/lidLoaderPlant.sysj line: 15, column: 10
              S14=1;
              armAtSource.setPresent();//sysj/lidLoaderPlant.sysj line: 19, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj/lidLoaderPlant.sysj line: 16, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(armDest.getprestatus() && enable.getprestatus()){//sysj/lidLoaderPlant.sysj line: 18, column: 10
              S14=0;
              armAtDest.setPresent();//sysj/lidLoaderPlant.sysj line: 16, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj/lidLoaderPlant.sysj line: 19, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread640(int [] tdone, int [] ends){
        S311=1;
    if(empty.getprestatus()){//sysj/lidLoaderPlant.sysj line: 103, column: 24
      emptyE.setPresent();//sysj/lidLoaderPlant.sysj line: 103, column: 31
      currsigs.addElement(emptyE);
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

  public void thread639(int [] tdone, int [] ends){
        S303=1;
    if(armAtDest.getprestatus()){//sysj/lidLoaderPlant.sysj line: 101, column: 24
      armAtDestE.setPresent();//sysj/lidLoaderPlant.sysj line: 101, column: 35
      currsigs.addElement(armAtDestE);
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

  public void thread638(int [] tdone, int [] ends){
        S295=1;
    if(armAtSource.getprestatus()){//sysj/lidLoaderPlant.sysj line: 99, column: 24
      armAtSourceE.setPresent();//sysj/lidLoaderPlant.sysj line: 99, column: 37
      currsigs.addElement(armAtSourceE);
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

  public void thread637(int [] tdone, int [] ends){
        S287=1;
    if(WPgripped.getprestatus()){//sysj/lidLoaderPlant.sysj line: 97, column: 24
      WPgrippedE.setPresent();//sysj/lidLoaderPlant.sysj line: 97, column: 35
      currsigs.addElement(WPgrippedE);
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

  public void thread636(int [] tdone, int [] ends){
        S279=1;
    if(pusherExtended.getprestatus()){//sysj/lidLoaderPlant.sysj line: 95, column: 24
      pusherExtendedE.setPresent();//sysj/lidLoaderPlant.sysj line: 95, column: 40
      currsigs.addElement(pusherExtendedE);
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread635(int [] tdone, int [] ends){
        S271=1;
    if(pusherRetracted.getprestatus()){//sysj/lidLoaderPlant.sysj line: 93, column: 24
      pusherRetractedE.setPresent();//sysj/lidLoaderPlant.sysj line: 93, column: 41
      currsigs.addElement(pusherRetractedE);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread634(int [] tdone, int [] ends){
        S313=1;
    thread635(tdone,ends);
    thread636(tdone,ends);
    thread637(tdone,ends);
    thread638(tdone,ends);
    thread639(tdone,ends);
    thread640(tdone,ends);
    int biggest641 = 0;
    if(ends[8]>=biggest641){
      biggest641=ends[8];
    }
    if(ends[9]>=biggest641){
      biggest641=ends[9];
    }
    if(ends[10]>=biggest641){
      biggest641=ends[10];
    }
    if(ends[11]>=biggest641){
      biggest641=ends[11];
    }
    if(ends[12]>=biggest641){
      biggest641=ends[12];
    }
    if(ends[13]>=biggest641){
      biggest641=ends[13];
    }
    if(biggest641 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread633(int [] tdone, int [] ends){
        S263=1;
    capcount_thread_6 = 5;//sysj/lidLoaderPlant.sysj line: 76, column: 3
    if(capDec_1.getprestatus()){//sysj/lidLoaderPlant.sysj line: 78, column: 12
      if(capcount_thread_6 > 0) {//sysj/lidLoaderPlant.sysj line: 79, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj/lidLoaderPlant.sysj line: 80, column: 6
      }
      System.out.println("[Plant] capcount = " + capcount_thread_6);//sysj/lidLoaderPlant.sysj line: 81, column: 5
      if(refill.getprestatus()){//sysj/lidLoaderPlant.sysj line: 83, column: 12
        capcount_thread_6 = 5;//sysj/lidLoaderPlant.sysj line: 84, column: 5
        if(capcount_thread_6 == 0){//sysj/lidLoaderPlant.sysj line: 86, column: 7
          empty.setPresent();//sysj/lidLoaderPlant.sysj line: 87, column: 5
          currsigs.addElement(empty);
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
        if(capcount_thread_6 == 0){//sysj/lidLoaderPlant.sysj line: 86, column: 7
          empty.setPresent();//sysj/lidLoaderPlant.sysj line: 87, column: 5
          currsigs.addElement(empty);
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
      if(refill.getprestatus()){//sysj/lidLoaderPlant.sysj line: 83, column: 12
        capcount_thread_6 = 5;//sysj/lidLoaderPlant.sysj line: 84, column: 5
        if(capcount_thread_6 == 0){//sysj/lidLoaderPlant.sysj line: 86, column: 7
          empty.setPresent();//sysj/lidLoaderPlant.sysj line: 87, column: 5
          currsigs.addElement(empty);
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
        if(capcount_thread_6 == 0){//sysj/lidLoaderPlant.sysj line: 86, column: 7
          empty.setPresent();//sysj/lidLoaderPlant.sysj line: 87, column: 5
          currsigs.addElement(empty);
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

  public void thread632(int [] tdone, int [] ends){
        S195=1;
    S149=0;
    S131=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread631(int [] tdone, int [] ends){
        S127=1;
    S97=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj/lidLoaderPlant.sysj line: 37, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj/lidLoaderPlant.sysj line: 38, column: 8
        capPos_1.setPresent();//sysj/lidLoaderPlant.sysj line: 39, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj/lidLoaderPlant.sysj line: 39, column: 6
        S92=0;
        WPgripped.setPresent();//sysj/lidLoaderPlant.sysj line: 41, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S97=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S97=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread630(int [] tdone, int [] ends){
        S83=1;
    S55=0;
    pusherRetracted.setPresent();//sysj/lidLoaderPlant.sysj line: 27, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread629(int [] tdone, int [] ends){
        S42=1;
    S14=0;
    armAtDest.setPresent();//sysj/lidLoaderPlant.sysj line: 16, column: 5
    currsigs.addElement(armAtDest);
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
      switch(S627){
        case 0 : 
          S627=0;
          break RUN;
        
        case 1 : 
          S627=2;
          S627=2;
          capDec_1.setClear();//sysj/lidLoaderPlant.sysj line: 10, column: 2
          capPos_1.setClear();//sysj/lidLoaderPlant.sysj line: 11, column: 2
          capPos_1.setPresent();//sysj/lidLoaderPlant.sysj line: 12, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj/lidLoaderPlant.sysj line: 12, column: 2
          thread629(tdone,ends);
          thread630(tdone,ends);
          thread631(tdone,ends);
          thread632(tdone,ends);
          thread633(tdone,ends);
          thread634(tdone,ends);
          int biggest642 = 0;
          if(ends[2]>=biggest642){
            biggest642=ends[2];
          }
          if(ends[3]>=biggest642){
            biggest642=ends[3];
          }
          if(ends[4]>=biggest642){
            biggest642=ends[4];
          }
          if(ends[5]>=biggest642){
            biggest642=ends[5];
          }
          if(ends[6]>=biggest642){
            biggest642=ends[6];
          }
          if(ends[7]>=biggest642){
            biggest642=ends[7];
          }
          if(biggest642 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj/lidLoaderPlant.sysj line: 10, column: 2
          capPos_1.setClear();//sysj/lidLoaderPlant.sysj line: 11, column: 2
          thread643(tdone,ends);
          thread644(tdone,ends);
          thread645(tdone,ends);
          thread646(tdone,ends);
          thread647(tdone,ends);
          thread648(tdone,ends);
          int biggest656 = 0;
          if(ends[2]>=biggest656){
            biggest656=ends[2];
          }
          if(ends[3]>=biggest656){
            biggest656=ends[3];
          }
          if(ends[4]>=biggest656){
            biggest656=ends[4];
          }
          if(ends[5]>=biggest656){
            biggest656=ends[5];
          }
          if(ends[6]>=biggest656){
            biggest656=ends[6];
          }
          if(ends[7]>=biggest656){
            biggest656=ends[7];
          }
          if(biggest656 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest656 == 0){
            S627=0;
            active[1]=0;
            ends[1]=0;
            S627=0;
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
    capDec_1 = new Signal();
    capPos_1 = new Signal();
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
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          enable.gethook();
          refill.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enable.setpreclear();
      refill.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      refilled.setpreclear();
      pusherRetractedE.setpreclear();
      pusherExtendedE.setpreclear();
      WPgrippedE.setpreclear();
      armAtSourceE.setpreclear();
      armAtDestE.setpreclear();
      emptyE.setpreclear();
      capDec_1.setpreclear();
      capPos_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      empty.sethook();
      empty.setClear();
      refilled.sethook();
      refilled.setClear();
      pusherRetractedE.sethook();
      pusherRetractedE.setClear();
      pusherExtendedE.sethook();
      pusherExtendedE.setClear();
      WPgrippedE.sethook();
      WPgrippedE.setClear();
      armAtSourceE.sethook();
      armAtSourceE.setClear();
      armAtDestE.sethook();
      armAtDestE.setClear();
      emptyE.sethook();
      emptyE.setClear();
      capDec_1.setClear();
      capPos_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        enable.gethook();
        refill.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
