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
  public Signal bottleAtSplitterExit = new Signal("bottleAtSplitterExit", Signal.INPUT);
  public Signal bottleAtLidRemoval = new Signal("bottleAtLidRemoval", Signal.INPUT);
  public Signal bottleAtDumper = new Signal("bottleAtDumper", Signal.INPUT);
  public Signal bottleAtReturn = new Signal("bottleAtReturn", Signal.INPUT);
  public Signal bottleLeftReturn = new Signal("bottleLeftReturn", Signal.INPUT);
  public Signal recyclingConveyorMotorM = new Signal("recyclingConveyorMotorM", Signal.INPUT);
  public Signal recyclingConveyorMotor = new Signal("recyclingConveyorMotor", Signal.OUTPUT);
  public Signal injectAtEntry = new Signal("injectAtEntry", Signal.OUTPUT);
  public Signal collectAtReturn = new Signal("collectAtReturn", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int OK_thread_3;//sysj\recyclingConveyorController.sysj line: 57, column: 3
  private int TO_LID_thread_3;//sysj\recyclingConveyorController.sysj line: 59, column: 3
  private int TO_DUMP_thread_3;//sysj\recyclingConveyorController.sysj line: 60, column: 3
  private int TO_RETURN_thread_3;//sysj\recyclingConveyorController.sysj line: 61, column: 3
  private int DISCHARGE_thread_3;//sysj\recyclingConveyorController.sysj line: 62, column: 3
  private int cmd_thread_3;//sysj\recyclingConveyorController.sysj line: 64, column: 3
  private int S156510 = 1;
  private int S119379 = 1;
  private int S156437 = 1;
  private int S125556 = 1;
  private int S119404 = 1;
  private int S119388 = 1;
  private int S119383 = 1;
  private int S119409 = 1;
  private int S119861 = 1;
  private int S119856 = 1;
  private int S156508 = 1;
  private int S156460 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread156518(int [] tdone, int [] ends){
        switch(S156508){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S156460){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 115, column: 20
              S156460=1;
              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 116, column: 20
                S156460=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 14
                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 118, column: 40
                  currsigs.addElement(recyclingConveyorMotor);
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
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 116, column: 20
              S156460=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 14
                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 118, column: 40
                currsigs.addElement(recyclingConveyorMotor);
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
            break;
          
          case 2 : 
            S156460=2;
            S156460=0;
            if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 115, column: 20
              S156460=1;
              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 116, column: 20
                S156460=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 14
                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 118, column: 40
                  currsigs.addElement(recyclingConveyorMotor);
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
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread156517(int [] tdone, int [] ends){
        switch(S156437){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S125556){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 67, column: 20
              S125556=1;
              if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 69, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S125556=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S119404=0;
                S119388=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                  enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                  S119388=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S119383=0;
                  if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                    enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                    S119383=1;
                    if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                      enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                      ends[3]=2;
                      ;//sysj\recyclingConveyorController.sysj line: 70, column: 5
                      cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 71, column: 5
                      S119404=1;
                      if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 73, column: 8
                        S119409=0;
                        if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 76, column: 22
                          System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 79, column: 6
                          S119409=1;
                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 80, column: 22
                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 83, column: 6
                            S119404=2;
                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                                S119404=3;
                                if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                  if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                    System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                    S119404=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=3;
                              if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                  System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                  S119404=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                          }
                          else {
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 81, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 77, column: 7
                          currsigs.addElement(injectAtEntry);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S119404=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                            S119404=3;
                            if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                              if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                S119404=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S119404=3;
                          if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                            if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                              System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                              S119404=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S119404=4;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=5;
                              S119861=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119861=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S119856=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119856=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S125556=2;
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
            if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 69, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S125556=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S119404){
                case 0 : 
                  switch(S119388){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                        enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                        S119388=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S119383){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                              enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                              S119383=1;
                              if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                                enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 70, column: 5
                                cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 71, column: 5
                                S119404=1;
                                if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 73, column: 8
                                  S119409=0;
                                  if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 76, column: 22
                                    System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 79, column: 6
                                    S119409=1;
                                    if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 80, column: 22
                                      System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 83, column: 6
                                      S119404=2;
                                      if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                                        if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                          System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                                          S119404=3;
                                          if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                            if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                              System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                              S119404=4;
                                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                                  S119404=5;
                                                  S119861=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S119861=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S119856=0;
                                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      S119856=1;
                                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                        S125556=2;
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
                                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                                  currsigs.addElement(collectAtReturn);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                S119404=5;
                                                S119861=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119861=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S119856=0;
                                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S119856=1;
                                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      S125556=2;
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
                                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                              currsigs.addElement(recyclingConveyorMotor);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S119404=4;
                                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                                S119404=5;
                                                S119861=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119861=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S119856=0;
                                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S119856=1;
                                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      S125556=2;
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
                                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                                currsigs.addElement(collectAtReturn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S119404=5;
                                              S119861=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119861=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S119856=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119856=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S125556=2;
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
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=3;
                                        if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                          if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                            System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                            S119404=4;
                                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                                S119404=5;
                                                S119861=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119861=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S119856=0;
                                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S119856=1;
                                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      S125556=2;
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
                                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                                currsigs.addElement(collectAtReturn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S119404=5;
                                              S119861=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119861=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S119856=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119856=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S125556=2;
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
                                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                            currsigs.addElement(recyclingConveyorMotor);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S119404=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                              S119404=5;
                                              S119861=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119861=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S119856=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119856=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S125556=2;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                    }
                                    else {
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 81, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 77, column: 7
                                    currsigs.addElement(injectAtEntry);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=2;
                                  if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                                      S119404=3;
                                      if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                          S119404=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                              S119404=5;
                                              S119861=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119861=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S119856=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119856=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S125556=2;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=3;
                                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                        S119404=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                            if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                              enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 70, column: 5
                              cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 71, column: 5
                              S119404=1;
                              if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 73, column: 8
                                S119409=0;
                                if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 76, column: 22
                                  System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 79, column: 6
                                  S119409=1;
                                  if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 80, column: 22
                                    System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 83, column: 6
                                    S119404=2;
                                    if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                                        S119404=3;
                                        if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                          if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                            System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                            S119404=4;
                                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                                S119404=5;
                                                S119861=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119861=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S119856=0;
                                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S119856=1;
                                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                      S125556=2;
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
                                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                                currsigs.addElement(collectAtReturn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S119404=5;
                                              S119861=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119861=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S119856=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119856=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S125556=2;
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
                                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                            currsigs.addElement(recyclingConveyorMotor);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S119404=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                              S119404=5;
                                              S119861=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119861=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S119856=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119856=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S125556=2;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=3;
                                      if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                          S119404=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                              S119404=5;
                                              S119861=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119861=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S119856=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119856=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S125556=2;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                  }
                                  else {
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 81, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 77, column: 7
                                  currsigs.addElement(injectAtEntry);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=2;
                                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                                    S119404=3;
                                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                        S119404=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=3;
                                  if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                    if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                      System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                      S119404=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                      S119388=1;
                      S119388=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                        enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                        S119388=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S119383=0;
                        if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                          enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                          S119383=1;
                          if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                            enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 70, column: 5
                            cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 71, column: 5
                            S119404=1;
                            if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 73, column: 8
                              S119409=0;
                              if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 76, column: 22
                                System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 79, column: 6
                                S119409=1;
                                if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 80, column: 22
                                  System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 83, column: 6
                                  S119404=2;
                                  if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                                      S119404=3;
                                      if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                          S119404=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                              S119404=5;
                                              S119861=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119861=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S119856=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S119856=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                    S125556=2;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=3;
                                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                        S119404=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                            S119404=5;
                                            S119861=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119861=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S119856=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S119856=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                  S125556=2;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                }
                                else {
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 81, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 77, column: 7
                                currsigs.addElement(injectAtEntry);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=2;
                              if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                                  S119404=3;
                                  if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                    if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                      System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                      S119404=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                          S119404=5;
                                          S119861=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119861=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S119856=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S119856=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                                S125556=2;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=3;
                                if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                  if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                    System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                    S119404=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                  switch(S119409){
                    case 0 : 
                      if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 76, column: 22
                        System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 79, column: 6
                        S119409=1;
                        if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 80, column: 22
                          System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 83, column: 6
                          S119404=2;
                          if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                              S119404=3;
                              if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                  System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                  S119404=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S119404=3;
                            if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                              if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                S119404=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                        }
                        else {
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 81, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 77, column: 7
                        currsigs.addElement(injectAtEntry);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 80, column: 22
                        System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 83, column: 6
                        S119404=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                            S119404=3;
                            if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                              if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                S119404=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S119404=3;
                          if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                            if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                              System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                              S119404=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S119404=4;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=5;
                              S119861=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119861=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S119856=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119856=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S125556=2;
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
                      }
                      else {
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 81, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 2 : 
                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                    S119404=3;
                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                        S119404=4;
                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                            S119404=5;
                            S119861=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119861=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S119856=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119856=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S125556=2;
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
                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                            currsigs.addElement(collectAtReturn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S119404=5;
                          S119861=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119861=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S119856=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119856=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S125556=2;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S119404=4;
                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                          S119404=5;
                          S119861=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119861=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S119856=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119856=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S125556=2;
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
                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                          currsigs.addElement(collectAtReturn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S119404=5;
                        S119861=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S119861=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S119856=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119856=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S125556=2;
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
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                    System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                    S119404=4;
                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                        S119404=5;
                        S119861=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S119861=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S119856=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119856=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S125556=2;
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
                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                        currsigs.addElement(collectAtReturn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S119404=5;
                      S119861=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        S119861=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S119856=0;
                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S119856=1;
                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S125556=2;
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
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 4 : 
                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                    S119404=5;
                    S119861=0;
                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                      S119861=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S119856=0;
                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        S119856=1;
                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          ends[3]=2;
                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S125556=2;
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
                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                    currsigs.addElement(collectAtReturn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 5 : 
                  switch(S119861){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        S119861=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S119856){
                          case 0 : 
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119856=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S125556=2;
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
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S125556=2;
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
                      S119861=1;
                      S119861=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        S119861=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S119856=0;
                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S119856=1;
                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S125556=2;
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
          
          case 2 : 
            S125556=2;
            S125556=0;
            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 67, column: 20
              S125556=1;
              if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 69, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S125556=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S119404=0;
                S119388=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                  enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                  S119388=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S119383=0;
                  if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                    enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                    S119383=1;
                    if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
                      enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
                      ends[3]=2;
                      ;//sysj\recyclingConveyorController.sysj line: 70, column: 5
                      cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 71, column: 5
                      S119404=1;
                      if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 73, column: 8
                        S119409=0;
                        if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 76, column: 22
                          System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 79, column: 6
                          S119409=1;
                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 80, column: 22
                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 83, column: 6
                            S119404=2;
                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                                S119404=3;
                                if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                  if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                    System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                    S119404=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                        S119404=5;
                                        S119861=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119861=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S119856=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S119856=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                              S125556=2;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=3;
                              if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                                if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                  System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                  S119404=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                      S119404=5;
                                      S119861=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119861=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S119856=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S119856=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                            S125556=2;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                          }
                          else {
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 81, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 77, column: 7
                          currsigs.addElement(injectAtEntry);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S119404=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                            S119404=3;
                            if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                              if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                                System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                                S119404=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                    S119404=5;
                                    S119861=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119861=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S119856=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S119856=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                          S125556=2;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S119404=3;
                          if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                            if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                              System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                              S119404=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                  S119404=5;
                                  S119861=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119861=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S119856=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S119856=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                        S125556=2;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S119404=4;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=5;
                              S119861=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119861=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S119856=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119856=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S125556=2;
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

  public void thread156516(int [] tdone, int [] ends){
        switch(S119379){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\recyclingConveyorController.sysj line: 48, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\recyclingConveyorController.sysj line: 49, column: 8
            auto_1.setPresent();//sysj\recyclingConveyorController.sysj line: 49, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\recyclingConveyorController.sysj line: 50, column: 12
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

  public void thread156514(int [] tdone, int [] ends){
        S156508=1;
    S156460=0;
    if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 115, column: 20
      S156460=1;
      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 116, column: 20
        S156460=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 118, column: 14
          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 118, column: 40
          currsigs.addElement(recyclingConveyorMotor);
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
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread156513(int [] tdone, int [] ends){
        S156437=1;
    OK_thread_3 = 0;//sysj\recyclingConveyorController.sysj line: 57, column: 3
    TO_LID_thread_3 = 1;//sysj\recyclingConveyorController.sysj line: 59, column: 3
    TO_DUMP_thread_3 = 2;//sysj\recyclingConveyorController.sysj line: 60, column: 3
    TO_RETURN_thread_3 = 3;//sysj\recyclingConveyorController.sysj line: 61, column: 3
    DISCHARGE_thread_3 = 4;//sysj\recyclingConveyorController.sysj line: 62, column: 3
    cmd_thread_3 = 0;//sysj\recyclingConveyorController.sysj line: 64, column: 3
    S125556=0;
    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 67, column: 20
      S125556=1;
      if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 69, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S125556=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S119404=0;
        S119388=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
          enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
          S119388=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S119383=0;
          if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
            enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 70, column: 5
            S119383=1;
            if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 70, column: 5
              enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 70, column: 5
              ends[3]=2;
              ;//sysj\recyclingConveyorController.sysj line: 70, column: 5
              cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 71, column: 5
              S119404=1;
              if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 73, column: 8
                S119409=0;
                if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 76, column: 22
                  System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 79, column: 6
                  S119409=1;
                  if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 80, column: 22
                    System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 83, column: 6
                    S119404=2;
                    if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                        S119404=3;
                        if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                          if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                            System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                            S119404=4;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                                S119404=5;
                                S119861=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119861=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S119856=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S119856=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                      S125556=2;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S119404=5;
                              S119861=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119861=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S119856=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119856=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S125556=2;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S119404=4;
                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                              S119404=5;
                              S119861=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119861=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S119856=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119856=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S125556=2;
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
                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                              currsigs.addElement(collectAtReturn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S119404=5;
                            S119861=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119861=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S119856=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119856=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S125556=2;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S119404=3;
                      if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                          S119404=4;
                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                              S119404=5;
                              S119861=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119861=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S119856=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S119856=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                    S125556=2;
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
                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                              currsigs.addElement(collectAtReturn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S119404=5;
                            S119861=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119861=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S119856=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119856=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S125556=2;
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
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S119404=4;
                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                            S119404=5;
                            S119861=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119861=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S119856=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119856=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S125556=2;
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
                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                            currsigs.addElement(collectAtReturn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S119404=5;
                          S119861=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119861=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S119856=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119856=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S125556=2;
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
                  }
                  else {
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 81, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 77, column: 7
                  currsigs.addElement(injectAtEntry);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                S119404=2;
                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 86, column: 8
                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 87, column: 22
                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 90, column: 6
                    S119404=3;
                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                        S119404=4;
                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                            S119404=5;
                            S119861=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119861=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S119856=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S119856=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                  S125556=2;
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
                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                            currsigs.addElement(collectAtReturn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S119404=5;
                          S119861=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119861=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S119856=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119856=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S125556=2;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S119404=4;
                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                          S119404=5;
                          S119861=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119861=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S119856=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119856=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S125556=2;
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
                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                          currsigs.addElement(collectAtReturn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S119404=5;
                        S119861=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S119861=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S119856=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119856=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S125556=2;
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
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 88, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  S119404=3;
                  if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 93, column: 8
                    if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 94, column: 22
                      System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 97, column: 6
                      S119404=4;
                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                          S119404=5;
                          S119861=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119861=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S119856=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S119856=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                                S125556=2;
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
                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                          currsigs.addElement(collectAtReturn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S119404=5;
                        S119861=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S119861=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S119856=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119856=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S125556=2;
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
                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 95, column: 7
                      currsigs.addElement(recyclingConveyorMotor);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    S119404=4;
                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 100, column: 8
                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 101, column: 22
                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 104, column: 6
                        S119404=5;
                        S119861=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S119861=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S119856=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S119856=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                              S125556=2;
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
                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 102, column: 7
                        currsigs.addElement(collectAtReturn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S119404=5;
                      S119861=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                        S119861=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S119856=0;
                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 107, column: 5
                          S119856=1;
                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 107, column: 5
                            S125556=2;
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

  public void thread156512(int [] tdone, int [] ends){
        S119379=1;
    if(mode.getprestatus()){//sysj\recyclingConveyorController.sysj line: 48, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\recyclingConveyorController.sysj line: 49, column: 8
        auto_1.setPresent();//sysj\recyclingConveyorController.sysj line: 49, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\recyclingConveyorController.sysj line: 50, column: 12
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
      switch(S156510){
        case 0 : 
          S156510=0;
          break RUN;
        
        case 1 : 
          S156510=2;
          S156510=2;
          auto_1.setClear();//sysj\recyclingConveyorController.sysj line: 44, column: 2
          manual_1.setClear();//sysj\recyclingConveyorController.sysj line: 44, column: 2
          thread156512(tdone,ends);
          thread156513(tdone,ends);
          thread156514(tdone,ends);
          int biggest156515 = 0;
          if(ends[2]>=biggest156515){
            biggest156515=ends[2];
          }
          if(ends[3]>=biggest156515){
            biggest156515=ends[3];
          }
          if(ends[4]>=biggest156515){
            biggest156515=ends[4];
          }
          if(biggest156515 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\recyclingConveyorController.sysj line: 44, column: 2
          manual_1.setClear();//sysj\recyclingConveyorController.sysj line: 44, column: 2
          thread156516(tdone,ends);
          thread156517(tdone,ends);
          thread156518(tdone,ends);
          int biggest156519 = 0;
          if(ends[2]>=biggest156519){
            biggest156519=ends[2];
          }
          if(ends[3]>=biggest156519){
            biggest156519=ends[3];
          }
          if(ends[4]>=biggest156519){
            biggest156519=ends[4];
          }
          if(biggest156519 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest156519 == 0){
            S156510=0;
            active[1]=0;
            ends[1]=0;
            S156510=0;
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
          enable_in.gethook();
          status_o.gethook();
          mode.gethook();
          bottleAtSplitterExit.gethook();
          bottleAtLidRemoval.gethook();
          bottleAtDumper.gethook();
          bottleAtReturn.gethook();
          bottleLeftReturn.gethook();
          recyclingConveyorMotorM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      bottleAtSplitterExit.setpreclear();
      bottleAtLidRemoval.setpreclear();
      bottleAtDumper.setpreclear();
      bottleAtReturn.setpreclear();
      bottleLeftReturn.setpreclear();
      recyclingConveyorMotorM.setpreclear();
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
        bottleAtSplitterExit.gethook();
        bottleAtLidRemoval.gethook();
        bottleAtDumper.gethook();
        bottleAtReturn.gethook();
        bottleLeftReturn.gethook();
        recyclingConveyorMotorM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
