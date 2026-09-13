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
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal bottleAtSource = new Signal("bottleAtSource", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal supplyEmpty = new Signal("supplyEmpty", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal releaseM = new Signal("releaseM", Signal.INPUT);
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
  private LoaderTwin t_thread_3;//sysj\bottleLoaderController.sysj line: 63, column: 3
  private int remaining_thread_3;//sysj\bottleLoaderController.sysj line: 64, column: 3
  private WorkpieceTwin w_thread_3;//sysj\bottleLoaderController.sysj line: 65, column: 3
  private boolean reported_thread_4;//sysj\bottleLoaderController.sysj line: 129, column: 3
  private int S4434 = 1;
  private int S12 = 1;
  private int S4418 = 1;
  private int S747 = 1;
  private int S36 = 1;
  private int S20 = 1;
  private int S15 = 1;
  private int S236 = 1;
  private int S231 = 1;
  private int S334 = 1;
  private int S329 = 1;
  private int S4432 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread4442(int [] tdone, int [] ends){
        switch(S4432){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(supplyEmpty.getprestatus()){//sysj\bottleLoaderController.sysj line: 131, column: 12
          if(!reported_thread_4) {//sysj\bottleLoaderController.sysj line: 132, column: 17
            System.out.println("[BL] Bottle supply is empty.");//sysj\bottleLoaderController.sysj line: 133, column: 5
            reported_thread_4 = true;//sysj\bottleLoaderController.sysj line: 134, column: 5
          }
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          reported_thread_4 = false;//sysj\bottleLoaderController.sysj line: 138, column: 4
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread4441(int [] tdone, int [] ends){
        switch(S4418){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S747){
          case 0 : 
            if(reset.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 20
              loadOrder_in.setPreempted();
              bottleHandoff_o.setPreempted();
              loadAck_o.setPreempted();
              S747=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S36){
                case 0 : 
                  switch(S20){
                    case 0 : 
                      if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                        loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
                        S20=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S15){
                          case 0 : 
                            if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                              loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 70, column: 5
                              S15=1;
                              if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                                loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
                                ends[3]=2;
                                ;//sysj\bottleLoaderController.sysj line: 70, column: 5
                                w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 71, column: 5
                                System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 72, column: 5
                                w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 73, column: 5
                                w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 74, column: 5
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 75, column: 5
                                  twin.setPresent();//sysj\bottleLoaderController.sysj line: 76, column: 6
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 76, column: 6
                                  if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                                    S36=1;
                                    if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                      S36=2;
                                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                      currsigs.addElement(armSource);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                        S36=2;
                                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                                    System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                                    S36=1;
                                    if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                      S36=2;
                                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                      currsigs.addElement(armSource);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                        S36=2;
                                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                                  if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                                    S36=1;
                                    if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                      S36=2;
                                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                      currsigs.addElement(armSource);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                        S36=2;
                                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                                    System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                                    S36=1;
                                    if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                      S36=2;
                                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                      currsigs.addElement(armSource);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                        S36=2;
                                        armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                            if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                              loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
                              ends[3]=2;
                              ;//sysj\bottleLoaderController.sysj line: 70, column: 5
                              w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 71, column: 5
                              System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 72, column: 5
                              w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 73, column: 5
                              w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 74, column: 5
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 75, column: 5
                                twin.setPresent();//sysj\bottleLoaderController.sysj line: 76, column: 6
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 76, column: 6
                                if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                                  S36=1;
                                  if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                    S36=2;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                    currsigs.addElement(armSource);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                      S36=2;
                                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                                  System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                                  S36=1;
                                  if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                    S36=2;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                    currsigs.addElement(armSource);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                      S36=2;
                                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                                if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                                  S36=1;
                                  if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                    S36=2;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                    currsigs.addElement(armSource);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                      S36=2;
                                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                                  System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                                  S36=1;
                                  if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                    S36=2;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                    currsigs.addElement(armSource);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                      S36=2;
                                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                      S20=1;
                      S20=0;
                      if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                        loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
                        S20=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S15=0;
                        if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                          loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 70, column: 5
                          S15=1;
                          if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                            loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 70, column: 5
                            w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 71, column: 5
                            System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 72, column: 5
                            w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 73, column: 5
                            w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 74, column: 5
                            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 75, column: 5
                              twin.setPresent();//sysj\bottleLoaderController.sysj line: 76, column: 6
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 76, column: 6
                              if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                                S36=1;
                                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                  S36=2;
                                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                    S36=2;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                                System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                                S36=1;
                                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                  S36=2;
                                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                    S36=2;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                              if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                                S36=1;
                                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                  S36=2;
                                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                    S36=2;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                                System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                                S36=1;
                                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                                  S36=2;
                                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                                  currsigs.addElement(armSource);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                                    S36=2;
                                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                  if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                    S36=2;
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                    currsigs.addElement(armSource);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                      S36=2;
                      armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                  break;
                
                case 2 : 
                  if(armAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 88, column: 11
                    S36=3;
                    if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 93, column: 21
                      S36=4;
                      vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 95, column: 6
                      currsigs.addElement(vacOn);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 93, column: 44
                        S36=4;
                        vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 95, column: 6
                        currsigs.addElement(vacOn);
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
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                    currsigs.addElement(armSource);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 93, column: 21
                    S36=4;
                    vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 95, column: 6
                    currsigs.addElement(vacOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    if(vacOnM.getprestatus()){//sysj\bottleLoaderController.sysj line: 93, column: 44
                      S36=4;
                      vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 95, column: 6
                      currsigs.addElement(vacOn);
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
                  break;
                
                case 4 : 
                  if(WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 94, column: 11
                    System.out.println("[BL] " + w_thread_3 + " gripped.");//sysj\bottleLoaderController.sysj line: 97, column: 5
                    S36=5;
                    if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 100, column: 21
                      S36=6;
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 102, column: 6
                      currsigs.addElement(armDest);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 100, column: 44
                        S36=6;
                        armDest.setPresent();//sysj\bottleLoaderController.sysj line: 102, column: 6
                        currsigs.addElement(armDest);
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
                    vacOn.setPresent();//sysj\bottleLoaderController.sysj line: 95, column: 6
                    currsigs.addElement(vacOn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 5 : 
                  if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 100, column: 21
                    S36=6;
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 102, column: 6
                    currsigs.addElement(armDest);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\bottleLoaderController.sysj line: 100, column: 44
                      S36=6;
                      armDest.setPresent();//sysj\bottleLoaderController.sysj line: 102, column: 6
                      currsigs.addElement(armDest);
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
                  break;
                
                case 6 : 
                  if(armAtDest.getprestatus()){//sysj\bottleLoaderController.sysj line: 101, column: 11
                    System.out.println("[BL] Offering " + w_thread_3 + " to the conveyor.");//sysj\bottleLoaderController.sysj line: 106, column: 5
                    S36=7;
                    S236=0;
                    if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                      bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 107, column: 5
                      S236=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S231=0;
                      if(bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                        bottleHandoff_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 107, column: 5
                        S231=1;
                        if(!bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                          bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 107, column: 5
                          ends[3]=2;
                          ;//sysj\bottleLoaderController.sysj line: 107, column: 5
                          S36=8;
                          if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 21
                            S36=9;
                            if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                              w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                              remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                              t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                              if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                                twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                                S36=10;
                                S334=0;
                                if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                  loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                  S334=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S329=0;
                                  if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    S329=1;
                                    if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S747=1;
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
                                S36=10;
                                S334=0;
                                if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                  loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                  S334=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S329=0;
                                  if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    S329=1;
                                    if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S747=1;
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
                              release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                              currsigs.addElement(release);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(releaseM.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 44
                              S36=9;
                              if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                                w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                                remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                                t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                                  twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                                  S36=10;
                                  S334=0;
                                  if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    S334=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S329=0;
                                    if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S329=1;
                                      if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S747=1;
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
                                  S36=10;
                                  S334=0;
                                  if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    S334=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S329=0;
                                    if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S329=1;
                                      if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S747=1;
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
                                release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
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
                    armDest.setPresent();//sysj\bottleLoaderController.sysj line: 102, column: 6
                    currsigs.addElement(armDest);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 7 : 
                  switch(S236){
                    case 0 : 
                      if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                        bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 107, column: 5
                        S236=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S231){
                          case 0 : 
                            if(bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                              bottleHandoff_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 107, column: 5
                              S231=1;
                              if(!bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                                bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 107, column: 5
                                ends[3]=2;
                                ;//sysj\bottleLoaderController.sysj line: 107, column: 5
                                S36=8;
                                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 21
                                  S36=9;
                                  if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                                    w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                                    remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                                    t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                                      twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                                      S36=10;
                                      S334=0;
                                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S334=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S329=0;
                                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S329=1;
                                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            S747=1;
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
                                      S36=10;
                                      S334=0;
                                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S334=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S329=0;
                                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S329=1;
                                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            S747=1;
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
                                    release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                                    currsigs.addElement(release);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(releaseM.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 44
                                    S36=9;
                                    if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                                      w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                                      remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                                      t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                                        twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                                        S36=10;
                                        S334=0;
                                        if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S334=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S329=0;
                                          if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            S329=1;
                                            if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                              loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                              S747=1;
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
                                        S36=10;
                                        S334=0;
                                        if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S334=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S329=0;
                                          if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            S329=1;
                                            if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                              loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                              ends[3]=2;
                                              ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                              S747=1;
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
                                      release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
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
                            if(!bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                              bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 107, column: 5
                              ends[3]=2;
                              ;//sysj\bottleLoaderController.sysj line: 107, column: 5
                              S36=8;
                              if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 21
                                S36=9;
                                if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                                  w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                                  remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                                  t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                                    twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                                    S36=10;
                                    S334=0;
                                    if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S334=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S329=0;
                                      if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S329=1;
                                        if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S747=1;
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
                                    S36=10;
                                    S334=0;
                                    if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S334=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S329=0;
                                      if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S329=1;
                                        if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S747=1;
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
                                  release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                                  currsigs.addElement(release);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(releaseM.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 44
                                  S36=9;
                                  if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                                    w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                                    remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                                    t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                                      twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                                      S36=10;
                                      S334=0;
                                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S334=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S329=0;
                                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S329=1;
                                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            S747=1;
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
                                      S36=10;
                                      S334=0;
                                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S334=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S329=0;
                                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S329=1;
                                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            ends[3]=2;
                                            ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                            S747=1;
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
                                    release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
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
                      S236=1;
                      S236=0;
                      if(!bottleHandoff_o.isPartnerPresent() || bottleHandoff_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                        bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 107, column: 5
                        S236=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S231=0;
                        if(bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                          bottleHandoff_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 107, column: 5
                          S231=1;
                          if(!bottleHandoff_o.isACK()){//sysj\bottleLoaderController.sysj line: 107, column: 5
                            bottleHandoff_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 107, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 107, column: 5
                            S36=8;
                            if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 21
                              S36=9;
                              if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                                w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                                remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                                t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                                if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                                  twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                                  S36=10;
                                  S334=0;
                                  if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    S334=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S329=0;
                                    if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S329=1;
                                      if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S747=1;
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
                                  S36=10;
                                  S334=0;
                                  if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                    S334=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S329=0;
                                    if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S329=1;
                                      if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        ends[3]=2;
                                        ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S747=1;
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
                                release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                                currsigs.addElement(release);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(releaseM.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 44
                                S36=9;
                                if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                                  w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                                  remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                                  t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                                  if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                                    twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                                    S36=10;
                                    S334=0;
                                    if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S334=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S329=0;
                                      if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S329=1;
                                        if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S747=1;
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
                                    S36=10;
                                    S334=0;
                                    if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                      S334=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S329=0;
                                      if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                        S329=1;
                                        if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                          S747=1;
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
                                  release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
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
                
                case 8 : 
                  if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 21
                    S36=9;
                    if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                      w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                      remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                      t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                      if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                        twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                        S36=10;
                        S334=0;
                        if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                          S334=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S329=0;
                          if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                            loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                            S329=1;
                            if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                              loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                              S747=1;
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
                        S36=10;
                        S334=0;
                        if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                          loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                          S334=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S329=0;
                          if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                            loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                            S329=1;
                            if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                              loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                              S747=1;
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
                      release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                      currsigs.addElement(release);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    if(releaseM.getprestatus()){//sysj\bottleLoaderController.sysj line: 110, column: 44
                      S36=9;
                      if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                        w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                        remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                        t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                        if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                          twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                          S36=10;
                          S334=0;
                          if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                            S334=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S329=0;
                            if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                              loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                              S329=1;
                              if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                S747=1;
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
                          S36=10;
                          S334=0;
                          if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                            S334=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S329=0;
                            if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                              loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                              S329=1;
                              if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                S747=1;
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
                        release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
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
                  break;
                
                case 9 : 
                  if(!WPgripped.getprestatus()){//sysj\bottleLoaderController.sysj line: 112, column: 21
                    w_thread_3.completed(Machine.LOADER, "placed on conveyor");//sysj\bottleLoaderController.sysj line: 116, column: 5
                    remaining_thread_3 = remaining_thread_3 - 1;//sysj\bottleLoaderController.sysj line: 117, column: 5
                    t_thread_3.setBottlesRemaining(remaining_thread_3);//sysj\bottleLoaderController.sysj line: 118, column: 5
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.IDLE, "idle", "loaded " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 119, column: 5
                      twin.setPresent();//sysj\bottleLoaderController.sysj line: 120, column: 6
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 120, column: 6
                      S36=10;
                      S334=0;
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                        S334=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S329=0;
                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                          S329=1;
                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                            S747=1;
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
                      S36=10;
                      S334=0;
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                        S334=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S329=0;
                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                          S329=1;
                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                            S747=1;
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
                    release.setPresent();//sysj\bottleLoaderController.sysj line: 113, column: 6
                    currsigs.addElement(release);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 10 : 
                  switch(S334){
                    case 0 : 
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                        S334=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S329){
                          case 0 : 
                            if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                              loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                              S329=1;
                              if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                                loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                                S747=1;
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
                            if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                              loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                              S747=1;
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
                      S334=1;
                      S334=0;
                      if(!loadAck_o.isPartnerPresent() || loadAck_o.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                        loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                        S334=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S329=0;
                        if(loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                          loadAck_o.setVal(w_thread_3);//sysj\bottleLoaderController.sysj line: 122, column: 5
                          S329=1;
                          if(!loadAck_o.isACK()){//sysj\bottleLoaderController.sysj line: 122, column: 5
                            loadAck_o.setREQ(false);//sysj\bottleLoaderController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\bottleLoaderController.sysj line: 122, column: 5
                            S747=1;
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
                
                case 11 : 
                  S747=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 12 : 
                  S747=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
                case 13 : 
                  S747=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 1 : 
            S747=1;
            S747=0;
            if(reset.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 20
              loadOrder_in.setPreempted();
              bottleHandoff_o.setPreempted();
              loadAck_o.setPreempted();
              S747=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S36=0;
              S20=0;
              if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
                S20=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S15=0;
                if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                  loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 70, column: 5
                  S15=1;
                  if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
                    loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
                    ends[3]=2;
                    ;//sysj\bottleLoaderController.sysj line: 70, column: 5
                    w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 71, column: 5
                    System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 72, column: 5
                    w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 73, column: 5
                    w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 74, column: 5
                    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 75, column: 5
                      twin.setPresent();//sysj\bottleLoaderController.sysj line: 76, column: 6
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 76, column: 6
                      if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                        S36=1;
                        if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                          S36=2;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                            S36=2;
                            armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                        System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                        S36=1;
                        if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                          S36=2;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                            S36=2;
                            armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                      if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                        S36=1;
                        if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                          S36=2;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                            S36=2;
                            armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                        System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                        S36=1;
                        if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                          S36=2;
                          armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                          currsigs.addElement(armSource);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                            S36=2;
                            armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
            break;
          
        }
        break;
      
    }
  }

  public void thread4440(int [] tdone, int [] ends){
        switch(S12){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\bottleLoaderController.sysj line: 50, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleLoaderController.sysj line: 51, column: 7
            auto_1.setPresent();//sysj\bottleLoaderController.sysj line: 52, column: 5
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\bottleLoaderController.sysj line: 55, column: 5
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

  public void thread4438(int [] tdone, int [] ends){
        S4432=1;
    reported_thread_4 = false;//sysj\bottleLoaderController.sysj line: 129, column: 3
    if(supplyEmpty.getprestatus()){//sysj\bottleLoaderController.sysj line: 131, column: 12
      if(!reported_thread_4) {//sysj\bottleLoaderController.sysj line: 132, column: 17
        System.out.println("[BL] Bottle supply is empty.");//sysj\bottleLoaderController.sysj line: 133, column: 5
        reported_thread_4 = true;//sysj\bottleLoaderController.sysj line: 134, column: 5
      }
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      reported_thread_4 = false;//sysj\bottleLoaderController.sysj line: 138, column: 4
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread4437(int [] tdone, int [] ends){
        S4418=1;
    t_thread_3 = new LoaderTwin();//sysj\bottleLoaderController.sysj line: 63, column: 3
    remaining_thread_3 = 20;//sysj\bottleLoaderController.sysj line: 64, column: 3
    w_thread_3 = null;//sysj\bottleLoaderController.sysj line: 65, column: 3
    S747=0;
    if(reset.getprestatus()){//sysj\bottleLoaderController.sysj line: 68, column: 20
      loadOrder_in.setPreempted();
      bottleHandoff_o.setPreempted();
      loadAck_o.setPreempted();
      S747=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S36=0;
      S20=0;
      if(!loadOrder_in.isPartnerPresent() || loadOrder_in.isPartnerPreempted()){//sysj\bottleLoaderController.sysj line: 70, column: 5
        loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
        S20=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S15=0;
        if(!loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
          loadOrder_in.setACK(true);//sysj\bottleLoaderController.sysj line: 70, column: 5
          S15=1;
          if(loadOrder_in.isREQ()){//sysj\bottleLoaderController.sysj line: 70, column: 5
            loadOrder_in.setACK(false);//sysj\bottleLoaderController.sysj line: 70, column: 5
            ends[3]=2;
            ;//sysj\bottleLoaderController.sysj line: 70, column: 5
            w_thread_3 = (WorkpieceTwin)(loadOrder_in.getVal() == null ? null : ((WorkpieceTwin)loadOrder_in.getVal()));//sysj\bottleLoaderController.sysj line: 71, column: 5
            System.out.println("[BL] Order received for " + w_thread_3 + ".");//sysj\bottleLoaderController.sysj line: 72, column: 5
            w_thread_3.arrived(Machine.LOADER);//sysj\bottleLoaderController.sysj line: 73, column: 5
            w_thread_3.started(Machine.LOADER, "pick and place");//sysj\bottleLoaderController.sysj line: 74, column: 5
            if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "load", "order " + w_thread_3.id)){//sysj\bottleLoaderController.sysj line: 75, column: 5
              twin.setPresent();//sysj\bottleLoaderController.sysj line: 76, column: 6
              currsigs.addElement(twin);
              twin.setValue(t_thread_3);//sysj\bottleLoaderController.sysj line: 76, column: 6
              if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                S36=1;
                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                  S36=2;
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                    S36=2;
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                S36=1;
                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                  S36=2;
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                    S36=2;
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
              if(bottleAtSource.getprestatus()){//sysj\bottleLoaderController.sysj line: 79, column: 13
                S36=1;
                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                  S36=2;
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                    S36=2;
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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
                System.out.println("[BL] Warning: no bottle at source.");//sysj\bottleLoaderController.sysj line: 83, column: 6
                S36=1;
                if(auto_1.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 21
                  S36=2;
                  armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
                  currsigs.addElement(armSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\bottleLoaderController.sysj line: 87, column: 44
                    S36=2;
                    armSource.setPresent();//sysj\bottleLoaderController.sysj line: 89, column: 6
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

  public void thread4436(int [] tdone, int [] ends){
        S12=1;
    if(mode.getprestatus()){//sysj\bottleLoaderController.sysj line: 50, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\bottleLoaderController.sysj line: 51, column: 7
        auto_1.setPresent();//sysj\bottleLoaderController.sysj line: 52, column: 5
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\bottleLoaderController.sysj line: 55, column: 5
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
      switch(S4434){
        case 0 : 
          S4434=0;
          break RUN;
        
        case 1 : 
          S4434=2;
          S4434=2;
          auto_1.setClear();//sysj\bottleLoaderController.sysj line: 46, column: 2
          manual_1.setClear();//sysj\bottleLoaderController.sysj line: 46, column: 2
          thread4436(tdone,ends);
          thread4437(tdone,ends);
          thread4438(tdone,ends);
          int biggest4439 = 0;
          if(ends[2]>=biggest4439){
            biggest4439=ends[2];
          }
          if(ends[3]>=biggest4439){
            biggest4439=ends[3];
          }
          if(ends[4]>=biggest4439){
            biggest4439=ends[4];
          }
          if(biggest4439 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\bottleLoaderController.sysj line: 46, column: 2
          manual_1.setClear();//sysj\bottleLoaderController.sysj line: 46, column: 2
          thread4440(tdone,ends);
          thread4441(tdone,ends);
          thread4442(tdone,ends);
          int biggest4443 = 0;
          if(ends[2]>=biggest4443){
            biggest4443=ends[2];
          }
          if(ends[3]>=biggest4443){
            biggest4443=ends[3];
          }
          if(ends[4]>=biggest4443){
            biggest4443=ends[4];
          }
          if(biggest4443 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4443 == 0){
            S4434=0;
            active[1]=0;
            ends[1]=0;
            S4434=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
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
          reset.gethook();
          bottleAtSource.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          supplyEmpty.gethook();
          vacOnM.gethook();
          releaseM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
      bottleAtSource.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      supplyEmpty.setpreclear();
      vacOnM.setpreclear();
      releaseM.setpreclear();
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
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
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
      dummyint = releaseM.getStatus() ? releaseM.setprepresent() : releaseM.setpreclear();
      releaseM.setpreval(releaseM.getValue());
      releaseM.setClear();
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
        reset.gethook();
        bottleAtSource.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        supplyEmpty.gethook();
        vacOnM.gethook();
        releaseM.gethook();
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
