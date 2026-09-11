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
<<<<<<< Updated upstream
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal capPos_1;
  private int capcount_thread_6;//sysj\lidLoaderPlant.sysj line: 76, column: 3
  private int S3786 = 1;
  private int S3201 = 1;
  private int S3173 = 1;
  private int S3242 = 1;
  private int S3214 = 1;
  private int S3286 = 1;
  private int S3256 = 1;
  private int S3251 = 1;
  private int S3354 = 1;
  private int S3308 = 1;
  private int S3290 = 1;
  private int S3422 = 1;
  private int S3472 = 1;
  private int S3430 = 1;
  private int S3438 = 1;
  private int S3446 = 1;
  private int S3454 = 1;
  private int S3462 = 1;
  private int S3470 = 1;
=======
  private int STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 26, column: 3
  private int lids_thread_3;//sysj\lidLoaderPlant.sysj line: 27, column: 3
  private boolean extended_thread_3;//sysj\lidLoaderPlant.sysj line: 28, column: 3
  private boolean lidReady_thread_3;//sysj\lidLoaderPlant.sysj line: 29, column: 3
  private boolean holding_thread_3;//sysj\lidLoaderPlant.sysj line: 30, column: 3
  private int S86303 = 1;
  private int S85441 = 1;
  private int S85413 = 1;
  private int S86301 = 1;
>>>>>>> Stashed changes
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
<<<<<<< Updated upstream
  public void thread3813(int [] tdone, int [] ends){
        switch(S3470){
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

  public void thread3812(int [] tdone, int [] ends){
        switch(S3462){
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

  public void thread3811(int [] tdone, int [] ends){
        switch(S3454){
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

  public void thread3810(int [] tdone, int [] ends){
        switch(S3446){
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

  public void thread3809(int [] tdone, int [] ends){
        switch(S3438){
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

  public void thread3808(int [] tdone, int [] ends){
        switch(S3430){
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

  public void thread3807(int [] tdone, int [] ends){
        switch(S3472){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread3808(tdone,ends);
        thread3809(tdone,ends);
        thread3810(tdone,ends);
        thread3811(tdone,ends);
        thread3812(tdone,ends);
        thread3813(tdone,ends);
        int biggest3814 = 0;
        if(ends[8]>=biggest3814){
          biggest3814=ends[8];
        }
        if(ends[9]>=biggest3814){
          biggest3814=ends[9];
        }
        if(ends[10]>=biggest3814){
          biggest3814=ends[10];
        }
        if(ends[11]>=biggest3814){
          biggest3814=ends[11];
        }
        if(ends[12]>=biggest3814){
          biggest3814=ends[12];
        }
        if(ends[13]>=biggest3814){
          biggest3814=ends[13];
        }
        if(biggest3814 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest3814 == 0){
          S3472=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread3806(int [] tdone, int [] ends){
        switch(S3422){
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

  public void thread3805(int [] tdone, int [] ends){
        switch(S3354){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S3308){
          case 0 : 
            if(empty.getprestatus()){//sysj\lidLoaderPlant.sysj line: 60, column: 10
              S3308=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S3290){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\lidLoaderPlant.sysj line: 62, column: 13
                    S3290=1;
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
                    S3290=2;
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
                    S3290=0;
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
              S3308=0;
              S3290=0;
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

  public void thread3804(int [] tdone, int [] ends){
        switch(S3286){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3256){
          case 0 : 
            switch(S3251){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\lidLoaderPlant.sysj line: 40, column: 12
                  S3251=1;
                  if(armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 43, column: 14
                    capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 44, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\lidLoaderPlant.sysj line: 44, column: 7
                    S3256=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S3256=1;
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
                S3256=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 37, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lidLoaderPlant.sysj line: 38, column: 8
                    capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 39, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\lidLoaderPlant.sysj line: 39, column: 6
                    S3251=0;
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 41, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S3256=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S3256=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S3256=1;
            S3256=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 37, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lidLoaderPlant.sysj line: 38, column: 8
                capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 39, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\lidLoaderPlant.sysj line: 39, column: 6
                S3251=0;
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 41, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S3256=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S3256=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3803(int [] tdone, int [] ends){
        switch(S3242){
=======
  public void thread86309(int [] tdone, int [] ends){
        switch(S86301){
>>>>>>> Stashed changes
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3214){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 26, column: 10
              S3214=1;
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
              S3214=0;
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

<<<<<<< Updated upstream
  public void thread3802(int [] tdone, int [] ends){
        switch(S3201){
=======
  public void thread86308(int [] tdone, int [] ends){
        switch(S85441){
>>>>>>> Stashed changes
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        switch(S3173){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 15, column: 10
              S3173=1;
              armAtSource.setPresent();//sysj\lidLoaderPlant.sysj line: 19, column: 5
=======
        switch(S85413){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 16, column: 10
              S85413=1;
              armAtSource.setPresent();//sysj\lidLoaderPlant.sysj line: 20, column: 5
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 18, column: 10
              S3173=0;
              armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 16, column: 5
=======
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 19, column: 10
              S85413=0;
              armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 17, column: 5
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
  public void thread3799(int [] tdone, int [] ends){
        S3470=1;
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

  public void thread3798(int [] tdone, int [] ends){
        S3462=1;
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

  public void thread3797(int [] tdone, int [] ends){
        S3454=1;
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

  public void thread3796(int [] tdone, int [] ends){
        S3446=1;
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

  public void thread3795(int [] tdone, int [] ends){
        S3438=1;
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

  public void thread3794(int [] tdone, int [] ends){
        S3430=1;
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

  public void thread3793(int [] tdone, int [] ends){
        S3472=1;
    thread3794(tdone,ends);
    thread3795(tdone,ends);
    thread3796(tdone,ends);
    thread3797(tdone,ends);
    thread3798(tdone,ends);
    thread3799(tdone,ends);
    int biggest3800 = 0;
    if(ends[8]>=biggest3800){
      biggest3800=ends[8];
    }
    if(ends[9]>=biggest3800){
      biggest3800=ends[9];
    }
    if(ends[10]>=biggest3800){
      biggest3800=ends[10];
    }
    if(ends[11]>=biggest3800){
      biggest3800=ends[11];
    }
    if(ends[12]>=biggest3800){
      biggest3800=ends[12];
    }
    if(ends[13]>=biggest3800){
      biggest3800=ends[13];
    }
    if(biggest3800 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread3792(int [] tdone, int [] ends){
        S3422=1;
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
=======
  public void thread86306(int [] tdone, int [] ends){
        S86301=1;
    STOCK_thread_3 = 3;//sysj\lidLoaderPlant.sysj line: 26, column: 3
    lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 27, column: 3
    extended_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 28, column: 3
    lidReady_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 29, column: 3
    holding_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 30, column: 3
    if(enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 33, column: 12
      if(pusherExtend.getprestatus()){//sysj\lidLoaderPlant.sysj line: 36, column: 13
        if(!extended_thread_3) {//sysj\lidLoaderPlant.sysj line: 37, column: 19
          extended_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 38, column: 7
          if(lids_thread_3 > 0 && !lidReady_thread_3) {//sysj\lidLoaderPlant.sysj line: 39, column: 32
            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderPlant.sysj line: 40, column: 8
            lidReady_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 41, column: 8
            System.out.println("[LIDPlant] Lid pushed out, " + lids_thread_3 + " left.");//sysj\lidLoaderPlant.sysj line: 42, column: 8
          }
        }
        pusherExtended.setPresent();//sysj\lidLoaderPlant.sysj line: 45, column: 6
        currsigs.addElement(pusherExtended);
        if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 53, column: 5
          if(vacOn.getprestatus()){//sysj\lidLoaderPlant.sysj line: 54, column: 14
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
              }
              else {
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
              }
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
              }
              else {
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
              }
            }
          }
          else {
            holding_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 58, column: 7
            System.out.println("[LIDPlant] Lid released.");//sysj\lidLoaderPlant.sysj line: 59, column: 7
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
              }
              else {
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
              }
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
              }
              else {
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
              }
            }
          }
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
  public void thread3791(int [] tdone, int [] ends){
        S3354=1;
    S3308=0;
    S3290=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3790(int [] tdone, int [] ends){
        S3286=1;
    S3256=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 37, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lidLoaderPlant.sysj line: 38, column: 8
        capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 39, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\lidLoaderPlant.sysj line: 39, column: 6
        S3251=0;
        WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 41, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S3256=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S3256=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread3789(int [] tdone, int [] ends){
        S3242=1;
    S3214=0;
    pusherRetracted.setPresent();//sysj\lidLoaderPlant.sysj line: 27, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3788(int [] tdone, int [] ends){
        S3201=1;
    S3173=0;
    armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 16, column: 5
=======
  public void thread86305(int [] tdone, int [] ends){
        S85441=1;
    S85413=0;
    armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 17, column: 5
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
      switch(S3786){
        case 0 : 
          S3786=0;
          break RUN;
        
        case 1 : 
          S3786=2;
          S3786=2;
          capDec_1.setClear();//sysj\lidLoaderPlant.sysj line: 10, column: 2
          capPos_1.setClear();//sysj\lidLoaderPlant.sysj line: 11, column: 2
          capPos_1.setPresent();//sysj\lidLoaderPlant.sysj line: 12, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\lidLoaderPlant.sysj line: 12, column: 2
          thread3788(tdone,ends);
          thread3789(tdone,ends);
          thread3790(tdone,ends);
          thread3791(tdone,ends);
          thread3792(tdone,ends);
          thread3793(tdone,ends);
          int biggest3801 = 0;
          if(ends[2]>=biggest3801){
            biggest3801=ends[2];
          }
          if(ends[3]>=biggest3801){
            biggest3801=ends[3];
          }
          if(ends[4]>=biggest3801){
            biggest3801=ends[4];
          }
          if(ends[5]>=biggest3801){
            biggest3801=ends[5];
          }
          if(ends[6]>=biggest3801){
            biggest3801=ends[6];
          }
          if(ends[7]>=biggest3801){
            biggest3801=ends[7];
          }
          if(biggest3801 == 1){
=======
      switch(S86303){
        case 0 : 
          S86303=0;
          break RUN;
        
        case 1 : 
          S86303=2;
          S86303=2;
          thread86305(tdone,ends);
          thread86306(tdone,ends);
          int biggest86307 = 0;
          if(ends[2]>=biggest86307){
            biggest86307=ends[2];
          }
          if(ends[3]>=biggest86307){
            biggest86307=ends[3];
          }
          if(biggest86307 == 1){
>>>>>>> Stashed changes
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
<<<<<<< Updated upstream
          capDec_1.setClear();//sysj\lidLoaderPlant.sysj line: 10, column: 2
          capPos_1.setClear();//sysj\lidLoaderPlant.sysj line: 11, column: 2
          thread3802(tdone,ends);
          thread3803(tdone,ends);
          thread3804(tdone,ends);
          thread3805(tdone,ends);
          thread3806(tdone,ends);
          thread3807(tdone,ends);
          int biggest3815 = 0;
          if(ends[2]>=biggest3815){
            biggest3815=ends[2];
          }
          if(ends[3]>=biggest3815){
            biggest3815=ends[3];
          }
          if(ends[4]>=biggest3815){
            biggest3815=ends[4];
          }
          if(ends[5]>=biggest3815){
            biggest3815=ends[5];
          }
          if(ends[6]>=biggest3815){
            biggest3815=ends[6];
          }
          if(ends[7]>=biggest3815){
            biggest3815=ends[7];
          }
          if(biggest3815 == 1){
=======
          thread86308(tdone,ends);
          thread86309(tdone,ends);
          int biggest86310 = 0;
          if(ends[2]>=biggest86310){
            biggest86310=ends[2];
          }
          if(ends[3]>=biggest86310){
            biggest86310=ends[3];
          }
          if(biggest86310 == 1){
>>>>>>> Stashed changes
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
<<<<<<< Updated upstream
          if(biggest3815 == 0){
            S3786=0;
            active[1]=0;
            ends[1]=0;
            S3786=0;
=======
          if(biggest86310 == 0){
            S86303=0;
            active[1]=0;
            ends[1]=0;
            S86303=0;
>>>>>>> Stashed changes
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
