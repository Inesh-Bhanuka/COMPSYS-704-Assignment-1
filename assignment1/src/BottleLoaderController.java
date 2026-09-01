import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class BottleLoaderController extends ClockDomain{
  public BottleLoaderController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal bottleLoad = new Signal("bottleLoad", Signal.INPUT);
  public Signal bottleAtSource = new Signal("bottleAtSource", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal supplyEmpty = new Signal("supplyEmpty", Signal.INPUT);
  public Signal conveyorReady = new Signal("conveyorReady", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal bottleLoaded = new Signal("bottleLoaded", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal release = new Signal("release", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal bottlePlaced = new Signal("bottlePlaced", Signal.OUTPUT);
  private Signal auto_1;
  private Signal manual_1;
  private boolean reported_thread_5;//sysj\bottleLoaderController.sysj line: 135, column: 3
  private int S1151 = 1;
  private int S12 = 1;
  private int S848 = 1;
  private int S290 = 1;
  private int S15 = 1;
  private int S1135 = 1;
  private int S943 = 1;
  private int S1149 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread1161(int [] tdone, int [] ends){
        switch(S1149){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(supplyEmpty.getprestatus()){//sysj\bottleLoaderController.sysj line: 137, column: 12
          if(!reported_thread_5) {//sysj\bottleLoaderController.sysj line: 138, column: 18
            System.out.println("[BL] Bottle supply is empty.");//sysj\bottleLoaderController.sysj line: 139, column: 6
            reported_thread_5 = true;//sysj\bottleLoaderController.sysj line: 140, column: 6
          }
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          reported_thread_5 = false;//sysj\bottleLoaderController.sysj line: 144, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread1160(int [] tdone, int [] ends){
        switch(S1135){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S943){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 121, column: 20
              S943=1;
              if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 122, column: 20
                S943=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 124, column: 14
                  vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 124, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 125, column: 14
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 125, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                      currsigs.addElement(armDest);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                      currsigs.addElement(armDest);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 125, column: 14
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 125, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                      currsigs.addElement(armDest);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                      currsigs.addElement(armDest);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 122, column: 20
              S943=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 124, column: 14
                vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 124, column: 23
                currsigs.addElement(vacOn);
                if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 125, column: 14
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 125, column: 27
                  currsigs.addElement(armSource);
                  if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                    currsigs.addElement(armDest);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                    currsigs.addElement(armDest);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
              }
              else {
                if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 125, column: 14
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 125, column: 27
                  currsigs.addElement(armSource);
                  if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                    currsigs.addElement(armDest);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                    currsigs.addElement(armDest);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
              }
            }
            break;
          
          case 2 : 
            S943=2;
            S943=0;
            if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 121, column: 20
              S943=1;
              if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 122, column: 20
                S943=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 124, column: 14
                  vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 124, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 125, column: 14
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 125, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                      currsigs.addElement(armDest);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                      currsigs.addElement(armDest);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 125, column: 14
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 125, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                      currsigs.addElement(armDest);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
                      currsigs.addElement(armDest);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1159(int [] tdone, int [] ends){
        switch(S848){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S290){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 53, column: 20
              S290=1;
              if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 55, column: 20
                S290=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S15=0;
                if(bottleLoad.getprestatus()){//sysj\bottleLoaderController.sysj line: 57, column: 21
                  System.out.println("[BL] Load request received.");//sysj\bottleLoaderController.sysj line: 58, column: 5
                  if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 60, column: 13
                    S15=1;
                    if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 13
                      S15=2;
                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                      currsigs.addElement(armSource);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      System.out.println("[BL] Conveyor busy - holding request.");//sysj\bottleLoaderController.sysj line: 72, column: 6
                      if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                        System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                        S15=2;
                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                        currsigs.addElement(armSource);
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
                    System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 64, column: 6
                    S15=1;
                    if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 13
                      S15=2;
                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                      currsigs.addElement(armSource);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      System.out.println("[BL] Conveyor busy - holding request.");//sysj\bottleLoaderController.sysj line: 72, column: 6
                      if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                        System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                        S15=2;
                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                        currsigs.addElement(armSource);
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
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 55, column: 20
              S290=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S15){
                case 0 : 
                  if(bottleLoad.getprestatus()){//sysj\bottleLoaderController.sysj line: 57, column: 21
                    System.out.println("[BL] Load request received.");//sysj\bottleLoaderController.sysj line: 58, column: 5
                    if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 60, column: 13
                      S15=1;
                      if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 13
                        S15=2;
                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        System.out.println("[BL] Conveyor busy - holding request.");//sysj\bottleLoaderController.sysj line: 72, column: 6
                        if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                          System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                          S15=2;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                          currsigs.addElement(armSource);
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
                      System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 64, column: 6
                      S15=1;
                      if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 13
                        S15=2;
                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                        currsigs.addElement(armSource);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        System.out.println("[BL] Conveyor busy - holding request.");//sysj\bottleLoaderController.sysj line: 72, column: 6
                        if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                          System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                          S15=2;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                          currsigs.addElement(armSource);
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 1 : 
                  if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                    System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                    S15=2;
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                    currsigs.addElement(armSource);
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
                
                case 2 : 
                  if(armAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 78, column: 11
                    S15=3;
                    vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 84, column: 6
                    currsigs.addElement(vacOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                    currsigs.addElement(armSource);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  if(WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 83, column: 11
                    System.out.println("[BL] Bottle gripped.");//sysj\bottleLoaderController.sysj line: 86, column: 5
                    S15=4;
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 90, column: 6
                    currsigs.addElement(armDest);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 84, column: 6
                    currsigs.addElement(vacOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 4 : 
                  if(armAtDest.getprestatus()){//sysj\bottleLoaderController.sysj line: 89, column: 11
                    S15=5;
                    if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 95, column: 13
                      System.out.println("[BL] Conveyor ready - releasing.");//sysj\bottleLoaderController.sysj line: 102, column: 5
                      release.setPresent();//sysj\bottleLoaderController.sysj line: 107, column: 5
                      currsigs.addElement(release);
                      bottlePlaced.setPresent();//sysj\bottleLoaderController.sysj line: 107, column: 19
                      currsigs.addElement(bottlePlaced);
                      S15=6;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      System.out.println("[BL] At conveyor - waiting for ready.");//sysj\bottleLoaderController.sysj line: 99, column: 6
                      if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 100, column: 22
                        System.out.println("[BL] Conveyor ready - releasing.");//sysj\bottleLoaderController.sysj line: 102, column: 5
                        release.setPresent();//sysj\bottleLoaderController.sysj line: 107, column: 5
                        currsigs.addElement(release);
                        bottlePlaced.setPresent();//sysj\bottleLoaderController.sysj line: 107, column: 19
                        currsigs.addElement(bottlePlaced);
                        S15=6;
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
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 90, column: 6
                    currsigs.addElement(armDest);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 5 : 
                  if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 100, column: 22
                    System.out.println("[BL] Conveyor ready - releasing.");//sysj\bottleLoaderController.sysj line: 102, column: 5
                    release.setPresent();//sysj\bottleLoaderController.sysj line: 107, column: 5
                    currsigs.addElement(release);
                    bottlePlaced.setPresent();//sysj\bottleLoaderController.sysj line: 107, column: 19
                    currsigs.addElement(bottlePlaced);
                    S15=6;
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
                
                case 6 : 
                  S15=6;
                  release.setPresent();//sysj\bottleLoaderController.sysj line: 108, column: 5
                  currsigs.addElement(release);
                  bottlePlaced.setPresent();//sysj\bottleLoaderController.sysj line: 108, column: 19
                  currsigs.addElement(bottlePlaced);
                  S15=7;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 7 : 
                  S15=7;
                  release.setPresent();//sysj\bottleLoaderController.sysj line: 109, column: 5
                  currsigs.addElement(release);
                  bottlePlaced.setPresent();//sysj\bottleLoaderController.sysj line: 109, column: 19
                  currsigs.addElement(bottlePlaced);
                  S15=8;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 8 : 
                  S15=8;
                  bottleLoaded.setPresent();//sysj\bottleLoaderController.sysj line: 111, column: 5
                  currsigs.addElement(bottleLoaded);
                  System.out.println("[BL] Cycle complete.");//sysj\bottleLoaderController.sysj line: 112, column: 5
                  S15=9;
                  if(!bottleLoad.getprestatus()){//sysj\bottleLoaderController.sysj line: 113, column: 21
                    S290=2;
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
                
                case 9 : 
                  if(!bottleLoad.getprestatus()){//sysj\bottleLoaderController.sysj line: 113, column: 21
                    S290=2;
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
                
                case 10 : 
                  S290=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S290=2;
            S290=0;
            if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 53, column: 20
              S290=1;
              if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 55, column: 20
                S290=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S15=0;
                if(bottleLoad.getprestatus()){//sysj\bottleLoaderController.sysj line: 57, column: 21
                  System.out.println("[BL] Load request received.");//sysj\bottleLoaderController.sysj line: 58, column: 5
                  if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 60, column: 13
                    S15=1;
                    if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 13
                      S15=2;
                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                      currsigs.addElement(armSource);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      System.out.println("[BL] Conveyor busy - holding request.");//sysj\bottleLoaderController.sysj line: 72, column: 6
                      if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                        System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                        S15=2;
                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                        currsigs.addElement(armSource);
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
                    System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 64, column: 6
                    S15=1;
                    if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 13
                      S15=2;
                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                      currsigs.addElement(armSource);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      System.out.println("[BL] Conveyor busy - holding request.");//sysj\bottleLoaderController.sysj line: 72, column: 6
                      if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                        System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                        S15=2;
                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                        currsigs.addElement(armSource);
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
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
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
        break;
      
    }
  }

  public void thread1158(int [] tdone, int [] ends){
        switch(S12){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\bottleLoaderController.sysj line: 39, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleLoaderController.sysj line: 40, column: 8
            auto_1.setPresent();//sysj\bottleLoaderController.sysj line: 41, column: 6
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\bottleLoaderController.sysj line: 44, column: 6
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
        break;
      
    }
  }

  public void thread1156(int [] tdone, int [] ends){
        S1149=1;
    reported_thread_5 = false;//sysj\bottleLoaderController.sysj line: 135, column: 3
    if(supplyEmpty.getprestatus()){//sysj\bottleLoaderController.sysj line: 137, column: 12
      if(!reported_thread_5) {//sysj\bottleLoaderController.sysj line: 138, column: 18
        System.out.println("[BL] Bottle supply is empty.");//sysj\bottleLoaderController.sysj line: 139, column: 6
        reported_thread_5 = true;//sysj\bottleLoaderController.sysj line: 140, column: 6
      }
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      reported_thread_5 = false;//sysj\bottleLoaderController.sysj line: 144, column: 5
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread1155(int [] tdone, int [] ends){
        S1135=1;
    S943=0;
    if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 121, column: 20
      S943=1;
      if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 122, column: 20
        S943=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 124, column: 14
          vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 124, column: 23
          currsigs.addElement(vacOn);
          if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 125, column: 14
            armSource.setPresent();//sysj\bottleLoaderController.sysj line: 125, column: 27
            currsigs.addElement(armSource);
            if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
              armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
              currsigs.addElement(armDest);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
              armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
              currsigs.addElement(armDest);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
        }
        else {
          if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 125, column: 14
            armSource.setPresent();//sysj\bottleLoaderController.sysj line: 125, column: 27
            currsigs.addElement(armSource);
            if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
              armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
              currsigs.addElement(armDest);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
              armDest.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 25
              currsigs.addElement(armDest);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
        }
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread1154(int [] tdone, int [] ends){
        S848=1;
    S290=0;
    if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 53, column: 20
      S290=1;
      if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 55, column: 20
        S290=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S15=0;
        if(bottleLoad.getprestatus()){//sysj\bottleLoaderController.sysj line: 57, column: 21
          System.out.println("[BL] Load request received.");//sysj\bottleLoaderController.sysj line: 58, column: 5
          if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 60, column: 13
            S15=1;
            if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 13
              S15=2;
              armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
              currsigs.addElement(armSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              System.out.println("[BL] Conveyor busy - holding request.");//sysj\bottleLoaderController.sysj line: 72, column: 6
              if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                S15=2;
                armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                currsigs.addElement(armSource);
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
            System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 64, column: 6
            S15=1;
            if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 13
              S15=2;
              armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
              currsigs.addElement(armSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              System.out.println("[BL] Conveyor busy - holding request.");//sysj\bottleLoaderController.sysj line: 72, column: 6
              if(conveyorReady.getprestatus()){//sysj\bottleLoaderController.sysj line: 73, column: 22
                System.out.println("[BL] Conveyor clear - starting cycle.");//sysj\bottleLoaderController.sysj line: 74, column: 6
                S15=2;
                armSource.setPresent();//sysj\bottleLoaderController.sysj line: 79, column: 6
                currsigs.addElement(armSource);
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
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
      }
    }
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread1153(int [] tdone, int [] ends){
        S12=1;
    if(mode.getprestatus()){//sysj\bottleLoaderController.sysj line: 39, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleLoaderController.sysj line: 40, column: 8
        auto_1.setPresent();//sysj\bottleLoaderController.sysj line: 41, column: 6
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\bottleLoaderController.sysj line: 44, column: 6
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
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1151){
        case 0 : 
          S1151=0;
          break RUN;
        
        case 1 : 
          S1151=2;
          S1151=2;
          auto_1.setClear();//sysj\bottleLoaderController.sysj line: 35, column: 2
          manual_1.setClear();//sysj\bottleLoaderController.sysj line: 35, column: 2
          thread1153(tdone,ends);
          thread1154(tdone,ends);
          thread1155(tdone,ends);
          thread1156(tdone,ends);
          int biggest1157 = 0;
          if(ends[2]>=biggest1157){
            biggest1157=ends[2];
          }
          if(ends[3]>=biggest1157){
            biggest1157=ends[3];
          }
          if(ends[4]>=biggest1157){
            biggest1157=ends[4];
          }
          if(ends[5]>=biggest1157){
            biggest1157=ends[5];
          }
          if(biggest1157 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\bottleLoaderController.sysj line: 35, column: 2
          manual_1.setClear();//sysj\bottleLoaderController.sysj line: 35, column: 2
          thread1158(tdone,ends);
          thread1159(tdone,ends);
          thread1160(tdone,ends);
          thread1161(tdone,ends);
          int biggest1162 = 0;
          if(ends[2]>=biggest1162){
            biggest1162=ends[2];
          }
          if(ends[3]>=biggest1162){
            biggest1162=ends[3];
          }
          if(ends[4]>=biggest1162){
            biggest1162=ends[4];
          }
          if(ends[5]>=biggest1162){
            biggest1162=ends[5];
          }
          if(biggest1162 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1162 == 0){
            S1151=0;
            active[1]=0;
            ends[1]=0;
            S1151=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
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
          mode.gethook();
          bottleLoad.gethook();
          bottleAtSource.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          supplyEmpty.gethook();
          conveyorReady.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      bottleLoad.setpreclear();
      bottleAtSource.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      supplyEmpty.setpreclear();
      conveyorReady.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      bottleLoaded.setpreclear();
      vacOn.setpreclear();
      release.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      bottlePlaced.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = bottleLoad.getStatus() ? bottleLoad.setprepresent() : bottleLoad.setpreclear();
      bottleLoad.setpreval(bottleLoad.getValue());
      bottleLoad.setClear();
      dummyint = bottleAtSource.getStatus() ? bottleAtSource.setprepresent() : bottleAtSource.setpreclear();
      bottleAtSource.setpreval(bottleAtSource.getValue());
      bottleAtSource.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = supplyEmpty.getStatus() ? supplyEmpty.setprepresent() : supplyEmpty.setpreclear();
      supplyEmpty.setpreval(supplyEmpty.getValue());
      supplyEmpty.setClear();
      dummyint = conveyorReady.getStatus() ? conveyorReady.setprepresent() : conveyorReady.setpreclear();
      conveyorReady.setpreval(conveyorReady.getValue());
      conveyorReady.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      bottleLoaded.sethook();
      bottleLoaded.setClear();
      vacOn.sethook();
      vacOn.setClear();
      release.sethook();
      release.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      bottlePlaced.sethook();
      bottlePlaced.setClear();
      auto_1.setClear();
      manual_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        mode.gethook();
        bottleLoad.gethook();
        bottleAtSource.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        supplyEmpty.gethook();
        conveyorReady.gethook();
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
