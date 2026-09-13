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
  private BeltQueue q_thread_4;//sysj\conveyorController.sysj line: 79, column: 3
  private WorkpieceTwin w_thread_4;//sysj\conveyorController.sysj line: 80, column: 3
  private ConveyorTwin t_thread_5;//sysj\conveyorController.sysj line: 105, column: 3
  private BeltQueue q_thread_6;//sysj\conveyorController.sysj line: 120, column: 3
  private WorkpieceTwin w_thread_6;//sysj\conveyorController.sysj line: 121, column: 3
  private WorkpieceTwin w_thread_7;//sysj\conveyorController.sysj line: 162, column: 3
  private int S59898 = 1;
  private int S32612 = 1;
  private int S59896 = 1;
  private int S41706 = 1;
  private int S33346 = 1;
  private int S32681 = 1;
  private int S32621 = 1;
  private int S32616 = 1;
  private int S33408 = 1;
  private int S39290 = 1;
  private int S33411 = 1;
  private int S33416 = 1;
  private int S33490 = 1;
  private int S33497 = 1;
  private int S33492 = 1;
  private int S41704 = 1;
  private int S39358 = 1;
  private int S39298 = 1;
  private int S39293 = 1;
  private int S39567 = 1;
  private int S39562 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread59918(int [] tdone, int [] ends){
        S41704=1;
    w_thread_7 = null;//sysj\conveyorController.sysj line: 162, column: 3
    S39358=0;
    if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 164, column: 20
      S39358=1;
      S39298=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 166, column: 4
        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
        S39298=1;
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
      else {
        S39293=0;
        if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
          tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 166, column: 4
          S39293=1;
          if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
            tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
            ends[7]=2;
            ;//sysj\conveyorController.sysj line: 166, column: 4
            w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 167, column: 4
            if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 173, column: 17
              w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 173, column: 19
            }
            System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 174, column: 4
            S39358=2;
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 20
              S39358=3;
              if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                S39358=4;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                  S39358=5;
                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                  currsigs.addElement(motOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                    S39358=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
                currsigs.addElement(injectOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 43
                S39358=3;
                if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                  S39358=4;
                  if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                    S39358=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                      S39358=5;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                  injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
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

  public void thread59917(int [] tdone, int [] ends){
        S39290=1;
    q_thread_6 = BeltQueue.shared();//sysj\conveyorController.sysj line: 120, column: 3
    w_thread_6 = null;//sysj\conveyorController.sysj line: 121, column: 3
    S33411=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 123, column: 20
      w_thread_6 = q_thread_6.peek();//sysj\conveyorController.sysj line: 125, column: 4
      S33411=1;
      if(w_thread_6 == null){//sysj\conveyorController.sysj line: 133, column: 7
        System.out.println("[CV] Clearing a bottle left on the belt by a reset.");//sysj\conveyorController.sysj line: 134, column: 5
        S33416=0;
        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 21
          S33416=1;
          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
            S33411=2;
            if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
              w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
              System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
              S33490=0;
              S33497=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                S33497=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S33492=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                  tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                  S33492=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                    ends[6]=2;
                    ;//sysj\conveyorController.sysj line: 146, column: 5
                    q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                    S33490=1;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                      S33490=2;
                      if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                        System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                        S33411=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                        currsigs.addElement(takeFromPos1);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                        S33490=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                          System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                          S33411=3;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
              S33411=3;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
            currsigs.addElement(takeFromPos1);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
        }
        else {
          if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 44
            S33416=1;
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
              S33411=2;
              if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                S33490=0;
                S33497=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                  S33497=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S33492=0;
                  if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                    tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                    S33492=1;
                    if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                      ends[6]=2;
                      ;//sysj\conveyorController.sysj line: 146, column: 5
                      q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                      S33490=1;
                      if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                        S33490=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                          System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                          S33411=3;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                          currsigs.addElement(takeFromPos1);
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                          S33490=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                            System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                            S33411=3;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                S33411=3;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
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
        S33411=2;
        if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
          w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
          System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
          S33490=0;
          S33497=0;
          if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
            S33497=1;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            S33492=0;
            if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
              tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
              S33492=1;
              if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                ends[6]=2;
                ;//sysj\conveyorController.sysj line: 146, column: 5
                q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                S33490=1;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                  S33490=2;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                    S33411=3;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                    S33490=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                      System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                      S33411=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
          S33411=3;
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

  public void thread59916(int [] tdone, int [] ends){
        S33408=1;
    t_thread_5 = new ConveyorTwin();//sysj\conveyorController.sysj line: 105, column: 3
    t_thread_5.setMoving(true);//sysj\conveyorController.sysj line: 106, column: 3
    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 12
      motInfeed.setPresent();//sysj\conveyorController.sysj line: 110, column: 19
      currsigs.addElement(motInfeed);
      if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 111, column: 12
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 25
        currsigs.addElement(motInfeed);
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
      if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 111, column: 12
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 25
        currsigs.addElement(motInfeed);
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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

  public void thread59915(int [] tdone, int [] ends){
        S33346=1;
    q_thread_4 = BeltQueue.shared();//sysj\conveyorController.sysj line: 79, column: 3
    w_thread_4 = null;//sysj\conveyorController.sysj line: 80, column: 3
    S32681=0;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 84, column: 20
      S32681=1;
      S32621=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 86, column: 4
        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
        S32621=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S32616=0;
        if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
          bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 86, column: 4
          S32616=1;
          if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
            bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
            ends[4]=2;
            ;//sysj\conveyorController.sysj line: 86, column: 4
            w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 87, column: 4
            q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 88, column: 4
            System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 89, column: 4
            S32681=2;
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 20
              S32681=3;
              if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                S32681=4;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
                currsigs.addElement(injectInfeed);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 43
                S32681=3;
                if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                  S32681=4;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
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

  public void thread59913(int [] tdone, int [] ends){
        switch(S41704){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S39358){
          case 0 : 
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 164, column: 20
              S39358=1;
              S39298=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 166, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                S39298=1;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S39293=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 166, column: 4
                  S39293=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                    ends[7]=2;
                    ;//sysj\conveyorController.sysj line: 166, column: 4
                    w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 167, column: 4
                    if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 173, column: 17
                      w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 173, column: 19
                    }
                    System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 174, column: 4
                    S39358=2;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 20
                      S39358=3;
                      if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                        S39358=4;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                          S39358=5;
                          motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                          currsigs.addElement(motOutfeed);
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                            S39358=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                        injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
                        currsigs.addElement(injectOutfeed);
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                    else {
                      if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 43
                        S39358=3;
                        if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                          S39358=4;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                            S39358=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                            currsigs.addElement(motOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                              S39358=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                          injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
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
            switch(S39298){
              case 0 : 
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 166, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                  S39298=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S39293){
                    case 0 : 
                      if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                        tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 166, column: 4
                        S39293=1;
                        if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                          tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                          ends[7]=2;
                          ;//sysj\conveyorController.sysj line: 166, column: 4
                          w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 167, column: 4
                          if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 173, column: 17
                            w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 173, column: 19
                          }
                          System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 174, column: 4
                          S39358=2;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 20
                            S39358=3;
                            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                              S39358=4;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                                S39358=5;
                                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                                currsigs.addElement(motOutfeed);
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                              else {
                                if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                                  S39358=5;
                                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
                              currsigs.addElement(injectOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                          }
                          else {
                            if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 43
                              S39358=3;
                              if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                                S39358=4;
                                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                                  S39358=5;
                                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                                  currsigs.addElement(motOutfeed);
                                  active[7]=1;
                                  ends[7]=1;
                                  tdone[7]=1;
                                }
                                else {
                                  if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                                    S39358=5;
                                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
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
                      if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                        ends[7]=2;
                        ;//sysj\conveyorController.sysj line: 166, column: 4
                        w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 167, column: 4
                        if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 173, column: 17
                          w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 173, column: 19
                        }
                        System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 174, column: 4
                        S39358=2;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 20
                          S39358=3;
                          if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                            S39358=4;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                              S39358=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                              currsigs.addElement(motOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                                S39358=5;
                                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
                            currsigs.addElement(injectOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                        }
                        else {
                          if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 43
                            S39358=3;
                            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                              S39358=4;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                                S39358=5;
                                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                                currsigs.addElement(motOutfeed);
                                active[7]=1;
                                ends[7]=1;
                                tdone[7]=1;
                              }
                              else {
                                if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                                  S39358=5;
                                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
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
                S39298=1;
                S39298=0;
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 166, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                  S39298=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S39293=0;
                  if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                    tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 166, column: 4
                    S39293=1;
                    if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                      tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                      ends[7]=2;
                      ;//sysj\conveyorController.sysj line: 166, column: 4
                      w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 167, column: 4
                      if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 173, column: 17
                        w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 173, column: 19
                      }
                      System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 174, column: 4
                      S39358=2;
                      if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 20
                        S39358=3;
                        if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                          S39358=4;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                            S39358=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                            currsigs.addElement(motOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                              S39358=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                          injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
                          currsigs.addElement(injectOutfeed);
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                      }
                      else {
                        if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 43
                          S39358=3;
                          if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                            S39358=4;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                              S39358=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                              currsigs.addElement(motOutfeed);
                              active[7]=1;
                              ends[7]=1;
                              tdone[7]=1;
                            }
                            else {
                              if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                                S39358=5;
                                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
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
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 20
              S39358=3;
              if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                S39358=4;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                  S39358=5;
                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                  currsigs.addElement(motOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                    S39358=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
                currsigs.addElement(injectOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 43
                S39358=3;
                if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                  S39358=4;
                  if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                    S39358=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                      S39358=5;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                  injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
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
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
              S39358=4;
              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                S39358=5;
                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                currsigs.addElement(motOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                  S39358=5;
                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
              currsigs.addElement(injectOutfeed);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 4 : 
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
              S39358=5;
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
              currsigs.addElement(motOutfeed);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                S39358=5;
                motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
            if(bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 182, column: 10
              S39358=6;
              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 186, column: 20
                S39358=7;
                if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 187, column: 20
                  System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 190, column: 4
                  S39358=8;
                  S39567=0;
                  if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 192, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                    S39567=1;
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    S39562=0;
                    if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                      bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 192, column: 4
                      S39562=1;
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                        ends[7]=2;
                        ;//sysj\conveyorController.sysj line: 192, column: 4
                        S39358=9;
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
                  collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 188, column: 5
                  currsigs.addElement(collectFromEnd);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(collectFromEndM.getprestatus()){//sysj\conveyorController.sysj line: 186, column: 43
                  S39358=7;
                  if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 187, column: 20
                    System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 190, column: 4
                    S39358=8;
                    S39567=0;
                    if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 192, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                      S39567=1;
                      active[7]=1;
                      ends[7]=1;
                      tdone[7]=1;
                    }
                    else {
                      S39562=0;
                      if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                        bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 192, column: 4
                        S39562=1;
                        if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                          bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                          ends[7]=2;
                          ;//sysj\conveyorController.sysj line: 192, column: 4
                          S39358=9;
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
                    collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 188, column: 5
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
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
              currsigs.addElement(motOutfeed);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 6 : 
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 186, column: 20
              S39358=7;
              if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 187, column: 20
                System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 190, column: 4
                S39358=8;
                S39567=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 192, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                  S39567=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S39562=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                    bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 192, column: 4
                    S39562=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                      ends[7]=2;
                      ;//sysj\conveyorController.sysj line: 192, column: 4
                      S39358=9;
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
                collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 188, column: 5
                currsigs.addElement(collectFromEnd);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              if(collectFromEndM.getprestatus()){//sysj\conveyorController.sysj line: 186, column: 43
                S39358=7;
                if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 187, column: 20
                  System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 190, column: 4
                  S39358=8;
                  S39567=0;
                  if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 192, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                    S39567=1;
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    S39562=0;
                    if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                      bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 192, column: 4
                      S39562=1;
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                        ends[7]=2;
                        ;//sysj\conveyorController.sysj line: 192, column: 4
                        S39358=9;
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
                  collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 188, column: 5
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
            if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 187, column: 20
              System.out.println("[CV] " + w_thread_7 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 190, column: 4
              S39358=8;
              S39567=0;
              if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 192, column: 4
                bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                S39567=1;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S39562=0;
                if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                  bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 192, column: 4
                  S39562=1;
                  if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                    ends[7]=2;
                    ;//sysj\conveyorController.sysj line: 192, column: 4
                    S39358=9;
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
              collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 188, column: 5
              currsigs.addElement(collectFromEnd);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 8 : 
            switch(S39567){
              case 0 : 
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 192, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                  S39567=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  switch(S39562){
                    case 0 : 
                      if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                        bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 192, column: 4
                        S39562=1;
                        if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                          bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                          ends[7]=2;
                          ;//sysj\conveyorController.sysj line: 192, column: 4
                          S39358=9;
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
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                        ends[7]=2;
                        ;//sysj\conveyorController.sysj line: 192, column: 4
                        S39358=9;
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
                S39567=1;
                S39567=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 192, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                  S39567=1;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S39562=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                    bottleDone_o.setVal(w_thread_7);//sysj\conveyorController.sysj line: 192, column: 4
                    S39562=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 192, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 192, column: 4
                      ends[7]=2;
                      ;//sysj\conveyorController.sysj line: 192, column: 4
                      S39358=9;
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
            S39358=9;
            S39358=0;
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 164, column: 20
              S39358=1;
              S39298=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 166, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                S39298=1;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S39293=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 166, column: 4
                  S39293=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
                    ends[7]=2;
                    ;//sysj\conveyorController.sysj line: 166, column: 4
                    w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 167, column: 4
                    if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 173, column: 17
                      w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 173, column: 19
                    }
                    System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 174, column: 4
                    S39358=2;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 20
                      S39358=3;
                      if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                        S39358=4;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                          S39358=5;
                          motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                          currsigs.addElement(motOutfeed);
                          active[7]=1;
                          ends[7]=1;
                          tdone[7]=1;
                        }
                        else {
                          if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                            S39358=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                        injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
                        currsigs.addElement(injectOutfeed);
                        active[7]=1;
                        ends[7]=1;
                        tdone[7]=1;
                      }
                    }
                    else {
                      if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 43
                        S39358=3;
                        if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                          S39358=4;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                            S39358=5;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                            currsigs.addElement(motOutfeed);
                            active[7]=1;
                            ends[7]=1;
                            tdone[7]=1;
                          }
                          else {
                            if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                              S39358=5;
                              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                          injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
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

  public void thread59912(int [] tdone, int [] ends){
        switch(S39290){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S33411){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 123, column: 20
              w_thread_6 = q_thread_6.peek();//sysj\conveyorController.sysj line: 125, column: 4
              S33411=1;
              if(w_thread_6 == null){//sysj\conveyorController.sysj line: 133, column: 7
                System.out.println("[CV] Clearing a bottle left on the belt by a reset.");//sysj\conveyorController.sysj line: 134, column: 5
                S33416=0;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 21
                  S33416=1;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
                    S33411=2;
                    if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                      w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                      System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                      S33490=0;
                      S33497=0;
                      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                        S33497=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S33492=0;
                        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                          tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                          S33492=1;
                          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                            ends[6]=2;
                            ;//sysj\conveyorController.sysj line: 146, column: 5
                            q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                            S33490=1;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                              S33490=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                S33411=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                                S33490=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                  S33411=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                      S33411=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 44
                    S33416=1;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
                      S33411=2;
                      if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                        w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                        System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                        S33490=0;
                        S33497=0;
                        if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                          S33497=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S33492=0;
                          if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                            tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                            S33492=1;
                            if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                              tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                              ends[6]=2;
                              ;//sysj\conveyorController.sysj line: 146, column: 5
                              q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                              S33490=1;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                                S33490=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                  S33411=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                                  S33490=2;
                                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                    S33411=3;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                        S33411=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
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
                S33411=2;
                if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                  w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                  System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                  S33490=0;
                  S33497=0;
                  if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                    S33497=1;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    S33492=0;
                    if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                      tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                      S33492=1;
                      if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                        ends[6]=2;
                        ;//sysj\conveyorController.sysj line: 146, column: 5
                        q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                        S33490=1;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                          S33490=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                            System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                            S33411=3;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                            currsigs.addElement(takeFromPos1);
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                            S33490=2;
                            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                              System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                              S33411=3;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                  S33411=3;
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
            switch(S33416){
              case 0 : 
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 21
                  S33416=1;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
                    S33411=2;
                    if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                      w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                      System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                      S33490=0;
                      S33497=0;
                      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                        S33497=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S33492=0;
                        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                          tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                          S33492=1;
                          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                            ends[6]=2;
                            ;//sysj\conveyorController.sysj line: 146, column: 5
                            q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                            S33490=1;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                              S33490=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                S33411=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                                S33490=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                  S33411=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                      S33411=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 44
                    S33416=1;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
                      S33411=2;
                      if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                        w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                        System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                        S33490=0;
                        S33497=0;
                        if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                          S33497=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S33492=0;
                          if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                            tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                            S33492=1;
                            if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                              tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                              ends[6]=2;
                              ;//sysj\conveyorController.sysj line: 146, column: 5
                              q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                              S33490=1;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                                S33490=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                  S33411=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                                  S33490=2;
                                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                    S33411=3;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                        S33411=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
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
                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
                  S33411=2;
                  if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                    w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                    System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                    S33490=0;
                    S33497=0;
                    if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                      S33497=1;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      S33492=0;
                      if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                        tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                        S33492=1;
                        if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                          ends[6]=2;
                          ;//sysj\conveyorController.sysj line: 146, column: 5
                          q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                          S33490=1;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                            S33490=2;
                            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                              System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                              S33411=3;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                              currsigs.addElement(takeFromPos1);
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                              S33490=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                S33411=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                    S33411=3;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
                  currsigs.addElement(takeFromPos1);
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            switch(S33490){
              case 0 : 
                switch(S33497){
                  case 0 : 
                    if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                      S33497=1;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      switch(S33492){
                        case 0 : 
                          if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                            tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                            S33492=1;
                            if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                              tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                              ends[6]=2;
                              ;//sysj\conveyorController.sysj line: 146, column: 5
                              q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                              S33490=1;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                                S33490=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                  S33411=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                                  S33490=2;
                                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                    S33411=3;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                            ends[6]=2;
                            ;//sysj\conveyorController.sysj line: 146, column: 5
                            q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                            S33490=1;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                              S33490=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                S33411=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                                S33490=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                  S33411=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                    S33497=1;
                    S33497=0;
                    if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                      S33497=1;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      S33492=0;
                      if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                        tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                        S33492=1;
                        if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                          ends[6]=2;
                          ;//sysj\conveyorController.sysj line: 146, column: 5
                          q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                          S33490=1;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                            S33490=2;
                            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                              System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                              S33411=3;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                              currsigs.addElement(takeFromPos1);
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                          }
                          else {
                            if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                              S33490=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                S33411=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                  S33490=2;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                    S33411=3;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                    S33490=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                      System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                      S33411=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                  S33411=3;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                  currsigs.addElement(takeFromPos1);
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                break;
              
            }
            break;
          
          case 3 : 
            S33411=3;
            S33411=0;
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 123, column: 20
              w_thread_6 = q_thread_6.peek();//sysj\conveyorController.sysj line: 125, column: 4
              S33411=1;
              if(w_thread_6 == null){//sysj\conveyorController.sysj line: 133, column: 7
                System.out.println("[CV] Clearing a bottle left on the belt by a reset.");//sysj\conveyorController.sysj line: 134, column: 5
                S33416=0;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 21
                  S33416=1;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
                    S33411=2;
                    if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                      w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                      System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                      S33490=0;
                      S33497=0;
                      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                        S33497=1;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        S33492=0;
                        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                          tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                          S33492=1;
                          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                            ends[6]=2;
                            ;//sysj\conveyorController.sysj line: 146, column: 5
                            q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                            S33490=1;
                            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                              S33490=2;
                              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                S33411=3;
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                              else {
                                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                                currsigs.addElement(takeFromPos1);
                                active[6]=1;
                                ends[6]=1;
                                tdone[6]=1;
                              }
                            }
                            else {
                              if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                                S33490=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                  S33411=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                      S33411=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 44
                    S33416=1;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
                      S33411=2;
                      if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                        w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                        System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                        S33490=0;
                        S33497=0;
                        if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                          S33497=1;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          S33492=0;
                          if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                            tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                            S33492=1;
                            if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                              tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                              ends[6]=2;
                              ;//sysj\conveyorController.sysj line: 146, column: 5
                              q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                              S33490=1;
                              if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                                S33490=2;
                                if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                  System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                  S33411=3;
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                                else {
                                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                                  currsigs.addElement(takeFromPos1);
                                  active[6]=1;
                                  ends[6]=1;
                                  tdone[6]=1;
                                }
                              }
                              else {
                                if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                                  S33490=2;
                                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                                    S33411=3;
                                    active[6]=1;
                                    ends[6]=1;
                                    tdone[6]=1;
                                  }
                                  else {
                                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                        S33411=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
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
                S33411=2;
                if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                  w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                  System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                  S33490=0;
                  S33497=0;
                  if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                    S33497=1;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    S33492=0;
                    if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                      tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                      S33492=1;
                      if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                        ends[6]=2;
                        ;//sysj\conveyorController.sysj line: 146, column: 5
                        q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                        S33490=1;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                          S33490=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                            System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                            S33411=3;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                            currsigs.addElement(takeFromPos1);
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                        }
                        else {
                          if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                            S33490=2;
                            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                              System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                              S33411=3;
                              active[6]=1;
                              ends[6]=1;
                              tdone[6]=1;
                            }
                            else {
                              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                  S33411=3;
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

  public void thread59911(int [] tdone, int [] ends){
        switch(S33408){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 12
          motInfeed.setPresent();//sysj\conveyorController.sysj line: 110, column: 19
          currsigs.addElement(motInfeed);
          if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 111, column: 12
            motInfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 25
            currsigs.addElement(motInfeed);
            if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
              twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
              currsigs.addElement(twin);
              twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
            if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
              twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
              currsigs.addElement(twin);
              twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
          if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 111, column: 12
            motInfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 25
            currsigs.addElement(motInfeed);
            if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
              twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
              currsigs.addElement(twin);
              twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
            if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
              twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
              currsigs.addElement(twin);
              twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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

  public void thread59910(int [] tdone, int [] ends){
        switch(S33346){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S32681){
          case 0 : 
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 84, column: 20
              S32681=1;
              S32621=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 86, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                S32621=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S32616=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 86, column: 4
                  S32616=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 86, column: 4
                    w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 87, column: 4
                    q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 88, column: 4
                    System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 89, column: 4
                    S32681=2;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 20
                      S32681=3;
                      if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                        S32681=4;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
                        currsigs.addElement(injectInfeed);
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 43
                        S32681=3;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                          S32681=4;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
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
            switch(S32621){
              case 0 : 
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 86, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                  S32621=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S32616){
                    case 0 : 
                      if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                        bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 86, column: 4
                        S32616=1;
                        if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                          bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                          ends[4]=2;
                          ;//sysj\conveyorController.sysj line: 86, column: 4
                          w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 87, column: 4
                          q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 88, column: 4
                          System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 89, column: 4
                          S32681=2;
                          if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 20
                            S32681=3;
                            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                              S32681=4;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
                              currsigs.addElement(injectInfeed);
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 43
                              S32681=3;
                              if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                                S32681=4;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
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
                      if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                        ends[4]=2;
                        ;//sysj\conveyorController.sysj line: 86, column: 4
                        w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 87, column: 4
                        q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 88, column: 4
                        System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 89, column: 4
                        S32681=2;
                        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 20
                          S32681=3;
                          if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                            S32681=4;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
                            currsigs.addElement(injectInfeed);
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 43
                            S32681=3;
                            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                              S32681=4;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
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
                S32621=1;
                S32621=0;
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 86, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                  S32621=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S32616=0;
                  if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                    bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 86, column: 4
                    S32616=1;
                    if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                      bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                      ends[4]=2;
                      ;//sysj\conveyorController.sysj line: 86, column: 4
                      w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 87, column: 4
                      q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 88, column: 4
                      System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 89, column: 4
                      S32681=2;
                      if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 20
                        S32681=3;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                          S32681=4;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
                          currsigs.addElement(injectInfeed);
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 43
                          S32681=3;
                          if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                            S32681=4;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
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
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 20
              S32681=3;
              if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                S32681=4;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
                currsigs.addElement(injectInfeed);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 43
                S32681=3;
                if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                  S32681=4;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
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
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
              S32681=4;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
              currsigs.addElement(injectInfeed);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 4 : 
            S32681=4;
            S32681=0;
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 84, column: 20
              S32681=1;
              S32621=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 86, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                S32621=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S32616=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 86, column: 4
                  S32616=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 86, column: 4
                    w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 87, column: 4
                    q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 88, column: 4
                    System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 89, column: 4
                    S32681=2;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 20
                      S32681=3;
                      if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                        S32681=4;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
                        currsigs.addElement(injectInfeed);
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 43
                        S32681=3;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                          S32681=4;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
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

  public void thread59909(int [] tdone, int [] ends){
        switch(S59896){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S41706){
          case 0 : 
            if(reset.getprestatus()){//sysj\conveyorController.sysj line: 77, column: 20
              bottleHandoff_in.setPreempted();
              tableOutfeed_in.setPreempted();
              tableInfeed_o.setPreempted();
              bottleDone_o.setPreempted();
              S41706=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread59910(tdone,ends);
              thread59911(tdone,ends);
              thread59912(tdone,ends);
              thread59913(tdone,ends);
              int biggest59914 = 0;
              if(ends[4]>=biggest59914){
                biggest59914=ends[4];
              }
              if(ends[5]>=biggest59914){
                biggest59914=ends[5];
              }
              if(ends[6]>=biggest59914){
                biggest59914=ends[6];
              }
              if(ends[7]>=biggest59914){
                biggest59914=ends[7];
              }
              if(biggest59914 == 1){
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              //FINXME code
              if(biggest59914 == 0){
                S41706=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 1 : 
            S41706=1;
            S41706=0;
            if(reset.getprestatus()){//sysj\conveyorController.sysj line: 77, column: 20
              bottleHandoff_in.setPreempted();
              tableOutfeed_in.setPreempted();
              tableInfeed_o.setPreempted();
              bottleDone_o.setPreempted();
              S41706=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread59915(tdone,ends);
              thread59916(tdone,ends);
              thread59917(tdone,ends);
              thread59918(tdone,ends);
              int biggest59919 = 0;
              if(ends[4]>=biggest59919){
                biggest59919=ends[4];
              }
              if(ends[5]>=biggest59919){
                biggest59919=ends[5];
              }
              if(ends[6]>=biggest59919){
                biggest59919=ends[6];
              }
              if(ends[7]>=biggest59919){
                biggest59919=ends[7];
              }
              if(biggest59919 == 1){
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

  public void thread59908(int [] tdone, int [] ends){
        switch(S32612){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\conveyorController.sysj line: 61, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\conveyorController.sysj line: 64, column: 8
            auto_1.setPresent();//sysj\conveyorController.sysj line: 64, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\conveyorController.sysj line: 65, column: 13
              manual_1.setPresent();//sysj\conveyorController.sysj line: 65, column: 35
              currsigs.addElement(manual_1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
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

  public void thread59905(int [] tdone, int [] ends){
        S41704=1;
    w_thread_7 = null;//sysj\conveyorController.sysj line: 162, column: 3
    S39358=0;
    if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 164, column: 20
      S39358=1;
      S39298=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 166, column: 4
        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
        S39298=1;
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
      else {
        S39293=0;
        if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
          tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 166, column: 4
          S39293=1;
          if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 166, column: 4
            tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 166, column: 4
            ends[7]=2;
            ;//sysj\conveyorController.sysj line: 166, column: 4
            w_thread_7 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 167, column: 4
            if(w_thread_7 != null) {//sysj\conveyorController.sysj line: 173, column: 17
              w_thread_7.started(Machine.CONVEYOR, "outfeed");//sysj\conveyorController.sysj line: 173, column: 19
            }
            System.out.println("[CV] " + w_thread_7 + " received from the table.");//sysj\conveyorController.sysj line: 174, column: 4
            S39358=2;
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 20
              S39358=3;
              if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                S39358=4;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                  S39358=5;
                  motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                  currsigs.addElement(motOutfeed);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                    S39358=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
                currsigs.addElement(injectOutfeed);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              if(injectOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 176, column: 43
                S39358=3;
                if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 177, column: 20
                  S39358=4;
                  if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 20
                    S39358=5;
                    motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
                    currsigs.addElement(motOutfeed);
                    active[7]=1;
                    ends[7]=1;
                    tdone[7]=1;
                  }
                  else {
                    if(motOutfeedM.getprestatus()){//sysj\conveyorController.sysj line: 181, column: 43
                      S39358=5;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 183, column: 5
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
                  injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 178, column: 5
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

  public void thread59904(int [] tdone, int [] ends){
        S39290=1;
    q_thread_6 = BeltQueue.shared();//sysj\conveyorController.sysj line: 120, column: 3
    w_thread_6 = null;//sysj\conveyorController.sysj line: 121, column: 3
    S33411=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 123, column: 20
      w_thread_6 = q_thread_6.peek();//sysj\conveyorController.sysj line: 125, column: 4
      S33411=1;
      if(w_thread_6 == null){//sysj\conveyorController.sysj line: 133, column: 7
        System.out.println("[CV] Clearing a bottle left on the belt by a reset.");//sysj\conveyorController.sysj line: 134, column: 5
        S33416=0;
        if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 21
          S33416=1;
          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
            S33411=2;
            if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
              w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
              System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
              S33490=0;
              S33497=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                S33497=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S33492=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                  tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                  S33492=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                    ends[6]=2;
                    ;//sysj\conveyorController.sysj line: 146, column: 5
                    q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                    S33490=1;
                    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                      S33490=2;
                      if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                        System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                        S33411=3;
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                      else {
                        takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                        currsigs.addElement(takeFromPos1);
                        active[6]=1;
                        ends[6]=1;
                        tdone[6]=1;
                      }
                    }
                    else {
                      if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                        S33490=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                          System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                          S33411=3;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
              S33411=3;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
            currsigs.addElement(takeFromPos1);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
        }
        else {
          if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 135, column: 44
            S33416=1;
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 136, column: 21
              S33411=2;
              if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
                w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
                System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
                S33490=0;
                S33497=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                  S33497=1;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S33492=0;
                  if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                    tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
                    S33492=1;
                    if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                      ends[6]=2;
                      ;//sysj\conveyorController.sysj line: 146, column: 5
                      q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                      S33490=1;
                      if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                        S33490=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                          System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                          S33411=3;
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                          currsigs.addElement(takeFromPos1);
                          active[6]=1;
                          ends[6]=1;
                          tdone[6]=1;
                        }
                      }
                      else {
                        if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                          S33490=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                            System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                            S33411=3;
                            active[6]=1;
                            ends[6]=1;
                            tdone[6]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
                S33411=3;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 137, column: 6
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
        S33411=2;
        if(w_thread_6 != null){//sysj\conveyorController.sysj line: 141, column: 7
          w_thread_6.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 142, column: 5
          System.out.println("[CV] " + w_thread_6 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 143, column: 5
          S33490=0;
          S33497=0;
          if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 146, column: 5
            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
            S33497=1;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            S33492=0;
            if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
              tableInfeed_o.setVal(w_thread_6);//sysj\conveyorController.sysj line: 146, column: 5
              S33492=1;
              if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 146, column: 5
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 146, column: 5
                ends[6]=2;
                ;//sysj\conveyorController.sysj line: 146, column: 5
                q_thread_6.pop();//sysj\conveyorController.sysj line: 147, column: 5
                S33490=1;
                if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 21
                  S33490=2;
                  if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                    System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                    S33411=3;
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                  else {
                    takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
                    currsigs.addElement(takeFromPos1);
                    active[6]=1;
                    ends[6]=1;
                    tdone[6]=1;
                  }
                }
                else {
                  if(takeFromPos1M.getprestatus()){//sysj\conveyorController.sysj line: 151, column: 44
                    S33490=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 152, column: 21
                      System.out.println("[CV] " + w_thread_6 + " handed to the table.");//sysj\conveyorController.sysj line: 155, column: 5
                      S33411=3;
                      active[6]=1;
                      ends[6]=1;
                      tdone[6]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 153, column: 6
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
          S33411=3;
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

  public void thread59903(int [] tdone, int [] ends){
        S33408=1;
    t_thread_5 = new ConveyorTwin();//sysj\conveyorController.sysj line: 105, column: 3
    t_thread_5.setMoving(true);//sysj\conveyorController.sysj line: 106, column: 3
    if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 12
      motInfeed.setPresent();//sysj\conveyorController.sysj line: 110, column: 19
      currsigs.addElement(motInfeed);
      if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 111, column: 12
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 25
        currsigs.addElement(motInfeed);
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
      if(motInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 111, column: 12
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 25
        currsigs.addElement(motInfeed);
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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
        if(t_thread_5.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 112, column: 4
          twin.setPresent();//sysj\conveyorController.sysj line: 113, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_5);//sysj\conveyorController.sysj line: 113, column: 5
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

  public void thread59902(int [] tdone, int [] ends){
        S33346=1;
    q_thread_4 = BeltQueue.shared();//sysj\conveyorController.sysj line: 79, column: 3
    w_thread_4 = null;//sysj\conveyorController.sysj line: 80, column: 3
    S32681=0;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 84, column: 20
      S32681=1;
      S32621=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 86, column: 4
        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
        S32621=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S32616=0;
        if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
          bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 86, column: 4
          S32616=1;
          if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 86, column: 4
            bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 86, column: 4
            ends[4]=2;
            ;//sysj\conveyorController.sysj line: 86, column: 4
            w_thread_4 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 87, column: 4
            q_thread_4.push(w_thread_4);//sysj\conveyorController.sysj line: 88, column: 4
            System.out.println("[CV] Accepted " + w_thread_4 + " from the loader.");//sysj\conveyorController.sysj line: 89, column: 4
            S32681=2;
            if(auto_1.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 20
              S32681=3;
              if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                S32681=4;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
                currsigs.addElement(injectInfeed);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(injectInfeedM.getprestatus()){//sysj\conveyorController.sysj line: 96, column: 43
                S32681=3;
                if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 97, column: 20
                  S32681=4;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  injectInfeed.setPresent();//sysj\conveyorController.sysj line: 98, column: 5
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
        S59896=1;
    S41706=0;
    if(reset.getprestatus()){//sysj\conveyorController.sysj line: 77, column: 20
      bottleHandoff_in.setPreempted();
      tableOutfeed_in.setPreempted();
      tableInfeed_o.setPreempted();
      bottleDone_o.setPreempted();
      S41706=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      thread59902(tdone,ends);
      thread59903(tdone,ends);
      thread59904(tdone,ends);
      thread59905(tdone,ends);
      int biggest59906 = 0;
      if(ends[4]>=biggest59906){
        biggest59906=ends[4];
      }
      if(ends[5]>=biggest59906){
        biggest59906=ends[5];
      }
      if(ends[6]>=biggest59906){
        biggest59906=ends[6];
      }
      if(ends[7]>=biggest59906){
        biggest59906=ends[7];
      }
      if(biggest59906 == 1){
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread59900(int [] tdone, int [] ends){
        S32612=1;
    if(mode.getprestatus()){//sysj\conveyorController.sysj line: 61, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\conveyorController.sysj line: 64, column: 8
        auto_1.setPresent();//sysj\conveyorController.sysj line: 64, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\conveyorController.sysj line: 65, column: 13
          manual_1.setPresent();//sysj\conveyorController.sysj line: 65, column: 35
          currsigs.addElement(manual_1);
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
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
      switch(S59898){
        case 0 : 
          S59898=0;
          break RUN;
        
        case 1 : 
          S59898=2;
          S59898=2;
          auto_1.setClear();//sysj\conveyorController.sysj line: 57, column: 2
          manual_1.setClear();//sysj\conveyorController.sysj line: 57, column: 2
          thread59900(tdone,ends);
          thread59901(tdone,ends);
          int biggest59907 = 0;
          if(ends[2]>=biggest59907){
            biggest59907=ends[2];
          }
          if(ends[3]>=biggest59907){
            biggest59907=ends[3];
          }
          if(biggest59907 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\conveyorController.sysj line: 57, column: 2
          manual_1.setClear();//sysj\conveyorController.sysj line: 57, column: 2
          thread59908(tdone,ends);
          thread59909(tdone,ends);
          int biggest59920 = 0;
          if(ends[2]>=biggest59920){
            biggest59920=ends[2];
          }
          if(ends[3]>=biggest59920){
            biggest59920=ends[3];
          }
          if(biggest59920 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest59920 == 0){
            S59898=0;
            active[1]=0;
            ends[1]=0;
            S59898=0;
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
