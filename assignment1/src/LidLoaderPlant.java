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
  private int capcount_thread_6;//sysj\lidLoaderPlant.sysj line: 76, column: 3
  private int S3648 = 1;
  private int S3063 = 1;
  private int S3035 = 1;
  private int S3104 = 1;
  private int S3076 = 1;
  private int S3148 = 1;
  private int S3118 = 1;
  private int S3113 = 1;
  private int S3216 = 1;
  private int S3170 = 1;
  private int S3152 = 1;
  private int S3284 = 1;
  private int S3334 = 1;
  private int S3292 = 1;
  private int S3300 = 1;
  private int S3308 = 1;
  private int S3316 = 1;
  private int S3324 = 1;
  private int S3332 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread3675(int [] tdone, int [] ends){
        switch(S3332){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\lidLoaderPlant.sysj line: 103, column: 24
          emptyE.setPresent();//sysj\lidLoaderPlant.sysj line: 103, column: 31
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

  public void thread3674(int [] tdone, int [] ends){
        switch(S3324){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\lidLoaderPlant.sysj line: 101, column: 24
          armAtDestE.setPresent();//sysj\lidLoaderPlant.sysj line: 101, column: 35
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

  public void thread3673(int [] tdone, int [] ends){
        switch(S3316){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 99, column: 24
          armAtSourceE.setPresent();//sysj\lidLoaderPlant.sysj line: 99, column: 37
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

  public void thread3672(int [] tdone, int [] ends){
        switch(S3308){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\lidLoaderPlant.sysj line: 97, column: 24
          WPgrippedE.setPresent();//sysj\lidLoaderPlant.sysj line: 97, column: 35
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

  public void thread3671(int [] tdone, int [] ends){
        switch(S3300){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\lidLoaderPlant.sysj line: 95, column: 24
          pusherExtendedE.setPresent();//sysj\lidLoaderPlant.sysj line: 95, column: 40
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

  public void thread3670(int [] tdone, int [] ends){
        switch(S3292){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\lidLoaderPlant.sysj line: 93, column: 24
          pusherRetractedE.setPresent();//sysj\lidLoaderPlant.sysj line: 93, column: 41
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

  public void thread3669(int [] tdone, int [] ends){
        switch(S3334){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread3670(tdone,ends);
        thread3671(tdone,ends);
        thread3672(tdone,ends);
        thread3673(tdone,ends);
        thread3674(tdone,ends);
        thread3675(tdone,ends);
        int biggest3676 = 0;
        if(ends[8]>=biggest3676){
          biggest3676=ends[8];
        }
        if(ends[9]>=biggest3676){
          biggest3676=ends[9];
        }
        if(ends[10]>=biggest3676){
          biggest3676=ends[10];
        }
        if(ends[11]>=biggest3676){
          biggest3676=ends[11];
        }
        if(ends[12]>=biggest3676){
          biggest3676=ends[12];
        }
        if(ends[13]>=biggest3676){
          biggest3676=ends[13];
        }
        if(biggest3676 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest3676 == 0){
          S3334=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread3668(int [] tdone, int [] ends){
        switch(S3284){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\lidLoaderPlant.sysj line: 78, column: 12
          if(capcount_thread_6 > 0) {//sysj\lidLoaderPlant.sysj line: 79, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\lidLoaderPlant.sysj line: 80, column: 6
          }
          System.out.println("[Plant] capcount = " + capcount_thread_6);//sysj\lidLoaderPlant.sysj line: 81, column: 5
          if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 83, column: 12
            capcount_thread_6 = 5;//sysj\lidLoaderPlant.sysj line: 84, column: 5
            if(capcount_thread_6 == 0){//sysj\lidLoaderPlant.sysj line: 86, column: 7
              empty.setPresent();//sysj\lidLoaderPlant.sysj line: 87, column: 5
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
            if(capcount_thread_6 == 0){//sysj\lidLoaderPlant.sysj line: 86, column: 7
              empty.setPresent();//sysj\lidLoaderPlant.sysj line: 87, column: 5
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
          if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 83, column: 12
            capcount_thread_6 = 5;//sysj\lidLoaderPlant.sysj line: 84, column: 5
            if(capcount_thread_6 == 0){//sysj\lidLoaderPlant.sysj line: 86, column: 7
              empty.setPresent();//sysj\lidLoaderPlant.sysj line: 87, column: 5
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
            if(capcount_thread_6 == 0){//sysj\lidLoaderPlant.sysj line: 86, column: 7
              empty.setPresent();//sysj\lidLoaderPlant.sysj line: 87, column: 5
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

  public void thread3667(int [] tdone, int [] ends){
        switch(S3216){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S3170){
          case 0 : 
            if(empty.getprestatus()){//sysj\lidLoaderPlant.sysj line: 60, column: 10
              S3170=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S3152){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderPlant.sysj line: 62, column: 13
                    S3152=1;
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
                  if(pusherExtended.getprestatus()){//sysj\lidLoaderPlant.sysj line: 63, column: 13
                    capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 65, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\lidLoaderPlant.sysj line: 65, column: 7
                    S3152=2;
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
                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderPlant.sysj line: 66, column: 13
                    capDec_1.setPresent();//sysj\lidLoaderPlant.sysj line: 67, column: 7
                    currsigs.addElement(capDec_1);
                    S3152=0;
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
            if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 70, column: 10
              refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 4
              currsigs.addElement(refilled);
              S3170=0;
              S3152=0;
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

  public void thread3666(int [] tdone, int [] ends){
        switch(S3148){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3118){
          case 0 : 
            switch(S3113){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\lidLoaderPlant.sysj line: 40, column: 12
                  S3113=1;
                  if(armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 43, column: 14
                    capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 44, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\lidLoaderPlant.sysj line: 44, column: 7
                    S3118=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S3118=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 41, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S3118=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 37, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lidLoaderPlant.sysj line: 38, column: 8
                    capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 39, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\lidLoaderPlant.sysj line: 39, column: 6
                    S3113=0;
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 41, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S3118=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S3118=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S3118=1;
            S3118=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 37, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lidLoaderPlant.sysj line: 38, column: 8
                capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 39, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\lidLoaderPlant.sysj line: 39, column: 6
                S3113=0;
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 41, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S3118=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S3118=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3665(int [] tdone, int [] ends){
        switch(S3104){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3076){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 26, column: 10
              S3076=1;
              pusherExtended.setPresent();//sysj\lidLoaderPlant.sysj line: 30, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\lidLoaderPlant.sysj line: 27, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 29, column: 10
              S3076=0;
              pusherRetracted.setPresent();//sysj\lidLoaderPlant.sysj line: 27, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\lidLoaderPlant.sysj line: 30, column: 5
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

  public void thread3664(int [] tdone, int [] ends){
        switch(S3063){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3035){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 15, column: 10
              S3035=1;
              armAtSource.setPresent();//sysj\lidLoaderPlant.sysj line: 19, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 16, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 18, column: 10
              S3035=0;
              armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 16, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\lidLoaderPlant.sysj line: 19, column: 5
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

  public void thread3661(int [] tdone, int [] ends){
        S3332=1;
    if(empty.getprestatus()){//sysj\lidLoaderPlant.sysj line: 103, column: 24
      emptyE.setPresent();//sysj\lidLoaderPlant.sysj line: 103, column: 31
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

  public void thread3660(int [] tdone, int [] ends){
        S3324=1;
    if(armAtDest.getprestatus()){//sysj\lidLoaderPlant.sysj line: 101, column: 24
      armAtDestE.setPresent();//sysj\lidLoaderPlant.sysj line: 101, column: 35
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

  public void thread3659(int [] tdone, int [] ends){
        S3316=1;
    if(armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 99, column: 24
      armAtSourceE.setPresent();//sysj\lidLoaderPlant.sysj line: 99, column: 37
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

  public void thread3658(int [] tdone, int [] ends){
        S3308=1;
    if(WPgripped.getprestatus()){//sysj\lidLoaderPlant.sysj line: 97, column: 24
      WPgrippedE.setPresent();//sysj\lidLoaderPlant.sysj line: 97, column: 35
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

  public void thread3657(int [] tdone, int [] ends){
        S3300=1;
    if(pusherExtended.getprestatus()){//sysj\lidLoaderPlant.sysj line: 95, column: 24
      pusherExtendedE.setPresent();//sysj\lidLoaderPlant.sysj line: 95, column: 40
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

  public void thread3656(int [] tdone, int [] ends){
        S3292=1;
    if(pusherRetracted.getprestatus()){//sysj\lidLoaderPlant.sysj line: 93, column: 24
      pusherRetractedE.setPresent();//sysj\lidLoaderPlant.sysj line: 93, column: 41
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

  public void thread3655(int [] tdone, int [] ends){
        S3334=1;
    thread3656(tdone,ends);
    thread3657(tdone,ends);
    thread3658(tdone,ends);
    thread3659(tdone,ends);
    thread3660(tdone,ends);
    thread3661(tdone,ends);
    int biggest3662 = 0;
    if(ends[8]>=biggest3662){
      biggest3662=ends[8];
    }
    if(ends[9]>=biggest3662){
      biggest3662=ends[9];
    }
    if(ends[10]>=biggest3662){
      biggest3662=ends[10];
    }
    if(ends[11]>=biggest3662){
      biggest3662=ends[11];
    }
    if(ends[12]>=biggest3662){
      biggest3662=ends[12];
    }
    if(ends[13]>=biggest3662){
      biggest3662=ends[13];
    }
    if(biggest3662 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread3654(int [] tdone, int [] ends){
        S3284=1;
    capcount_thread_6 = 5;//sysj\lidLoaderPlant.sysj line: 76, column: 3
    if(capDec_1.getprestatus()){//sysj\lidLoaderPlant.sysj line: 78, column: 12
      if(capcount_thread_6 > 0) {//sysj\lidLoaderPlant.sysj line: 79, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\lidLoaderPlant.sysj line: 80, column: 6
      }
      System.out.println("[Plant] capcount = " + capcount_thread_6);//sysj\lidLoaderPlant.sysj line: 81, column: 5
      if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 83, column: 12
        capcount_thread_6 = 5;//sysj\lidLoaderPlant.sysj line: 84, column: 5
        if(capcount_thread_6 == 0){//sysj\lidLoaderPlant.sysj line: 86, column: 7
          empty.setPresent();//sysj\lidLoaderPlant.sysj line: 87, column: 5
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
        if(capcount_thread_6 == 0){//sysj\lidLoaderPlant.sysj line: 86, column: 7
          empty.setPresent();//sysj\lidLoaderPlant.sysj line: 87, column: 5
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
      if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 83, column: 12
        capcount_thread_6 = 5;//sysj\lidLoaderPlant.sysj line: 84, column: 5
        if(capcount_thread_6 == 0){//sysj\lidLoaderPlant.sysj line: 86, column: 7
          empty.setPresent();//sysj\lidLoaderPlant.sysj line: 87, column: 5
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
        if(capcount_thread_6 == 0){//sysj\lidLoaderPlant.sysj line: 86, column: 7
          empty.setPresent();//sysj\lidLoaderPlant.sysj line: 87, column: 5
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

  public void thread3653(int [] tdone, int [] ends){
        S3216=1;
    S3170=0;
    S3152=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3652(int [] tdone, int [] ends){
        S3148=1;
    S3118=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 37, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lidLoaderPlant.sysj line: 38, column: 8
        capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 39, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\lidLoaderPlant.sysj line: 39, column: 6
        S3113=0;
        WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 41, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S3118=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S3118=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread3651(int [] tdone, int [] ends){
        S3104=1;
    S3076=0;
    pusherRetracted.setPresent();//sysj\lidLoaderPlant.sysj line: 27, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3650(int [] tdone, int [] ends){
        S3063=1;
    S3035=0;
    armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 16, column: 5
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
      switch(S3648){
        case 0 : 
          S3648=0;
          break RUN;
        
        case 1 : 
          S3648=2;
          S3648=2;
          capDec_1.setClear();//sysj\lidLoaderPlant.sysj line: 10, column: 2
          capPos_1.setClear();//sysj\lidLoaderPlant.sysj line: 11, column: 2
          capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 12, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\lidLoaderPlant.sysj line: 12, column: 2
          thread3650(tdone,ends);
          thread3651(tdone,ends);
          thread3652(tdone,ends);
          thread3653(tdone,ends);
          thread3654(tdone,ends);
          thread3655(tdone,ends);
          int biggest3663 = 0;
          if(ends[2]>=biggest3663){
            biggest3663=ends[2];
          }
          if(ends[3]>=biggest3663){
            biggest3663=ends[3];
          }
          if(ends[4]>=biggest3663){
            biggest3663=ends[4];
          }
          if(ends[5]>=biggest3663){
            biggest3663=ends[5];
          }
          if(ends[6]>=biggest3663){
            biggest3663=ends[6];
          }
          if(ends[7]>=biggest3663){
            biggest3663=ends[7];
          }
          if(biggest3663 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\lidLoaderPlant.sysj line: 10, column: 2
          capPos_1.setClear();//sysj\lidLoaderPlant.sysj line: 11, column: 2
          thread3664(tdone,ends);
          thread3665(tdone,ends);
          thread3666(tdone,ends);
          thread3667(tdone,ends);
          thread3668(tdone,ends);
          thread3669(tdone,ends);
          int biggest3677 = 0;
          if(ends[2]>=biggest3677){
            biggest3677=ends[2];
          }
          if(ends[3]>=biggest3677){
            biggest3677=ends[3];
          }
          if(ends[4]>=biggest3677){
            biggest3677=ends[4];
          }
          if(ends[5]>=biggest3677){
            biggest3677=ends[5];
          }
          if(ends[6]>=biggest3677){
            biggest3677=ends[6];
          }
          if(ends[7]>=biggest3677){
            biggest3677=ends[7];
          }
          if(biggest3677 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3677 == 0){
            S3648=0;
            active[1]=0;
            ends[1]=0;
            S3648=0;
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
