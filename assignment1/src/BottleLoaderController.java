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
  public Signal bottleAtSource = new Signal("bottleAtSource", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal supplyEmpty = new Signal("supplyEmpty", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal release = new Signal("release", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public input_Channel loadOrder_in = new input_Channel();
  public output_Channel loadAck_o = new output_Channel();
  public output_Channel bottleHandoff_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private LoaderTwin t_thread_3;//sysj\bottleLoaderController.sysj line: 58, column: 3
  private int remaining_thread_3;//sysj\bottleLoaderController.sysj line: 59, column: 3
  private WorkpieceTwin w_thread_3;//sysj\bottleLoaderController.sysj line: 60, column: 3
  private boolean reported_thread_5;//sysj\bottleLoaderController.sysj line: 137, column: 3
  private int S6917 = 1;
  private int S12 = 1;
  private int S6614 = 1;
  private int S1113 = 1;
  private int S37 = 1;
  private int S21 = 1;
  private int S16 = 1;
  private int S123 = 1;
  private int S118 = 1;
  private int S188 = 1;
  private int S183 = 1;
  private int S6901 = 1;
  private int S6709 = 1;
  private int S6915 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread6927(int [] tdone, int [] ends){
        switch(S6915){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(supplyEmpty.getprestatus()){//sysj\bottleLoaderController.sysj line: 139, column: 12
          if(!reported_thread_5) {//sysj\bottleLoaderController.sysj line: 140, column: 18
            System.out.println("[BL] Bottle supply is empty.");//sysj\bottleLoaderController.sysj line: 141, column: 6
            reported_thread_5 = true;//sysj\bottleLoaderController.sysj line: 142, column: 6
          }
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          reported_thread_5 = false;//sysj\bottleLoaderController.sysj line: 146, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread6926(int [] tdone, int [] ends){
        switch(S6901){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S6709){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 123, column: 20
              S6709=1;
              if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 124, column: 20
                S6709=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                  vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 127, column: 14
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 127, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 127, column: 14
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 127, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
            if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 124, column: 20
              S6709=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 23
                currsigs.addElement(vacOn);
                if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 127, column: 14
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 127, column: 27
                  currsigs.addElement(armSource);
                  if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                  if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 127, column: 14
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 127, column: 27
                  currsigs.addElement(armSource);
                  if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                  if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
            S6709=2;
            S6709=0;
            if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 123, column: 20
              S6709=1;
              if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 124, column: 20
                S6709=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
                  vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 23
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 127, column: 14
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 127, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 127, column: 14
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 127, column: 27
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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

  public void thread6925(int [] tdone, int [] ends){
        switch(S6614){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1113){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 63, column: 20
              S1113=1;
              if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 65, column: 20
                loadOrder_in.setPreempted();
                bottleHandoff_o.setPreempted();
                loadAck_o.setPreempted();
                S1113=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S37=0;
                S21=0;
                if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                  loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                  S21=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S16=0;
                  if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                    loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 67, column: 5
                    S16=1;
                    if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                      loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                      ends[3]=2;
                      ;//sysj\bottleLoaderController.sysj line: 67, column: 5
                      w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 68, column: 5
                      System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 69, column: 5
                      w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 70, column: 5
                      w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 71, column: 5
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 72, column: 5
                        twin.setPresent();//sysj\bottleLoaderController.sysj line: 73, column: 6
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 73, column: 6
                        if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                          S37=1;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                          S37=1;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                          S37=1;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                          S37=1;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                          currsigs.addElement(armSource);
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
            if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 65, column: 20
              loadOrder_in.setPreempted();
              bottleHandoff_o.setPreempted();
              loadAck_o.setPreempted();
              S1113=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S37){
                case 0 : 
                  switch(S21){
                    case 0 : 
                      if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                        loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                        S21=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S16){
                          case 0 : 
                            if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                              loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 67, column: 5
                              S16=1;
                              if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                                loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                                ends[3]=2;
                                ;//sysj\bottleLoaderController.sysj line: 67, column: 5
                                w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 68, column: 5
                                System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 69, column: 5
                                w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 70, column: 5
                                w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 71, column: 5
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 72, column: 5
                                  twin.setPresent();//sysj\bottleLoaderController.sysj line: 73, column: 6
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 73, column: 6
                                  if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                                    S37=1;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                    currsigs.addElement(armSource);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                                    S37=1;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                    currsigs.addElement(armSource);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                                    S37=1;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                    currsigs.addElement(armSource);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                                    S37=1;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                    currsigs.addElement(armSource);
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
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                              loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                              ends[3]=2;
                              ;//sysj\bottleLoaderController.sysj line: 67, column: 5
                              w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 68, column: 5
                              System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 69, column: 5
                              w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 70, column: 5
                              w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 71, column: 5
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 72, column: 5
                                twin.setPresent();//sysj\bottleLoaderController.sysj line: 73, column: 6
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 73, column: 6
                                if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                                  S37=1;
                                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                                  S37=1;
                                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                                  S37=1;
                                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                                  S37=1;
                                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                  currsigs.addElement(armSource);
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
                      }
                      break;
                    
                    case 1 : 
                      S21=1;
                      S21=0;
                      if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                        loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                        S21=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S16=0;
                        if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                          loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 67, column: 5
                          S16=1;
                          if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                            loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 67, column: 5
                            w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 68, column: 5
                            System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 69, column: 5
                            w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 70, column: 5
                            w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 71, column: 5
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 72, column: 5
                              twin.setPresent();//sysj\bottleLoaderController.sysj line: 73, column: 6
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 73, column: 6
                              if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                                S37=1;
                                armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                currsigs.addElement(armSource);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                                S37=1;
                                armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                currsigs.addElement(armSource);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                                S37=1;
                                armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                currsigs.addElement(armSource);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                                S37=1;
                                armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                                currsigs.addElement(armSource);
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
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 1 : 
                  if(armAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 84, column: 11
                    S37=2;
                    vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 90, column: 6
                    currsigs.addElement(vacOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                    currsigs.addElement(armSource);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 89, column: 11
                    System.out.println("[BL] " + w_thread_3 + " gripped.");//sysj\bottleLoaderController.sysj line: 92, column: 5
                    S37=3;
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 96, column: 6
                    currsigs.addElement(armDest);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 90, column: 6
                    currsigs.addElement(vacOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  if(armAtDest.getprestatus()){//sysj\bottleLoaderController.sysj line: 95, column: 11
                    System.out.println("[BL] Offering " + w_thread_3 + " to the conveyor.");//sysj\bottleLoaderController.sysj line: 100, column: 5
                    S37=4;
                    S123=0;
                    if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                      bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 101, column: 5
                      S123=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S118=0;
                      if(bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                        bottleHandoff_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 101, column: 5
                        S118=1;
                        if(!bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                          bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 101, column: 5
                          ends[3]=2;
                          ;//sysj\bottleLoaderController.sysj line: 101, column: 5
                          S37=5;
                          if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 105, column: 21
                            w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 109, column: 5
                            remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 110, column: 5
                            t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 111, column: 5
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 112, column: 5
                              twin.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 113, column: 6
                              S37=6;
                              S188=0;
                              if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                S188=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S183=0;
                                if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                  loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                  S183=1;
                                  if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    S1113=2;
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
                              S37=6;
                              S188=0;
                              if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                S188=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S183=0;
                                if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                  loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                  S183=1;
                                  if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    ends[3]=2;
                                    ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    S1113=2;
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
                            release.setPresent();//sysj\bottleLoaderController.sysj line: 106, column: 6
                            currsigs.addElement(release);
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 96, column: 6
                    currsigs.addElement(armDest);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 4 : 
                  switch(S123){
                    case 0 : 
                      if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                        bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 101, column: 5
                        S123=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S118){
                          case 0 : 
                            if(bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                              bottleHandoff_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 101, column: 5
                              S118=1;
                              if(!bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                                bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 101, column: 5
                                ends[3]=2;
                                ;//sysj\bottleLoaderController.sysj line: 101, column: 5
                                S37=5;
                                if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 105, column: 21
                                  w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 109, column: 5
                                  remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 110, column: 5
                                  t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 111, column: 5
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 112, column: 5
                                    twin.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 113, column: 6
                                    S37=6;
                                    S188=0;
                                    if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      S188=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S183=0;
                                      if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        S183=1;
                                        if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                          S1113=2;
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
                                    S37=6;
                                    S188=0;
                                    if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      S188=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S183=0;
                                      if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        S183=1;
                                        if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                          S1113=2;
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
                                  release.setPresent();//sysj\bottleLoaderController.sysj line: 106, column: 6
                                  currsigs.addElement(release);
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(!bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                              bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 101, column: 5
                              ends[3]=2;
                              ;//sysj\bottleLoaderController.sysj line: 101, column: 5
                              S37=5;
                              if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 105, column: 21
                                w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 109, column: 5
                                remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 110, column: 5
                                t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 111, column: 5
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 112, column: 5
                                  twin.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 113, column: 6
                                  S37=6;
                                  S188=0;
                                  if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    S188=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S183=0;
                                    if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      S183=1;
                                      if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        S1113=2;
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
                                  S37=6;
                                  S188=0;
                                  if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    S188=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S183=0;
                                    if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      S183=1;
                                      if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                        S1113=2;
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
                                release.setPresent();//sysj\bottleLoaderController.sysj line: 106, column: 6
                                currsigs.addElement(release);
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
                          
                        }
                      }
                      break;
                    
                    case 1 : 
                      S123=1;
                      S123=0;
                      if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                        bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 101, column: 5
                        S123=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S118=0;
                        if(bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                          bottleHandoff_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 101, column: 5
                          S118=1;
                          if(!bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 101, column: 5
                            bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 101, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 101, column: 5
                            S37=5;
                            if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 105, column: 21
                              w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 109, column: 5
                              remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 110, column: 5
                              t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 111, column: 5
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 112, column: 5
                                twin.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 113, column: 6
                                S37=6;
                                S188=0;
                                if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                  loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                  S188=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S183=0;
                                  if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    S183=1;
                                    if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      S1113=2;
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
                                S37=6;
                                S188=0;
                                if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                  loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                  S188=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S183=0;
                                  if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                    S183=1;
                                    if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                      S1113=2;
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
                              release.setPresent();//sysj\bottleLoaderController.sysj line: 106, column: 6
                              currsigs.addElement(release);
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 5 : 
                  if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 105, column: 21
                    w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 109, column: 5
                    remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 110, column: 5
                    t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 111, column: 5
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 112, column: 5
                      twin.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 113, column: 6
                      S37=6;
                      S188=0;
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                        S188=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S183=0;
                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                          S183=1;
                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                            S1113=2;
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
                      S37=6;
                      S188=0;
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                        S188=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S183=0;
                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                          S183=1;
                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                            S1113=2;
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
                    release.setPresent();//sysj\bottleLoaderController.sysj line: 106, column: 6
                    currsigs.addElement(release);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 6 : 
                  switch(S188){
                    case 0 : 
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                        S188=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S183){
                          case 0 : 
                            if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                              loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                              S183=1;
                              if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                                loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                                ends[3]=2;
                                ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                                S1113=2;
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
                            if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                              loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                              ends[3]=2;
                              ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                              S1113=2;
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
                      S188=1;
                      S188=0;
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                        S188=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S183=0;
                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 115, column: 5
                          S183=1;
                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 115, column: 5
                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 115, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 115, column: 5
                            S1113=2;
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
                    
                  }
                  break;
                
                case 7 : 
                  S1113=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 8 : 
                  S1113=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 9 : 
                  S1113=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S1113=2;
            S1113=0;
            if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 63, column: 20
              S1113=1;
              if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 65, column: 20
                loadOrder_in.setPreempted();
                bottleHandoff_o.setPreempted();
                loadAck_o.setPreempted();
                S1113=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S37=0;
                S21=0;
                if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                  loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                  S21=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S16=0;
                  if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                    loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 67, column: 5
                    S16=1;
                    if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
                      loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
                      ends[3]=2;
                      ;//sysj\bottleLoaderController.sysj line: 67, column: 5
                      w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 68, column: 5
                      System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 69, column: 5
                      w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 70, column: 5
                      w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 71, column: 5
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 72, column: 5
                        twin.setPresent();//sysj\bottleLoaderController.sysj line: 73, column: 6
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 73, column: 6
                        if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                          S37=1;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                          S37=1;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                          S37=1;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                          S37=1;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                          currsigs.addElement(armSource);
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
          
        }
        break;
      
    }
  }

  public void thread6924(int [] tdone, int [] ends){
        switch(S12){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\bottleLoaderController.sysj line: 45, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleLoaderController.sysj line: 46, column: 8
            auto_1.setPresent();//sysj\bottleLoaderController.sysj line: 47, column: 6
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\bottleLoaderController.sysj line: 50, column: 6
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

  public void thread6922(int [] tdone, int [] ends){
        S6915=1;
    reported_thread_5 = false;//sysj\bottleLoaderController.sysj line: 137, column: 3
    if(supplyEmpty.getprestatus()){//sysj\bottleLoaderController.sysj line: 139, column: 12
      if(!reported_thread_5) {//sysj\bottleLoaderController.sysj line: 140, column: 18
        System.out.println("[BL] Bottle supply is empty.");//sysj\bottleLoaderController.sysj line: 141, column: 6
        reported_thread_5 = true;//sysj\bottleLoaderController.sysj line: 142, column: 6
      }
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      reported_thread_5 = false;//sysj\bottleLoaderController.sysj line: 146, column: 5
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread6921(int [] tdone, int [] ends){
        S6901=1;
    S6709=0;
    if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 123, column: 20
      S6709=1;
      if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 124, column: 20
        S6709=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 126, column: 14
          vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 126, column: 23
          currsigs.addElement(vacOn);
          if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 127, column: 14
            armSource.setPresent();//sysj\bottleLoaderController.sysj line: 127, column: 27
            currsigs.addElement(armSource);
            if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
              armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
            if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
              armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
          if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 127, column: 14
            armSource.setPresent();//sysj\bottleLoaderController.sysj line: 127, column: 27
            currsigs.addElement(armSource);
            if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
              armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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
            if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 128, column: 14
              armDest.setPresent();//sysj\bottleLoaderController.sysj line: 128, column: 25
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

  public void thread6920(int [] tdone, int [] ends){
        S6614=1;
    t_thread_3 = new LoaderTwin();//sysj\bottleLoaderController.sysj line: 58, column: 3
    remaining_thread_3 = 20;//sysj\bottleLoaderController.sysj line: 59, column: 3
    w_thread_3 = null;//sysj\bottleLoaderController.sysj line: 60, column: 3
    S1113=0;
    if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 63, column: 20
      S1113=1;
      if(manual_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 65, column: 20
        loadOrder_in.setPreempted();
        bottleHandoff_o.setPreempted();
        loadAck_o.setPreempted();
        S1113=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S37=0;
        S21=0;
        if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 67, column: 5
          loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
          S21=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S16=0;
          if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
            loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 67, column: 5
            S16=1;
            if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 67, column: 5
              loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 67, column: 5
              ends[3]=2;
              ;//sysj\bottleLoaderController.sysj line: 67, column: 5
              w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 68, column: 5
              System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 69, column: 5
              w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 70, column: 5
              w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 71, column: 5
              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 72, column: 5
                twin.setPresent();//sysj\bottleLoaderController.sysj line: 73, column: 6
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 73, column: 6
                if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                  S37=1;
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                  S37=1;
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 76, column: 13
                  S37=1;
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 80, column: 6
                  S37=1;
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 85, column: 6
                  currsigs.addElement(armSource);
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

  public void thread6919(int [] tdone, int [] ends){
        S12=1;
    if(mode.getprestatus()){//sysj\bottleLoaderController.sysj line: 45, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleLoaderController.sysj line: 46, column: 8
        auto_1.setPresent();//sysj\bottleLoaderController.sysj line: 47, column: 6
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\bottleLoaderController.sysj line: 50, column: 6
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
      switch(S6917){
        case 0 : 
          S6917=0;
          break RUN;
        
        case 1 : 
          S6917=2;
          S6917=2;
          auto_1.setClear();//sysj\bottleLoaderController.sysj line: 41, column: 2
          manual_1.setClear();//sysj\bottleLoaderController.sysj line: 41, column: 2
          thread6919(tdone,ends);
          thread6920(tdone,ends);
          thread6921(tdone,ends);
          thread6922(tdone,ends);
          int biggest6923 = 0;
          if(ends[2]>=biggest6923){
            biggest6923=ends[2];
          }
          if(ends[3]>=biggest6923){
            biggest6923=ends[3];
          }
          if(ends[4]>=biggest6923){
            biggest6923=ends[4];
          }
          if(ends[5]>=biggest6923){
            biggest6923=ends[5];
          }
          if(biggest6923 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\bottleLoaderController.sysj line: 41, column: 2
          manual_1.setClear();//sysj\bottleLoaderController.sysj line: 41, column: 2
          thread6924(tdone,ends);
          thread6925(tdone,ends);
          thread6926(tdone,ends);
          thread6927(tdone,ends);
          int biggest6928 = 0;
          if(ends[2]>=biggest6928){
            biggest6928=ends[2];
          }
          if(ends[3]>=biggest6928){
            biggest6928=ends[3];
          }
          if(ends[4]>=biggest6928){
            biggest6928=ends[4];
          }
          if(ends[5]>=biggest6928){
            biggest6928=ends[5];
          }
          if(biggest6928 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest6928 == 0){
            S6917=0;
            active[1]=0;
            ends[1]=0;
            S6917=0;
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
          loadOrder_in.gethook();
          loadAck_o.gethook();
          bottleHandoff_o.gethook();
          mode.gethook();
          bottleAtSource.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          supplyEmpty.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      bottleAtSource.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      supplyEmpty.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      twin.setpreclear();
      vacOn.setpreclear();
      release.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
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
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      twin.sethook();
      twin.setClear();
      vacOn.sethook();
      vacOn.setClear();
      release.sethook();
      release.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      auto_1.setClear();
      manual_1.setClear();
      loadOrder_in.sethook();
      loadAck_o.sethook();
      bottleHandoff_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        loadOrder_in.gethook();
        loadAck_o.gethook();
        bottleHandoff_o.gethook();
        mode.gethook();
        bottleAtSource.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        supplyEmpty.gethook();
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
