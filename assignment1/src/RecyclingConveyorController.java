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
  private int OK_thread_3;//sysj\recyclingConveyorController.sysj line: 113, column: 3
  private int TO_LID_thread_3;//sysj\recyclingConveyorController.sysj line: 117, column: 3
  private int TO_DUMP_thread_3;//sysj\recyclingConveyorController.sysj line: 119, column: 3
  private int TO_RETURN_thread_3;//sysj\recyclingConveyorController.sysj line: 121, column: 3
  private int DISCHARGE_thread_3;//sysj\recyclingConveyorController.sysj line: 123, column: 3
  private int cmd_thread_3;//sysj\recyclingConveyorController.sysj line: 127, column: 3
  private int S176288 = 1;
  private int S139157 = 1;
  private int S176215 = 1;
  private int S145334 = 1;
  private int S139182 = 1;
  private int S139166 = 1;
  private int S139161 = 1;
  private int S139187 = 1;
  private int S139639 = 1;
  private int S139634 = 1;
  private int S176286 = 1;
  private int S176238 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread176296(int [] tdone, int [] ends){
        switch(S176286){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S176238){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 229, column: 20
              S176238=1;
              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 231, column: 20
                S176238=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 235, column: 14
                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 235, column: 40
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
            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 231, column: 20
              S176238=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 235, column: 14
                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 235, column: 40
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
            S176238=2;
            S176238=0;
            if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 229, column: 20
              S176238=1;
              if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 231, column: 20
                S176238=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 235, column: 14
                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 235, column: 40
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

  public void thread176295(int [] tdone, int [] ends){
        switch(S176215){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S145334){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 133, column: 20
              S145334=1;
              if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 137, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S145334=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S139182=0;
                S139166=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                  enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                  S139166=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S139161=0;
                  if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                    enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                    S139161=1;
                    if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                      enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                      ends[3]=2;
                      ;//sysj\recyclingConveyorController.sysj line: 139, column: 5
                      cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 141, column: 5
                      S139182=1;
                      if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 145, column: 8
                        S139187=0;
                        if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 151, column: 22
                          System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 157, column: 6
                          S139187=1;
                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 159, column: 22
                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 165, column: 6
                            S139182=2;
                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                                S139182=3;
                                if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                  if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                    System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                    S139182=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=3;
                              if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                  System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                  S139182=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 161, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 153, column: 7
                          currsigs.addElement(injectAtEntry);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S139182=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                            S139182=3;
                            if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                              if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                S139182=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S139182=3;
                          if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                            if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                              System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                              S139182=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S139182=4;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=5;
                              S139639=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139639=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S139634=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139634=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S145334=2;
                                    active[3]=1;
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
            if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 137, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S145334=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S139182){
                case 0 : 
                  switch(S139166){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                        enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                        S139166=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S139161){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                              enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                              S139161=1;
                              if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                                enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 139, column: 5
                                cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 141, column: 5
                                S139182=1;
                                if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 145, column: 8
                                  S139187=0;
                                  if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 151, column: 22
                                    System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 157, column: 6
                                    S139187=1;
                                    if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 159, column: 22
                                      System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 165, column: 6
                                      S139182=2;
                                      if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                                        if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                                          System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                                          S139182=3;
                                          if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                            if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                              System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                              S139182=4;
                                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                                  S139182=5;
                                                  S139639=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S139639=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S139634=0;
                                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      S139634=1;
                                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                        S145334=2;
                                                        active[3]=1;
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
                                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                                  currsigs.addElement(collectAtReturn);
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                S139182=5;
                                                S139639=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139639=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S139634=0;
                                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S139634=1;
                                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      S145334=2;
                                                      active[3]=1;
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
                                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                              currsigs.addElement(recyclingConveyorMotor);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S139182=4;
                                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                                S139182=5;
                                                S139639=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139639=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S139634=0;
                                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S139634=1;
                                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      S145334=2;
                                                      active[3]=1;
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
                                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                                currsigs.addElement(collectAtReturn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S139182=5;
                                              S139639=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139639=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S139634=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139634=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S145334=2;
                                                    active[3]=1;
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
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=3;
                                        if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                          if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                            System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                            S139182=4;
                                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                                S139182=5;
                                                S139639=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139639=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S139634=0;
                                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S139634=1;
                                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      S145334=2;
                                                      active[3]=1;
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
                                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                                currsigs.addElement(collectAtReturn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S139182=5;
                                              S139639=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139639=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S139634=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139634=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S145334=2;
                                                    active[3]=1;
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
                                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                            currsigs.addElement(recyclingConveyorMotor);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S139182=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                              S139182=5;
                                              S139639=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139639=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S139634=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139634=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S145334=2;
                                                    active[3]=1;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 161, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 153, column: 7
                                    currsigs.addElement(injectAtEntry);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=2;
                                  if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                                      S139182=3;
                                      if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                          S139182=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                              S139182=5;
                                              S139639=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139639=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S139634=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139634=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S145334=2;
                                                    active[3]=1;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=3;
                                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                        S139182=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                            if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                              enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 139, column: 5
                              cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 141, column: 5
                              S139182=1;
                              if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 145, column: 8
                                S139187=0;
                                if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 151, column: 22
                                  System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 157, column: 6
                                  S139187=1;
                                  if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 159, column: 22
                                    System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 165, column: 6
                                    S139182=2;
                                    if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                                        S139182=3;
                                        if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                          if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                            System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                            S139182=4;
                                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                                S139182=5;
                                                S139639=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139639=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S139634=0;
                                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S139634=1;
                                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                      S145334=2;
                                                      active[3]=1;
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
                                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                                currsigs.addElement(collectAtReturn);
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S139182=5;
                                              S139639=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139639=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S139634=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139634=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S145334=2;
                                                    active[3]=1;
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
                                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                            currsigs.addElement(recyclingConveyorMotor);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S139182=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                              S139182=5;
                                              S139639=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139639=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S139634=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139634=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S145334=2;
                                                    active[3]=1;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=3;
                                      if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                          S139182=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                              S139182=5;
                                              S139639=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139639=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S139634=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139634=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S145334=2;
                                                    active[3]=1;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 161, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 153, column: 7
                                  currsigs.addElement(injectAtEntry);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=2;
                                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                                    S139182=3;
                                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                        S139182=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=3;
                                  if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                    if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                      System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                      S139182=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                      S139166=1;
                      S139166=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                        enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                        S139166=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S139161=0;
                        if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                          enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                          S139161=1;
                          if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                            enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 139, column: 5
                            cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 141, column: 5
                            S139182=1;
                            if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 145, column: 8
                              S139187=0;
                              if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 151, column: 22
                                System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 157, column: 6
                                S139187=1;
                                if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 159, column: 22
                                  System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 165, column: 6
                                  S139182=2;
                                  if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                                    if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                                      System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                                      S139182=3;
                                      if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                          S139182=4;
                                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                              S139182=5;
                                              S139639=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139639=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S139634=0;
                                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S139634=1;
                                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                    S145334=2;
                                                    active[3]=1;
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
                                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                              currsigs.addElement(collectAtReturn);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                          currsigs.addElement(recyclingConveyorMotor);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=3;
                                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                        S139182=4;
                                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                            S139182=5;
                                            S139639=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139639=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S139634=0;
                                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S139634=1;
                                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                  S145334=2;
                                                  active[3]=1;
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
                                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                            currsigs.addElement(collectAtReturn);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                        currsigs.addElement(recyclingConveyorMotor);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 161, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 153, column: 7
                                currsigs.addElement(injectAtEntry);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=2;
                              if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                                if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                                  System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                                  S139182=3;
                                  if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                    if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                      System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                      S139182=4;
                                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                          S139182=5;
                                          S139639=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139639=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S139634=0;
                                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S139634=1;
                                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                ends[3]=2;
                                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                                S145334=2;
                                                active[3]=1;
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
                                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                          currsigs.addElement(collectAtReturn);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                      currsigs.addElement(recyclingConveyorMotor);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=3;
                                if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                  if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                    System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                    S139182=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                  switch(S139187){
                    case 0 : 
                      if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 151, column: 22
                        System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 157, column: 6
                        S139187=1;
                        if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 159, column: 22
                          System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 165, column: 6
                          S139182=2;
                          if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                            if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                              System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                              S139182=3;
                              if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                  System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                  S139182=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S139182=3;
                            if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                              if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                S139182=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 161, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 153, column: 7
                        currsigs.addElement(injectAtEntry);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 159, column: 22
                        System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 165, column: 6
                        S139182=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                            S139182=3;
                            if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                              if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                S139182=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S139182=3;
                          if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                            if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                              System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                              S139182=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S139182=4;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=5;
                              S139639=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139639=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S139634=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139634=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S145334=2;
                                    active[3]=1;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 161, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                  }
                  break;
                
                case 2 : 
                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                    S139182=3;
                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                        S139182=4;
                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                            S139182=5;
                            S139639=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139639=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S139634=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139634=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S145334=2;
                                  active[3]=1;
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
                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                            currsigs.addElement(collectAtReturn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S139182=5;
                          S139639=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139639=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S139634=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139634=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S145334=2;
                                active[3]=1;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S139182=4;
                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                          S139182=5;
                          S139639=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139639=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S139634=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139634=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S145334=2;
                                active[3]=1;
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
                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                          currsigs.addElement(collectAtReturn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S139182=5;
                        S139639=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S139639=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S139634=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139634=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S145334=2;
                              active[3]=1;
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
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 3 : 
                  if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                    System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                    S139182=4;
                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                        S139182=5;
                        S139639=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S139639=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S139634=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139634=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S145334=2;
                              active[3]=1;
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
                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                        currsigs.addElement(collectAtReturn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S139182=5;
                      S139639=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        S139639=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S139634=0;
                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S139634=1;
                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S145334=2;
                            active[3]=1;
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
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 4 : 
                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                    S139182=5;
                    S139639=0;
                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                      S139639=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S139634=0;
                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        S139634=1;
                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          ends[3]=2;
                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S145334=2;
                          active[3]=1;
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
                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                    currsigs.addElement(collectAtReturn);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 5 : 
                  switch(S139639){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        S139639=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S139634){
                          case 0 : 
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139634=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S145334=2;
                                active[3]=1;
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
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S145334=2;
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
                      S139639=1;
                      S139639=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        S139639=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S139634=0;
                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S139634=1;
                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S145334=2;
                            active[3]=1;
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
            S145334=2;
            S145334=0;
            if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 133, column: 20
              S145334=1;
              if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 137, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S145334=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S139182=0;
                S139166=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                  enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                  S139166=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S139161=0;
                  if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                    enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                    S139161=1;
                    if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
                      enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
                      ends[3]=2;
                      ;//sysj\recyclingConveyorController.sysj line: 139, column: 5
                      cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 141, column: 5
                      S139182=1;
                      if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 145, column: 8
                        S139187=0;
                        if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 151, column: 22
                          System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 157, column: 6
                          S139187=1;
                          if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 159, column: 22
                            System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 165, column: 6
                            S139182=2;
                            if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                              if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                                System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                                S139182=3;
                                if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                  if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                    System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                    S139182=4;
                                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                        S139182=5;
                                        S139639=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139639=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S139634=0;
                                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S139634=1;
                                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              ends[3]=2;
                                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                              S145334=2;
                                              active[3]=1;
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
                                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                        currsigs.addElement(collectAtReturn);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                    currsigs.addElement(recyclingConveyorMotor);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=3;
                              if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                                if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                  System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                  S139182=4;
                                  if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                    if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                      System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                      S139182=5;
                                      S139639=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139639=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S139634=0;
                                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S139634=1;
                                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            ends[3]=2;
                                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                            S145334=2;
                                            active[3]=1;
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
                                      collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                      currsigs.addElement(collectAtReturn);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                  recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                  currsigs.addElement(recyclingConveyorMotor);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 161, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 153, column: 7
                          currsigs.addElement(injectAtEntry);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S139182=2;
                        if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                          if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                            System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                            S139182=3;
                            if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                              if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                                System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                                S139182=4;
                                if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                  if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                    System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                    S139182=5;
                                    S139639=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139639=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S139634=0;
                                      if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S139634=1;
                                        if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          ends[3]=2;
                                          ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                          S145334=2;
                                          active[3]=1;
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
                                    collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                    currsigs.addElement(collectAtReturn);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                                currsigs.addElement(recyclingConveyorMotor);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S139182=3;
                          if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                            if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                              System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                              S139182=4;
                              if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                                if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                  System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                  S139182=5;
                                  S139639=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139639=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S139634=0;
                                    if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S139634=1;
                                      if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        ends[3]=2;
                                        ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                        S145334=2;
                                        active[3]=1;
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
                                  collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                  currsigs.addElement(collectAtReturn);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                              recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                              currsigs.addElement(recyclingConveyorMotor);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S139182=4;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=5;
                              S139639=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139639=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S139634=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139634=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S145334=2;
                                    active[3]=1;
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

  public void thread176294(int [] tdone, int [] ends){
        switch(S139157){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\recyclingConveyorController.sysj line: 97, column: 8
            auto_1.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\recyclingConveyorController.sysj line: 99, column: 12
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

  public void thread176292(int [] tdone, int [] ends){
        S176286=1;
    S176238=0;
    if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 229, column: 20
      S176238=1;
      if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 231, column: 20
        S176238=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(recyclingConveyorMotorM.getprestatus()){//sysj\recyclingConveyorController.sysj line: 235, column: 14
          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 235, column: 40
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

  public void thread176291(int [] tdone, int [] ends){
        S176215=1;
    OK_thread_3 = 0;//sysj\recyclingConveyorController.sysj line: 113, column: 3
    TO_LID_thread_3 = 1;//sysj\recyclingConveyorController.sysj line: 117, column: 3
    TO_DUMP_thread_3 = 2;//sysj\recyclingConveyorController.sysj line: 119, column: 3
    TO_RETURN_thread_3 = 3;//sysj\recyclingConveyorController.sysj line: 121, column: 3
    DISCHARGE_thread_3 = 4;//sysj\recyclingConveyorController.sysj line: 123, column: 3
    cmd_thread_3 = 0;//sysj\recyclingConveyorController.sysj line: 127, column: 3
    S145334=0;
    if(auto_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 133, column: 20
      S145334=1;
      if(manual_1.getprestatus()){//sysj\recyclingConveyorController.sysj line: 137, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S145334=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S139182=0;
        S139166=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
          enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
          S139166=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S139161=0;
          if(!enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
            enable_in.setACK(true);//sysj\recyclingConveyorController.sysj line: 139, column: 5
            S139161=1;
            if(enable_in.isREQ()){//sysj\recyclingConveyorController.sysj line: 139, column: 5
              enable_in.setACK(false);//sysj\recyclingConveyorController.sysj line: 139, column: 5
              ends[3]=2;
              ;//sysj\recyclingConveyorController.sysj line: 139, column: 5
              cmd_thread_3 = ((Integer)(enable_in.getVal() == null ? null : ((Integer)enable_in.getVal()))).intValue();//sysj\recyclingConveyorController.sysj line: 141, column: 5
              S139182=1;
              if(cmd_thread_3 == TO_LID_thread_3){//sysj\recyclingConveyorController.sysj line: 145, column: 8
                S139187=0;
                if(bottleAtSplitterExit.getprestatus()){//sysj\recyclingConveyorController.sysj line: 151, column: 22
                  System.out.println("[RC] Bottle on the recycling conveyor, indexing to lid removal.");//sysj\recyclingConveyorController.sysj line: 157, column: 6
                  S139187=1;
                  if(bottleAtLidRemoval.getprestatus()){//sysj\recyclingConveyorController.sysj line: 159, column: 22
                    System.out.println("[RC] Bottle at lid removal.");//sysj\recyclingConveyorController.sysj line: 165, column: 6
                    S139182=2;
                    if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                      if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                        System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                        S139182=3;
                        if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                          if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                            System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                            S139182=4;
                            if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                              if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                                System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                                S139182=5;
                                S139639=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139639=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S139634=0;
                                  if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S139634=1;
                                    if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      ends[3]=2;
                                      ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                      S145334=2;
                                      active[3]=1;
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
                                collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                                currsigs.addElement(collectAtReturn);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S139182=5;
                              S139639=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139639=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S139634=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139634=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S145334=2;
                                    active[3]=1;
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
                            recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                            currsigs.addElement(recyclingConveyorMotor);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S139182=4;
                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                              S139182=5;
                              S139639=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139639=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S139634=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139634=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S145334=2;
                                    active[3]=1;
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
                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                              currsigs.addElement(collectAtReturn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S139182=5;
                            S139639=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139639=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S139634=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139634=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S145334=2;
                                  active[3]=1;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S139182=3;
                      if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                        if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                          System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                          S139182=4;
                          if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                            if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                              System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                              S139182=5;
                              S139639=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139639=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S139634=0;
                                if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S139634=1;
                                  if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    ends[3]=2;
                                    ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                    S145334=2;
                                    active[3]=1;
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
                              collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                              currsigs.addElement(collectAtReturn);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S139182=5;
                            S139639=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139639=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S139634=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139634=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S145334=2;
                                  active[3]=1;
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
                          recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                          currsigs.addElement(recyclingConveyorMotor);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S139182=4;
                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                            S139182=5;
                            S139639=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139639=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S139634=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139634=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S145334=2;
                                  active[3]=1;
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
                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                            currsigs.addElement(collectAtReturn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S139182=5;
                          S139639=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139639=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S139634=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139634=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S145334=2;
                                active[3]=1;
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
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 161, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  injectAtEntry.setPresent();//sysj\recyclingConveyorController.sysj line: 153, column: 7
                  currsigs.addElement(injectAtEntry);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                S139182=2;
                if(cmd_thread_3 == TO_DUMP_thread_3){//sysj\recyclingConveyorController.sysj line: 171, column: 8
                  if(bottleAtDumper.getprestatus()){//sysj\recyclingConveyorController.sysj line: 173, column: 22
                    System.out.println("[RC] Bottle at the liquid dumper.");//sysj\recyclingConveyorController.sysj line: 179, column: 6
                    S139182=3;
                    if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                      if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                        System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                        S139182=4;
                        if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                          if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                            System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                            S139182=5;
                            S139639=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139639=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S139634=0;
                              if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S139634=1;
                                if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  ends[3]=2;
                                  ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                  S145334=2;
                                  active[3]=1;
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
                            collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                            currsigs.addElement(collectAtReturn);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S139182=5;
                          S139639=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139639=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S139634=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139634=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S145334=2;
                                active[3]=1;
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
                        recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                        currsigs.addElement(recyclingConveyorMotor);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S139182=4;
                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                          S139182=5;
                          S139639=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139639=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S139634=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139634=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S145334=2;
                                active[3]=1;
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
                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                          currsigs.addElement(collectAtReturn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S139182=5;
                        S139639=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S139639=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S139634=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139634=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S145334=2;
                              active[3]=1;
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
                    recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 175, column: 7
                    currsigs.addElement(recyclingConveyorMotor);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                else {
                  S139182=3;
                  if(cmd_thread_3 == TO_RETURN_thread_3){//sysj\recyclingConveyorController.sysj line: 185, column: 8
                    if(bottleAtReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 187, column: 22
                      System.out.println("[RC] Bottle at the bottle return.");//sysj\recyclingConveyorController.sysj line: 193, column: 6
                      S139182=4;
                      if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                        if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                          System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                          S139182=5;
                          S139639=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139639=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S139634=0;
                            if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S139634=1;
                              if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                ends[3]=2;
                                ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                                S145334=2;
                                active[3]=1;
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
                          collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                          currsigs.addElement(collectAtReturn);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S139182=5;
                        S139639=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S139639=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S139634=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139634=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S145334=2;
                              active[3]=1;
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
                      recyclingConveyorMotor.setPresent();//sysj\recyclingConveyorController.sysj line: 189, column: 7
                      currsigs.addElement(recyclingConveyorMotor);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    S139182=4;
                    if(cmd_thread_3 == DISCHARGE_thread_3){//sysj\recyclingConveyorController.sysj line: 199, column: 8
                      if(bottleLeftReturn.getprestatus()){//sysj\recyclingConveyorController.sysj line: 201, column: 22
                        System.out.println("[RC] Bottle handed over, recycling conveyor clear.");//sysj\recyclingConveyorController.sysj line: 207, column: 6
                        S139182=5;
                        S139639=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S139639=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S139634=0;
                          if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S139634=1;
                            if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              ends[3]=2;
                              ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                              S145334=2;
                              active[3]=1;
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
                        collectAtReturn.setPresent();//sysj\recyclingConveyorController.sysj line: 203, column: 7
                        currsigs.addElement(collectAtReturn);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S139182=5;
                      S139639=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                        S139639=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S139634=0;
                        if(status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          status_o.setVal(new Integer(OK_thread_3));//sysj\recyclingConveyorController.sysj line: 213, column: 5
                          S139634=1;
                          if(!status_o.isACK()){//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            status_o.setREQ(false);//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            ends[3]=2;
                            ;//sysj\recyclingConveyorController.sysj line: 213, column: 5
                            S145334=2;
                            active[3]=1;
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

  public void thread176290(int [] tdone, int [] ends){
        S139157=1;
    if(mode.getprestatus()){//sysj\recyclingConveyorController.sysj line: 95, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\recyclingConveyorController.sysj line: 97, column: 8
        auto_1.setPresent();//sysj\recyclingConveyorController.sysj line: 97, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\recyclingConveyorController.sysj line: 99, column: 12
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
      switch(S176288){
        case 0 : 
          S176288=0;
          break RUN;
        
        case 1 : 
          S176288=2;
          S176288=2;
          auto_1.setClear();//sysj\recyclingConveyorController.sysj line: 87, column: 2
          manual_1.setClear();//sysj\recyclingConveyorController.sysj line: 87, column: 2
          thread176290(tdone,ends);
          thread176291(tdone,ends);
          thread176292(tdone,ends);
          int biggest176293 = 0;
          if(ends[2]>=biggest176293){
            biggest176293=ends[2];
          }
          if(ends[3]>=biggest176293){
            biggest176293=ends[3];
          }
          if(ends[4]>=biggest176293){
            biggest176293=ends[4];
          }
          if(biggest176293 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\recyclingConveyorController.sysj line: 87, column: 2
          manual_1.setClear();//sysj\recyclingConveyorController.sysj line: 87, column: 2
          thread176294(tdone,ends);
          thread176295(tdone,ends);
          thread176296(tdone,ends);
          int biggest176297 = 0;
          if(ends[2]>=biggest176297){
            biggest176297=ends[2];
          }
          if(ends[3]>=biggest176297){
            biggest176297=ends[3];
          }
          if(ends[4]>=biggest176297){
            biggest176297=ends[4];
          }
          if(biggest176297 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest176297 == 0){
            S176288=0;
            active[1]=0;
            ends[1]=0;
            S176288=0;
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
