import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RecyclingConveyorController extends ClockDomain{
  public RecyclingConveyorController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal bottleAtSplitterExit = new Signal("bottleAtSplitterExit", Signal.INPUT);
  public Signal bottleAtLidRemoval = new Signal("bottleAtLidRemoval", Signal.INPUT);
  public Signal bottleAtDumper = new Signal("bottleAtDumper", Signal.INPUT);
  public Signal bottleAtReturn = new Signal("bottleAtReturn", Signal.INPUT);
  public Signal bottleLeftReturn = new Signal("bottleLeftReturn", Signal.INPUT);
  public Signal recyclingConveyorMotorM = new Signal("recyclingConveyorMotorM", Signal.INPUT);
  public Signal injectAtEntryM = new Signal("injectAtEntryM", Signal.INPUT);
  public Signal collectAtReturnM = new Signal("collectAtReturnM", Signal.INPUT);
  public Signal recyclingConveyorMotor = new Signal("recyclingConveyorMotor", Signal.OUTPUT);
  public Signal injectAtEntry = new Signal("injectAtEntry", Signal.OUTPUT);
  public Signal collectAtReturn = new Signal("collectAtReturn", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int OK_thread_3;//sysj\recyclingConveyorController.sysj line: 65, column: 3
  private int TO_LID_thread_3;//sysj\recyclingConveyorController.sysj line: 67, column: 3
  private int TO_DUMP_thread_3;//sysj\recyclingConveyorController.sysj line: 68, column: 3
  private int TO_RETURN_thread_3;//sysj\recyclingConveyorController.sysj line: 69, column: 3
  private int DISCHARGE_thread_3;//sysj\recyclingConveyorController.sysj line: 70, column: 3
  private int cmd_thread_3;//sysj\recyclingConveyorController.sysj line: 72, column: 3
  private int S237692 = 1;
  private int S227626 = 1;
  private int S237690 = 1;
  private int S229304 = 1;
  private int S227650 = 1;
  private int S227634 = 1;
  private int S227629 = 1;
  private int S227673 = 1;
  private int S228025 = 1;
  private int S228625 = 1;
  private int S228673 = 1;
  private int S228825 = 1;
  private int S228820 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread237698(int [] tdone, int [] ends){
        switch(S237690){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S229304){
          case 0 : 
            if(reset.getprestatus()){//sysj\recyclingConveyorController.sysj line: 75, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S229304=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S227650){
                case 0 : 
                  switch(S227634){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                        enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                        S227634=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S227629){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                              enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                              S227629=1;
                              if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                                enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 76, column: 5
                                cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 77, column: 5
                                S227650=1;
                                if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 79, column: 8
                                  S227673=0;
                                  if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 22
                                    S227673=1;
                                    if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                                      System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                                      S227673=2;
                                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                        S227673=3;
                                        if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                          System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                          S227650=2;
                                          if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                            S228025=0;
                                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                              S228025=1;
                                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                S227650=3;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                currsigs.addElement(recyclingConveyorMotor);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                                S228025=1;
                                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                  S227650=3;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                  currsigs.addElement(recyclingConveyorMotor);
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
                                            S227650=3;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                                          S227673=3;
                                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                            S227650=2;
                                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                              S228025=0;
                                              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                                S228025=1;
                                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                  S227650=3;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                  currsigs.addElement(recyclingConveyorMotor);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                                  S228025=1;
                                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                    S227650=3;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                    currsigs.addElement(recyclingConveyorMotor);
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
                                              S227650=3;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                            currsigs.addElement(recyclingConveyorMotor);
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
                                      injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                                      currsigs.addElement(injectAtEntry);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(injectAtEntryM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 45
                                      S227673=1;
                                      if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                                        System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                                        S227673=2;
                                        if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                          S227673=3;
                                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                            S227650=2;
                                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                              S228025=0;
                                              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                                S228025=1;
                                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                  S227650=3;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                  currsigs.addElement(recyclingConveyorMotor);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                                  S228025=1;
                                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                    S227650=3;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                    currsigs.addElement(recyclingConveyorMotor);
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
                                              S227650=3;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                            currsigs.addElement(recyclingConveyorMotor);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                                            S227673=3;
                                            if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                              System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                              S227650=2;
                                              if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                                S228025=0;
                                                if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                                  S228025=1;
                                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                    S227650=3;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                    currsigs.addElement(recyclingConveyorMotor);
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                                    S228025=1;
                                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                      S227650=3;
                                                      active[3]=1;
                                                      ends[3]=1;
                                                      tdone[3]=1;
                                                    }
                                                    else {
                                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                      currsigs.addElement(recyclingConveyorMotor);
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
                                                S227650=3;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                              currsigs.addElement(recyclingConveyorMotor);
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
                                        injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                                        currsigs.addElement(injectAtEntry);
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
                                  S227650=2;
                                  if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                    S228025=0;
                                    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                      S228025=1;
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                        S228025=1;
                                        if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                          System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                          S227650=3;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
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
                                    S227650=3;
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
                            if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                              enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 76, column: 5
                              cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 77, column: 5
                              S227650=1;
                              if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 79, column: 8
                                S227673=0;
                                if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 22
                                  S227673=1;
                                  if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                                    System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                                    S227673=2;
                                    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                      S227673=3;
                                      if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                        System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                        S227650=2;
                                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                          S228025=0;
                                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                            S228025=1;
                                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                              S227650=3;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                              currsigs.addElement(recyclingConveyorMotor);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                              S228025=1;
                                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                S227650=3;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                currsigs.addElement(recyclingConveyorMotor);
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
                                          S227650=3;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                                        S227673=3;
                                        if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                          System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                          S227650=2;
                                          if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                            S228025=0;
                                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                              S228025=1;
                                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                S227650=3;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                currsigs.addElement(recyclingConveyorMotor);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                                S228025=1;
                                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                  S227650=3;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                  currsigs.addElement(recyclingConveyorMotor);
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
                                            S227650=3;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
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
                                    injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                                    currsigs.addElement(injectAtEntry);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(injectAtEntryM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 45
                                    S227673=1;
                                    if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                                      System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                                      S227673=2;
                                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                        S227673=3;
                                        if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                          System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                          S227650=2;
                                          if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                            S228025=0;
                                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                              S228025=1;
                                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                S227650=3;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                currsigs.addElement(recyclingConveyorMotor);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                                S228025=1;
                                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                  S227650=3;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                  currsigs.addElement(recyclingConveyorMotor);
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
                                            S227650=3;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                                          S227673=3;
                                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                            S227650=2;
                                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                              S228025=0;
                                              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                                S228025=1;
                                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                  S227650=3;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                  currsigs.addElement(recyclingConveyorMotor);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                                  S228025=1;
                                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                    S227650=3;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                    currsigs.addElement(recyclingConveyorMotor);
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
                                              S227650=3;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                            currsigs.addElement(recyclingConveyorMotor);
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
                                      injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                                      currsigs.addElement(injectAtEntry);
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
                                S227650=2;
                                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                  S228025=0;
                                  if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                      S228025=1;
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
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
                                  S227650=3;
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
                      S227634=1;
                      S227634=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                        enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                        S227634=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S227629=0;
                        if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                          enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                          S227629=1;
                          if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                            enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 76, column: 5
                            cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 77, column: 5
                            S227650=1;
                            if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 79, column: 8
                              S227673=0;
                              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 22
                                S227673=1;
                                if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                                  System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                                  S227673=2;
                                  if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                    S227673=3;
                                    if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                      System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                      S227650=2;
                                      if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                        S228025=0;
                                        if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                          S228025=1;
                                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                            S227650=3;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                            currsigs.addElement(recyclingConveyorMotor);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                            S228025=1;
                                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                              S227650=3;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                              currsigs.addElement(recyclingConveyorMotor);
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
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                                      S227673=3;
                                      if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                        System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                        S227650=2;
                                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                          S228025=0;
                                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                            S228025=1;
                                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                              S227650=3;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                              currsigs.addElement(recyclingConveyorMotor);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                              S228025=1;
                                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                S227650=3;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                currsigs.addElement(recyclingConveyorMotor);
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
                                          S227650=3;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
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
                                  injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                                  currsigs.addElement(injectAtEntry);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(injectAtEntryM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 45
                                  S227673=1;
                                  if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                                    System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                                    S227673=2;
                                    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                      S227673=3;
                                      if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                        System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                        S227650=2;
                                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                          S228025=0;
                                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                            S228025=1;
                                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                              S227650=3;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                              currsigs.addElement(recyclingConveyorMotor);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                              S228025=1;
                                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                S227650=3;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                currsigs.addElement(recyclingConveyorMotor);
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
                                          S227650=3;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                                        S227673=3;
                                        if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                          System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                          S227650=2;
                                          if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                            S228025=0;
                                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                              S228025=1;
                                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                S227650=3;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                currsigs.addElement(recyclingConveyorMotor);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                                S228025=1;
                                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                                  S227650=3;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                                  currsigs.addElement(recyclingConveyorMotor);
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
                                            S227650=3;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
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
                                    injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                                    currsigs.addElement(injectAtEntry);
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
                              S227650=2;
                              if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                S228025=0;
                                if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                  S228025=1;
                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                    S227650=3;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
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
                                S227650=3;
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
                  switch(S227673){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 22
                        S227673=1;
                        if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                          System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                          S227673=2;
                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                            S227673=3;
                            if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                              System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                              S227650=2;
                              if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                S228025=0;
                                if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                  S228025=1;
                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                    S227650=3;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
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
                                S227650=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                              S227673=3;
                              if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                S227650=2;
                                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                  S228025=0;
                                  if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                      S228025=1;
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
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
                                  S227650=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
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
                          injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                          currsigs.addElement(injectAtEntry);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(injectAtEntryM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 45
                          S227673=1;
                          if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                            System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                            S227673=2;
                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                              S227673=3;
                              if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                S227650=2;
                                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                  S228025=0;
                                  if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                      S228025=1;
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
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
                                  S227650=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                                S227673=3;
                                if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                  System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                  S227650=2;
                                  if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                    S228025=0;
                                    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                      S228025=1;
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                        S228025=1;
                                        if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                          System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                          S227650=3;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
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
                                    S227650=3;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
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
                            injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                            currsigs.addElement(injectAtEntry);
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
                    
                    case 1 : 
                      if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                        System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                        S227673=2;
                        if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                          S227673=3;
                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                            S227650=2;
                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                              S228025=0;
                              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                S228025=1;
                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                  S227650=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                  S228025=1;
                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                    S227650=3;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
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
                              S227650=3;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                            S227673=3;
                            if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                              System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                              S227650=2;
                              if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                S228025=0;
                                if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                  S228025=1;
                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                    S227650=3;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
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
                                S227650=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
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
                        injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                        currsigs.addElement(injectAtEntry);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 2 : 
                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                        S227673=3;
                        if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                          System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                          S227650=2;
                          if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                            S228025=0;
                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                              S228025=1;
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                S227650=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                S228025=1;
                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                  S227650=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
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
                            S227650=3;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                          S227673=3;
                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                            S227650=2;
                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                              S228025=0;
                              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                S228025=1;
                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                  S227650=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                  S228025=1;
                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                    S227650=3;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
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
                              S227650=3;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
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
                    
                    case 3 : 
                      if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                        System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                        S227650=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                          S228025=0;
                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                            S228025=1;
                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                              S227650=3;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                              S228025=1;
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                S227650=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
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
                          S227650=3;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 2 : 
                  switch(S228025){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                        S228025=1;
                        if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                          System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                          S227650=3;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                          S228025=1;
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                            S227650=3;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
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
                    
                    case 1 : 
                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                        S227650=3;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 3 : 
                  S227650=3;
                  S227650=4;
                  if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 109, column: 8
                    S228625=0;
                    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 110, column: 22
                      S228625=1;
                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 111, column: 22
                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 114, column: 6
                        S227650=5;
                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 117, column: 8
                          S228673=0;
                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 22
                            S228673=1;
                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                              S227650=6;
                              S228825=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S228825=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S228820=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S228820=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S229304=1;
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
                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                              currsigs.addElement(collectAtReturn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(collectAtReturnM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 45
                              S228673=1;
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                                S227650=6;
                                S228825=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S228825=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S228820=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S228820=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      S229304=1;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                                currsigs.addElement(collectAtReturn);
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
                          S227650=6;
                          S228825=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            S228825=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S228820=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228820=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S229304=1;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 112, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 110, column: 45
                        S228625=1;
                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 111, column: 22
                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 114, column: 6
                          S227650=5;
                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 117, column: 8
                            S228673=0;
                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 22
                              S228673=1;
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                                S227650=6;
                                S228825=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S228825=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S228820=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S228820=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      S229304=1;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(collectAtReturnM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 45
                                S228673=1;
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                                  S227650=6;
                                  S228825=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S228825=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S228820=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      S228820=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        S229304=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                                  currsigs.addElement(collectAtReturn);
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
                            S227650=6;
                            S228825=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228825=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S228820=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S228820=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S229304=1;
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
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 112, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
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
                    S227650=5;
                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 117, column: 8
                      S228673=0;
                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 22
                        S228673=1;
                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                          S227650=6;
                          S228825=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            S228825=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S228820=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228820=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S229304=1;
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
                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                          currsigs.addElement(collectAtReturn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(collectAtReturnM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 45
                          S228673=1;
                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                            S227650=6;
                            S228825=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228825=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S228820=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S228820=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S229304=1;
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
                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                            currsigs.addElement(collectAtReturn);
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
                      S227650=6;
                      S228825=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                        S228825=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S228820=0;
                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                          S228820=1;
                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            S229304=1;
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
                  break;
                
                case 4 : 
                  switch(S228625){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 110, column: 22
                        S228625=1;
                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 111, column: 22
                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 114, column: 6
                          S227650=5;
                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 117, column: 8
                            S228673=0;
                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 22
                              S228673=1;
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                                S227650=6;
                                S228825=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S228825=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S228820=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S228820=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      S229304=1;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(collectAtReturnM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 45
                                S228673=1;
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                                  S227650=6;
                                  S228825=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S228825=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S228820=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      S228820=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        S229304=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                                  currsigs.addElement(collectAtReturn);
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
                            S227650=6;
                            S228825=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228825=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S228820=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S228820=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S229304=1;
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
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 112, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 110, column: 45
                          S228625=1;
                          if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 111, column: 22
                            System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 114, column: 6
                            S227650=5;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 117, column: 8
                              S228673=0;
                              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 22
                                S228673=1;
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                                  S227650=6;
                                  S228825=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S228825=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S228820=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      S228820=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        S229304=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                if(collectAtReturnM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 45
                                  S228673=1;
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                                    S227650=6;
                                    S228825=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      S228825=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S228820=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                        S228820=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                          S229304=1;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                                    currsigs.addElement(collectAtReturn);
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
                              S227650=6;
                              S228825=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S228825=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S228820=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S228820=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S229304=1;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 112, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
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
                    
                    case 1 : 
                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 111, column: 22
                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 114, column: 6
                        S227650=5;
                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 117, column: 8
                          S228673=0;
                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 22
                            S228673=1;
                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                              S227650=6;
                              S228825=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S228825=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S228820=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S228820=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S229304=1;
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
                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                              currsigs.addElement(collectAtReturn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(collectAtReturnM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 45
                              S228673=1;
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                                S227650=6;
                                S228825=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S228825=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S228820=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                    S228820=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                      S229304=1;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                                currsigs.addElement(collectAtReturn);
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
                          S227650=6;
                          S228825=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            S228825=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S228820=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228820=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S229304=1;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 112, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 5 : 
                  switch(S228673){
                    case 0 : 
                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 22
                        S228673=1;
                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                          S227650=6;
                          S228825=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            S228825=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S228820=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228820=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S229304=1;
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
                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                          currsigs.addElement(collectAtReturn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(collectAtReturnM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 45
                          S228673=1;
                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                            S227650=6;
                            S228825=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228825=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S228820=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S228820=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                  S229304=1;
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
                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                            currsigs.addElement(collectAtReturn);
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
                    
                    case 1 : 
                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 119, column: 22
                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 122, column: 6
                        S227650=6;
                        S228825=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                          S228825=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S228820=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            S228820=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S229304=1;
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
                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 120, column: 7
                        currsigs.addElement(collectAtReturn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 6 : 
                  switch(S228825){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                        S228825=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S228820){
                          case 0 : 
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S228820=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                                S229304=1;
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
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                              S229304=1;
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
                      S228825=1;
                      S228825=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                        S228825=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S228820=0;
                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 125, column: 5
                          S228820=1;
                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 125, column: 5
                            S229304=1;
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
                
              }
            }
            break;
          
          case 1 : 
            S229304=1;
            S229304=0;
            if(reset.getprestatus()){//sysj\recyclingConveyorController.sysj line: 75, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S229304=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S227650=0;
              S227634=0;
              if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                S227634=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S227629=0;
                if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                  enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                  S227629=1;
                  if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
                    enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
                    ends[3]=2;
                    ;//sysj\recyclingConveyorController.sysj line: 76, column: 5
                    cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 77, column: 5
                    S227650=1;
                    if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 79, column: 8
                      S227673=0;
                      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 22
                        S227673=1;
                        if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                          System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                          S227673=2;
                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                            S227673=3;
                            if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                              System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                              S227650=2;
                              if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                S228025=0;
                                if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                  S228025=1;
                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                    S227650=3;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
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
                                S227650=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                              S227673=3;
                              if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                S227650=2;
                                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                  S228025=0;
                                  if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                      S228025=1;
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
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
                                  S227650=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
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
                          injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                          currsigs.addElement(injectAtEntry);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        if(injectAtEntryM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 45
                          S227673=1;
                          if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                            System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                            S227673=2;
                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                              S227673=3;
                              if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                S227650=2;
                                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                  S228025=0;
                                  if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                    S228025=1;
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                      S227650=3;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                      S228025=1;
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
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
                                  S227650=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                                S227673=3;
                                if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                                  System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                                  S227650=2;
                                  if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                                    S228025=0;
                                    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                                      S228025=1;
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                        S227650=3;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                        S228025=1;
                                        if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                          System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                          S227650=3;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
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
                                    S227650=3;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
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
                            injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                            currsigs.addElement(injectAtEntry);
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
                      S227650=2;
                      if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                        S228025=0;
                        if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                          S228025=1;
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                            S227650=3;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                            S228025=1;
                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                              S227650=3;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
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
                        S227650=3;
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
            break;
          
        }
        break;
      
    }
  }

  public void thread237697(int [] tdone, int [] ends){
        switch(S227626){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\recyclingConveyorController.sysj line: 54, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\recyclingConveyorController.sysj line: 57, column: 8
            auto_1.setPresent();//sysj\recyclingConveyorController.sysj line: 57, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\recyclingConveyorController.sysj line: 58, column: 13
              manual_1.setPresent();//sysj\recyclingConveyorController.sysj line: 58, column: 35
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

  public void thread237695(int [] tdone, int [] ends){
        S237690=1;
    OK_thread_3 = 0;//sysj\recyclingConveyorController.sysj line: 65, column: 3
    TO_LID_thread_3 = 1;//sysj\recyclingConveyorController.sysj line: 67, column: 3
    TO_DUMP_thread_3 = 2;//sysj\recyclingConveyorController.sysj line: 68, column: 3
    TO_RETURN_thread_3 = 3;//sysj\recyclingConveyorController.sysj line: 69, column: 3
    DISCHARGE_thread_3 = 4;//sysj\recyclingConveyorController.sysj line: 70, column: 3
    cmd_thread_3 = 0;//sysj\recyclingConveyorController.sysj line: 72, column: 3
    S229304=0;
    if(reset.getprestatus()){//sysj\recyclingConveyorController.sysj line: 75, column: 20
      enable_in.setPreempted();
      status_o.setPreempted();
      S229304=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S227650=0;
      S227634=0;
      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
        enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
        S227634=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S227629=0;
        if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
          enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 76, column: 5
          S227629=1;
          if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 76, column: 5
            enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 76, column: 5
            ends[3]=2;
            ;//sysj\recyclingConveyorController.sysj line: 76, column: 5
            cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 77, column: 5
            S227650=1;
            if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 79, column: 8
              S227673=0;
              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 22
                S227673=1;
                if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                  System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                  S227673=2;
                  if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                    S227673=3;
                    if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                      System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                      S227650=2;
                      if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                        S228025=0;
                        if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                          S228025=1;
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                            S227650=3;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                            S228025=1;
                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                              S227650=3;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
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
                        S227650=3;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                      currsigs.addElement(recyclingConveyorMotor);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                      S227673=3;
                      if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                        System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                        S227650=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                          S228025=0;
                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                            S228025=1;
                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                              S227650=3;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                              S228025=1;
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                S227650=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
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
                          S227650=3;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
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
                  injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                  currsigs.addElement(injectAtEntry);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(injectAtEntryM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 82, column: 45
                  S227673=1;
                  if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 83, column: 22
                    System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 86, column: 6
                    S227673=2;
                    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                      S227673=3;
                      if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                        System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                        S227650=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                          S228025=0;
                          if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                            S228025=1;
                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                              S227650=3;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                              S228025=1;
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                S227650=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
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
                          S227650=3;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 45
                        S227673=3;
                        if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 88, column: 22
                          System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 91, column: 6
                          S227650=2;
                          if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                            S228025=0;
                            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                              S228025=1;
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                S227650=3;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                                S228025=1;
                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                                  S227650=3;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
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
                            S227650=3;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 89, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
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
                    injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 84, column: 7
                    currsigs.addElement(injectAtEntry);
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
              S227650=2;
              if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 94, column: 8
                S228025=0;
                if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 22
                  S228025=1;
                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                    S227650=3;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 45
                    S228025=1;
                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 96, column: 22
                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 99, column: 6
                      S227650=3;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 7
                      currsigs.addElement(recyclingConveyorMotor);
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
                S227650=3;
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

  public void thread237694(int [] tdone, int [] ends){
        S227626=1;
    if(mode.getprestatus()){//sysj\recyclingConveyorController.sysj line: 54, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\recyclingConveyorController.sysj line: 57, column: 8
        auto_1.setPresent();//sysj\recyclingConveyorController.sysj line: 57, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\recyclingConveyorController.sysj line: 58, column: 13
          manual_1.setPresent();//sysj\recyclingConveyorController.sysj line: 58, column: 35
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
      switch(S237692){
        case 0 : 
          S237692=0;
          break RUN;
        
        case 1 : 
          S237692=2;
          S237692=2;
          auto_1.setClear();//sysj\recyclingConveyorController.sysj line: 50, column: 2
          manual_1.setClear();//sysj\recyclingConveyorController.sysj line: 50, column: 2
          thread237694(tdone,ends);
          thread237695(tdone,ends);
          int biggest237696 = 0;
          if(ends[2]>=biggest237696){
            biggest237696=ends[2];
          }
          if(ends[3]>=biggest237696){
            biggest237696=ends[3];
          }
          if(biggest237696 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\recyclingConveyorController.sysj line: 50, column: 2
          manual_1.setClear();//sysj\recyclingConveyorController.sysj line: 50, column: 2
          thread237697(tdone,ends);
          thread237698(tdone,ends);
          int biggest237699 = 0;
          if(ends[2]>=biggest237699){
            biggest237699=ends[2];
          }
          if(ends[3]>=biggest237699){
            biggest237699=ends[3];
          }
          if(biggest237699 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest237699 == 0){
            S237692=0;
            active[1]=0;
            ends[1]=0;
            S237692=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
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
          enable_in.gethook();
          status_o.gethook();
          mode.gethook();
          reset.gethook();
          bottleAtSplitterExit.gethook();
          bottleAtLidRemoval.gethook();
          bottleAtDumper.gethook();
          bottleAtReturn.gethook();
          bottleLeftReturn.gethook();
          recyclingConveyorMotorM.gethook();
          injectAtEntryM.gethook();
          collectAtReturnM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      reset.setpreclear();
      bottleAtSplitterExit.setpreclear();
      bottleAtLidRemoval.setpreclear();
      bottleAtDumper.setpreclear();
      bottleAtReturn.setpreclear();
      bottleLeftReturn.setpreclear();
      recyclingConveyorMotorM.setpreclear();
      injectAtEntryM.setpreclear();
      collectAtReturnM.setpreclear();
      recyclingConveyorMotor.setpreclear();
      injectAtEntry.setpreclear();
      collectAtReturn.setpreclear();
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
      dummyint = bottleAtSplitterExit.getStatus() ? bottleAtSplitterExit.setprepresent() : bottleAtSplitterExit.setpreclear();
      bottleAtSplitterExit.setpreval(bottleAtSplitterExit.getValue());
      bottleAtSplitterExit.setClear();
      dummyint = bottleAtLidRemoval.getStatus() ? bottleAtLidRemoval.setprepresent() : bottleAtLidRemoval.setpreclear();
      bottleAtLidRemoval.setpreval(bottleAtLidRemoval.getValue());
      bottleAtLidRemoval.setClear();
      dummyint = bottleAtDumper.getStatus() ? bottleAtDumper.setprepresent() : bottleAtDumper.setpreclear();
      bottleAtDumper.setpreval(bottleAtDumper.getValue());
      bottleAtDumper.setClear();
      dummyint = bottleAtReturn.getStatus() ? bottleAtReturn.setprepresent() : bottleAtReturn.setpreclear();
      bottleAtReturn.setpreval(bottleAtReturn.getValue());
      bottleAtReturn.setClear();
      dummyint = bottleLeftReturn.getStatus() ? bottleLeftReturn.setprepresent() : bottleLeftReturn.setpreclear();
      bottleLeftReturn.setpreval(bottleLeftReturn.getValue());
      bottleLeftReturn.setClear();
      dummyint = recyclingConveyorMotorM.getStatus() ? recyclingConveyorMotorM.setprepresent() : recyclingConveyorMotorM.setpreclear();
      recyclingConveyorMotorM.setpreval(recyclingConveyorMotorM.getValue());
      recyclingConveyorMotorM.setClear();
      dummyint = injectAtEntryM.getStatus() ? injectAtEntryM.setprepresent() : injectAtEntryM.setpreclear();
      injectAtEntryM.setpreval(injectAtEntryM.getValue());
      injectAtEntryM.setClear();
      dummyint = collectAtReturnM.getStatus() ? collectAtReturnM.setprepresent() : collectAtReturnM.setpreclear();
      collectAtReturnM.setpreval(collectAtReturnM.getValue());
      collectAtReturnM.setClear();
      recyclingConveyorMotor.sethook();
      recyclingConveyorMotor.setClear();
      injectAtEntry.sethook();
      injectAtEntry.setClear();
      collectAtReturn.sethook();
      collectAtReturn.setClear();
      auto_1.setClear();
      manual_1.setClear();
      enable_in.sethook();
      status_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable_in.gethook();
        status_o.gethook();
        mode.gethook();
        reset.gethook();
        bottleAtSplitterExit.gethook();
        bottleAtLidRemoval.gethook();
        bottleAtDumper.gethook();
        bottleAtReturn.gethook();
        bottleLeftReturn.gethook();
        recyclingConveyorMotorM.gethook();
        injectAtEntryM.gethook();
        collectAtReturnM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
