import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class ConveyorController extends ClockDomain{
  public ConveyorController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal infeedClear = new Signal("infeedClear", Signal.INPUT);
  public Signal infeedAdmitted = new Signal("infeedAdmitted", Signal.INPUT);
  public Signal bottleAtOutfeedEnd = new Signal("bottleAtOutfeedEnd", Signal.INPUT);
  public Signal outfeedClear = new Signal("outfeedClear", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal motInfeedM = new Signal("motInfeedM", Signal.INPUT);
  public Signal takeFromPos1M = new Signal("takeFromPos1M", Signal.INPUT);
  public Signal motOutfeedM = new Signal("motOutfeedM", Signal.INPUT);
  public Signal injectInfeedM = new Signal("injectInfeedM", Signal.INPUT);
  public Signal injectOutfeedM = new Signal("injectOutfeedM", Signal.INPUT);
  public Signal collectFromEndM = new Signal("collectFromEndM", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal motInfeed = new Signal("motInfeed", Signal.OUTPUT);
  public Signal injectInfeed = new Signal("injectInfeed", Signal.OUTPUT);
  public Signal takeFromPos1 = new Signal("takeFromPos1", Signal.OUTPUT);
  public Signal motOutfeed = new Signal("motOutfeed", Signal.OUTPUT);
  public Signal injectOutfeed = new Signal("injectOutfeed", Signal.OUTPUT);
  public Signal collectFromEnd = new Signal("collectFromEnd", Signal.OUTPUT);
  public input_Channel bottleHandoff_in = new input_Channel();
  public input_Channel tableOutfeed_in = new input_Channel();
  public output_Channel tableInfeed_o = new output_Channel();
  public output_Channel bottleDone_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private BeltQueue q_thread_4;//sysj\conveyorController.sysj line: 77, column: 3
  private WorkpieceTwin w_thread_4;//sysj\conveyorController.sysj line: 78, column: 3
  private ConveyorTwin t_thread_5;//sysj\conveyorController.sysj line: 103, column: 3
  private BeltQueue q_thread_6;//sysj\conveyorController.sysj line: 118, column: 3
  private WorkpieceTwin w_thread_6;//sysj\conveyorController.sysj line: 119, column: 3
  private WorkpieceTwin w_thread_7;//sysj\conveyorController.sysj line: 160, column: 3
  private int S59886 = 1;
  private int S32600 = 1;
  private int S59884 = 1;
  private int S41694 = 1;
  private int S33334 = 1;
  private int S32669 = 1;
  private int S32609 = 1;
  private int S32604 = 1;
  private int S33396 = 1;
  private int S39278 = 1;
  private int S33399 = 1;
  private int S33404 = 1;
  private int S33478 = 1;
  private int S33485 = 1;
  private int S33480 = 1;
  private int S41692 = 1;
  private int S39346 = 1;
  private int S39286 = 1;
  private int S39281 = 1;
  private int S39555 = 1;
  private int S39550 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread59906(int [] tdone, int [] ends){
        S41692=1;
    w_thread_7 = null;//sysj\conveyorController.sysj line: 160, column: 3
    S39346=0;
    if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 162, column: 20
      S39346=1;
      S39286=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 164, column: 4
        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
        S39286=1;
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
      else {
        S39281=0;
        if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
          tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 164, column: 4
          S39281=1;
          if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
            tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
            ends[7]=2;
            ;//sysj\conveyorController.sysj line: 164, column: 4
            w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 165, column: 4
            if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 171, column: 17
              w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 171, column: 19
            }
            System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 172, column: 4
            S39346=2;
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 20
              S39346=3;
              if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                S39346=4;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                  S39346=5;
                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                  currsigs.addElement(motOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                    S39346=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
              }
              else {
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                currsigs.addElement(injectOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 43
                S39346=3;
                if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                  S39346=4;
                  if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                    S39346=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                      S39346=5;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                      currsigs.addElement(motOutfeed);
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                }
                else {
                  injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                  currsigs.addElement(injectOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
          }
          else {
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
        }
        else {
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
      }
    }
    else {
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread59905(int [] tdone, int [] ends){
        S39278=1;
    q_thread_6 = BeltQueue.shared();//sysj\conveyorController.sysj line: 118, column: 3
    w_thread_6 = null;//sysj\conveyorController.sysj line: 119, column: 3
    S33399=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 121, column: 20
      w_thread_6 = q_thread_6.peek();//sysj\conveyorController.sysj line: 123, column: 4
      S33399=1;
      if(w_thread_6 == null){//sysj\conveyorController.sysj line: 131, column: 7
        System.out.println("[CV] Clearing a bottle left on the belt by a reset.");//sysj\conveyorController.sysj line: 132, column: 5
        S33404=0;
        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 21
          S33404=1;
          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
            S33399=2;
            if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
              w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
              System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
              S33478=0;
              S33485=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                S33485=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S33480=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                  tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                  S33480=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                    ends[6]=2;
                    ;//sysj\conveyorController.sysj line: 144, column: 5
                    q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                    S33478=1;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                      S33478=2;
                      if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                        System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                        S33399=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                        currsigs.addElement(takeFromPos1);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                        S33478=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                          System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                          S33399=3;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                          currsigs.addElement(takeFromPos1);
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
              }
            }
            else {
              S33399=3;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
            currsigs.addElement(takeFromPos1);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
        }
        else {
          if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 44
            S33404=1;
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
              S33399=2;
              if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                S33478=0;
                S33485=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                  S33485=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S33480=0;
                  if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                    tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                    S33480=1;
                    if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                      ends[6]=2;
                      ;//sysj\conveyorController.sysj line: 144, column: 5
                      q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                      S33478=1;
                      if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                        S33478=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                          System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                          S33399=3;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                          currsigs.addElement(takeFromPos1);
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                          S33478=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                            System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                            S33399=3;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                            currsigs.addElement(takeFromPos1);
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
              }
              else {
                S33399=3;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
              currsigs.addElement(takeFromPos1);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
        }
      }
      else {
        S33399=2;
        if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
          w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
          System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
          S33478=0;
          S33485=0;
          if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
            S33485=1;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            S33480=0;
            if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
              tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
              S33480=1;
              if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                ends[6]=2;
                ;//sysj\conveyorController.sysj line: 144, column: 5
                q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                S33478=1;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                  S33478=2;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                    S33399=3;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                    S33478=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                      System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                      S33399=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                      currsigs.addElement(takeFromPos1);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        else {
          S33399=3;
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread59904(int [] tdone, int [] ends){
        S33396=1;
    t_thread_5 = new ConveyorTwin();//sysj\conveyorController.sysj line: 103, column: 3
    t_thread_5.setMoving(true);//sysj\conveyorController.sysj line: 104, column: 3
    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 108, column: 12
      motInfeed.setPresent();//sysj\conveyorController.sysj line: 108, column: 19
      currsigs.addElement(motInfeed);
      if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 12
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 109, column: 25
        currsigs.addElement(motInfeed);
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
      else {
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
    }
    else {
      if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 12
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 109, column: 25
        currsigs.addElement(motInfeed);
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
      else {
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
    }
  }

  public void thread59903(int [] tdone, int [] ends){
        S33334=1;
    q_thread_4 = BeltQueue.shared();//sysj\conveyorController.sysj line: 77, column: 3
    w_thread_4 = null;//sysj\conveyorController.sysj line: 78, column: 3
    S32669=0;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 82, column: 20
      S32669=1;
      S32609=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
        S32609=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S32604=0;
        if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
          bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 84, column: 4
          S32604=1;
          if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
            bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
            ends[4]=2;
            ;//sysj\conveyorController.sysj line: 84, column: 4
            w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 85, column: 4
            q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 86, column: 4
            System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 87, column: 4
            S32669=2;
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 20
              S32669=3;
              if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                S32669=4;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                currsigs.addElement(injectInfeed);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 43
                S32669=3;
                if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                  S32669=4;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                  currsigs.addElement(injectInfeed);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
          else {
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread59901(int [] tdone, int [] ends){
        switch(S41692){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S39346){
          case 0 : 
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 162, column: 20
              S39346=1;
              S39286=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 164, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                S39286=1;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S39281=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 164, column: 4
                  S39281=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                    ends[7]=2;
                    ;//sysj\conveyorController.sysj line: 164, column: 4
                    w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 165, column: 4
                    if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 171, column: 17
                      w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 171, column: 19
                    }
                    System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 172, column: 4
                    S39346=2;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 20
                      S39346=3;
                      if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                        S39346=4;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                          S39346=5;
                          motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                          currsigs.addElement(motOutfeed);
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                            S39346=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                            currsigs.addElement(motOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                        }
                      }
                      else {
                        injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                        currsigs.addElement(injectOutfeed);
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                    else {
                      if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 43
                        S39346=3;
                        if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                          S39346=4;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                            S39346=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                            currsigs.addElement(motOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                              S39346=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                              currsigs.addElement(motOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                        }
                        else {
                          injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                          currsigs.addElement(injectOutfeed);
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            switch(S39286){
              case 0 : 
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 164, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                  S39286=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S39281){
                    case 0 : 
                      if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                        tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 164, column: 4
                        S39281=1;
                        if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                          tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                          ends[7]=2;
                          ;//sysj\conveyorController.sysj line: 164, column: 4
                          w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 165, column: 4
                          if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 171, column: 17
                            w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 171, column: 19
                          }
                          System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 172, column: 4
                          S39346=2;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 20
                            S39346=3;
                            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                              S39346=4;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                                S39346=5;
                                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                                currsigs.addElement(motOutfeed);
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                              else {
                                if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                                  S39346=5;
                                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                                  currsigs.addElement(motOutfeed);
                                  active[7]=1;
                                  ends[7]=1;
                                  tdone[7]=1;
                                }
                                else {
                                  active[7]=1;
                                  ends[7]=1;
                                  tdone[7]=1;
                                }
                              }
                            }
                            else {
                              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                              currsigs.addElement(injectOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                          else {
                            if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 43
                              S39346=3;
                              if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                                S39346=4;
                                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                                  S39346=5;
                                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                                  currsigs.addElement(motOutfeed);
                                  active[7]=1;
                                  ends[7]=1;
                                  tdone[7]=1;
                                }
                                else {
                                  if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                                    S39346=5;
                                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                                    currsigs.addElement(motOutfeed);
                                    active[7]=1;
                                    ends[7]=1;
                                    tdone[7]=1;
                                  }
                                  else {
                                    active[7]=1;
                                    ends[7]=1;
                                    tdone[7]=1;
                                  }
                                }
                              }
                              else {
                                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                                currsigs.addElement(injectOutfeed);
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                            }
                            else {
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                        ends[7]=2;
                        ;//sysj\conveyorController.sysj line: 164, column: 4
                        w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 165, column: 4
                        if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 171, column: 17
                          w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 171, column: 19
                        }
                        System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 172, column: 4
                        S39346=2;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 20
                          S39346=3;
                          if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                            S39346=4;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                              S39346=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                              currsigs.addElement(motOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                                S39346=5;
                                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                                currsigs.addElement(motOutfeed);
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                              else {
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                            }
                          }
                          else {
                            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                            currsigs.addElement(injectOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                        }
                        else {
                          if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 43
                            S39346=3;
                            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                              S39346=4;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                                S39346=5;
                                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                                currsigs.addElement(motOutfeed);
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                              else {
                                if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                                  S39346=5;
                                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                                  currsigs.addElement(motOutfeed);
                                  active[7]=1;
                                  ends[7]=1;
                                  tdone[7]=1;
                                }
                                else {
                                  active[7]=1;
                                  ends[7]=1;
                                  tdone[7]=1;
                                }
                              }
                            }
                            else {
                              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                              currsigs.addElement(injectOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                          else {
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S39286=1;
                S39286=0;
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 164, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                  S39286=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S39281=0;
                  if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                    tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 164, column: 4
                    S39281=1;
                    if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                      tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                      ends[7]=2;
                      ;//sysj\conveyorController.sysj line: 164, column: 4
                      w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 165, column: 4
                      if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 171, column: 17
                        w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 171, column: 19
                      }
                      System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 172, column: 4
                      S39346=2;
                      if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 20
                        S39346=3;
                        if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                          S39346=4;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                            S39346=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                            currsigs.addElement(motOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                              S39346=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                              currsigs.addElement(motOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                        }
                        else {
                          injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                          currsigs.addElement(injectOutfeed);
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 43
                          S39346=3;
                          if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                            S39346=4;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                              S39346=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                              currsigs.addElement(motOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                                S39346=5;
                                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                                currsigs.addElement(motOutfeed);
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                              else {
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                            }
                          }
                          else {
                            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                            currsigs.addElement(injectOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 20
              S39346=3;
              if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                S39346=4;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                  S39346=5;
                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                  currsigs.addElement(motOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                    S39346=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
              }
              else {
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                currsigs.addElement(injectOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 43
                S39346=3;
                if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                  S39346=4;
                  if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                    S39346=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                      S39346=5;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                      currsigs.addElement(motOutfeed);
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                }
                else {
                  injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                  currsigs.addElement(injectOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            break;
          
          case 3 : 
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
              S39346=4;
              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                S39346=5;
                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                currsigs.addElement(motOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                  S39346=5;
                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                  currsigs.addElement(motOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
              currsigs.addElement(injectOutfeed);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 4 : 
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
              S39346=5;
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
              currsigs.addElement(motOutfeed);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                S39346=5;
                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                currsigs.addElement(motOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            break;
          
          case 5 : 
            if(bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 180, column: 10
              S39346=6;
              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 184, column: 20
                S39346=7;
                if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 185, column: 20
                  System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 188, column: 4
                  S39346=8;
                  S39555=0;
                  if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 190, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                    S39555=1;
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    S39550=0;
                    if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                      bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 190, column: 4
                      S39550=1;
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                        ends[7]=2;
                        ;//sysj\conveyorController.sysj line: 190, column: 4
                        S39346=9;
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                }
                else {
                  collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 186, column: 5
                  currsigs.addElement(collectFromEnd);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(collectFromEndM.getprestatus()){//sysj\conveyorController.sysj line: 184, column: 43
                  S39346=7;
                  if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 185, column: 20
                    System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 188, column: 4
                    S39346=8;
                    S39555=0;
                    if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 190, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                      S39555=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      S39550=0;
                      if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                        bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 190, column: 4
                        S39550=1;
                        if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                          bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                          ends[7]=2;
                          ;//sysj\conveyorController.sysj line: 190, column: 4
                          S39346=9;
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                  }
                  else {
                    collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 186, column: 5
                    currsigs.addElement(collectFromEnd);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
              currsigs.addElement(motOutfeed);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 6 : 
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 184, column: 20
              S39346=7;
              if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 185, column: 20
                System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 188, column: 4
                S39346=8;
                S39555=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 190, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                  S39555=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S39550=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                    bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 190, column: 4
                    S39550=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                      ends[7]=2;
                      ;//sysj\conveyorController.sysj line: 190, column: 4
                      S39346=9;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
              }
              else {
                collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 186, column: 5
                currsigs.addElement(collectFromEnd);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              if(collectFromEndM.getprestatus()){//sysj\conveyorController.sysj line: 184, column: 43
                S39346=7;
                if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 185, column: 20
                  System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 188, column: 4
                  S39346=8;
                  S39555=0;
                  if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 190, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                    S39555=1;
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    S39550=0;
                    if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                      bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 190, column: 4
                      S39550=1;
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                        ends[7]=2;
                        ;//sysj\conveyorController.sysj line: 190, column: 4
                        S39346=9;
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                }
                else {
                  collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 186, column: 5
                  currsigs.addElement(collectFromEnd);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            break;
          
          case 7 : 
            if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 185, column: 20
              System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 188, column: 4
              S39346=8;
              S39555=0;
              if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 190, column: 4
                bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                S39555=1;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S39550=0;
                if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                  bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 190, column: 4
                  S39550=1;
                  if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                    ends[7]=2;
                    ;//sysj\conveyorController.sysj line: 190, column: 4
                    S39346=9;
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 186, column: 5
              currsigs.addElement(collectFromEnd);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 8 : 
            switch(S39555){
              case 0 : 
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 190, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                  S39555=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S39550){
                    case 0 : 
                      if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                        bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 190, column: 4
                        S39550=1;
                        if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                          bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                          ends[7]=2;
                          ;//sysj\conveyorController.sysj line: 190, column: 4
                          S39346=9;
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                        ends[7]=2;
                        ;//sysj\conveyorController.sysj line: 190, column: 4
                        S39346=9;
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S39555=1;
                S39555=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 190, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                  S39555=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S39550=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                    bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 190, column: 4
                    S39550=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 190, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 190, column: 4
                      ends[7]=2;
                      ;//sysj\conveyorController.sysj line: 190, column: 4
                      S39346=9;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 9 : 
            S39346=9;
            S39346=0;
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 162, column: 20
              S39346=1;
              S39286=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 164, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                S39286=1;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S39281=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 164, column: 4
                  S39281=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
                    ends[7]=2;
                    ;//sysj\conveyorController.sysj line: 164, column: 4
                    w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 165, column: 4
                    if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 171, column: 17
                      w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 171, column: 19
                    }
                    System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 172, column: 4
                    S39346=2;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 20
                      S39346=3;
                      if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                        S39346=4;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                          S39346=5;
                          motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                          currsigs.addElement(motOutfeed);
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                            S39346=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                            currsigs.addElement(motOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                        }
                      }
                      else {
                        injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                        currsigs.addElement(injectOutfeed);
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                    else {
                      if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 43
                        S39346=3;
                        if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                          S39346=4;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                            S39346=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                            currsigs.addElement(motOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                              S39346=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                              currsigs.addElement(motOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                        }
                        else {
                          injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                          currsigs.addElement(injectOutfeed);
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread59900(int [] tdone, int [] ends){
        switch(S39278){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S33399){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 121, column: 20
              w_thread_6 = q_thread_6.peek();//sysj\conveyorController.sysj line: 123, column: 4
              S33399=1;
              if(w_thread_6 == null){//sysj\conveyorController.sysj line: 131, column: 7
                System.out.println("[CV] Clearing a bottle left on the belt by a reset.");//sysj\conveyorController.sysj line: 132, column: 5
                S33404=0;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 21
                  S33404=1;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
                    S33399=2;
                    if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                      w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                      System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                      S33478=0;
                      S33485=0;
                      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                        S33485=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S33480=0;
                        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                          tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                          S33480=1;
                          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                            ends[6]=2;
                            ;//sysj\conveyorController.sysj line: 144, column: 5
                            q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                            S33478=1;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                              S33478=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                S33399=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                                S33478=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                  S33399=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                    }
                    else {
                      S33399=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 44
                    S33404=1;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
                      S33399=2;
                      if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                        w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                        System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                        S33478=0;
                        S33485=0;
                        if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                          S33485=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S33480=0;
                          if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                            tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                            S33480=1;
                            if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                              tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                              ends[6]=2;
                              ;//sysj\conveyorController.sysj line: 144, column: 5
                              q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                              S33478=1;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                                S33478=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                  S33399=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                                  S33478=2;
                                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                    S33399=3;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                    currsigs.addElement(takeFromPos1);
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                }
                                else {
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                            }
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                      }
                      else {
                        S33399=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
                      currsigs.addElement(takeFromPos1);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
              }
              else {
                S33399=2;
                if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                  w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                  System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                  S33478=0;
                  S33485=0;
                  if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                    S33485=1;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    S33480=0;
                    if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                      tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                      S33480=1;
                      if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                        ends[6]=2;
                        ;//sysj\conveyorController.sysj line: 144, column: 5
                        q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                        S33478=1;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                          S33478=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                            System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                            S33399=3;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                            currsigs.addElement(takeFromPos1);
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                            S33478=2;
                            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                              System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                              S33399=3;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                              currsigs.addElement(takeFromPos1);
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                }
                else {
                  S33399=3;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
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
            switch(S33404){
              case 0 : 
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 21
                  S33404=1;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
                    S33399=2;
                    if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                      w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                      System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                      S33478=0;
                      S33485=0;
                      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                        S33485=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S33480=0;
                        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                          tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                          S33480=1;
                          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                            ends[6]=2;
                            ;//sysj\conveyorController.sysj line: 144, column: 5
                            q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                            S33478=1;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                              S33478=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                S33399=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                                S33478=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                  S33399=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                    }
                    else {
                      S33399=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 44
                    S33404=1;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
                      S33399=2;
                      if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                        w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                        System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                        S33478=0;
                        S33485=0;
                        if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                          S33485=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S33480=0;
                          if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                            tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                            S33480=1;
                            if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                              tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                              ends[6]=2;
                              ;//sysj\conveyorController.sysj line: 144, column: 5
                              q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                              S33478=1;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                                S33478=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                  S33399=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                                  S33478=2;
                                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                    S33399=3;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                    currsigs.addElement(takeFromPos1);
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                }
                                else {
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                            }
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                      }
                      else {
                        S33399=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
                      currsigs.addElement(takeFromPos1);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                break;
              
              case 1 : 
                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
                  S33399=2;
                  if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                    w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                    System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                    S33478=0;
                    S33485=0;
                    if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                      S33485=1;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      S33480=0;
                      if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                        tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                        S33480=1;
                        if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                          ends[6]=2;
                          ;//sysj\conveyorController.sysj line: 144, column: 5
                          q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                          S33478=1;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                            S33478=2;
                            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                              System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                              S33399=3;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                              currsigs.addElement(takeFromPos1);
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                              S33478=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                S33399=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                  else {
                    S33399=3;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
                  currsigs.addElement(takeFromPos1);
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            switch(S33478){
              case 0 : 
                switch(S33485){
                  case 0 : 
                    if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                      S33485=1;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      switch(S33480){
                        case 0 : 
                          if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                            tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                            S33480=1;
                            if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                              tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                              ends[6]=2;
                              ;//sysj\conveyorController.sysj line: 144, column: 5
                              q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                              S33478=1;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                                S33478=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                  S33399=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                                  S33478=2;
                                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                    S33399=3;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                    currsigs.addElement(takeFromPos1);
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                }
                                else {
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                            }
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          break;
                        
                        case 1 : 
                          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                            ends[6]=2;
                            ;//sysj\conveyorController.sysj line: 144, column: 5
                            q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                            S33478=1;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                              S33478=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                S33399=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                                S33478=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                  S33399=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
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
                    }
                    break;
                  
                  case 1 : 
                    S33485=1;
                    S33485=0;
                    if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                      S33485=1;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      S33480=0;
                      if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                        tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                        S33480=1;
                        if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                          ends[6]=2;
                          ;//sysj\conveyorController.sysj line: 144, column: 5
                          q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                          S33478=1;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                            S33478=2;
                            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                              System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                              S33399=3;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                              currsigs.addElement(takeFromPos1);
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                              S33478=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                S33399=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                  S33478=2;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                    S33399=3;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                    S33478=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                      System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                      S33399=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                      currsigs.addElement(takeFromPos1);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                break;
              
              case 2 : 
                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                  S33399=3;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                  currsigs.addElement(takeFromPos1);
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                break;
              
            }
            break;
          
          case 3 : 
            S33399=3;
            S33399=0;
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 121, column: 20
              w_thread_6 = q_thread_6.peek();//sysj\conveyorController.sysj line: 123, column: 4
              S33399=1;
              if(w_thread_6 == null){//sysj\conveyorController.sysj line: 131, column: 7
                System.out.println("[CV] Clearing a bottle left on the belt by a reset.");//sysj\conveyorController.sysj line: 132, column: 5
                S33404=0;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 21
                  S33404=1;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
                    S33399=2;
                    if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                      w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                      System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                      S33478=0;
                      S33485=0;
                      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                        S33485=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S33480=0;
                        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                          tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                          S33480=1;
                          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                            ends[6]=2;
                            ;//sysj\conveyorController.sysj line: 144, column: 5
                            q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                            S33478=1;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                              S33478=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                S33399=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                                S33478=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                  S33399=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                    }
                    else {
                      S33399=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 44
                    S33404=1;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
                      S33399=2;
                      if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                        w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                        System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                        S33478=0;
                        S33485=0;
                        if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                          S33485=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S33480=0;
                          if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                            tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                            S33480=1;
                            if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                              tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                              ends[6]=2;
                              ;//sysj\conveyorController.sysj line: 144, column: 5
                              q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                              S33478=1;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                                S33478=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                  S33399=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                                  S33478=2;
                                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                                    S33399=3;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                                    currsigs.addElement(takeFromPos1);
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                }
                                else {
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                            }
                            else {
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                      }
                      else {
                        S33399=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
                      currsigs.addElement(takeFromPos1);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
              }
              else {
                S33399=2;
                if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                  w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                  System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                  S33478=0;
                  S33485=0;
                  if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                    S33485=1;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    S33480=0;
                    if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                      tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                      S33480=1;
                      if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                        ends[6]=2;
                        ;//sysj\conveyorController.sysj line: 144, column: 5
                        q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                        S33478=1;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                          S33478=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                            System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                            S33399=3;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                            currsigs.addElement(takeFromPos1);
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                            S33478=2;
                            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                              System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                              S33399=3;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                              currsigs.addElement(takeFromPos1);
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                }
                else {
                  S33399=3;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
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
        break;
      
    }
  }

  public void thread59899(int [] tdone, int [] ends){
        switch(S33396){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 108, column: 12
          motInfeed.setPresent();//sysj\conveyorController.sysj line: 108, column: 19
          currsigs.addElement(motInfeed);
          if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 12
            motInfeed.setPresent();//sysj\conveyorController.sysj line: 109, column: 25
            currsigs.addElement(motInfeed);
            if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
              twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
              currsigs.addElement(twin);
              twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
          else {
            if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
              twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
              currsigs.addElement(twin);
              twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
        }
        else {
          if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 12
            motInfeed.setPresent();//sysj\conveyorController.sysj line: 109, column: 25
            currsigs.addElement(motInfeed);
            if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
              twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
              currsigs.addElement(twin);
              twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
          else {
            if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
              twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
              currsigs.addElement(twin);
              twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread59898(int [] tdone, int [] ends){
        switch(S33334){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S32669){
          case 0 : 
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 82, column: 20
              S32669=1;
              S32609=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                S32609=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S32604=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 84, column: 4
                  S32604=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 84, column: 4
                    w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 85, column: 4
                    q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 86, column: 4
                    System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 87, column: 4
                    S32669=2;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 20
                      S32669=3;
                      if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                        S32669=4;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                        currsigs.addElement(injectInfeed);
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 43
                        S32669=3;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                          S32669=4;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                          currsigs.addElement(injectInfeed);
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
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
            switch(S32609){
              case 0 : 
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                  S32609=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S32604){
                    case 0 : 
                      if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                        bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 84, column: 4
                        S32604=1;
                        if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                          bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                          ends[4]=2;
                          ;//sysj\conveyorController.sysj line: 84, column: 4
                          w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 85, column: 4
                          q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 86, column: 4
                          System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 87, column: 4
                          S32669=2;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 20
                            S32669=3;
                            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                              S32669=4;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                              currsigs.addElement(injectInfeed);
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 43
                              S32669=3;
                              if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                                S32669=4;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                                currsigs.addElement(injectInfeed);
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                        ends[4]=2;
                        ;//sysj\conveyorController.sysj line: 84, column: 4
                        w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 85, column: 4
                        q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 86, column: 4
                        System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 87, column: 4
                        S32669=2;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 20
                          S32669=3;
                          if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                            S32669=4;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                            currsigs.addElement(injectInfeed);
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 43
                            S32669=3;
                            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                              S32669=4;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                              currsigs.addElement(injectInfeed);
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
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
                }
                break;
              
              case 1 : 
                S32609=1;
                S32609=0;
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                  S32609=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S32604=0;
                  if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                    bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 84, column: 4
                    S32604=1;
                    if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                      bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                      ends[4]=2;
                      ;//sysj\conveyorController.sysj line: 84, column: 4
                      w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 85, column: 4
                      q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 86, column: 4
                      System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 87, column: 4
                      S32669=2;
                      if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 20
                        S32669=3;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                          S32669=4;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                          currsigs.addElement(injectInfeed);
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 43
                          S32669=3;
                          if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                            S32669=4;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                            currsigs.addElement(injectInfeed);
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 20
              S32669=3;
              if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                S32669=4;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                currsigs.addElement(injectInfeed);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 43
                S32669=3;
                if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                  S32669=4;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                  currsigs.addElement(injectInfeed);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 3 : 
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
              S32669=4;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
              currsigs.addElement(injectInfeed);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 4 : 
            S32669=4;
            S32669=0;
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 82, column: 20
              S32669=1;
              S32609=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                S32609=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S32604=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 84, column: 4
                  S32604=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 84, column: 4
                    w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 85, column: 4
                    q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 86, column: 4
                    System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 87, column: 4
                    S32669=2;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 20
                      S32669=3;
                      if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                        S32669=4;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                        currsigs.addElement(injectInfeed);
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 43
                        S32669=3;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                          S32669=4;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                          currsigs.addElement(injectInfeed);
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
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

  public void thread59897(int [] tdone, int [] ends){
        switch(S59884){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S41694){
          case 0 : 
            if(reset.getprestatus()){//sysj\conveyorController.sysj line: 75, column: 20
              bottleHandoff_in.setPreempted();
              tableOutfeed_in.setPreempted();
              tableInfeed_o.setPreempted();
              bottleDone_o.setPreempted();
              S41694=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread59898(tdone,ends);
              thread59899(tdone,ends);
              thread59900(tdone,ends);
              thread59901(tdone,ends);
              int biggest59902 = 0;
              if(ends[4]>=biggest59902){
                biggest59902=ends[4];
              }
              if(ends[5]>=biggest59902){
                biggest59902=ends[5];
              }
              if(ends[6]>=biggest59902){
                biggest59902=ends[6];
              }
              if(ends[7]>=biggest59902){
                biggest59902=ends[7];
              }
              if(biggest59902 == 1){
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              //FINXME code
              if(biggest59902 == 0){
                S41694=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 1 : 
            S41694=1;
            S41694=0;
            if(reset.getprestatus()){//sysj\conveyorController.sysj line: 75, column: 20
              bottleHandoff_in.setPreempted();
              tableOutfeed_in.setPreempted();
              tableInfeed_o.setPreempted();
              bottleDone_o.setPreempted();
              S41694=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread59903(tdone,ends);
              thread59904(tdone,ends);
              thread59905(tdone,ends);
              thread59906(tdone,ends);
              int biggest59907 = 0;
              if(ends[4]>=biggest59907){
                biggest59907=ends[4];
              }
              if(ends[5]>=biggest59907){
                biggest59907=ends[5];
              }
              if(ends[6]>=biggest59907){
                biggest59907=ends[6];
              }
              if(ends[7]>=biggest59907){
                biggest59907=ends[7];
              }
              if(biggest59907 == 1){
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread59896(int [] tdone, int [] ends){
        switch(S32600){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\conveyorController.sysj line: 61, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\conveyorController.sysj line: 62, column: 8
            auto_1.setPresent();//sysj\conveyorController.sysj line: 62, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\conveyorController.sysj line: 63, column: 12
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

  public void thread59893(int [] tdone, int [] ends){
        S41692=1;
    w_thread_7 = null;//sysj\conveyorController.sysj line: 160, column: 3
    S39346=0;
    if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 162, column: 20
      S39346=1;
      S39286=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 164, column: 4
        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
        S39286=1;
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
      else {
        S39281=0;
        if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
          tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 164, column: 4
          S39281=1;
          if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 164, column: 4
            tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 164, column: 4
            ends[7]=2;
            ;//sysj\conveyorController.sysj line: 164, column: 4
            w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 165, column: 4
            if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 171, column: 17
              w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 171, column: 19
            }
            System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 172, column: 4
            S39346=2;
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 20
              S39346=3;
              if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                S39346=4;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                  S39346=5;
                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                  currsigs.addElement(motOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                    S39346=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                }
              }
              else {
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                currsigs.addElement(injectOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 174, column: 43
                S39346=3;
                if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 175, column: 20
                  S39346=4;
                  if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 20
                    S39346=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 179, column: 43
                      S39346=5;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 181, column: 5
                      currsigs.addElement(motOutfeed);
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                  }
                }
                else {
                  injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 176, column: 5
                  currsigs.addElement(injectOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
          }
          else {
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
        }
        else {
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
      }
    }
    else {
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread59892(int [] tdone, int [] ends){
        S39278=1;
    q_thread_6 = BeltQueue.shared();//sysj\conveyorController.sysj line: 118, column: 3
    w_thread_6 = null;//sysj\conveyorController.sysj line: 119, column: 3
    S33399=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 121, column: 20
      w_thread_6 = q_thread_6.peek();//sysj\conveyorController.sysj line: 123, column: 4
      S33399=1;
      if(w_thread_6 == null){//sysj\conveyorController.sysj line: 131, column: 7
        System.out.println("[CV] Clearing a bottle left on the belt by a reset.");//sysj\conveyorController.sysj line: 132, column: 5
        S33404=0;
        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 21
          S33404=1;
          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
            S33399=2;
            if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
              w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
              System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
              S33478=0;
              S33485=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                S33485=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S33480=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                  tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                  S33480=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                    ends[6]=2;
                    ;//sysj\conveyorController.sysj line: 144, column: 5
                    q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                    S33478=1;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                      S33478=2;
                      if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                        System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                        S33399=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                        currsigs.addElement(takeFromPos1);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                        S33478=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                          System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                          S33399=3;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                          currsigs.addElement(takeFromPos1);
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
              }
            }
            else {
              S33399=3;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
            currsigs.addElement(takeFromPos1);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
        }
        else {
          if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 133, column: 44
            S33404=1;
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 134, column: 21
              S33399=2;
              if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
                w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
                System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
                S33478=0;
                S33485=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                  S33485=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S33480=0;
                  if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                    tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
                    S33480=1;
                    if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                      ends[6]=2;
                      ;//sysj\conveyorController.sysj line: 144, column: 5
                      q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                      S33478=1;
                      if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                        S33478=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                          System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                          S33399=3;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                          currsigs.addElement(takeFromPos1);
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                          S33478=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                            System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                            S33399=3;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                            currsigs.addElement(takeFromPos1);
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                    }
                    else {
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
              }
              else {
                S33399=3;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 135, column: 6
              currsigs.addElement(takeFromPos1);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
        }
      }
      else {
        S33399=2;
        if(w_thread_6 != null){//sysj\conveyorController.sysj line: 139, column: 7
          w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 140, column: 5
          System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 141, column: 5
          S33478=0;
          S33485=0;
          if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 144, column: 5
            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
            S33485=1;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            S33480=0;
            if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
              tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 144, column: 5
              S33480=1;
              if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 144, column: 5
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 144, column: 5
                ends[6]=2;
                ;//sysj\conveyorController.sysj line: 144, column: 5
                q_thread_6.pop();//sysj\conveyorController.sysj line: 145, column: 5
                S33478=1;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 21
                  S33478=2;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                    S33399=3;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 149, column: 44
                    S33478=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 150, column: 21
                      System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 153, column: 5
                      S33399=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 151, column: 6
                      currsigs.addElement(takeFromPos1);
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        else {
          S33399=3;
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread59891(int [] tdone, int [] ends){
        S33396=1;
    t_thread_5 = new ConveyorTwin();//sysj\conveyorController.sysj line: 103, column: 3
    t_thread_5.setMoving(true);//sysj\conveyorController.sysj line: 104, column: 3
    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 108, column: 12
      motInfeed.setPresent();//sysj\conveyorController.sysj line: 108, column: 19
      currsigs.addElement(motInfeed);
      if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 12
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 109, column: 25
        currsigs.addElement(motInfeed);
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
      else {
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
    }
    else {
      if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 12
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 109, column: 25
        currsigs.addElement(motInfeed);
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
      else {
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 110, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 111, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
    }
  }

  public void thread59890(int [] tdone, int [] ends){
        S33334=1;
    q_thread_4 = BeltQueue.shared();//sysj\conveyorController.sysj line: 77, column: 3
    w_thread_4 = null;//sysj\conveyorController.sysj line: 78, column: 3
    S32669=0;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 82, column: 20
      S32669=1;
      S32609=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
        S32609=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S32604=0;
        if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
          bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 84, column: 4
          S32604=1;
          if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 84, column: 4
            bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 84, column: 4
            ends[4]=2;
            ;//sysj\conveyorController.sysj line: 84, column: 4
            w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 85, column: 4
            q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 86, column: 4
            System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 87, column: 4
            S32669=2;
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 20
              S32669=3;
              if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                S32669=4;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                currsigs.addElement(injectInfeed);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 94, column: 43
                S32669=3;
                if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 95, column: 20
                  S32669=4;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  injectInfeed.setPresent();//sysj\conveyorController.sysj line: 96, column: 5
                  currsigs.addElement(injectInfeed);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
          }
          else {
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread59889(int [] tdone, int [] ends){
        S59884=1;
    S41694=0;
    if(reset.getprestatus()){//sysj\conveyorController.sysj line: 75, column: 20
      bottleHandoff_in.setPreempted();
      tableOutfeed_in.setPreempted();
      tableInfeed_o.setPreempted();
      bottleDone_o.setPreempted();
      S41694=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      thread59890(tdone,ends);
      thread59891(tdone,ends);
      thread59892(tdone,ends);
      thread59893(tdone,ends);
      int biggest59894 = 0;
      if(ends[4]>=biggest59894){
        biggest59894=ends[4];
      }
      if(ends[5]>=biggest59894){
        biggest59894=ends[5];
      }
      if(ends[6]>=biggest59894){
        biggest59894=ends[6];
      }
      if(ends[7]>=biggest59894){
        biggest59894=ends[7];
      }
      if(biggest59894 == 1){
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread59888(int [] tdone, int [] ends){
        S32600=1;
    if(mode.getprestatus()){//sysj\conveyorController.sysj line: 61, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\conveyorController.sysj line: 62, column: 8
        auto_1.setPresent();//sysj\conveyorController.sysj line: 62, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\conveyorController.sysj line: 63, column: 12
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
      switch(S59886){
        case 0 : 
          S59886=0;
          break RUN;
        
        case 1 : 
          S59886=2;
          S59886=2;
          auto_1.setClear();//sysj\conveyorController.sysj line: 57, column: 2
          manual_1.setClear();//sysj\conveyorController.sysj line: 57, column: 2
          thread59888(tdone,ends);
          thread59889(tdone,ends);
          int biggest59895 = 0;
          if(ends[2]>=biggest59895){
            biggest59895=ends[2];
          }
          if(ends[3]>=biggest59895){
            biggest59895=ends[3];
          }
          if(biggest59895 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\conveyorController.sysj line: 57, column: 2
          manual_1.setClear();//sysj\conveyorController.sysj line: 57, column: 2
          thread59896(tdone,ends);
          thread59897(tdone,ends);
          int biggest59908 = 0;
          if(ends[2]>=biggest59908){
            biggest59908=ends[2];
          }
          if(ends[3]>=biggest59908){
            biggest59908=ends[3];
          }
          if(biggest59908 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest59908 == 0){
            S59886=0;
            active[1]=0;
            ends[1]=0;
            S59886=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
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
          bottleHandoff_in.gethook();
          tableOutfeed_in.gethook();
          tableInfeed_o.gethook();
          bottleDone_o.gethook();
          bottleAtPos1.gethook();
          infeedClear.gethook();
          infeedAdmitted.gethook();
          bottleAtOutfeedEnd.gethook();
          outfeedClear.gethook();
          mode.gethook();
          reset.gethook();
          motInfeedM.gethook();
          takeFromPos1M.gethook();
          motOutfeedM.gethook();
          injectInfeedM.gethook();
          injectOutfeedM.gethook();
          collectFromEndM.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos1.setpreclear();
      infeedClear.setpreclear();
      infeedAdmitted.setpreclear();
      bottleAtOutfeedEnd.setpreclear();
      outfeedClear.setpreclear();
      mode.setpreclear();
      reset.setpreclear();
      motInfeedM.setpreclear();
      takeFromPos1M.setpreclear();
      motOutfeedM.setpreclear();
      injectInfeedM.setpreclear();
      injectOutfeedM.setpreclear();
      collectFromEndM.setpreclear();
      twin.setpreclear();
      motInfeed.setpreclear();
      injectInfeed.setpreclear();
      takeFromPos1.setpreclear();
      motOutfeed.setpreclear();
      injectOutfeed.setpreclear();
      collectFromEnd.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = infeedClear.getStatus() ? infeedClear.setprepresent() : infeedClear.setpreclear();
      infeedClear.setpreval(infeedClear.getValue());
      infeedClear.setClear();
      dummyint = infeedAdmitted.getStatus() ? infeedAdmitted.setprepresent() : infeedAdmitted.setpreclear();
      infeedAdmitted.setpreval(infeedAdmitted.getValue());
      infeedAdmitted.setClear();
      dummyint = bottleAtOutfeedEnd.getStatus() ? bottleAtOutfeedEnd.setprepresent() : bottleAtOutfeedEnd.setpreclear();
      bottleAtOutfeedEnd.setpreval(bottleAtOutfeedEnd.getValue());
      bottleAtOutfeedEnd.setClear();
      dummyint = outfeedClear.getStatus() ? outfeedClear.setprepresent() : outfeedClear.setpreclear();
      outfeedClear.setpreval(outfeedClear.getValue());
      outfeedClear.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
      dummyint = motInfeedM.getStatus() ? motInfeedM.setprepresent() : motInfeedM.setpreclear();
      motInfeedM.setpreval(motInfeedM.getValue());
      motInfeedM.setClear();
      dummyint = takeFromPos1M.getStatus() ? takeFromPos1M.setprepresent() : takeFromPos1M.setpreclear();
      takeFromPos1M.setpreval(takeFromPos1M.getValue());
      takeFromPos1M.setClear();
      dummyint = motOutfeedM.getStatus() ? motOutfeedM.setprepresent() : motOutfeedM.setpreclear();
      motOutfeedM.setpreval(motOutfeedM.getValue());
      motOutfeedM.setClear();
      dummyint = injectInfeedM.getStatus() ? injectInfeedM.setprepresent() : injectInfeedM.setpreclear();
      injectInfeedM.setpreval(injectInfeedM.getValue());
      injectInfeedM.setClear();
      dummyint = injectOutfeedM.getStatus() ? injectOutfeedM.setprepresent() : injectOutfeedM.setpreclear();
      injectOutfeedM.setpreval(injectOutfeedM.getValue());
      injectOutfeedM.setClear();
      dummyint = collectFromEndM.getStatus() ? collectFromEndM.setprepresent() : collectFromEndM.setpreclear();
      collectFromEndM.setpreval(collectFromEndM.getValue());
      collectFromEndM.setClear();
      twin.sethook();
      twin.setClear();
      motInfeed.sethook();
      motInfeed.setClear();
      injectInfeed.sethook();
      injectInfeed.setClear();
      takeFromPos1.sethook();
      takeFromPos1.setClear();
      motOutfeed.sethook();
      motOutfeed.setClear();
      injectOutfeed.sethook();
      injectOutfeed.setClear();
      collectFromEnd.sethook();
      collectFromEnd.setClear();
      auto_1.setClear();
      manual_1.setClear();
      bottleHandoff_in.sethook();
      tableOutfeed_in.sethook();
      tableInfeed_o.sethook();
      bottleDone_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleHandoff_in.gethook();
        tableOutfeed_in.gethook();
        tableInfeed_o.gethook();
        bottleDone_o.gethook();
        bottleAtPos1.gethook();
        infeedClear.gethook();
        infeedAdmitted.gethook();
        bottleAtOutfeedEnd.gethook();
        outfeedClear.gethook();
        mode.gethook();
        reset.gethook();
        motInfeedM.gethook();
        takeFromPos1M.gethook();
        motOutfeedM.gethook();
        injectInfeedM.gethook();
        injectOutfeedM.gethook();
        collectFromEndM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
