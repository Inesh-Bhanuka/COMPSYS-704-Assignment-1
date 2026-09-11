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
<<<<<<< Updated upstream
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
=======
  private LidLoaderTwin t_thread_3;//sysj\lidLoaderController.sysj line: 44, column: 3
  private int lids_thread_3;//sysj\lidLoaderController.sysj line: 45, column: 3
  private WorkpieceTwin w_thread_3;//sysj\lidLoaderController.sysj line: 46, column: 3
  private int S85337 = 1;
  private int S56387 = 1;
  private int S84805 = 1;
  private int S61124 = 1;
  private int S56412 = 1;
  private int S56396 = 1;
  private int S56391 = 1;
  private int S56440 = 1;
  private int S56502 = 1;
  private int S56507 = 1;
  private int S57203 = 1;
  private int S57198 = 1;
  private int S85335 = 1;
  private int S84981 = 1;
>>>>>>> Stashed changes
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
<<<<<<< Updated upstream
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
=======
  public void thread85399(int [] tdone, int [] ends){
        switch(S85335){
>>>>>>> Stashed changes
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        armDest.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 14
        currsigs.addElement(armDest);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
=======
        switch(S84981){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 20
              S84981=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 20
                S84981=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 14
                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 109, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 110, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 110, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 20
              S84981=2;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 14
                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 109, column: 30
                currsigs.addElement(pusherExtend);
                if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 14
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 110, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 14
                  vacOn.setPresent();//sysj\lidLoaderController.sysj line: 110, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                  if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                    if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                      armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
            S84981=2;
            S84981=0;
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 20
              S84981=1;
              if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 20
                S84981=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                if(pusherExtendM.getprestatus()){//sysj\lidLoaderController.sysj line: 109, column: 14
                  pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 109, column: 30
                  currsigs.addElement(pusherExtend);
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 110, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                  if(vacOnM.getprestatus()){//sysj\lidLoaderController.sysj line: 110, column: 14
                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 110, column: 23
                    currsigs.addElement(vacOn);
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                    if(armSourceM.getprestatus()){//sysj\lidLoaderController.sysj line: 111, column: 14
                      armSource.setPresent();//sysj\lidLoaderController.sysj line: 111, column: 27
                      currsigs.addElement(armSource);
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
                      if(armDestM.getprestatus()){//sysj\lidLoaderController.sysj line: 112, column: 14
                        armDest.setPresent();//sysj\lidLoaderController.sysj line: 112, column: 25
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
>>>>>>> Stashed changes
        break;
      
    }
  }

<<<<<<< Updated upstream
  public void thread3136(int [] tdone, int [] ends){
        S2240=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 34
=======
  public void thread85397(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
>>>>>>> Stashed changes
    currsigs.addElement(vacOn);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

<<<<<<< Updated upstream
  public void thread3135(int [] tdone, int [] ends){
        S2235=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 58, column: 14
=======
  public void thread85396(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
>>>>>>> Stashed changes
    currsigs.addElement(armDest);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

<<<<<<< Updated upstream
  public void thread3134(int [] tdone, int [] ends){
        switch(S2791){
=======
  public void thread85394(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85393(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85391(int [] tdone, int [] ends){
        switch(S56507){
>>>>>>> Stashed changes
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
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
=======
        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
        currsigs.addElement(vacOn);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread85390(int [] tdone, int [] ends){
        switch(S56502){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
        currsigs.addElement(armDest);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread85388(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85387(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85385(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85384(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85382(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85381(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85379(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85378(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85376(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85375(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85373(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85372(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85370(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85369(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85367(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85366(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85364(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85363(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85361(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85360(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85358(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85357(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85355(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85354(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85352(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85351(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85350(int [] tdone, int [] ends){
        switch(S84805){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S61124){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 49, column: 20
              S61124=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 51, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S61124=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S56412=0;
                S56396=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 52, column: 5
                  start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                  S56396=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S56391=0;
                  if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                    start_in.setACK(true);//sysj\lidLoaderController.sysj line: 52, column: 5
                    S56391=1;
                    if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                      start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 52, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 53, column: 5
                      S56412=1;
                      if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 55, column: 8
                        System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 56, column: 6
                        w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 57, column: 6
                        S56412=2;
                        S57203=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                          S57203=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S57198=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                            S57198=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 98, column: 5
                              S61124=2;
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
                        if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 59, column: 13
                          S56440=0;
                          if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 14
                            System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 62, column: 7
                            if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 23
                              S56440=1;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                S56440=2;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                  S56440=3;
                                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                    S56440=4;
                                    if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                      S56440=5;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                        S56440=6;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                          }
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                            S56412=2;
                                            S57203=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                              S57203=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S57198=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                S57198=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  S61124=2;
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
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                            S56412=2;
                                            S57203=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                              S57203=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S57198=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                S57198=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  S61124=2;
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
                                      vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                      currsigs.addElement(vacOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              refill.setPresent();//sysj\lidLoaderController.sysj line: 64, column: 8
                              currsigs.addElement(refill);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S56440=1;
                            if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                              S56440=2;
                              if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                S56440=3;
                                if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                  S56440=4;
                                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                    S56440=5;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                      S56440=6;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                        }
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                          S56412=2;
                                          S57203=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                            S57203=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S57198=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                              S57198=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                S61124=2;
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
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                          S56412=2;
                                          S57203=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                            S57203=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S57198=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                              S57198=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                S61124=2;
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
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                              pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          S56412=2;
                          S57203=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                            S57203=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S57198=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                              S57198=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                S61124=2;
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
=======
            if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 51, column: 20
              start_in.setPreempted();
              done_o.setPreempted();
              S61124=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S56412){
                case 0 : 
                  switch(S56396){
                    case 0 : 
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 52, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                        S56396=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S56391){
                          case 0 : 
                            if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                              start_in.setACK(true);//sysj\lidLoaderController.sysj line: 52, column: 5
                              S56391=1;
                              if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                                start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 52, column: 5
                                w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 53, column: 5
                                S56412=1;
                                if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 55, column: 8
                                  System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 56, column: 6
                                  w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 57, column: 6
                                  S56412=2;
                                  S57203=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57203=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57198=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57198=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S61124=2;
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
                                  if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 59, column: 13
                                    S56440=0;
                                    if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 14
                                      System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 62, column: 7
                                      if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 23
                                        S56440=1;
                                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                          S56440=2;
                                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                            S56440=3;
                                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                              S56440=4;
                                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                                S56440=5;
                                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                                  S56440=6;
                                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                                    }
                                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                                      currsigs.addElement(twin);
                                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                      S56412=2;
                                                      S57203=0;
                                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S57203=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S57198=0;
                                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          S57198=1;
                                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                            S61124=2;
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
                                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                      S56412=2;
                                                      S57203=0;
                                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S57203=1;
                                                        active[3]=1;
                                                        ends[3]=1;
                                                        tdone[3]=1;
                                                      }
                                                      else {
                                                        S57198=0;
                                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          S57198=1;
                                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                            ends[3]=2;
                                                            ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                            S61124=2;
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
                                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                                currsigs.addElement(vacOn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                          currsigs.addElement(pusherExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        refill.setPresent();//sysj\lidLoaderController.sysj line: 64, column: 8
                                        currsigs.addElement(refill);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S56440=1;
                                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                        S56440=2;
                                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                          S56440=3;
                                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                            S56440=4;
                                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                              S56440=5;
                                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                                S56440=6;
                                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                                  }
                                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                                    currsigs.addElement(twin);
                                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                    S56412=2;
                                                    S57203=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S57203=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S57198=0;
                                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S57198=1;
                                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          S61124=2;
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
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                    S56412=2;
                                                    S57203=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S57203=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S57198=0;
                                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S57198=1;
                                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          S61124=2;
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
                                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                              currsigs.addElement(vacOn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                        currsigs.addElement(pusherExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S56412=2;
                                    S57203=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57203=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57198=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S57198=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                          S61124=2;
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
                            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 52, column: 5
                              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 53, column: 5
                              S56412=1;
                              if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 55, column: 8
                                System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 56, column: 6
                                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 57, column: 6
                                S56412=2;
                                S57203=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57203=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S57198=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57198=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S61124=2;
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
                                if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 59, column: 13
                                  S56440=0;
                                  if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 14
                                    System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 62, column: 7
                                    if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 23
                                      S56440=1;
                                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                        S56440=2;
                                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                          S56440=3;
                                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                            S56440=4;
                                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                              S56440=5;
                                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                                S56440=6;
                                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                                  }
                                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                                    currsigs.addElement(twin);
                                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                    S56412=2;
                                                    S57203=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S57203=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S57198=0;
                                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S57198=1;
                                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          S61124=2;
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
                                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                    S56412=2;
                                                    S57203=0;
                                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S57203=1;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      S57198=0;
                                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S57198=1;
                                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          ends[3]=2;
                                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                          S61124=2;
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
                                                thread85363(tdone,ends);
                                                thread85364(tdone,ends);
                                                int biggest85365 = 0;
                                                if(ends[4]>=biggest85365){
                                                  biggest85365=ends[4];
                                                }
                                                if(ends[5]>=biggest85365){
                                                  biggest85365=ends[5];
                                                }
                                                if(biggest85365 == 1){
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                              currsigs.addElement(vacOn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                        currsigs.addElement(pusherExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      refill.setPresent();//sysj\lidLoaderController.sysj line: 64, column: 8
                                      currsigs.addElement(refill);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S56440=1;
                                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                      S56440=2;
                                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                        S56440=3;
                                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                          S56440=4;
                                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                            S56440=5;
                                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                              S56440=6;
                                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                                }
                                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                                  currsigs.addElement(twin);
                                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                  S56412=2;
                                                  S57203=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    S57203=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S57198=0;
                                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S57198=1;
                                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S61124=2;
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
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                  S56412=2;
                                                  S57203=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    S57203=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S57198=0;
                                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S57198=1;
                                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S61124=2;
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
                                              thread85366(tdone,ends);
                                              thread85367(tdone,ends);
                                              int biggest85368 = 0;
                                              if(ends[4]>=biggest85368){
                                                biggest85368=ends[4];
                                              }
                                              if(ends[5]>=biggest85368){
                                                biggest85368=ends[5];
                                              }
                                              if(biggest85368 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  S56412=2;
                                  S57203=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57203=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57198=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57198=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S61124=2;
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
                      S56396=1;
                      S56396=0;
                      if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 52, column: 5
                        start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                        S56396=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S56391=0;
                        if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                          start_in.setACK(true);//sysj\lidLoaderController.sysj line: 52, column: 5
                          S56391=1;
                          if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                            start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 52, column: 5
                            w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 53, column: 5
                            S56412=1;
                            if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 55, column: 8
                              System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 56, column: 6
                              w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 57, column: 6
                              S56412=2;
                              S57203=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                S57203=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57198=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57198=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S61124=2;
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
                              if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 59, column: 13
                                S56440=0;
                                if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 14
                                  System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 62, column: 7
                                  if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 23
                                    S56440=1;
                                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                      S56440=2;
                                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                        S56440=3;
                                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                          S56440=4;
                                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                            S56440=5;
                                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                              S56440=6;
                                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                                }
                                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                                  currsigs.addElement(twin);
                                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                  S56412=2;
                                                  S57203=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    S57203=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S57198=0;
                                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S57198=1;
                                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S61124=2;
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
                                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                  S56412=2;
                                                  S57203=0;
                                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    S57203=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S57198=0;
                                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S57198=1;
                                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                        S61124=2;
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
                                              thread85369(tdone,ends);
                                              thread85370(tdone,ends);
                                              int biggest85371 = 0;
                                              if(ends[4]>=biggest85371){
                                                biggest85371=ends[4];
                                              }
                                              if(ends[5]>=biggest85371){
                                                biggest85371=ends[5];
                                              }
                                              if(biggest85371 == 1){
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                            currsigs.addElement(vacOn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                      currsigs.addElement(pusherExtend);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    refill.setPresent();//sysj\lidLoaderController.sysj line: 64, column: 8
                                    currsigs.addElement(refill);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S56440=1;
                                  if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                    S56440=2;
                                    if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                      S56440=3;
                                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                        S56440=4;
                                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                          S56440=5;
                                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                            S56440=6;
                                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                              lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                              if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                                lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                              }
                                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                                twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                                currsigs.addElement(twin);
                                                twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                S56412=2;
                                                S57203=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  S57203=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S57198=0;
                                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    S57198=1;
                                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S61124=2;
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
                                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                                S56412=2;
                                                S57203=0;
                                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  S57203=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S57198=0;
                                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                    S57198=1;
                                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                      S61124=2;
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
                                            thread85372(tdone,ends);
                                            thread85373(tdone,ends);
                                            int biggest85374 = 0;
                                            if(ends[4]>=biggest85374){
                                              biggest85374=ends[4];
                                            }
                                            if(ends[5]>=biggest85374){
                                              biggest85374=ends[5];
                                            }
                                            if(biggest85374 == 1){
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                          currsigs.addElement(vacOn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                                    pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                    currsigs.addElement(pusherExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S56412=2;
                                S57203=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57203=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S57198=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57198=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S61124=2;
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
                    
>>>>>>> Stashed changes
                  }
                  break;
                
                case 1 : 
<<<<<<< Updated upstream
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
=======
                  switch(S56440){
                    case 0 : 
                      if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 23
                        S56440=1;
                        if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                          S56440=2;
                          if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                            S56440=3;
                            if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                              S56440=4;
                              if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                S56440=5;
                                if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                  S56440=6;
                                  if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                    w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                    lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                    if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                      lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                    }
                                    t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                      twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                      S56412=2;
                                      S57203=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S57203=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S57198=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                          S57198=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                            S61124=2;
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
                                      System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                      S56412=2;
                                      S57203=0;
                                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S57203=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S57198=0;
                                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                          S57198=1;
                                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                            S61124=2;
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
                                  thread85375(tdone,ends);
                                  thread85376(tdone,ends);
                                  int biggest85377 = 0;
                                  if(ends[4]>=biggest85377){
                                    biggest85377=ends[4];
                                  }
                                  if(ends[5]>=biggest85377){
                                    biggest85377=ends[5];
                                  }
                                  if(biggest85377 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                currsigs.addElement(vacOn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                          pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                          currsigs.addElement(pusherExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        refill.setPresent();//sysj\lidLoaderController.sysj line: 64, column: 8
                        currsigs.addElement(refill);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                        S56440=2;
                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                          S56440=3;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                            S56440=4;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                              S56440=5;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                S56440=6;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                  }
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                    S56412=2;
                                    S57203=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57203=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57198=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S57198=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                          S61124=2;
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
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                    S56412=2;
                                    S57203=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57203=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57198=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S57198=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                          S61124=2;
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
                                thread85378(tdone,ends);
                                thread85379(tdone,ends);
                                int biggest85380 = 0;
                                if(ends[4]>=biggest85380){
                                  biggest85380=ends[4];
                                }
                                if(ends[5]>=biggest85380){
                                  biggest85380=ends[5];
                                }
                                if(biggest85380 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                        S56440=3;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                          S56440=4;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                            S56440=5;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                              S56440=6;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                }
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                  S56412=2;
                                  S57203=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57203=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57198=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57198=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S61124=2;
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
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                  S56412=2;
                                  S57203=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57203=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57198=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57198=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S61124=2;
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
                              thread85381(tdone,ends);
                              thread85382(tdone,ends);
                              int biggest85383 = 0;
                              if(ends[4]>=biggest85383){
                                biggest85383=ends[4];
                              }
                              if(ends[5]>=biggest85383){
                                biggest85383=ends[5];
                              }
                              if(biggest85383 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                      if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                        S56440=4;
                        if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                          S56440=5;
                          if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                            S56440=6;
                            if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                              w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                              lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                              if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                              }
                              t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                S56412=2;
                                S57203=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57203=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S57198=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57198=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S61124=2;
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
                                System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                S56412=2;
                                S57203=0;
                                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57203=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S57198=0;
                                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57198=1;
                                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S61124=2;
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
                            thread85384(tdone,ends);
                            thread85385(tdone,ends);
                            int biggest85386 = 0;
                            if(ends[4]>=biggest85386){
                              biggest85386=ends[4];
                            }
                            if(ends[5]>=biggest85386){
                              biggest85386=ends[5];
                            }
                            if(biggest85386 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                          currsigs.addElement(vacOn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 4 : 
                      if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                        S56440=5;
                        if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                          S56440=6;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                            }
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                              S56412=2;
                              S57203=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                S57203=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57198=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57198=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S61124=2;
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
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                              S56412=2;
                              S57203=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                S57203=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57198=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57198=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S61124=2;
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
                          thread85387(tdone,ends);
                          thread85388(tdone,ends);
                          int biggest85389 = 0;
                          if(ends[4]>=biggest85389){
                            biggest85389=ends[4];
                          }
                          if(ends[5]>=biggest85389){
                            biggest85389=ends[5];
                          }
                          if(biggest85389 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                        currsigs.addElement(vacOn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 5 : 
                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                        S56440=6;
                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                          }
                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                            twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                            S56412=2;
                            S57203=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                              S57203=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S57198=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                S57198=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S61124=2;
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
                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                            S56412=2;
                            S57203=0;
                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                              S57203=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S57198=0;
                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                S57198=1;
                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S61124=2;
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
                        thread85390(tdone,ends);
                        thread85391(tdone,ends);
                        int biggest85392 = 0;
                        if(ends[4]>=biggest85392){
                          biggest85392=ends[4];
                        }
                        if(ends[5]>=biggest85392){
                          biggest85392=ends[5];
                        }
                        if(biggest85392 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest85392 == 0){
                          S56440=6;
                          if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                            w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                            if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                              lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                            }
                            t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                              twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                              S56412=2;
                              S57203=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                S57203=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57198=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57198=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S61124=2;
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
                              System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                              S56412=2;
                              S57203=0;
                              if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                S57203=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S57198=0;
                                if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                  done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                  S57198=1;
                                  if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S61124=2;
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
                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                        }
                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                          twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                          S56412=2;
                          S57203=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                            S57203=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S57198=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                              S57198=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                S61124=2;
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
                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                          S56412=2;
                          S57203=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                            S57203=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S57198=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                              S57198=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                S61124=2;
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
                    
>>>>>>> Stashed changes
                  }
                  break;
                
                case 2 : 
<<<<<<< Updated upstream
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
=======
                  switch(S57203){
                    case 0 : 
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                        S57203=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S57198){
                          case 0 : 
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                              S57198=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                S61124=2;
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
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 98, column: 5
                              S61124=2;
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
                      S57203=1;
                      S57203=0;
                      if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                        S57203=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S57198=0;
                        if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                          done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                          S57198=1;
                          if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                            ends[3]=2;
                            ;//sysj\lidLoaderController.sysj line: 98, column: 5
                            S61124=2;
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
                    
>>>>>>> Stashed changes
                  }
                  break;
                
                case 3 : 
<<<<<<< Updated upstream
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
=======
                  S61124=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 4 : 
                  S61124=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
>>>>>>> Stashed changes
                  break;
                
              }
            }
            break;
          
          case 2 : 
<<<<<<< Updated upstream
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
=======
            S61124=2;
            S61124=0;
            if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 49, column: 20
              S61124=1;
              if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 51, column: 20
                start_in.setPreempted();
                done_o.setPreempted();
                S61124=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S56412=0;
                S56396=0;
                if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 52, column: 5
                  start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                  S56396=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S56391=0;
                  if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                    start_in.setACK(true);//sysj\lidLoaderController.sysj line: 52, column: 5
                    S56391=1;
                    if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
                      start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 52, column: 5
                      w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 53, column: 5
                      S56412=1;
                      if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 55, column: 8
                        System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 56, column: 6
                        w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 57, column: 6
                        S56412=2;
                        S57203=0;
                        if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                          S57203=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S57198=0;
                          if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                            done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                            S57198=1;
                            if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                              ends[3]=2;
                              ;//sysj\lidLoaderController.sysj line: 98, column: 5
                              S61124=2;
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
                        if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 59, column: 13
                          S56440=0;
                          if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 14
                            System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 62, column: 7
                            if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 23
                              S56440=1;
                              if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                                S56440=2;
                                if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                  S56440=3;
                                  if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                    S56440=4;
                                    if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                      S56440=5;
                                      if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                        S56440=6;
                                        if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                          w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                          lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                          if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                            lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                          }
                                          t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                          if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                            twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                            S56412=2;
                                            S57203=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                              S57203=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S57198=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                S57198=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  S61124=2;
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
                                            System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                            S56412=2;
                                            S57203=0;
                                            if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                              done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                              S57203=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S57198=0;
                                              if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                S57198=1;
                                                if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                  S61124=2;
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
                                        thread85393(tdone,ends);
                                        thread85394(tdone,ends);
                                        int biggest85395 = 0;
                                        if(ends[4]>=biggest85395){
                                          biggest85395=ends[4];
                                        }
                                        if(ends[5]>=biggest85395){
                                          biggest85395=ends[5];
                                        }
                                        if(biggest85395 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                      currsigs.addElement(vacOn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                                pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                                currsigs.addElement(pusherExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              refill.setPresent();//sysj\lidLoaderController.sysj line: 64, column: 8
                              currsigs.addElement(refill);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S56440=1;
                            if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                              S56440=2;
                              if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                                S56440=3;
                                if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                                  S56440=4;
                                  if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                                    S56440=5;
                                    if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                      S56440=6;
                                      if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                        w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                        lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                        if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                          lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                        }
                                        t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                          twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                          S56412=2;
                                          S57203=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                            S57203=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S57198=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                              S57198=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                S61124=2;
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
                                          System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                          S56412=2;
                                          S57203=0;
                                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                            S57203=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S57198=0;
                                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                              S57198=1;
                                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                                S61124=2;
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
                                      thread85396(tdone,ends);
                                      thread85397(tdone,ends);
                                      int biggest85398 = 0;
                                      if(ends[4]>=biggest85398){
                                        biggest85398=ends[4];
                                      }
                                      if(ends[5]>=biggest85398){
                                        biggest85398=ends[5];
                                      }
                                      if(biggest85398 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                                    currsigs.addElement(vacOn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                              pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                              currsigs.addElement(pusherExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          S56412=2;
                          S57203=0;
                          if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                            done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                            S57203=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S57198=0;
                            if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                              done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                              S57198=1;
                              if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                ends[3]=2;
                                ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                S61124=2;
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
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
  public void thread85349(int [] tdone, int [] ends){
        switch(S56387){
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
  public void thread85347(int [] tdone, int [] ends){
        S85335=1;
    S84981=0;
    if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 106, column: 20
      S84981=1;
      if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 107, column: 20
        S84981=2;
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
  public void thread3114(int [] tdone, int [] ends){
        S2198=1;
    S2149=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
=======
  public void thread85345(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85344(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85342(int [] tdone, int [] ends){
        S56507=1;
    vacOn.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 33
    currsigs.addElement(vacOn);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread85341(int [] tdone, int [] ends){
        S56502=1;
    armDest.setPresent();//sysj\lidLoaderController.sysj line: 84, column: 9
    currsigs.addElement(armDest);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread85340(int [] tdone, int [] ends){
        S84805=1;
    t_thread_3 = new LidLoaderTwin();//sysj\lidLoaderController.sysj line: 44, column: 3
    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 45, column: 3
    w_thread_3 = null;//sysj\lidLoaderController.sysj line: 46, column: 3
    S61124=0;
    if(auto_1.getprestatus()){//sysj\lidLoaderController.sysj line: 49, column: 20
      S61124=1;
      if(manual_1.getprestatus()){//sysj\lidLoaderController.sysj line: 51, column: 20
        start_in.setPreempted();
        done_o.setPreempted();
        S61124=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S56412=0;
        S56396=0;
        if(!start_in.isPartnerPresent() || start_in.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 52, column: 5
          start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
          S56396=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S56391=0;
          if(!start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
            start_in.setACK(true);//sysj\lidLoaderController.sysj line: 52, column: 5
            S56391=1;
            if(start_in.isREQ()){//sysj\lidLoaderController.sysj line: 52, column: 5
              start_in.setACK(false);//sysj\lidLoaderController.sysj line: 52, column: 5
              ends[3]=2;
              ;//sysj\lidLoaderController.sysj line: 52, column: 5
              w_thread_3 = (WorkpieceTwin)(start_in.getVal() == null ? null : ((WorkpieceTwin)start_in.getVal()));//sysj\lidLoaderController.sysj line: 53, column: 5
              S56412=1;
              if(w_thread_3 != null && w_thread_3.catchFault("lid-fitted")){//sysj\lidLoaderController.sysj line: 55, column: 8
                System.out.println("[LID] " + w_thread_3 + " already has a lid fitted.");//sysj\lidLoaderController.sysj line: 56, column: 6
                w_thread_3.reject(Machine.LID_LOADER, "lid already fitted");//sysj\lidLoaderController.sysj line: 57, column: 6
                S56412=2;
                S57203=0;
                if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                  done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                  S57203=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S57198=0;
                  if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                    done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                    S57198=1;
                    if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                      ends[3]=2;
                      ;//sysj\lidLoaderController.sysj line: 98, column: 5
                      S61124=2;
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
                if(w_thread_3 != null){//sysj\lidLoaderController.sysj line: 59, column: 13
                  S56440=0;
                  if(magazineEmpty.getprestatus()){//sysj\lidLoaderController.sysj line: 61, column: 14
                    System.out.println("[LID] Magazine empty, refilling.");//sysj\lidLoaderController.sysj line: 62, column: 7
                    if(refilled.getprestatus()){//sysj\lidLoaderController.sysj line: 63, column: 23
                      S56440=1;
                      if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                        S56440=2;
                        if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                          S56440=3;
                          if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                            S56440=4;
                            if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                              S56440=5;
                              if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                                S56440=6;
                                if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                  w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                  lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                  if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                    lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                  }
                                  t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                    twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                    S56412=2;
                                    S57203=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57203=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57198=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S57198=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                          S61124=2;
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
                                    System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                    S56412=2;
                                    S57203=0;
                                    if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57203=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S57198=0;
                                      if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S57198=1;
                                        if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                          done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                          S61124=2;
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
                                thread85341(tdone,ends);
                                thread85342(tdone,ends);
                                int biggest85343 = 0;
                                if(ends[4]>=biggest85343){
                                  biggest85343=ends[4];
                                }
                                if(ends[5]>=biggest85343){
                                  biggest85343=ends[5];
                                }
                                if(biggest85343 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                              currsigs.addElement(vacOn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                        pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                        currsigs.addElement(pusherExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      refill.setPresent();//sysj\lidLoaderController.sysj line: 64, column: 8
                      currsigs.addElement(refill);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    S56440=1;
                    if(pusherExtended.getprestatus()){//sysj\lidLoaderController.sysj line: 69, column: 22
                      S56440=2;
                      if(pusherRetracted.getprestatus()){//sysj\lidLoaderController.sysj line: 72, column: 22
                        S56440=3;
                        if(armAtSource.getprestatus()){//sysj\lidLoaderController.sysj line: 75, column: 22
                          S56440=4;
                          if(WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 78, column: 22
                            S56440=5;
                            if(armAtDest.getprestatus()){//sysj\lidLoaderController.sysj line: 83, column: 22
                              S56440=6;
                              if(!WPgripped.getprestatus()){//sysj\lidLoaderController.sysj line: 86, column: 22
                                w_thread_3.lid();//sysj\lidLoaderController.sysj line: 88, column: 6
                                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderController.sysj line: 89, column: 6
                                if(lids_thread_3 < 0) {//sysj\lidLoaderController.sysj line: 90, column: 18
                                  lids_thread_3 = 3;//sysj\lidLoaderController.sysj line: 90, column: 20
                                }
                                t_thread_3.setLidsRemaining(lids_thread_3);//sysj\lidLoaderController.sysj line: 91, column: 6
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "place", "lid on " + w_thread_3.id)){//sysj\lidLoaderController.sysj line: 92, column: 6
                                  twin.setPresent();//sysj\lidLoaderController.sysj line: 93, column: 7
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\lidLoaderController.sysj line: 93, column: 7
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                  S56412=2;
                                  S57203=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57203=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57198=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57198=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S61124=2;
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
                                  System.out.println("[LID] Lid placed on " + w_thread_3 + ".");//sysj\lidLoaderController.sysj line: 95, column: 6
                                  S56412=2;
                                  S57203=0;
                                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                    S57203=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S57198=0;
                                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                                      S57198=1;
                                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                                        S61124=2;
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
                              thread85344(tdone,ends);
                              thread85345(tdone,ends);
                              int biggest85346 = 0;
                              if(ends[4]>=biggest85346){
                                biggest85346=ends[4];
                              }
                              if(ends[5]>=biggest85346){
                                biggest85346=ends[5];
                              }
                              if(biggest85346 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            vacOn.setPresent();//sysj\lidLoaderController.sysj line: 79, column: 7
                            currsigs.addElement(vacOn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          armSource.setPresent();//sysj\lidLoaderController.sysj line: 76, column: 7
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
                      pusherExtend.setPresent();//sysj\lidLoaderController.sysj line: 70, column: 7
                      currsigs.addElement(pusherExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  S56412=2;
                  S57203=0;
                  if(!done_o.isPartnerPresent() || done_o.isPartnerPreempted()){//sysj\lidLoaderController.sysj line: 98, column: 5
                    done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                    S57203=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S57198=0;
                    if(done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                      done_o.setVal(w_thread_3);//sysj\lidLoaderController.sysj line: 98, column: 5
                      S57198=1;
                      if(!done_o.isACK()){//sysj\lidLoaderController.sysj line: 98, column: 5
                        done_o.setREQ(false);//sysj\lidLoaderController.sysj line: 98, column: 5
                        ends[3]=2;
                        ;//sysj\lidLoaderController.sysj line: 98, column: 5
                        S61124=2;
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

  public void thread85339(int [] tdone, int [] ends){
        S56387=1;
    if(mode.getprestatus()){//sysj\lidLoaderController.sysj line: 35, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidLoaderController.sysj line: 36, column: 8
        auto_1.setPresent();//sysj\lidLoaderController.sysj line: 36, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\lidLoaderController.sysj line: 37, column: 12
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
>>>>>>> Stashed changes
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
<<<<<<< Updated upstream
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
=======
      switch(S85337){
        case 0 : 
          S85337=0;
          break RUN;
        
        case 1 : 
          S85337=2;
          S85337=2;
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 31, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 31, column: 2
          thread85339(tdone,ends);
          thread85340(tdone,ends);
          thread85347(tdone,ends);
          int biggest85348 = 0;
          if(ends[2]>=biggest85348){
            biggest85348=ends[2];
          }
          if(ends[3]>=biggest85348){
            biggest85348=ends[3];
          }
          if(ends[6]>=biggest85348){
            biggest85348=ends[6];
          }
          if(biggest85348 == 1){
>>>>>>> Stashed changes
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
<<<<<<< Updated upstream
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
=======
          auto_1.setClear();//sysj\lidLoaderController.sysj line: 31, column: 2
          manual_1.setClear();//sysj\lidLoaderController.sysj line: 31, column: 2
          thread85349(tdone,ends);
          thread85350(tdone,ends);
          thread85399(tdone,ends);
          int biggest85400 = 0;
          if(ends[2]>=biggest85400){
            biggest85400=ends[2];
          }
          if(ends[3]>=biggest85400){
            biggest85400=ends[3];
          }
          if(ends[6]>=biggest85400){
            biggest85400=ends[6];
          }
          if(biggest85400 == 1){
>>>>>>> Stashed changes
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
<<<<<<< Updated upstream
          if(biggest3158 == 0){
            S3112=0;
            active[1]=0;
            ends[1]=0;
            S3112=0;
=======
          if(biggest85400 == 0){
            S85337=0;
            active[1]=0;
            ends[1]=0;
            S85337=0;
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
